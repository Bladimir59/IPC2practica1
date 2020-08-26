/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bladimir
 */
public class reporte5 {
    public List<ClaseReporte5> repo5(String codigo){
        List<reportes.ClaseReporte5> listado = new ArrayList<>();
        String query="SELECT idVENTAS,TOTAL,nombreCliente,NIT "
                + "FROM VENTA V INNER JOIN CLIENTE C ON V.CLIENTE_NIT=C.NIT WHERE NIT=?";
        Connection conexion=null;
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            obtener=conexion.prepareStatement(query);
            obtener.setString(1, codigo);
            rs=obtener.executeQuery();
            while(rs.next()){
                ClaseReporte5 lista=new ClaseReporte5(rs.getInt("idVENTAS"),rs.getDouble("TOTAL"),rs.getString("NIT"),rs.getString("nombreCliente"));
                lista.setIdVenta(rs.getInt("idVENTAS"));
                lista.setTotal(rs.getDouble("TOTAL"));
                lista.setNIT(rs.getString("NIT"));
                lista.setNombre(rs.getString("nombreCliente"));
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
