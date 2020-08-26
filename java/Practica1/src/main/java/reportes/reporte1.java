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
public class reporte1 {
    //SELECT EnTienda,nombreProducto,cantidadProducto FROM PEDIDOS P INNER JOIN PEDIDOSdePRODUCTO PP ON P.codigoPedido = PP.PEDIDOS_codigoPedido INNER JOIN PRODUCTO S ON S.idPRODUCTO=PP.PRODUCTO_idPRODUCTO WHERE P.EnTienda is true;

   //SELECT nombreTienda,codigoPedido,fechaEntrega FROM TIENDA T INNER JOIN destino d on T.idTienda =d.TIENDA_idTienda INNER JOIN PEDIDOS P ON P.destino_TIENDA_idTienda=d.TIENDA_idTienda WHERE T.idTienda='ABC-2';
    public List<ClaseReporte1> repo1(String codigo){
        List<reportes.ClaseReporte1> listado = new ArrayList<>();
        String query="SELECT nombreTienda,codigoPedido,fechaEntrega "
                + "FROM TIENDA T INNER JOIN destino d on T.idTienda =d.TIENDA_idTienda "
                + "INNER JOIN PEDIDOS P ON P.destino_TIENDA_idTienda=d.TIENDA_idTienda WHERE T.idTienda=?";
        Connection conexion=null;
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            obtener=conexion.prepareStatement(query);
            obtener.setString(1, codigo);
            rs=obtener.executeQuery();
            while(rs.next()){
                ClaseReporte1 lista=new ClaseReporte1(rs.getString("nombreTienda"),rs.getString("codigoPedido"),rs.getDate("fechaEntrega"));
                lista.setNombre(rs.getString("nombreTienda"));
                lista.setCodigo(rs.getString("codigoPedido"));
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
 