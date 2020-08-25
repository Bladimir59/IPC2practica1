package logica;

import clases.producto;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author bladimir
 */
public class llenarJcombo {
    public void llenarCOdigo(JComboBox  codigos) {
        String dato;
        codigos.removeAllItems();
        dao.daoProducto ver_lista=new dao.daoProducto();
        List<producto> listado =ver_lista.listaCodigo();
        try {               
            for (int i = 0; i < listado.size(); i++) {
                dato=listado.get(i).getCodigo();
                codigos.addItem(dato);
            }
        } catch (Exception e) {
        }
    }
    public void llenarNombre(JComboBox nombre) {
        String dato;
        nombre.removeAllItems();
        dao.daoProducto ver_lista=new dao.daoProducto();
        List<producto> listado =ver_lista.listaNombre();
        try {        
            for (int i = 0; i < listado.size(); i++) {
                dato=listado.get(i).getNombre();
                nombre.addItem(dato);
            }
        } catch (Exception e) {
        }
    }
}
