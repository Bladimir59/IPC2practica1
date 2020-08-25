package dao;

import clases.cliente;
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
        public List<clases.cliente> listaCliente(){
        List<cliente> listado = new ArrayList<>();
        String query="SELECT nit,nombreCliente,correoCliente,creditoCliente from CLIENTE";
        Connection conexion=null;
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            obtener=conexion.prepareStatement(query);
            rs=obtener.executeQuery();
            while(rs.next()){
                cliente lista=new cliente(rs.getNString("nombreCliente"),rs.getNString("nit") , rs.getDouble("creditoCliente"), rs.getNString("correoCliente"));
                lista.setNIT(rs.getString("nit"));
                lista.setNombre(rs.getNString("nombreCliente"));
                lista.setCredito(rs.getDouble("creditoCliente"));
                lista.setCorreo(rs.getNString("correoCliente"));
                listado.add(lista);
            }
            return listado;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(rs);
            Conexion.conexionMysql.close(obtener);
            Conexion.conexionMysql.close(conexion);
        }
        return listado; 
    }
    //EDITAR EL CREDITO
    public void cambiarUnDato(cliente cliente){
        String query="UPDATE CLIENTE SET creditoCliente=? WHERE NIT=?";
        Connection conexion=null;
        PreparedStatement modificar=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            modificar=conexion.prepareStatement(query);
            modificar.setDouble(1, cliente.getCredito());
            modificar.setString(2, cliente.getNIT());
            modificar.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(modificar);
            Conexion.conexionMysql.close(conexion);
        }
    }
}
