/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

/**
 *
 * @author bladimir
 */
public class ClaseReporte5 {
    private int idVenta;
    private double total;
    private String NIT;
    private String nombre;

    public ClaseReporte5(int idVenta, double total, String NIT, String nombre) {
        this.idVenta = idVenta;
        this.total = total;
        this.NIT = NIT;
        this.nombre = nombre;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
