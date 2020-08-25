package logica;

import clases.usuario;
import dao.daoUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bladimir
 */
public class recuperarDatos {
    public void recuperarUsuario(String id){
        dao.daoUsuario regreso=new daoUsuario();
        usuario traido=regreso.obtenerUsuarioCodigo(id);
        System.out.println("nombre "+traido.getNombre());
        System.out.println(""+traido.toString());
    }
    public ResultSet getTabla(String consulta) {
        Connection cd = null;
        Statement st;
        ResultSet datos = null;
        try {
            cd=Conexion.conexionMysql.conectar();
            st = cd.createStatement();
            datos = st.executeQuery(consulta);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(datos);
            Conexion.conexionMysql.close(cd);
        }
        return datos;
    }
}
