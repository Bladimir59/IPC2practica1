package dao;

import clases.pedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bladimir
 */
public class daoPedidos {
        public void insertarPedidos(pedidos pedidos){
        String query="INSERT INTO PEDIDOS(codigoPedido,fecha,anticipo,origen_TIENDA_idTienda,destino_TIENDA_idTienda,total,CLIENTE_NIT) "
                    +"VALUES(?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE codigoPedido=codigoPedido";
        String queryunion="INSERT INTO PEDIDOSdePRODUCTO(PEDIDOS_codigoPedido,PRODUCTO_idPRODUCTO,cantidadProducto ) "
                    +"VALUES(?,?,?)";
        Connection conexion=null;
        PreparedStatement llevar=null;
        PreparedStatement llevarUnion=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            llevar=conexion.prepareStatement(query);
            llevar.setString(1, pedidos.getCodigoPedido());
            llevar.setDate(2, pedidos.getFecha());
            llevar.setDouble(3, pedidos.getAnticipo());
            llevar.setString(4, pedidos.getTienda1());
            llevar.setString(5, pedidos.getTienda2());
            llevar.setDouble(6, pedidos.getTotal());
            llevar.setString(7, pedidos.getCliente());
            llevar.executeUpdate();
//llenar la tabla union
            llevarUnion=conexion.prepareStatement(queryunion);
            llevarUnion.setString(1, pedidos.getCodigoPedido());
            llevarUnion.setString(2, pedidos.getArticulo());
            llevarUnion.setInt(3, pedidos.getCantidad());
            
            llevarUnion.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(llevarUnion);
            Conexion.conexionMysql.close(llevar);
            Conexion.conexionMysql.close(conexion);
           
        }
    }
}
