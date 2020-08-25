package clases;

/**
 *
 * @author Bladimir
 */
public class usuario {
    private String nombre;
    private String telefono;
    private String DPI;
    private String codigo;
    private String NIT;
    private String correo;
    private String direccion;
    //contructor para todo los metodos
    public usuario(String nombre, String telefono, String DPI, String codigo, String NIT, String correo, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.DPI = DPI;
        this.codigo = codigo;
        this.NIT = NIT;
        this.correo = correo;
        this.direccion = direccion;
    }
    //generado para la carga de archivo 
    public usuario(String nombre, String telefono, String DPI, String codigo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.DPI = DPI;
        this.codigo = codigo;
    }
    //para el login recuperar los datos de la base de datos 

    public usuario(String codigo) {
        this.codigo = codigo;
    }

    public usuario(String codigo, String direccion) {
        this.codigo = codigo;
        this.direccion = direccion;
    }

    
    public usuario() {
    }
    

    @Override
    public String toString() {
        return "usuario{" + "nombre=" + nombre + ", telefono=" + telefono + ", DPI=" + DPI + ", codigo=" + codigo + ", NIT=" + NIT + ", correo=" + correo + ", direccion=" + direccion + '}';
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

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
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
