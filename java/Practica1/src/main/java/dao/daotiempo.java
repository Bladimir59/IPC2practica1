package dao;

import clases.tiempo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bladimir
 */
public class daotiempo {
    //para la lectura de archivo
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
    //QUERY PARA LLAMAR AL TIEMPO
    //SELECT * FROM TIEMPO WHERE origen_TIENDA_idTienda='ABC-1' AND destino_TIENDA_idTienda='ABC-3' OR origen_TIENDA_idTienda='ABC-3' AND destino_TIENDA_idTienda='ABC-1';
    public int tiempoPedido(String tiendaorigen,String tiendaDestino){
        String query="SELECT tiempo FROM TIEMPO WHERE origen_TIENDA_idTienda=? AND destino_TIENDA_idTienda=?"
                + "OR origen_TIENDA_idTienda=? AND destino_TIENDA_idTienda=?";
        int Tiempo=0;
        Connection conexion=null;
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            obtener=conexion.prepareStatement(query);
            obtener.setString(1, tiendaorigen);
            obtener.setString(2, tiendaDestino);
            obtener.setString(3, tiendaDestino);
            obtener.setString(4, tiendaorigen);
            rs=obtener.executeQuery();
            while(rs.next()){
                tiempo lista=new tiempo(rs.getInt("tiempo"));
                lista.setTiempo(rs.getInt("tiempo"));
                Tiempo=lista.getTiempo();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(rs);
            Conexion.conexionMysql.close(obtener);
            Conexion.conexionMysql.close(conexion);
        }
        return Tiempo; 
    }
}
