package dao;

import clases.tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bladimir
 */
public class daoTienda {
    public void insertarTienda(tienda tienda){
        String query="INSERT INTO TIENDA(idTienda,nombreTienda,direccionTienda,telefonoTienda1,telefonoTienda2,correoTienda,horario) "
                    +"VALUES(?,?,?,?,?,?,?)";
        String queryOrigen="INSERT INTO origen(TIENDA_idTienda) VALUES(?)";
        String querydestino="INSERT INTO destino(TIENDA_idTienda) VALUES(?)";
        Connection conexion=null;
        PreparedStatement llevar=null;
        PreparedStatement origen=null;
        PreparedStatement destino=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            llevar=conexion.prepareStatement(query);
            origen=conexion.prepareStatement(queryOrigen);
            destino=conexion.prepareStatement(querydestino);
            llevar.setString(1, tienda.getCodigo());
            llevar.setString(2, tienda.getNombre());
            llevar.setString(3, tienda.getDireccion());
            llevar.setString(4, tienda.getTelefono1());
            llevar.setString(5, tienda.getTelefono2());
            llevar.setString(6, tienda.getCorreo());
            llevar.setString(7, tienda.getHorario());
            //llena las tablas union de origen destino
            origen.setString(1, tienda.getCodigo());
            destino.setString(1, tienda.getCodigo());
            llevar.executeUpdate();
            origen.executeUpdate();
            destino.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(conexion);
            Conexion.conexionMysql.close(llevar);
            Conexion.conexionMysql.close(origen);
            Conexion.conexionMysql.close(destino);
        }
    } 
    public List<clases.tienda> listaTienda(){
        List<tienda> listado = new ArrayList<>();
        String query="SELECT idTienda FROM TIENDA";
        Connection conexion=null;
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            obtener=conexion.prepareStatement(query);
            rs=obtener.executeQuery(query);
            while(rs.next()){
                String id=rs.getString("idTienda");
                tienda lista=new tienda(id);
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
