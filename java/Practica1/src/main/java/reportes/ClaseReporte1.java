package reportes;

import java.util.Date;

/**
 *
 * @author Bladimir
 */
public class ClaseReporte1 {
    private String nombre;
    private String codigo;
    private Date fecha;

    public ClaseReporte1(String nombre, String codigo, Date fecha) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
