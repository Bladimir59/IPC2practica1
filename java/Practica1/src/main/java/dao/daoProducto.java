package dao;

import clases.producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bladimir
 */
public class daoProducto {
    public void insertarProducto(producto producto){
        String query="INSERT INTO PRODUCTO(nombreProducto,fabrica,codigoProducto,cantidad,precio,descripcionProducto)"
                    +"VALUES(?,?,?,?,?,?)";
        Connection conexion=null;
        PreparedStatement llevar=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            llevar=conexion.prepareStatement(query);
            llevar.setString(1, producto.getNombre());
            llevar.setString(2, producto.getFabrica());
            llevar.setString(3, producto.getCodigo());
            llevar.setInt(4, producto.getCantidad());
            llevar.setDouble(5, producto.getPrecio());
            llevar.setString(6, producto.getDescripcion());
            llevar.executeLargeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(conexion);
            Conexion.conexionMysql.close(llevar);
        }
    }    
}
