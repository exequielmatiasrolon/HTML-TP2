/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 *
 * @author Keko Matias Rolon
 */
public class Venta implements Serializable{
    
    
    private String nombre;
    private String email;
    private String Fecha;
    private String Hora;
    private String NroTarjeta;
    private String Montocompra;
    
   

    public void agregarVenta(Venta venta){
    
        
        
    
    
    }
    
    

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getNroTarjeta() {
        return NroTarjeta;
    }

    public void setNroTarjeta(String NroTarjeta) {
        this.NroTarjeta = NroTarjeta;
    }

    public String getMontocompra() {
        return Montocompra;
    }

    public void setMontocompra(String Montocompra) {
        this.Montocompra = Montocompra;
    }
    
    
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
