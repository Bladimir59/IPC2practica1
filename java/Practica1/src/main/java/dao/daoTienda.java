package dao;

import clases.tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bladimir
 */
public class daoTienda {
    public void insertarTienda(tienda tienda){
        String query="INSERT INTO TIENDA(nombreTienda,direccionTienda,codigoTienda,telefonoTienda1,telefonoTienda2,correoTienda,horario) "
                    +"VALUES(?,?,?,?,?,?,?)";
        Connection conexion=null;
        PreparedStatement llevar=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            llevar=conexion.prepareStatement(query);
            llevar.setString(1, tienda.getNombre());
            llevar.setString(2, tienda.getDireccion());
            llevar.setString(3, tienda.getCodigo());
            llevar.setString(4, tienda.getTelefono1());
            llevar.setString(5, tienda.getTelefono2());
            llevar.setString(6, tienda.getCorreo());
            llevar.setString(7, tienda.getHorario());
            llevar.executeLargeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(conexion);
            Conexion.conexionMysql.close(llevar);
        }
    }   
}
