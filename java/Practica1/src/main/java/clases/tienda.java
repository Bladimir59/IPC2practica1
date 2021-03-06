package clases;

/**
 *
 * @author Bladimir
 */
public class tienda {
    private String nombre;
    private String direccion;
    private String codigo;
    private String telefono1;
    private String telefono2;
    private String correo;
    private String horario;
    //contructor para nuevo ingreso
    public tienda(String nombre, String direccion, String codigo, String telefono1, String telefono2, String correo, String horario) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigo = codigo;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.correo = correo;
        this.horario = horario;
    }
    //contructor para la carga de archivo
    public tienda(String nombre, String direccion, String codigo, String telefono1) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigo = codigo;
        this.telefono1 = telefono1;
    }

    public tienda(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public tienda(String codigo) {
        this.codigo = codigo;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
}
