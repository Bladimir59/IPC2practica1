package reportes;

import java.sql.Date;

/**
 *
 * @author Bladimir
 */
public class ClaseReporte3 {
    private String codigo;
    private Date fecha;
    private double total;
    private String cliente;

    public ClaseReporte3(String codigo, Date fecha, double total, String cliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
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
