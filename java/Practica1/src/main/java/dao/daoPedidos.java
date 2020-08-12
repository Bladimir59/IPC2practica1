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
        String query="INSERT INTO TIEMPO(codigoPedido ,idDETALLEPEDIDO,fecha,total,CLIENTE_idCLIENTE,anticipo ,cantidaProducto ) "
                    +"VALUES(?,?,?,?,?,?,?)";
        Connection conexion=null;
        PreparedStatement llevar=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            llevar=conexion.prepareStatement(query);
            llevar.setString(1, pedidos.getCodigoPedido());
            llevar.setString(2, pedidos.getTienda1());
            llevar.setString(3, pedidos.getTienda2());
            llevar.setString(4, pedidos.getFecha());
            llevar.setString(5, pedidos.getCliente());
            llevar.setString(6, pedidos.getArticulo());
            llevar.setInt(7, pedidos.getCantidad());
            llevar.setDouble(8, pedidos.getTotal());
            llevar.setDouble(8, pedidos.getTotal());
            llevar.executeLargeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(conexion);
            Conexion.conexionMysql.close(llevar);
        }
    }
}
