package dao;

import clases.cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bladimir
 */
public class daoCliente {
    public void insertarCliente(cliente cliente){
        String query="INSERT INTO CLIENTE(NIT,nombreCliente,telefonoCliente,DPI,correoCliente,direccionCliente,creditoCliente) "
                    +"VALUES(?,?,?,?,?,?,?)";
        Connection conexion=null;
        PreparedStatement llevar=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            llevar=conexion.prepareStatement(query);
            llevar.setString(1, cliente.getNIT());
            llevar.setString(2, cliente.getNombre());
            llevar.setString(3, cliente.getTelefono());
            llevar.setString(4, cliente.getDPI());
            llevar.setString(5, cliente.getCorreo());
            llevar.setString(6, cliente.getDireccion());
            llevar.setDouble(7, cliente.getCredito());
            llevar.executeLargeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(conexion);
            Conexion.conexionMysql.close(llevar);
        }
    }
    
    
}
