package clases;

/**
 *
 * @author Bladimir
 */
public class tiempo {
    private int tiempo;
    private String tienda1;
    private String tienda2;

    public tiempo(int tiempo, String tienda1, String tienda2) {
        this.tiempo = tiempo;
        this.tienda1 = tienda1;
        this.tienda2 = tienda2;
    }

    public tiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
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
    
}
