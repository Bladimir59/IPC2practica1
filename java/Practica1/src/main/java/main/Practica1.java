package main;

import Interface.Empleado;
import Interface.cargaArchivo;
import Interface.nuevosDatos;
import clases.cliente;
import clases.producto;
import clases.usuario;
import clases.venta;
import dao.daoCliente;
import dao.daoProducto;
import dao.daoUsuario;
import dao.daoVenta;
import java.awt.image.DataBuffer;
import java.text.SimpleDateFormat;
import java.util.List;
import logica.BuscarDatos;



/**
 *
 * @author Bladimir
 */
public class Practica1 {
    public static void main(String[] args) {
        BuscarDatos ir=new BuscarDatos();
        ir.dirige();  
//        login ir=new login();
//        ir.show();
        
//        nuevosDatos ir=new nuevosDatos();
//        ir.show();
//        Empleado ir=new Empleado();
  //      ir.show();     
//        cargaArchivo ir=new cargaArchivo();
  //      ir.show();
//        dao.daoProducto nuevo=new daoProducto();
//        List<producto> listado=nuevo.listaProductosVenta("ABC-1");
//        for (int i = 0; i < listado.size(); i++) {
//            System.out.println(""+listado.get(i).toString());
//        }
//        daoCliente lista=new daoCliente();
//        List<cliente> listado=lista.listaCliente();
//        for (int i = 0; i < listado.size(); i++) {
//            System.out.println(""+listado.get(i).toString());

        
//        String fecha="2020-06-02";
//        venta nuevo=new venta("ABC-1", "R-1752", 5, getDate(fecha));
//        dao.daoVenta llenar=new daoVenta();
//        int id=llenar.insertarVenta(nuevo);
//        System.out.println(""+id);
//       
//    }
//    public static java.sql.Date getDate(String fechainicial){
//        java.sql.Date dato=null;
//        try {
//            SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
//            java.util.Date fecha=formato.parse(fechainicial);
//            dato=new java.sql.Date(fecha.getTime());
//        } catch (Exception ex) {
//            ex.printStackTrace(System.out);
//        }
//        return dato;
// MODIFICAR USUARIO
//        usuario nuevo=new usuario("stiven", "59012221", "no se", "11111", "tampoco", "casimiro@gmail.com", "chuisuc");
//        daoUsuario llenar=new daoUsuario();
//        llenar.modificarUsuario(nuevo);
//MODIFICAR SOLO UN DATO
       
    }
}