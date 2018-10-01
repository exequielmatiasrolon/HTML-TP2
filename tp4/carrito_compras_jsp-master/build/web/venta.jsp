<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>  

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
        <title>Confirmacion de la Compra</title>
    </head>
    <body >
         <jsp:include page="encabezado.html"/>
         
         
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
                        <li class="active"><a href="index.jsp">Productos</a></li>
                        <li><a href="mostrar_carrito.jsp">Carrito</a></li>
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
                            
                        </ul>
                    <% } %> 
                </div>
            </div>
        </nav>
         
         
         
         
         
         
        
        <h1>Vamos a confirmar la Compra</h1>
        
        
        <div class="container-fluid text-center" id="formularioventa"> 
            <fieldset>
                <legend>Formulario de Confirmacion de Compra!</legend>
                Nombre de Usuario : <label id="datos"><%= usuario.getNombre()%></label>
                <hr>
                Correo Electronico : <label id="datos"><%= usuario.getEmail() %></label>
                <hr>
                   <fieldset id="productos">
                
                 <div class="container-fluid"> 
            <table class="table table-hover table-striped text-center" style="width:100%">
                
                <thead>
                    <tr  >
                       
                        <th align="center">Producto</th>
                        <td>Talle</td>
                        <td>Color</td>
                        <td>Precio</td>
                        
                    </tr>
                </thead>
                
                <tbody>
         
               <% 
                for (Producto producto: carrito.getProductos()) { %>
                
                <tr>
                    
                    <td><%= producto.getNombre() %></td>
                    <td><%= producto.getTalle() %></td>
                    <td><%= producto.getColor() %></td>
                    <td><%= producto.getPrecio() %></td>
                    
                  
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
                
                     </fieldset>
                                    
                <hr>
                
                
                        Total productos a comprar: <%= carrito.contarProductos()%>
                        <hr>
                    
                        Monto Total del Carrito: <%= carrito.sumarMontoProductos()%>
                        <hr>
                    
                      <a href="#" class="btn btn-success text-center"><span class="glyphicon glyphicon-shopping-cart text-center"></span> Confirmar Compra</a>
                      <hr>
                
            </fieldset>
        
        
        </div>
        
        
        
         
        
         <jsp:include page="footer.html" />
    </body>
</html>
