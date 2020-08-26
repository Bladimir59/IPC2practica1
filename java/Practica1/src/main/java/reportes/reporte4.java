package reportes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bladimir
 */
public class reporte4 {
        public List<ClaseReporte4> repo4(String codigo){
        List<reportes.ClaseReporte4> listado = new ArrayList<>();
        String query="SELECT nombreTienda,codigoPedido,anticipo,total,fechaEntrega "
                + "FROM TIENDA T INNER JOIN origen o ON T.idTienda=o.TIENDA_idTienda "
                + "INNER JOIN PEDIDOS P ON o.TIENDA_idTienda =P.origen_TIENDA_idTienda WHERE idTienda=?";
        Connection conexion=null;
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            obtener=conexion.prepareStatement(query);
            obtener.setString(1, codigo);
            rs=obtener.executeQuery();
            while(rs.next()){
                ClaseReporte4 lista=new ClaseReporte4(rs.getString("nombreTienda"),rs.getString("codigoPedido"),rs.getDouble("anticipo"),
                        rs.getDouble("total"),rs.getDate("fechaEntrega"));
                lista.setNombre(rs.getString("nombreTienda"));
                lista.setCodigoPedido(rs.getString("codigoPedido"));
                lista.setAnticipo(rs.getDouble("anticipo"));
                lista.setTotal(rs.getDouble("total"));
                lista.setFechaEntrega(rs.getDate("fechaEntrega"));
                
                listado.add(lista);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(rs);
            Conexion.conexionMysql.close(obtener);
            Conexion.conexionMysql.close(conexion);
        }
        return listado; 
    }
    
}
