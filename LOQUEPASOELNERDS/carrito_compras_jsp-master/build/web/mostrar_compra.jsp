<%-- 
    Document   : mostrar_compra
    Created on : 29/09/2018, 23:05:31
    Author     : marti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="RN.ProductoRN"%>
<%@page import="java.util.List"%>
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
        <title>Carrito de Compras</title>
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
                <form action="Aceptar_compra.jsp" method="get">
                <h1>Carrito de Compras</h1>
            <br>

        <%
             if(request.getParameter("id")!=null && request.getParameter("op")!=null) {
                
                Producto producto= ProductoRN.obtenerProductoById(Integer.parseInt(request.getParameter("id"))); // obtengo instancia de producto de acuerdo al codigo recibido
                 if (producto==null) { %>

                    <jsp:forward page="index.jsp">
                        <jsp:param name="msjlog" value="No se encuentra el producto solicitado..."/>
                    </jsp:forward>

                <%} 
                switch (request.getParameter("op")) {
                case "1":  // AGREGAR PRODUCTO AL CARRITO
                    carrito.agregarProducto(producto); 
                    break;
                    
                } 
            }     
       %>
        
        <div class="table-responsive"> 
            <table class="table table-hover table-striped ">
                <caption>Productos agregados al Carrito</caption>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Producto</th>
                        <th>Talle</th>
                        <th>Color</th>
                        <th>Precio</th>
                        
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th colspan="6">Total productos del Carrito: <%= carrito.contarProductos()%></th>
                    </tr>
                    <tr>
                        <th colspan="6">Monto Total del Carrito: <%= carrito.sumarMontoProductos()%> </th>
                    </tr>
                    
                  </tfoot>
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
                
                </tr>
                 
                </tbody>
            </table>
                    <%= usuario.getNombre() %> <br>
                    <%= usuario.getDni() %><br>
                    <%= usuario.getEmail() %>        
        </div>
        
        <br><br>
        <fieldset> 
            <legend> datos de la targeta</legend>
           
            <label for="numerodetargeta">numero de la targeta</label> <br>
            <input type="text" name="numerodetargeta" /> <br>
            <label for="fecven">fecha vencimiento</label> <br>
            <input type="text" name="fecven" placeholder="22/12/2019" /><br>
             <label for="titular_tarjeta">nombre titular</label> <br>
            <input type="text" name="titular_tarjeta" /> <br>
            <input type="submit" value="aceptar compra">
        </fieldset> 
 
        </div>
        <jsp:include page="footer.html" />
        
        </form>
    </body>
</html>
