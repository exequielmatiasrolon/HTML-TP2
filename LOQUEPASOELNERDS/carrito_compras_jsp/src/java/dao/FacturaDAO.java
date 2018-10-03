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
import model.Factura;
import model.Producto;


/**
 *
 * @author Bazan
 */
public class FacturaDAO extends ConexionDAO {
    
//    public List<Producto> getProductos() throws Exception{
//        Connection conn = null;
//        ResultSet rs=null;
//        PreparedStatement ps=null;
//        Producto p = null;
//        List<Producto> lista=new ArrayList<Producto>();
//        
//        try {
//            conn = this.getDs().getConnection();
//            String vsql="SELECT * FROM productos ORDER BY nombre";
//            ps = conn.prepareStatement(vsql);
//            
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                p = new Producto();
//                p.setId(rs.getInt("id"));
//                p.setNombre(rs.getString("nombre"));
//                p.setDescripcion(rs.getString("descripcion"));
//                p.setPrecio(rs.getBigDecimal("precio"));
//                p.setTalle(rs.getString("talle"));
//                p.setColor(rs.getString("color"));
//                
//                lista.add(p);
//            }
//            rs.close();
//            rs=null;
//            ps.close();
//            ps=null;
//            conn.close();
//            conn=null;
//
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            cierra_todo(rs, conn, ps);
//        }
//        return lista;
//     }
//    
//    public Producto getProductoById(int idProducto) throws Exception{
//        Connection conn = null;
//        ResultSet rs=null;
//        PreparedStatement ps=null;
//        Producto p = null;
//        
//        try {
//            conn = this.getDs().getConnection();
//            String vsql="SELECT * FROM productos where id=? ";
//            ps = conn.prepareStatement(vsql);
//            ps.setInt(1, idProducto);
//            rs = ps.executeQuery();
//            
//            if (rs.next()) {
//                p = new Producto();
//                p.setId(rs.getInt("id"));
//                p.setNombre(rs.getString("nombre"));
//                p.setDescripcion(rs.getString("descripcion"));
//                p.setPrecio(rs.getBigDecimal("precio"));
//                p.setTalle(rs.getString("talle"));
//                p.setColor(rs.getString("color"));
//            }
//            rs.close();
//            rs=null;
//            ps.close();
//            ps=null;
//            conn.close();
//            conn=null;
//
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            cierra_todo(rs, conn, ps);
//        }
//        return p;
//     }
    
    public Factura obtenerFactura(int id_factura) throws Exception{
        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        Factura f=null;
        
        try{
            conn = this.getDs().getConnection();
            String vsql="SELECT * FROM facturas WHERE id_factura=?";
            ps=conn.prepareStatement(vsql);
            ps.setInt(1, id_factura);
            rs = ps.executeQuery();
            
            if(rs.next()){
                f=new Factura();
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

    
    public int guardaFacturas(Factura factura) throws Exception{
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int id_factura;
        
        try{
            conn = this.getDs().getConnection();
            String key[]={"id_factura"};
            
            String vsql="INSERT INTO factura (id_usuario,numero_tarjeta,titular_tarjeta,monto) VALUES (?,?,?,?)";
            ps = conn.prepareStatement(vsql,key);
            ps.setInt(1, factura.getId_usuario());
            ps.setString(2,factura.getNumero_tarjeta());
            ps.setString(3, factura.getTitular_tarjeta());
            ps.setBigDecimal(4,factura.getMonto());
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
    
    
    public void guardaCarritos(Carrito carrito, int id_factura) throws Exception{
        Connection conn=null;
        PreparedStatement ps= null;
        
        try{
            conn = this.getDs().getConnection();
            
            for(int i=0; i<carrito.contarProductos();i++){
                String vsql="INSERT INTO carrito (id_factura,id_producto,nombre,descripcion,talle,precio) VALUES (?,?,?,?,?,?)";
                ps = conn.prepareStatement(vsql);
                ps.setInt(1, id_factura);
                ps.setInt(2, carrito.getProductos().get(i).getId());
                ps.setString(3,carrito.getProductos().get(i).getNombre());
                ps.setString(4, carrito.getProductos().get(i).getDescripcion());
                ps.setString(5, carrito.getProductos().get(i).getTalle());
                ps.setBigDecimal(6, carrito.getProductos().get(i).getPrecio());
                ps.executeUpdate();
            }
        
            ps.close();
            ps=null;
            conn.close();
            conn=null;
            
        } catch (Exception e){
            throw e;
        }
        
    }
        
}
