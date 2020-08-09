package clases;

/**
 *
 * @author Bladimir
 */
public class cliente {
    private String nombre;
    private String telefono;
    private String NIT;
    private String DPI;
    private double credito;
    private String correo;
    private String direccion;
    //para ingreso de nuevo clientes
    public cliente(String nombre, String telefono, String NIT, String DPI, double credito, String correo, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.NIT = NIT;
        this.DPI = DPI;
        this.credito = credito;
        this.correo = correo;
        this.direccion = direccion;
    }
    //constructor para carga de archivo
    public cliente(String nombre, String telefono, String NIT, double credito) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.NIT = NIT;
        this.credito = credito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
