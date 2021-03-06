package clases;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Bladimir
 */
public class venta {
    SimpleDateFormat date=new SimpleDateFormat();
    private String tiendaVenta;
    private String clienteVenta;
    private String productoVenta;
    private int cantidaProducto;
    private double subtotal;
    private double total;
    private Date fecha;
    private int idVenta;

    public venta(String tiendaVenta, String clienteVenta, double total, Date fecha) {
        this.tiendaVenta = tiendaVenta;
        this.clienteVenta = clienteVenta;
        this.total = total;
        this.fecha = fecha;
    }

    public venta(String productoVenta, int cantidaProducto, double subtotal, int idVenta) {
        this.productoVenta = productoVenta;
        this.cantidaProducto = cantidaProducto;
        this.subtotal = subtotal;
        this.idVenta = idVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public String getTiendaVenta() {
        return tiendaVenta;
    }

    public void setTiendaVenta(String tiendaVenta) {
        this.tiendaVenta = tiendaVenta;
    }

    public String getClienteVenta() {
        return clienteVenta;
    }

    public void setClienteVenta(String clienteVenta) {
        this.clienteVenta = clienteVenta;
    }

    public String getProductoVenta() {
        return productoVenta;
    }

    public void setProductoVenta(String productoVenta) {
        this.productoVenta = productoVenta;
    }

    public int getCantidaProducto() {
        return cantidaProducto;
    }

    public void setCantidaProducto(int cantidaProducto) {
        this.cantidaProducto = cantidaProducto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
