package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index4_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"stylesheet\" href=\"FB_ML.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">    \r\n");
      out.write("\t\tvar paginaActual = 1;\r\n");
      out.write("\t\tvar cantidadPorPagina = 10;\r\n");
      out.write("\t\tvar offset = (paginaActual-1) * cantidadPorPagina;\r\n");
      out.write("\t\tvar resultadosTotales = 0;\r\n");
      out.write("\t\tvar busqueda = \"\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction buscar(key){\r\n");
      out.write("\t\t\tbusqueda = key;\r\n");
      out.write("\t\t\tActualizarBusqueda();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction ActualizarBusqueda(){\r\n");
      out.write("\t\t\tvar parameters = \"?q=\" + busqueda +\r\n");
      out.write("\t\t\t\t\t         \"&limit=\" + cantidadPorPagina + \r\n");
      out.write("\t\t\t\t\t         \"&offset=\"+ offset;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$.getJSON(\"https://api.mercadolibre.com/sites/MLA/search\" + parameters + \"&callback=?\", mostrarResultados);\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction mostrarResultados(response){\r\n");
      out.write("            respuesta = response;\r\n");
      out.write("            \r\n");
      out.write("            resultadosTotales = response[2].paging.total;\r\n");
      out.write("            \r\n");
      out.write("            $(\"#listado\").html(\"\");\r\n");
      out.write("            $.each(response[2].results, function(i, item) {\r\n");
      out.write("            \t$(\"<li class='list-view-item'>\" +\r\n");
      out.write("\t            \t  \"<h3 class='list-view-item-title'>\" +\r\n");
      out.write("\t            \t  \t\"<a href='\" + item.permalink   +\"'>\" + \r\n");
      out.write("\t            \t  \t \titem.title +\r\n");
      out.write("\t            \t  \t\"</a>\" +\r\n");
      out.write("\t            \t  \"</h3>\" +\r\n");
      out.write("\t            \t  \"<p class='list-view-item-subtitle'>\" +\r\n");
      out.write("\t            \t  \titem.subtitle +\r\n");
      out.write("\t          \t\t  \"</p>\" +\r\n");
      out.write("\t          \t\t\"<a href='\" + item.permalink +\"' class='list-view-item-figure'>\" +\r\n");
      out.write("\t          \t\t\titem.thumbnail + \r\n");
      out.write("\t          \t\t  \"</a>\" +  \r\n");
      out.write("\t          \t\t  \"<p class='price-info'>\" +\r\n");
      out.write("\t          \t\t  \t\"<span class='price-info-cost'>\" + \r\n");
      out.write("\t\t          \t\t  \t\"<strong class='price'>\" +  \r\n");
      out.write("\t\t          \t\t  \t\titem.price  + \" (con decimales: <sup>99</sup>)\" +\r\n");
      out.write("\t\t          \t\t\t\"</strong>\" +\r\n");
      out.write("\t          \t\t\t\"</span>\" +\r\n");
      out.write("\t          \t\t\t\"<span class='price-info-installments'>\" +\r\n");
      out.write("\t\t        \t\t\t\"<span class='installmentsQuantity'>\" +\r\n");
      out.write("\t\t        \t\t\t\t\"N°Cuotas\" +\r\n");
      out.write("\t\t        \t\t\t\"</span> cuotas de \"+\r\n");
      out.write("\t\t        \t\t\t\"<span class='price'>\" + \r\n");
      out.write("\t\t        \t\t\t\t\"PrecioCuotas\" + \" (Con decimales: <sup>99</sup>)\" + \r\n");
      out.write("\t\t        \t\t\t\"</span>\" + \r\n");
      out.write("\t        \t\t\t\"</span>\" + \r\n");
      out.write("\t        \t\t  \"</p>\" +\r\n");
      out.write("\t          \t\t  \"<ul class='extra-info'>\" +  \r\n");
      out.write("\t          \t\t\t\"<li class='extra-info-condition'>\" +\r\n");
      out.write("\t          \t\t\t\titem.condition +\r\n");
      out.write("\t          \t\t\t\"</li>\" +\r\n");
      out.write("\t          \t\t\t\"<li class='extra-info-sold'>\" +\r\n");
      out.write("\t          \t\t\t\t\"CantidadVendidos\" +\r\n");
      out.write("\t          \t\t\t\"</li>\"  +\r\n");
      out.write("\t          \t\t\t\"<li class='extra-info-location'>\" + \r\n");
      out.write("\t          \t\t\t\titem.address.city_name +\r\n");
      out.write("\t          \t\t\t\"</li>\" + \r\n");
      out.write("\t          \t\t  \"</ul>\" +\r\n");
      out.write("          \t\t  \"</li>\").appendTo(\"#listado\");\r\n");
      out.write("            });  \r\n");
      out.write("            \r\n");
      out.write("            armarPaginador();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction irAPagina(pagina){\r\n");
      out.write("\t\t\tpaginaActual = pagina;\r\n");
      out.write("\t\t\tActualizarBusqueda();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction armarPaginador(pagAnt, pagDesp){\r\n");
      out.write("\t\t\tif (resultadosTotales == 0) return;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar cantPaginas = Math.ceil(resultadosTotales / cantidadPorPagina);\r\n");
      out.write("\t\t\tif (cantPaginas == 1) return; \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif (pagAnt == null) pagAnt=6;\r\n");
      out.write("\t\t\tif (pagDesp == null) pagDesp=6;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar paginaLimiteInf = Math.max(1,(paginaActual - pagAnt));\r\n");
      out.write("\t\t\tvar paginaLimiteSup = Math.min(cantPaginas,(paginaActual + pagDesp));\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar paginadorHTML = \"<h2>Paginación</h2><ul class='pagination'>\";\r\n");
      out.write("\t\t\tif (paginaActual > 1) paginadorHTML += \"<li><a type='prev' href='javascript:irAPagina(\" + (paginaActual-1) + \")'>&lt; Anterior</a></li>\";\r\n");
      out.write("\t\t\tfor(pagina = paginaLimiteInf ; pagina <= paginaLimiteSup ; pagina++){\r\n");
      out.write("\t\t\t\tvar selected = \"\";\r\n");
      out.write("\t\t\t\tif (pagina == paginaActual) selected = \"class='current'\";\r\n");
      out.write("\t\t\t\tpaginadorHTML += \"<li \" + selected + \"><a href='javascript:irAPagina(\" + pagina + \")'>\" + pagina + \"</a></li>\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (paginaActual < cantPaginas) paginadorHTML += \"<li><a type='next' href='javascript:irAPagina(\" + (paginaActual+1) + \")'>Siguiente &gt;</a></li>\";\r\n");
      out.write("\t\t\tpaginadorHTML += \"</ul>\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\"#paginador\").html(paginadorHTML);\t\r\n");
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
      out.write("\t\t\t<input type=\"button\" class=\"btn secondary\" value=\"buscar\" onclick=\"buscar($('#key').val())\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<br/>\r\n");
      out.write("Hay un table adentro del tag \"li\", por eso se ven medio raras algunas filas. Deberiamos hacer estilos y sacar ese table.\r\n");
      out.write("<br/>\r\n");
      out.write("\r\n");
      out.write("<div class=\"box\"> \r\n");
      out.write("\t<ol id=\"listado\" summary=\"Listado de Resultados\">\r\n");
      out.write("\t</ol>\r\n");
      out.write("\t<div id=\"paginador\"></div>\r\n");
      out.write("</div> \r\n");
      out.write("\r\n");
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
