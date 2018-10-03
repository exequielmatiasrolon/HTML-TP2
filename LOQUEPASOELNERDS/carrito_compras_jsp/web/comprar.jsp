<%-- 
    Document   : comprar.jsp
    Created on : 27-sep-2017, 19:20:03
    Author     : Bazan
--%>

<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@page import="RN.ProductoRN"%>
<%@page import="java.util.List"%>
<%@page import="model.Producto"%>
<%@page import="model.Carrito"%>
<%@page import="model.Factura"%>
<%@page import="model.Usuario" session="true"%>
<%@page import="dao.FacturaDAO"%>
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
      <title>Compra</title>
    </head>
    <body>
        <jsp:include page="encabezado.html" />
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#">Logo</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Productos</a></li>
                        <li class="active"><a href="mostrar_carrito.jsp">Carrito</a></li>
                        <li><a href="#">Ofertas</a></li>
                        <li><a href="#">Tiendas</a></li>
                        <li><a href="#">Contacto</a></li>
                    </ul>

                    <% if(usuario==null) { %>
                        <form action="login.jsp" method="post" class="navbar-form navbar-right">
                            <div class="form-group">
                                <input type="text" class="form-control" name="email" placeholder="Email Usuario">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="password" placeholder="Contraseña">
                            </div>
                            <button type="submit" name="ingresar" class="btn btn-default">Ingresar</button>
                        </form>

                        <% } else { %>
                        
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#"><span class="glyphicon glyphicon-user"></span> <%= usuario.getNombre()%></a></li> 
                            <li><a href="salir.jsp"><span class="glyphicon glyphicon-log-out"></span> Cerrar Sesión</a></li>
                            <li><a href="mostrar_carrito.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Carrito</a></li>
                        </ul>
                    <% } %> 
                </div>
            </div>
        </nav>
                
         <h1 class="text-center">Finalizar compra</h1>
         <div class="table-responsive"> 
            <table class="table table-hover table-striped ">
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
            </table>
         </div>
         
         <form action="confirmar.jsp" method="post">
                <h2>Datos del comprador:</h2><br>
                Nombre: <%=usuario.getNombre()%>
                Email: <%=usuario.getEmail()%>
                N° Tarjeta de credito: <input type="text" class="numero_tarjeta" name="numero_tarjeta">
                Nombre del titular:<input type="text" class="nombre_titular" name="titular_tarjeta">
                
                <button type="submit" name="confirmar" class="btn btn-default">Confirmar</button>
         </form><br>
    </body>
    <jsp:include page="footer.html"/>
</html>
