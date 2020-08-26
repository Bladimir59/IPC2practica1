package logica;

import clases.cliente;
import clases.pedidos;
import clases.producto;
import clases.tiempo;
import clases.tienda;
import clases.usuario;
import dao.daoCliente;
import dao.daoPedidos;
import dao.daoProducto;
import dao.daoTienda;
import dao.daoUsuario;
import dao.daotiempo;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Bladimir
 */
public class logicaLectura {
    public String tienda(String datoTienda){
        String[] partes=datoTienda.split(",");
        System.out.println(""+partes[3]);
        tienda nuevotienda=new tienda(partes[1], partes[2], partes[3], partes[4]);
        dao.daoTienda llenartienda=new daoTienda();
        llenartienda.insertarTienda(nuevotienda);
        System.out.println(""+datoTienda);
        return datoTienda;
    }
    public String usuario(String datoUsuario){
        String[] partes=datoUsuario.split(",");
        usuario nuevo=new usuario(partes[1], partes[3], partes[4], partes[2]);
        dao.daoUsuario llenar=new daoUsuario();
        llenar.insertarUsuario(nuevo);
        System.out.println(""+datoUsuario);
        return datoUsuario;
    } 
    public String cliente(String datoCliente){
        String[] partes=datoCliente.split(",");
        double credito=Double.parseDouble(partes[4]);
        cliente nuevo=new cliente(partes[1], partes[3], partes[2], credito);
        dao.daoCliente llenar=new daoCliente();
        llenar.insertarCliente(nuevo);
        System.out.println(""+datoCliente);
        return datoCliente;
    }
    public String tiempo(String datoTiempo){
        String[] partes=datoTiempo.split(",");
        int time=Integer.parseInt(partes[3]);
        tiempo nuevo=new tiempo(time, partes[1], partes[2]);
        dao.daotiempo llenar=new daotiempo();
        llenar.insertarTiempo(nuevo);
        System.out.println(""+datoTiempo);
        return datoTiempo;
    }
    public String producto(String datoproducto){
        String[] partes=datoproducto.split(",");
        int cantida=Integer.parseInt(partes[4]);
        Double precio=Double.parseDouble(partes[5]);
        producto nuevo=new producto(partes[1], partes[2],partes[3], cantida, precio, partes[6]);
        dao.daoProducto llenar=new daoProducto();
        llenar.insertarProducto(nuevo);
        System.out.println(""+datoproducto);
        return datoproducto;
    }
    public String pedido(String datoPedido){
        String[] partes=datoPedido.split(",");
        int cantidad=Integer.parseInt(partes[7]);
        Double total=Double.parseDouble(partes[8]);
        Double anticipo=Double.parseDouble(partes[9]);
        daotiempo tiempo=new daotiempo();
        int numero=tiempo.tiempoPedido(partes[2], partes[3]);
        
        pedidos nuevo=new pedidos(partes[1], partes[2], partes[3], partes[5], partes[6],cantidad , total, anticipo, getDate(partes[4]));
        dao.daoPedidos llenar=new daoPedidos();
        llenar.insertarPedidos(nuevo);
        System.out.println(""+datoPedido);
        return datoPedido;
    }
    public static java.sql.Date getDate(String fechainicial){
        java.sql.Date dato=null;
        try {
            SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fecha=formato.parse(fechainicial);
            dato=new java.sql.Date(fecha.getTime());
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return dato;
    }
    
}
