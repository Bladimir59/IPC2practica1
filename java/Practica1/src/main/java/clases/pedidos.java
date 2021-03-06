package clases;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Bladimir
 */
public class pedidos {
    SimpleDateFormat date=new SimpleDateFormat();
    private String codigoPedido;
    private String tienda1;
    private String tienda2;
    private String cliente;
    private String articulo;
    private int cantidad;
    private double total;
    private double anticipo;
    private Date fecha;
    private Date fechaEntrega;
    private boolean enTienda;
//usar para registrar un nuevo pedido

    public pedidos(String codigoPedido, String tienda1, String tienda2, String cliente, String articulo, int cantidad, double total, double anticipo, Date fecha, Date fechaEntrega, boolean enTienda) {
        this.codigoPedido = codigoPedido;
        this.tienda1 = tienda1;
        this.tienda2 = tienda2;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.total = total;
        this.anticipo = anticipo;
        this.fecha = fecha;
        this.fechaEntrega = fechaEntrega;
        this.enTienda = enTienda;
    }
    

//pedido para carga de archivo

    public pedidos(String codigoPedido, String tienda1, String tienda2, String cliente, String articulo, int cantidad, double total, double anticipo, Date fecha) {
        this.codigoPedido = codigoPedido;
        this.tienda1 = tienda1;
        this.tienda2 = tienda2;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.total = total;
        this.anticipo = anticipo;
        this.fecha = fecha;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public boolean isEnTienda() {
        return enTienda;
    }

    public void setEnTienda(boolean enTienda) {
        this.enTienda = enTienda;
    }
    

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getTienda1() {
        return tienda1;
    }

    public void setTienda1(String tienda1) {
        this.tienda1 = tienda1;
    }

    public String getTienda2() {
        return tienda2;
    }

    public void setTienda2(String tienda2) {
        this.tienda2 = tienda2;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
