package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import reportes.claseTabla;

/**
 *
 * @author Bladimir
 */
public class TablaPedido {
    public List<reportes.claseTabla> ListaProductoTienda(String codigo){
        List<reportes.claseTabla> listado = new ArrayList<>();
        String query="select idPRODUCTO,nombreProducto,precio,cantidadProducto,idTienda,nombreTienda,direccionTienda"
                + " from PRODUCTO p inner join TIENDASdePRODUCTOS T ON T.PRODUCTO_idPRODUCTO = p.idPRODUCTO inner join TIENDA TI ON TI.idTIENDA = T.TIENDA_idTIENDA WHERE p.idPRODUCTO =?";
        Connection conexion=null;
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            obtener=conexion.prepareStatement(query);
            obtener.setString(1, codigo);
            rs=obtener.executeQuery();
            while(rs.next()){
                claseTabla lista=new claseTabla(rs.getString("idTienda"),rs.getString("nombreTienda"),rs.getString("direccionTienda"),
                        rs.getString("idPRODUCTO"),rs.getString("nombreProducto"),rs.getDouble("precio"),rs.getInt("cantidadProducto"));
                lista.setIdTienda(rs.getString("idTienda"));
                lista.setNombreTienda(rs.getString("nombreTienda"));
                lista.setDirecciontienda(rs.getString("direccionTienda"));
                lista.setCodigoProducto(rs.getString("idPRODUCTO"));
                lista.setNombreProducto(rs.getString("nombreProducto"));
                lista.setPrecioProducto(rs.getDouble("precio"));
                lista.setCantidadProducto(rs.getInt("cantidadProducto"));
                
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
