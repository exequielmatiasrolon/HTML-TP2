/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import dao.UsuarioDAO;
import dao.VentaDao;
import java.math.BigDecimal;
import model.Venta;
/**
 *
 * @author hp
 */
public class VentaRN {
  //  public static Venta guardarVenta(String nombre, BigDecimal monto) throws Exception {
      public static String guardarVenta(Venta v) throws Exception {
        VentaDao venta = new VentaDao();
        //return Venta.setVenta(nombre, monto);
         return venta.setVenta(v);
         
    }  
    
}
