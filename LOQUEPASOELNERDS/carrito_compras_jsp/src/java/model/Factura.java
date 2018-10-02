/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Bazan
 */
public class Factura implements Serializable {
 
    private int id_usuario;
    private Integer id_factura;
    private java.sql.Date fecha;
    private String numero_tarjeta;
    private String titular_tarjeta;
    private BigDecimal monto;


    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_factura() {
        return id_factura;
    }

    public void setId_factura(Integer id_factura) {
        this.id_factura = id_factura;
    }

    public java.sql.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public String getTitular_tarjeta() {
        return titular_tarjeta;
    }

    public void setTitular_tarjeta(String titular_tarjeta) {
        this.titular_tarjeta = titular_tarjeta;
    }
    
    public BigDecimal getMonto(){
        return monto;
    }
    
    public void setMonto(BigDecimal monto){
        this.monto=monto;
    }


}
