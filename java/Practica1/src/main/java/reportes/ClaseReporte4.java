/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.sql.Date;

/**
 *
 * @author bladimir
 */
public class ClaseReporte4 {
    private String nombre;
    private String codigoPedido;
    private double anticipo;
    private double total;
    private Date fechaEntrega;

    public ClaseReporte4(String nombre, String codigoPedido, double anticipo, double total, Date fechaEntrega) {
        this.nombre = nombre;
        this.codigoPedido = codigoPedido;
        this.anticipo = anticipo;
        this.total = total;
        this.fechaEntrega = fechaEntrega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
    
}
