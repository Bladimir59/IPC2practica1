package dao;

import clases.usuario;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public usuario obtenerUsuarioCodigo(String codigo){
        usuario datosUsuario=null;
        String query="SELECT * FROM USUARIO WHERE idUsuario=?";
        Connection conecxion=null;
        PreparedStatement obtenerUsuario=null;
        ResultSet rs=null;
        try {
            conecxion=Conexion.conexionMysql.conectar();
            obtenerUsuario=conecxion.prepareStatement(query);
            obtenerUsuario.setString(1, codigo);
            rs=obtenerUsuario.executeQuery();
            if(rs.next()){
                datosUsuario=new usuario(rs.getString("nombreUsuario"), rs.getNString("telefonoUsuario"), rs.getNString("DPIUsuario")
                                       , rs.getNString("idUsuario"), rs.getNString("NITUsuario"), rs.getNString("correoUsuario"), rs.getNString("direccionUsuario"));
                datosUsuario.setCodigo(rs.getNString("idUsuario"));
                datosUsuario.setNombre(rs.getNString("nombreUsuario"));
                datosUsuario.setTelefono(rs.getNString("telefonoUsuario"));
                datosUsuario.setDPI(rs.getNString("DPIUsuario"));
                datosUsuario.setNIT(rs.getNString("NITUsuario"));
                datosUsuario.setCorreo(rs.getNString("correoUsuario"));
                datosUsuario.setDireccion(rs.getNString("direccionUsuario"));                  
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(rs);
            Conexion.conexionMysql.close(obtenerUsuario);
            Conexion.conexionMysql.close(conecxion);
        }
        return datosUsuario;
    }
    //codigo de usuarios
    public List<clases.usuario> listaCodigo(){
        List<usuario> listado = new ArrayList<>();
        String query="SELECT idUsuario FROM USUARIO";
        Connection conexion=null;
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            obtener=conexion.prepareStatement(query);
            rs=obtener.executeQuery(query);
            while(rs.next()){
                String id=rs.getString("idUsuario");
                usuario lista=new usuario(id);
                lista.setCodigo(id);
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
    public void modificarUsuario(usuario usuario){
        String query="UPDATE USUARIO SET nombreUsuario = ?,telefonoUsuario = ?,DPIUsuario = ?,NITUsuario = ?,"
                + "correoUsuario = ?,direccionUsuario = ? WHERE idUsuario = ?";
        Connection conexion=null;
        PreparedStatement modificar=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            modificar=conexion.prepareStatement(query);
            modificar.setString(1, usuario.getNombre());
            modificar.setString(2, usuario.getTelefono());
            modificar.setString(3, usuario.getDPI());
            modificar.setString(4, usuario.getNIT());
            modificar.setString(5, usuario.getCorreo());
            modificar.setString(6, usuario.getDireccion());
            modificar.setString(7, usuario.getCodigo());
            modificar.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(modificar);
            Conexion.conexionMysql.close(conexion);
        }
    }
    //prueba de alterar un solo dato en usuario
    public void cambiarUnDato(usuario usuario){
        String query="UPDATE USUARIO SET direccionUsuario=? WHERE idUsuario=?";
        Connection conexion=null;
        PreparedStatement modificar=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            modificar=conexion.prepareStatement(query);
            modificar.setString(1, usuario.getDireccion());
            modificar.setString(2, usuario.getCodigo());
            modificar.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(modificar);
            Conexion.conexionMysql.close(conexion);
        }
    }
}
