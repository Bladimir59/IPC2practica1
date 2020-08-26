package reportes;

import java.sql.Date;

/**
 *
 * @author bladimir 
 */
public class ClaseReporte2 {
    private String codigoPedido;
    private Date fecha;
    private double total;
    private String cliente;

    public ClaseReporte2(String codigoPedido, Date fecha, double total, String cliente) {
        this.codigoPedido = codigoPedido;
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    
    
}
