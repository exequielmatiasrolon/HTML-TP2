/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import static java.lang.Integer.valueOf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Carrito;
import model.Venta;
import model.Producto;
/**
 *
 * @author marti
 */
public class VentaDAO extends ConexionDAO {
       public int guardarVenta(Venta venta) throws Exception{
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int id_factura;
        
        try{
            conn = this.getDs().getConnection();
            String key[]={"id_factura"};
            java.util.Date d = new java.util.Date();
            String date = new String();
            
            String vsql="INSERT INTO venta (id_usuario,numero_tarjeta,titular_tarjeta,monto,vencimiento,fecha) VALUES (?,?,?,?,?,?)";
            ps = conn.prepareStatement(vsql,key);
            ps.setInt(1, venta.getId_usuario());
            ps.setString(2,venta.getNumero_tarjeta());
            ps.setString(3, venta.getTitular_tarjeta());
            ps.setBigDecimal(4,venta.getMonto());
            ps.setString(5,venta.getFechaVen());
            ps.setDate(6, venta.getFecha());
            
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                id_factura=rs.getInt(1);
                return id_factura;
            }
            
            ps.close();
            ps=null;
            conn.close();
            conn=null;
            
        } catch (Exception e) {
            throw e;
        }
        
        return 0;
    
    }
   public Venta obtenerVenta(int id_factura) throws Exception{
        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        Venta f=null;
        
        try{
            conn = this.getDs().getConnection();
            String vsql="SELECT * FROM venta WHERE id_factura=?";
            ps=conn.prepareStatement(vsql);
            ps.setInt(1, id_factura);
            rs = ps.executeQuery();
            
            if(rs.next()){
                f=new Venta();
                f.setId_factura(rs.getInt("id_factura") );
                f.setId_usuario(rs.getInt("id_usuario") );
                f.setTitular_tarjeta(rs.getString("titular_tarjeta"));
                f.setNumero_tarjeta(rs.getString("numero_tarjeta"));
                f.setMonto(rs.getBigDecimal("monto"));
                
            }
            rs.close();
            rs=null;
            ps.close();
            ps=null;
            conn.close();
            conn=null;
            
        } catch (Exception e){
            throw e;
        }
        
        return f;
    }
}
