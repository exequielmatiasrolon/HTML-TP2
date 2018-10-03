/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Producto;
import model.Usuario;
import model.Venta;



public class VentaDao extends ConexionDAO{

   
    
    
 /*public Venta getVenta(String nombre,String email,String fecha,String hora, String NroTarjeta, String MontoCompra) throws Exception{
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        Venta venta = null;
        
        
        try {
            conn = this.getDs().getConnection();
            String vsql="SELECT * FROM Venta";
            ps = conn.prepareStatement(vsql);
            
             rs = ps.executeQuery();
                
             venta = new Venta();
                
                venta.setNombre(rs.getString(nombre));
                venta.setEmail(rs.getString(email));
                
                
                
               
            rs.close();
            rs=null;
            ps.close();
            ps=null;
            conn.close();
            conn=null;

        } catch (Exception e) {
            throw e;
        } finally {
            cierra_todo(rs, conn, ps);
        }
        return venta;
     }
     */
    
      public String setVenta(Venta v) throws Exception{
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        String id="0";
        
        
        try {
            // insert
            conn = this.getDs().getConnection();
            String vsql= "insert into ventas(monto,usuario,fecha,hora) values(?,?,?,?) returning idventas ";
            ps = conn.prepareStatement(vsql);
            ps.setBigDecimal(1, v.getMontocompra());
            ps.setString(2, v.getNombre() );
            ps.setString(3,v.getFecha());
            ps.setString(4,v.getHora());
            rs = ps.executeQuery(); 
            rs.next();
            id = rs.getString("idventas");
            // rescato el id generado 
           /* conn = this.getDs().getConnection();
            vsql="SELECT * FROM Venta";
            ps = conn.prepareStatement(vsql);
            
             rs = ps.executeQuery();
                
             venta = new Venta();
                
                venta.setNombre(rs.getString(nombre));
                venta.setEmail(rs.getString(email));
            */
            
            rs.close();
            rs=null;
            ps.close();
            ps=null;
            conn.close();
            conn=null;
                                   
            
        } catch (Exception e) {
            throw e;
        } finally {
            cierra_todo(rs, conn, ps);
        }
      //  return venta;
        return id;
     }
      
    
    
 }
    
