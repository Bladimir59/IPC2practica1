package logica;

import clases.usuario;
import dao.daoUsuario;

/**
 *
 * @author Bladimir
 */
public class recuperarDatos {
    public void recuperarUsuario(String id){
        dao.daoUsuario regreso=new daoUsuario();
        usuario traido=regreso.obtenerUsuarioCodigo(id);
        System.out.println("nombre "+traido.getNombre());
        System.out.println(""+traido.toString());
    }  
}
