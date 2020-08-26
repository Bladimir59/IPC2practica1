package reportes;

/**
 *
 * @author bladimir
 */
public class claseTabla {
    private String idTienda;
    private String nombreTienda;
    private String direcciontienda;
    private String codigoProducto;
    private String nombreProducto;
    private double precioProducto;
    private int CantidadProducto;

    public claseTabla(String idTienda, String nombreTienda, String direcciontienda, String codigoProducto, String nombreProducto, double precioProducto, int CantidadProducto) {
        this.idTienda = idTienda;
        this.nombreTienda = nombreTienda;
        this.direcciontienda = direcciontienda;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.CantidadProducto = CantidadProducto;
    }

    @Override
    public String toString() {
        return "claseTabla{" + "idTienda=" + idTienda + ", nombreTienda=" + nombreTienda + ", direcciontienda=" + direcciontienda + ", codigoProducto=" + codigoProducto + ", nombreProducto=" + nombreProducto + ", precioProducto=" + precioProducto + ", CantidadProducto=" + CantidadProducto + '}';
    }

    public String getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(String idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getDirecciontienda() {
        return direcciontienda;
    }

    public void setDirecciontienda(String direcciontienda) {
        this.direcciontienda = direcciontienda;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidadProducto() {
        return CantidadProducto;
    }

    public void setCantidadProducto(int CantidadProducto) {
        this.CantidadProducto = CantidadProducto;
    }


}
