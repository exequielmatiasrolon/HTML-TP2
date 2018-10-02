/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import dao.FacturaDAO;
import model.Carrito;
import model.Factura;

public class CarritoRN {
    public static Factura obtenerFactura(int id_factura) throws Exception{
        FacturaDAO factDao= new FacturaDAO();
        return factDao.obtenerFactura(id_factura);
    }
    
    public static void guardarFactura(Factura factura, Carrito carrito) throws Exception{
        FacturaDAO factDao= new FacturaDAO();
        int id_factura = factDao.guardaFacturas(factura);
        factDao.guardaCarritos(carrito,id_factura);
    }
    
}
