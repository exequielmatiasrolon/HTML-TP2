package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import RN.ProductoRN;
import java.util.List;
import model.Producto;
import model.Carrito;
import model.Usuario;

public final class mostrar_005fcompra_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

  Usuario usuario= (Usuario) session.getAttribute("usuario");   
  if (usuario==null) { 
      out.write("\n");
      out.write("  \n");
      out.write("    ");
      if (true) {
        _jspx_page_context.forward("index.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("msjlog", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("Debe loguearse para Ver o Agregar un Producto al Carrito...", request.getCharacterEncoding()));
        return;
      }
      out.write("\n");
      out.write("    \n");
      out.write("    ");
} 
  //obtener objeto carrito de compras
    Carrito carrito=null;
    if (session.getAttribute("carrito")==null) {  
        carrito=new Carrito();
        session.setAttribute("carrito", carrito);
    } else {
        carrito= (Carrito) session.getAttribute("carrito");
    }

      out.write("\n");
      out.write("    \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"estilos/estilos.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <title>Carrito de Compras</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "encabezado.html", out, false);
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>                        \n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">Logo</a>\n");
      out.write("                </div>\n");
      out.write("        ");
 if(usuario==null) { 
      out.write("\n");
      out.write("                        <form action=\"login.jsp\" method=\"post\" class=\"navbar-form navbar-right\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"email\" placeholder=\"Email Usuario\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Contraseña\">\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"submit\" name=\"ingresar\" class=\"btn btn-default\">Ingresar</button>\n");
      out.write("                        </form>\n");
      out.write("\n");
      out.write("                        ");
 } else { 
      out.write("\n");
      out.write("                        \n");
      out.write("                        <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                            <li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> ");
      out.print( usuario.getNombre());
      out.write("</a></li> \n");
      out.write("                            <li><a href=\"salir.jsp\"><span class=\"glyphicon glyphicon-log-out\"></span> Cerrar Sesión</a></li>\n");
      out.write("                            <li><a href=\"mostrar_carrito.jsp\"><span class=\"glyphicon glyphicon-shopping-cart\"></span> Carrito</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    ");
 } 
      out.write(" \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("                <form action=\"aceptar_compra \" method=\"get\">\n");
      out.write("                <h1>Carrito de Compras</h1>\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("        ");

             if(request.getParameter("id")!=null && request.getParameter("op")!=null) {
                
                Producto producto= ProductoRN.obtenerProductoById(Integer.parseInt(request.getParameter("id"))); // obtengo instancia de producto de acuerdo al codigo recibido
                 if (producto==null) { 
      out.write("\n");
      out.write("\n");
      out.write("                    ");
      if (true) {
        _jspx_page_context.forward("index.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("msjlog", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("No se encuentra el producto solicitado...", request.getCharacterEncoding()));
        return;
      }
      out.write("\n");
      out.write("\n");
      out.write("                ");
} 
                switch (request.getParameter("op")) {
                case "1":  // AGREGAR PRODUCTO AL CARRITO
                    carrito.agregarProducto(producto); 
                    break;
                    
                } 
            }     
       
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"table-responsive\"> \n");
      out.write("            <table class=\"table table-hover table-striped \">\n");
      out.write("                <caption>Productos agregados al Carrito</caption>\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Código</th>\n");
      out.write("                        <th>Producto</th>\n");
      out.write("                        <th>Talle</th>\n");
      out.write("                        <th>Color</th>\n");
      out.write("                        <th>Precio</th>\n");
      out.write("                        \n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tfoot>\n");
      out.write("                    <tr>\n");
      out.write("                        <th colspan=\"6\">Total productos del Carrito: ");
      out.print( carrito.contarProductos());
      out.write("</th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th colspan=\"6\">Monto Total del Carrito: ");
      out.print( carrito.sumarMontoProductos());
      out.write(" </th>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                  </tfoot>\n");
      out.write("                <tbody>\n");
      out.write("         \n");
      out.write("               ");
 
                for (Producto producto: carrito.getProductos()) { 
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( producto.getId() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( producto.getNombre() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( producto.getTalle() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( producto.getColor() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( producto.getPrecio() );
      out.write("</td>\n");
      out.write("                    \n");
      out.write("                   \n");
      out.write("                </tr>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("                \n");
      out.write("                </tr>\n");
      out.write("                 \n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("                    ");
      out.print( usuario.getNombre() );
      out.write(" <br>\n");
      out.write("                    ");
      out.print( usuario.getDni() );
      out.write("<br>\n");
      out.write("                    ");
      out.print( usuario.getEmail() );
      out.write("        \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <br><br>\n");
      out.write("        <fieldset> \n");
      out.write("            <legend> datos de la targeta</legend>\n");
      out.write("           \n");
      out.write("            <label for=\"numerodetargeta\">numero de la targeta</label> <br>\n");
      out.write("            <input type=\"numeric\" name=\"numerodetargeta\" /> <br>\n");
      out.write("            <label for=\"fecven\">fecha vencimiento</label> <br>\n");
      out.write("            <input type=\"text\" name=\"fecven\" placeholder=\"22/12/2019\" /><br>\n");
      out.write("            <label for=\"codseg\">codigo de seguridad</label> <br>\n");
      out.write("            <input type=\"text\" name=\"codseg\" placeholder=\"codigo\" /> <br>\n");
      out.write("            <input type=\"submit\" value=\"aceptar compra\">\n");
      out.write("        </fieldset> \n");
      out.write(" \n");
      out.write("        </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.html", out, false);
      out.write("\n");
      out.write("        \n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
