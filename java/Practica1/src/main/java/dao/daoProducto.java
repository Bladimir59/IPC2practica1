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
        String query="INSERT INTO PRODUCTO(idPRODUCTO,nombreProducto,fabrica,precio,Descripcion,Garantilla)"
                    +"VALUES(?,?,?,?,?,?)ON DUPLICATE KEY UPDATE idPRODUCTO=idPRODUCTO";
        String querytienda_producto="INSERT INTO TIENDASdePRODUCTOS(TIENDA_idTienda,PRODUCTO_idPRODUCTO ,cantidadProducto)"
                    +"VALUES(?,?,?)";
        Connection conexion=null;
        PreparedStatement llevar=null;
        PreparedStatement llevaunion=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            llevar=conexion.prepareStatement(query);
            //llena la tabla de producto
            llevar.setString(1, producto.getCodigo());
            llevar.setString(2, producto.getNombre());
            llevar.setString(3, producto.getFabrica());
            llevar.setDouble(4, producto.getPrecio());
            llevar.setString(5, producto.getDescripcion());
            llevar.setInt(6, producto.getGarantia());
            llevar.executeUpdate();
            //llena la tabla union
            llevaunion=conexion.prepareStatement(querytienda_producto);
            llevaunion.setString(1, producto.getIdTienda());
            llevaunion.setString(2, producto.getCodigo());
            llevaunion.setInt(3, producto.getCantidad());
            llevaunion.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(llevaunion);
            Conexion.conexionMysql.close(llevar);
            Conexion.conexionMysql.close(conexion);
        }
    }    
}
