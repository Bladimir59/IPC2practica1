package main;

import Interface.Empleado;
import Interface.cargaArchivo;
import Interface.nuevosDatos;
import clases.cliente;
import clases.producto;
import clases.venta;
import dao.daoCliente;
import dao.daoProducto;
import dao.daoVenta;
import java.awt.image.DataBuffer;
import java.text.SimpleDateFormat;
import java.util.List;



/**
 *
 * @author Bladimir
 */
public class Practica1 {
    public static void main(String[] args) {
//        login ir=new login();
//        ir.show();
//        dao.daoUsuario ver_lista=new daoUsuario();
//        List<usuario> listado =ver_lista.listaCodigo();
//        for (int i = 0; i < listado.size(); i++) {
//            System.out.println(""+listado.get(i).getCodigo());
//        }
//        nuevosDatos ir=new nuevosDatos();
//        ir.show();
//    }
        Empleado ir=new Empleado();
        ir.show();     
//        cargaArchivo ir=new cargaArchivo();
//        ir.show();
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
    }
}