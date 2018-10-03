<%-- 
    Document   : Aceptar_compra
    Created on : 30/09/2018, 18:41:35
    Author     : marti
--%>


<%@page import="model.Producto"%>
<%@page import="model.Venta"%>
<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>  
<%@ page import="java.util.*" %>
<%@page import="model.Carrito"%>
<%@page import="model.Usuario" session="true"%>
<%@page import="RN.UsuarioRN"%>
<%@page import="RN.CarritoRN"%>

<%
  Usuario usuario= (Usuario) session.getAttribute("usuario");   
  if (usuario==null) { %>
    <jsp:forward page="index.jsp">
        <jsp:param name="msjlog" value="Debe loguearse para Ver o Agregar un Producto al Carrito..."/>
    </jsp:forward>
    <%} 
  //obtener objeto carrito de compras
    Carrito carrito=null;
    if (session.getAttribute("carrito")==null) { %>
        <jsp:forward page="index.jsp">
        <jsp:param name="msjlog" value="Debe agregar productos al carrito."/>
        </jsp:forward>
<%  }
    carrito= (Carrito) session.getAttribute("carrito");
    if(carrito.contarProductos()<1){%>
        <jsp:forward page="index.jsp">
        <jsp:param name="msjlog" value="Debe agregar productos al carrito."/>
        </jsp:forward>
<%  }
    %>

<%
    if(!request.getParameter("numerodetargeta").isEmpty() && !request.getParameter("titular_tarjeta").isEmpty()){
        
        Venta venta=new Venta();
        
        java.util.Date date = new Date();
        java.sql.Date fechaActual = new java.sql.Date(date.getTime());
       
        venta.setId_usuario(usuario.getId());
        venta.setFecha((fechaActual));
        venta.setTitular_tarjeta(request.getParameter("titular_tarjeta"));
        venta.setNumero_tarjeta(request.getParameter("numerodetargeta"));
        venta.setFechaVen(request.getParameter("fecven"));
        venta.setMonto(carrito.sumarMontoProductos());
        
        CarritoRN guardar= new CarritoRN();
        guardar.guardarVenta(venta,carrito);
        
        session.removeAttribute("carrito");
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
                  <title>Confirmar</title>
                  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                  <title>Confirmar compra</title>
    </head>
    <body>
        <jsp:include page="encabezado.html" />

         <h1>Finalizar compra</h1>
         <form action="index.jsp">
         <div class="table-responsive"> 
            <table class="table table-hover table-striped ">
                <br><fieldset><legend>Datos del usuario</legend>
                <label class="col-form-label">Nombre: <%= usuario.getNombre()%></label><br>
                <label class="col-form-label">IDº: <%= usuario.getId()%></label><br>
                
                </fieldset><br>
                <fieldset><legend>Productos agregados al Carrito</legend>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Producto</th>
                        <th>Talle</th>
                        <th>Color</th>
                        <th>Precio</th>
                    </tr>
                </thead>
                <tbody>
               <% 
                for (Producto producto: carrito.getProductos()) { %>
                <tr>
                    <td><%= producto.getId() %></td>
                    <td><%= producto.getNombre() %></td>
                    <td><%= producto.getTalle() %></td>
                    <td><%= producto.getColor() %></td>
                    <td><%= producto.getPrecio() %></td>
                </tr>
                <% } %>
                </tbody>
                <tr>
                    <th colspan="6">Total productos del Carrito: <%= carrito.contarProductos()%></th>
                    <th colspan="6">Monto Total del Carrito: <%= carrito.sumarMontoProductos()%> </th>
                    
                </tr>
                </fieldset>
            </table>
         </div>
                <input type="submit" value="Terminar" onClick="alert('Gracias por su compra.!')">
         </form>
    </body>
</html>