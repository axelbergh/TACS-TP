package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"ml.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">    \r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction getJSONMercadoLibre(key){\r\n");
      out.write("\t\t\t$.getJSON(\"https://api.mercadolibre.com/sites/MLA/search?q=\"+key+\"&callback=?\", mostrarResultados);\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction mostrarResultados(response){\r\n");
      out.write("            respuesta = response;\r\n");
      out.write("            $(\"#tablitaBody\").html(\"\");\r\n");
      out.write("            \r\n");
      out.write("            $.each(response[2].results, function(i, item) {\r\n");
      out.write("            \t$(\"<tr>\"+\r\n");
      out.write("            \t\t\t\"<td><img src='\" + item.thumbnail + \"'></span></li>\" +\r\n");
      out.write("        \t\t\t\t\"<td>\" + item.title + \"</td>\" +\r\n");
      out.write("        \t\t\t\t\"<td>\" + item.price + \"</td>\" +             \t\t\t\t\r\n");
      out.write("        \t\t\t\t\"<td>\" + item.condition + \"</td>\" + \r\n");
      out.write("        \t\t\t\t\"<td>\" + item.buying_mode + \"</span></li>\" + \r\n");
      out.write("        \t\t\t\t\"<td>\" + item.address.city_name + \"</span></li>\" + \r\n");
      out.write("        \t\t\t\t\"<td><a href='\" + item.permalink + \"'>Ir</a></span></li>\" +                 \t\t\t \t\r\n");
      out.write("           \t\t  \"</tr>\").appendTo(\"#tablitaBody\");\r\n");
      out.write("            });  \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"100%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t<h3>TACS - Mercado Libre</h3> \r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<br>\r\n");
      out.write("<table width=\"100%\">\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\tIngrese una palabra para efectuar la búsqueda (ejemplos: \"argentina\",\"brasil\",\"boca\",\"ford\")\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"key\" id=\"key\"/> \r\n");
      out.write("\t\t\t<input type=\"button\" class=\"btn secondary\" value=\"buscar\" onclick=\"getJSONMercadoLibre($('#key').val())\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("\r\n");
      out.write("<div class=\"box\"> \r\n");
      out.write("\t<table id=\"tablita\" summary=\"Listado de Resultados\">\r\n");
      out.write("\t\t<caption>Table</caption>\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th scope=\"col\">Imagen</th>\r\n");
      out.write("\t\t\t\t<th scope=\"col\">Nombre</th>\r\n");
      out.write("\t\t\t\t<th scope=\"col\">Precio</th>\r\n");
      out.write("\t\t\t\t<th scope=\"col\">Condición</th>\r\n");
      out.write("\t\t\t\t<th scope=\"col\">Forma de Compra</th>\r\n");
      out.write("\t\t\t\t<th scope=\"col\">Ciudad</th>\r\n");
      out.write("\t\t\t\t<th scope=\"col\">Ir a Publicación</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody id=\"tablitaBody\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div> \r\n");
      out.write("\r\n");
      out.write("<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
