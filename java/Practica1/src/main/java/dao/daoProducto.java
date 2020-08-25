package dao;

import clases.producto;
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
public class daoProducto {
    public void insertarProducto(producto producto){
        String query="INSERT INTO PRODUCTO(idPRODUCTO,nombreProducto,fabrica,precio,Descripcion,Garantilla)"
                    +"VALUES(?,?,?,?,?,?)ON DUPLICATE KEY UPDATE idPRODUCTO=idPRODUCTO";
        String querytienda_producto="INSERT INTO TIENDASdePRODUCTOS(TIENDA_idTienda,PRODUCTO_idPRODUCTO ,cantidadProducto)"
                    +"VALUES(?,?,?)";
        Connection conexion=null;
        PreparedStatement llevar=null;
        PreparedStatement llevaunion=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            llevar=conexion.prepareStatement(query);
            //llena la tabla de producto
            llevar.setString(1, producto.getCodigo());
            llevar.setString(2, producto.getNombre());
            llevar.setString(3, producto.getFabrica());
            llevar.setDouble(4, producto.getPrecio());
            llevar.setString(5, producto.getDescripcion());
            llevar.setInt(6, producto.getGarantia());
            llevar.executeUpdate();
            //llena la tabla union
            llevaunion=conexion.prepareStatement(querytienda_producto);
            llevaunion.setString(1, producto.getIdTienda());
            llevaunion.setString(2, producto.getCodigo());
            llevaunion.setInt(3, producto.getCantidad());
            llevaunion.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(llevaunion);
            Conexion.conexionMysql.close(llevar);
            Conexion.conexionMysql.close(conexion);
        }
    }
   // metodo de recuperacion de producto para ventas
    public List<clases.producto> listaProductosVenta(String codigoTienda){
        List<producto> listado = new ArrayList<>();
        String query="SELECT idPRODUCTO,nombreProducto,fabrica,PRECIO,Descripcion,GARANTILLA,cantidadProducto FROM PRODUCTO"
                + " INNER JOIN TIENDASdePRODUCTOS ON PRODUCTO.idPRODUCTO = TIENDASdePRODUCTOS.PRODUCTO_idPRODUCTO WHERE TIENDA_idTienda =?";
//agregar de la tabla tiendas de producto su id 
        Connection conexion=null;
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            obtener=conexion.prepareStatement(query);
            obtener.setString(1, codigoTienda);
            rs=obtener.executeQuery();
            while(rs.next()){
                producto lista=new producto(rs.getNString("nombreProducto"), rs.getNString("fabrica"),rs.getNString("idPRODUCTO"),
                        rs.getInt("cantidadProducto"), rs.getDouble("PRECIO"),rs.getString("Descripcion"), rs.getInt("GARANTILLA"));
                lista.setCodigo(rs.getString("idPRODUCTO"));
                lista.setNombre(rs.getNString("nombreProducto"));
                lista.setFabrica(rs.getString("fabrica"));
                lista.setPrecio(rs.getDouble("PRECIO"));
                lista.setDescripcion(rs.getNString("Descripcion"));
                lista.setGarantia(rs.getInt("GARANTILLA"));
                lista.setCantidad(rs.getInt("cantidadProducto"));
               
                listado.add(lista);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(obtener);
            Conexion.conexionMysql.close(conexion);
        }
        return listado; 
    }
    //ver producto por nombre
    public List<producto> listaCodigo(){
        List<producto> listadoCodigopreoducto = new ArrayList<>();
        String query="SELECT idPRODUCTO FROM PRODUCTO";
        Connection conexion=null;
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            obtener=conexion.prepareStatement(query);
            rs=obtener.executeQuery(query);
            while(rs.next()){
                String id=rs.getString("idPRODUCTO");
                producto lista=new producto(id,null);
                lista.setCodigo(id);
                listadoCodigopreoducto.add(lista);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(rs);
            Conexion.conexionMysql.close(obtener);
            Conexion.conexionMysql.close(conexion);
        }
        return listadoCodigopreoducto;
        
    }
    public List<producto> listaNombre(){
        List<producto> listadoCodigopreoducto = new ArrayList<>();
        String query="SELECT nombreProducto FROM PRODUCTO";
        Connection conexion=null;
        PreparedStatement obtener=null;
        ResultSet rs=null;
        try {
            conexion=Conexion.conexionMysql.conectar();
            obtener=conexion.prepareStatement(query);
            rs=obtener.executeQuery(query);
            while(rs.next()){
                String id=rs.getString("nombreProducto");
                producto lista=new producto(id,null);
                lista.setNombre(id);
                listadoCodigopreoducto.add(lista);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.conexionMysql.close(rs);
            Conexion.conexionMysql.close(obtener);
            Conexion.conexionMysql.close(conexion);
        }
        return listadoCodigopreoducto;
        
    }
  //  SELECT idPRODUCTO,nombreProducto,fabrica,PRECIO,Descripcion,GARANTILLA,cantidadProducto FROM PRODUCTO INNER JOIN TIENDASdePRODUCTOS ON PRODUCTO.idPRODUCTO = TIENDASdePRODUCTOS.PRODUCTO_idPRODUCTO
 //   query para ventas
//String query = "SELECT id, codigo, nombre, fabricante, precio, descripcion, garantia, stockProductos "
//               + "FROM productos INNER JOIN tiendasProductos ON productos.codigo = tiendasProductos.productosCodigo "
//               + "WHERE tiendasCodigo = ?"  agregar de la tabla tiendas de producto su id  
}
