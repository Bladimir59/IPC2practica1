package logica;

import Interface.Empleado;
import Interface.cargaArchivo;
import Interface.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bladimir
 */
public class BuscarDatos {
    public boolean siExiste(){
        boolean hay=false;
        String query="SELECT * FROM TIENDA";
        Connection conexion=null;
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            obtener=conexion.prepareStatement(query);
            rs=obtener.executeQuery(query);
            hay=rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(rs);
            Conexion.conexionMysql.close(obtener);
            Conexion.conexionMysql.close(conexion);
        }
        return hay;
    }
    
    public void dirige(){        
        if(siExiste()){
            Interface.login ir=new login();
            ir.show();
        }else{
            cargaArchivo entrada=new cargaArchivo();
            entrada.show();
        }
    }
}
