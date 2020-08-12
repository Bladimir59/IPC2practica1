package logica;

import clases.cliente;
import clases.pedidos;
import clases.tiempo;
import clases.tienda;
import clases.usuario;
import dao.daoCliente;
import dao.daoPedidos;
import dao.daoTienda;
import dao.daoUsuario;
import dao.daotiempo;

/**
 *
 * @author Bladimir
 */
public class logicaLectura {
    public String tienda(String datoTienda){
        String[] partes=datoTienda.split(",");
        tienda nuevotienda=new tienda(partes[1], partes[2], partes[3], partes[4]);
        dao.daoTienda llenartienda=new daoTienda();
        llenartienda.insertarTienda(nuevotienda);
        return datoTienda;
    }
    public String usuario(String datoUsuario){
        String[] partes=datoUsuario.split(",");
        usuario nuevo=new usuario(partes[1], partes[2], partes[3], partes[4]);
        dao.daoUsuario llenar=new daoUsuario();
        llenar.insertarUsuario(nuevo);
        return datoUsuario;
    }
    public String tiempo(String datoTiempo){
        String[] partes=datoTiempo.split(",");
        int time=Integer.parseInt(partes[1]);
        tiempo nuevo=new tiempo(time, partes[1], partes[2]);
        dao.daotiempo llenar=new daotiempo();
        llenar.insertarTiempo(nuevo);
        return datoTiempo;
    }
    public String cliente(String datoCliente){
        String[] partes=datoCliente.split(",");
        double credito=Double.parseDouble(partes[4]);
        cliente nuevo=new cliente(partes[1], partes[2], partes[3], credito);
        dao.daoCliente llenar=new daoCliente();
        llenar.insertarCliente(nuevo);
        return datoCliente;
    }
    public String pedido(String datoPedido){
        String[] partes=datoPedido.split(",");
        pedidos nuevo=new pedidos(partes[1], partes[2], partes[3], partes[4], partes[5], 0, 0, 0, partes[6]);
        dao.daoPedidos llenar=new daoPedidos();
        llenar.insertarPedidos(nuevo);
        return datoPedido;
    }
//    public void cliente(){
//        String[] partes=datoUsuario.split(",");
//        usuario nuevo=new usuario(partes[1], partes[2], partes[3], partes[4]);
//        dao.daoUsuario llenar=new daoUsuario();
//        llenar.insertarUsuario(nuevo);
//        return datoUsuario;
//    }
}
