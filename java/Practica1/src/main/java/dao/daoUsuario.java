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
}
