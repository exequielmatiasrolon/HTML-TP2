
<%@page import="model.Venta"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>  

<%@page import="RN.ProductoRN"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="model.Producto"%>
<%@page import="model.Carrito"%>
<%@page import="model.Usuario" session="true"%>


<%
  Usuario usuario= (Usuario) session.getAttribute("usuario");   
  if (usuario==null) { %>
  
   <jsp:forward page="index.jsp">
        <jsp:param name="msjlog" value="Debe loguearse para Ver o Agregar un Producto al Carrito..."/>
    </jsp:forward>
  
  
      <%} 
  //obtener objeto carrito de compras
    Carrito carrito=null;
    if (session.getAttribute("carrito")==null) {  
        carrito=new Carrito();
        session.setAttribute("carrito", carrito);
    } else {
        carrito= (Carrito) session.getAttribute("carrito");
    }
%>
  
   
  

<!DOCTYPE html>
<html>
      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="estilos/estilos.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
        
        
        <title>Confirmacion de la Compra</title>
        
    </head>
    <body >
        

                 
        
      
         <!-- recibiendo parametros -->
        <%
            String numerotarjeta=request.getParameter("numerotarjeta");
         
            String pat=request.getParameter("paterno");
            String mat=request.getParameter("materno");
         %>
        <table border="1">
            <tr>
                <th colspan="2">Datos que se reciben:</th>
            </tr>
            <!-- imprimiendo parametros que fueron rescatados -->
            <tr> 
                <td>Usuario:</td><td><%= usuario.getNombre()%></td>
            </tr>
            <tr>
                <td>Mail:</td><td><%= usuario.getEmail() %></td>
            </tr>
            <tr>
                <td>Numero Tarjeta:</td><td><%=numerotarjeta%></td>
            </tr>
                 
            <tr>
                <td>Fecha:</td><td> <%= new java.util.Date()%> </td>
            </tr>
            <tr>
                <td>Hora:</td><td><%=numerotarjeta%></td>
            </tr>
            <tr>
                <td>Total productos a comprar: </td><td><%= carrito.contarProductos()%>:</td>
            </tr>
              <tr>
                <td>   Monto Total del Carrito:</td><td><%= carrito.sumarMontoProductos()%></td>
            </tr>
            
        </table>       
                
            
            
                <%
                    Venta venta = new Venta();
                    
                       
                    venta.setNroTarjeta(request.getParameter(numerotarjeta));
                   
                 
                       
                       
                        
                       
                    
                    %>
            
            
                
                
                
                
 
    </body>
</html>
