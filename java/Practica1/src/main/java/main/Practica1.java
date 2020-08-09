package main;

import clases.cliente;
import dao.daoCliente;
/**
 *
 * @author Bladimir
 */
public class Practica1 {
    public static void main(String[] args) {
        cliente nuevo=new cliente("dato","dfa","df5s4", 0);
        daoCliente llevar=new daoCliente();
        llevar.insertarCliente(nuevo);
    }
}
