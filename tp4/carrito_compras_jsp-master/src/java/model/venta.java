/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author hp
 */
public class venta {
    List <Producto> productos;
    MetodoPago metotopago;
    Usuario usuario;
    Double montoTotal;
    Date fecha;
    Time hora;
    int nrotransaccion;
    
}
