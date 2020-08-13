package dao;

import clases.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bladimir
 */
public class daoUsuario {
    public void insertarUsuario(usuario usuario){
        String query="INSERT INTO USUARIO(idUsuario,nombreUsuario,telefonoUsuario,DPIUsuario,NITUsuario,correoUsuario,direccionUsuario) "
                    +"VALUES(?,?,?,?,?,?,?)";
        Connection conexion=null;
        PreparedStatement llevar=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            llevar=conexion.prepareStatement(query);
            llevar.setString(1, usuario.getCodigo());
            llevar.setString(2, usuario.getNombre());
            llevar.setString(3, usuario.getTelefono());
            llevar.setString(4, usuario.getDPI());
            llevar.setString(5, usuario.getNIT());
            llevar.setString(6, usuario.getCorreo());
            llevar.setString(7, usuario.getDireccion());
            llevar.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(conexion);
            Conexion.conexionMysql.close(llevar);
        }
    }
    
}
