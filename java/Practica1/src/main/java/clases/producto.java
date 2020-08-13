package clases;

/**
 *
 * @author Bladimir
 */
public class producto {
    private String nombre;
    private String fabrica;
    private String codigo;
    private int cantidad;
    private Double precio;
    private String descripcion;
    private int garantia;
    private String idTienda;
    //CONTRUCTOR PARA EL ENVIO DE ARCHIVOS COMPLETO

    public producto(String nombre, String fabrica, String codigo, int cantidad, Double precio, String descripcion, int garantia, String idTienda) {
        this.nombre = nombre;
        this.fabrica = fabrica;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.garantia = garantia;
        this.idTienda = idTienda;
    }
    
    //CONTRUCTOR PARA LA CARGA DE ARCHIVO

    public producto(String nombre, String fabrica, String codigo, int cantidad, Double precio, String idTienda) {
        this.nombre = nombre;
        this.fabrica = fabrica;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.idTienda = idTienda;
    }
    

    public String getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(String idTienda) {
        this.idTienda = idTienda;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabrica() {
        return fabrica;
    }

    public void setFabrica(String fabrica) {
        this.fabrica = fabrica;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }
    
}
