package reportes;

import java.util.Date;

/**
 *
 * @author bladimir
 */
public class ClaseReporte6 {
    private String nit;
    private String nombreCliente;
    private String direccion;
    private String codigoPedido;
    private Date fecha;

    public ClaseReporte6(String nit, String nombreCliente, String direccion, String codigoPedido, Date fecha) {
        this.nit = nit;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.codigoPedido = codigoPedido;
        this.fecha = fecha;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
