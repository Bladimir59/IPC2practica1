package clases;

/**
 *
 * @author Bladimir
 */
public class pedidos {
    
    private String codigoPedido;
    private double total;
    private String tienda1;
    private String tienda2;
    private String cliente;
    private String articulo;
    private int cantidad;
    private double anticipo;
    
//usar para registrar un nuevo pedido
    public pedidos(String codigoPedido, double total, String tienda1, String cliente, String articulo, int cantidad, double anticipo) {
        this.codigoPedido = codigoPedido;
        this.total = total;
        this.tienda1 = tienda1;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.anticipo = anticipo;
    }
//pedido para nuevo pedido
    public pedidos(String codigoPedido, double total, String tienda1, String tienda2, String cliente, String articulo, int cantidad, double anticipo) {
        this.codigoPedido = codigoPedido;
        this.total = total;
        this.tienda1 = tienda1;
        this.tienda2 = tienda2;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.anticipo = anticipo;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }
    
    
    
}
