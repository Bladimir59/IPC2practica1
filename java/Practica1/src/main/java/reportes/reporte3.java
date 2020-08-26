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
public class reporte3 {
    public List<ClaseReporte3> repor3(String fecha){
        List<reportes.ClaseReporte3> listado = new ArrayList<>();
        String query="SELECT codigoPedido,fechaEntrega,total,CLIENTE_NIT "
                + "FROM PEDIDOS WHERE fechaEntrega  BETWEEN '2010-07-29' AND ?";
        Connection conexion=null;
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            obtener=conexion.prepareStatement(query);
            obtener.setString(1, fecha);
            rs=obtener.executeQuery();
            while(rs.next()){
                ClaseReporte3 lista=new ClaseReporte3(rs.getString("codigoPedido"),rs.getDate("fechaEntrega"),rs.getDouble("total"),rs.getString("CLIENTE_NIT"));
                lista.setCodigo(rs.getString("codigoPedido"));
                lista.setFecha(rs.getDate("fechaEntrega"));
                lista.setTotal(rs.getDouble("total"));
                lista.setCliente(rs.getNString("CLIENTE_NIT"));
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
