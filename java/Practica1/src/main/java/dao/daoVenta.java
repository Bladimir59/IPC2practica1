package dao;

import clases.venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bladimir
 */
public class daoVenta {
    //llevara la informcacionde la venta hacia la base de datos
    public int insertarVenta(venta venta){
        int idVenta=0;
        String query="INSERT INTO VENTA(TOTAL,TIENDA_idTienda ,CLIENTE_NIT,FechaVENTA )"
                    +"VALUES(?,?,?,?)";
        Connection conexion=null;
        PreparedStatement llevar=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            llevar=conexion.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
            //llena la tabla de VENTA
            llevar.setDouble(1, venta.getTotal());
            llevar.setString(2, venta.getTiendaVenta());
            llevar.setString(3, venta.getClienteVenta());
            llevar.setDate(4, venta.getFecha());
            llevar.executeUpdate();
            rs=llevar.getGeneratedKeys();
            if(rs.next()){
                idVenta=rs.getInt(1);
            }
            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(rs);
            Conexion.conexionMysql.close(llevar);
            Conexion.conexionMysql.close(conexion);
        }
        return idVenta;
    }
    public void insertarDetalleVenta(venta venta){
        String query="INSERT INTO detalleVenta(PRODUCTO_idPRODUCTO,VENTA_idVENTAS ,cantidadProducto,subTotal)"
                    +"VALUES(?,?,?,?)";
        Connection conexion=null;
        PreparedStatement llevar=null;
        PreparedStatement llevaunion=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            llevar=conexion.prepareStatement(query);
            //llena la tabla de VENTA
            llevar.setString(1, venta.getProductoVenta());
            llevar.setInt(2, venta.getDetalleVenta());
            llevar.setInt(3, venta.getCantidaProducto());
            llevar.setDouble(4, venta.getTotal());
            llevar.executeUpdate();
            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(llevaunion);
            Conexion.conexionMysql.close(llevar);
            Conexion.conexionMysql.close(conexion);
        }
    }
    
}
