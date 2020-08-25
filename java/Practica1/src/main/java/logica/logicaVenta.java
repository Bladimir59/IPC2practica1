package logica;

import clases.cliente;
import clases.venta;
import dao.daoCliente;

/**
 *
 * @author Bladimir
 */
public class logicaVenta {
    public void editarCredito(String nit,double  credito){
        cliente editarCredito=new cliente(nit, credito);
        dao.daoCliente modifi=new daoCliente();
        modifi.cambiarUnDato(editarCredito);
    }
}
