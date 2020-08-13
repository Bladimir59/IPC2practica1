package dao;

import clases.tiempo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bladimir
 */
public class daotiempo {
        public void insertarTiempo(tiempo tiempo){
        String query="INSERT INTO TIEMPO(tiempo,origen_TIENDA_idTienda,destino_TIENDA_idTienda  ) "
                    +"VALUES(?,?,?)";
        Connection conexion=null;
        PreparedStatement llevar=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            llevar=conexion.prepareStatement(query);
            llevar.setInt(1, tiempo.getTiempo());
            llevar.setString(2, tiempo.getTienda1());
            llevar.setString(3, tiempo.getTienda2());
            llevar.executeLargeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(conexion);
            Conexion.conexionMysql.close(llevar);
        }
    }
}
