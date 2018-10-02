/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import model.Carrito;
import model.Venta;
import dao.VentaDAO;

/**
 *
 * @author Cecy
 */
public class CarritoRN {
     public static Venta obtenerVenta(int id_factura) throws Exception{
        VentaDAO venDao= new VentaDAO();
        return venDao.obtenerVenta(id_factura);
    }
    
    public static void guardarVenta(Venta venta, Carrito carrito) throws Exception{
        VentaDAO venDao= new VentaDAO();
        int id_factura = venDao.guardarVenta(venta);
        
    }
    
}
