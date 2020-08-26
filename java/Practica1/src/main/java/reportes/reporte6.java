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
public class reporte6 {
    public List<ClaseReporte6> repo6(String codigo){
        List<reportes.ClaseReporte6> listado = new ArrayList<>();
        String query="SELECT NIT,nombreCliente,direccionCliente,codigoPedido,fechaEntrega  "
                + "FROM CLIENTE C INNER JOIN PEDIDOS P ON C.NIT=P.CLIENTE_NIT WHERE NIT=?";
        Connection conexion=null;
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            obtener=conexion.prepareStatement(query);
            obtener.setString(1, codigo);
            rs=obtener.executeQuery();
            while(rs.next()){
                ClaseReporte6 lista=new ClaseReporte6(rs.getString("NIT"),rs.getString("nombreCliente"),
                        rs.getString("direccionCliente"),rs.getString("codigoPedido"),rs.getDate("fechaEntrega"));
                lista.setNit(rs.getString("NIT"));
                lista.setNombreCliente(rs.getString("nombreCliente"));
                lista.setDireccion(rs.getString("direccionCliente"));
                lista.setCodigoPedido(rs.getString("codigoPedido"));
                lista.setFecha(rs.getDate("fechaEntrega"));
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
