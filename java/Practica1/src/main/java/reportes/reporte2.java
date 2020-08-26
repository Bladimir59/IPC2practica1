package reportes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bladimir
 */
public class reporte2 {
    public List<ClaseReporte2> repo2(){
        List<reportes.ClaseReporte2> listado = new ArrayList<>();
        String query="SELECT codigoPedido,fechaEntrega,total,CLIENTE_NIT FROM PEDIDOS WHERE EnTienda is false";
        Connection conexion=null;
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            obtener=conexion.prepareStatement(query);
            rs=obtener.executeQuery();
            while(rs.next()){
                ClaseReporte2 lista=new ClaseReporte2(rs.getString("codigoPedido"),rs.getDate("fechaEntrega"),rs.getDouble("total"),rs.getString("CLIENTE_NIT"));
                lista.setCodigoPedido(rs.getString("codigoPedido"));
                lista.setFecha(rs.getDate("fechaEntrega"));
                lista.setTotal(rs.getDouble("total"));
                lista.setCliente(rs.getString("CLIENTE_NIT"));
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
