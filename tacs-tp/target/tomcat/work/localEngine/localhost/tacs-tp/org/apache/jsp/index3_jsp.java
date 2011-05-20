package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index3_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<head>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"ml.css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"chico-0.6.2.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">    \r\n");
      out.write("\t\t\tvar paginaActual = 1;\r\n");
      out.write("\t\t\tvar cantidadPorPagina = 10;\r\n");
      out.write("\t\t\tvar offset = (paginaActual-1) * cantidadPorPagina;\r\n");
      out.write("\t\t\tvar resultadosTotales = 0;\r\n");
      out.write("\t\t\tvar busqueda = \"\";\r\n");
      out.write("\t\t\tvar categoria = \"\";\r\n");
      out.write("\t\t\tvar paisId = \"MLA\";  //TODO: Parametrizar luego\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction completarComboPaises(){\r\n");
      out.write("\t\t\t\t$.getJSON(\"https://api.mercadolibre.com/sites?callback=?\", function(response){\r\n");
      out.write("\t\t\t\t\t$(\"#listaPaises\").html(\"\");\r\n");
      out.write("\t\t\t\t\t$.each(response[2], function(i, country) {\r\n");
      out.write("\t\t\t        \t$(\"<li><a href='javascript:cambiarPaisA(\\\"\" + country.id + \"\\\")'>\" + country.name + \"</li>\").appendTo(\"#listaPaises\");\r\n");
      out.write("\t\t\t        });  \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t    \t\r\n");
      out.write("\t\t\tfunction cambiarPaisA(countryId){\r\n");
      out.write("\t\t\t\tpaisId = countryId;\r\n");
      out.write("\t\t\t\tactualizarCategoriasPrincipales();\r\n");
      out.write("\t\t\t\tresetearBusquedas();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\tfunction resetearBusquedas(){\r\n");
      out.write("\t\t\t\t$('#key').val(\"\");\r\n");
      out.write("\t\t\t\t$(\"#listado\").html(\"\");\r\n");
      out.write("\t\t\t\t$(\"#paginador\").html(\"\");\r\n");
      out.write("\t\t\t\tcategoria = \"\";\r\n");
      out.write("\t\t\t\tpaginaActual = 1;\r\n");
      out.write("\t\t\t\tresultadosTotales = 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction buscar(key){\r\n");
      out.write("\t\t\t\tbusqueda = key;\r\n");
      out.write("\t\t\t\tif (busqueda == null) busqueda = \"\";\r\n");
      out.write("\t\t\t\tactualizarBusqueda();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction filtrarPorCategoria(categoriaId){\r\n");
      out.write("\t\t\t\tcategoria = categoriaId;\r\n");
      out.write("\t\t\t\tactualizarCategoriasSecundarias();\r\n");
      out.write("\t\t\t\tactualizarBusqueda();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction actualizarCategoriasSecundarias(){\r\n");
      out.write("\t\t\t\t$.getJSON(\"https://api.mercadolibre.com/categories/\" + categoria + \"?callback=?\", function(response){\r\n");
      out.write("\t\t\t\t\tmostrarCategorias(response[2].children_categories);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction actualizarCategoriasPrincipales(){\r\n");
      out.write("\t\t\t\t$.getJSON(\"https://api.mercadolibre.com/sites/\" + paisId + \"?callback=?\", function(response){\r\n");
      out.write("\t\t\t\t\tmostrarCategorias(response[2].categories);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction mostrarCategorias(listadoCategorias){\t \r\n");
      out.write("\t            $(\"#categorias\").html(\"\");\r\n");
      out.write("\t            $.each(listadoCategorias, function(i, category) {\r\n");
      out.write("\t            \t$(\"<li><a href='javascript:filtrarPorCategoria(\\\"\" + category.id + \"\\\")'>\" + category.name + \"</li>\").appendTo(\"#categorias\");\r\n");
      out.write("\t            });  \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction actualizarBusqueda(){\r\n");
      out.write("\t\t\t\tvar parameters = \"?q=\" + busqueda +\r\n");
      out.write("\t\t\t\t\t\t\t\t \"&category=\" + categoria + \r\n");
      out.write("\t\t\t\t\t\t         \"&limit=\" + cantidadPorPagina + \r\n");
      out.write("\t\t\t\t\t\t         \"&offset=\"+ offset;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$.getJSON(\"https://api.mercadolibre.com/sites/\" + paisId + \"/search\" + parameters + \"&callback=?\", mostrarResultados);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tfunction mostrarResultados(response){\r\n");
      out.write("\t            \r\n");
      out.write("\t            resultadosTotales = response[2].paging.total;\r\n");
      out.write("\t            \r\n");
      out.write("\t            $(\"#listado\").html(\"\");\r\n");
      out.write("\t            $.each(response[2].results, function(i, item) {\r\n");
      out.write("\t            \t$(\"<li><table><tr height='100px'>\"+\r\n");
      out.write("\t            \t\t\t\"<td>\" +\r\n");
      out.write("\t            \t\t\t\t\"<a href='\" + item.permalink + \"' target='_blank'>\" +\r\n");
      out.write("\t            \t\t\t\t\t\"<img src='\" + item.thumbnail + \"'>\" +\r\n");
      out.write("\t            \t\t\t\t\"</a>\" +\r\n");
      out.write("\t            \t\t\t\"</td>\" +\t\r\n");
      out.write("\t        \t\t\t\t\"<td>\" + \r\n");
      out.write("\t        \t\t\t\t\t\"<a href='\" + item.permalink + \"' target='_blank'>\" +\r\n");
      out.write("\t        \t\t\t\t\t\titem.title +\r\n");
      out.write("\t    \t\t\t\t\t\t\"</a>\"+\r\n");
      out.write("\t        \t\t\t\t\"</td>\" +\r\n");
      out.write("\t        \t\t\t\t\"<td>\" + item.price + \"</td>\" +             \t\t\t\t\r\n");
      out.write("\t        \t\t\t\t\"<td>\" + item.condition + \"</td>\" + \r\n");
      out.write("\t        \t\t\t\t\"<td>\" + item.buying_mode + \"</td>\" + \r\n");
      out.write("\t        \t\t\t\t\"<td>\" + item.address.city_name + \"</td>\" +                 \t\t\t \t\r\n");
      out.write("\t           \t\t  \"</tr></table></li>\").appendTo(\"#listado\");\r\n");
      out.write("\t            });  \r\n");
      out.write("\t            armarPaginador();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction irAPagina(pagina){\r\n");
      out.write("\t\t\t\tpaginaActual = pagina;\r\n");
      out.write("\t\t\t\tActualizarBusqueda();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction armarPaginador(pagAnt, pagDesp){\r\n");
      out.write("\t\t\t\t$(\"#paginador\").html(\"\");\r\n");
      out.write("\t\t\t\tif (resultadosTotales == 0) return;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar cantPaginas = Math.ceil(resultadosTotales / cantidadPorPagina);\r\n");
      out.write("\t\t\t\tif (cantPaginas == 1) return; \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif (pagAnt == null) pagAnt=6;\r\n");
      out.write("\t\t\t\tif (pagDesp == null) pagDesp=6;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar paginaLimiteInf = Math.max(1,(paginaActual - pagAnt));\r\n");
      out.write("\t\t\t\tvar paginaLimiteSup = Math.min(cantPaginas,(paginaActual + pagDesp));\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar paginadorHTML = \"<h2>Paginación</h2><ul class='pagination'>\";\r\n");
      out.write("\t\t\t\tif (paginaActual > 1) paginadorHTML += \"<li><a type='prev' href='javascript:irAPagina(\" + (paginaActual-1) + \")'>&lt; Anterior</a></li>\";\r\n");
      out.write("\t\t\t\tfor(pagina = paginaLimiteInf ; pagina <= paginaLimiteSup ; pagina++){\r\n");
      out.write("\t\t\t\t\tvar selected = \"\";\r\n");
      out.write("\t\t\t\t\tif (pagina == paginaActual) selected = \"class='current'\";\r\n");
      out.write("\t\t\t\t\tpaginadorHTML += \"<li \" + selected + \"><a href='javascript:irAPagina(\" + pagina + \")'>\" + pagina + \"</a></li>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif (paginaActual < cantPaginas) paginadorHTML += \"<li><a type='next' href='javascript:irAPagina(\" + (paginaActual+1) + \")'>Siguiente &gt;</a></li>\";\r\n");
      out.write("\t\t\t\tpaginadorHTML += \"</ul>\";\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#paginador\").html(paginadorHTML);\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t\tactualizarCategoriasPrincipales();\r\n");
      out.write("\t\t\t\tcompletarComboPaises();\r\n");
      out.write("\t\t\t\t$(\".demoDropdown\").dropdown();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t<h3>TACS - Mercado Libre</h3> \r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<div class=\"demoDropdown\">\r\n");
      out.write("\t\t\t\t\t    <span>País</span>\r\n");
      out.write("\t\t\t\t\t    <ul id=\"listaPaises\"></ul>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table width=\"100%\">\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"100%\">\r\n");
      out.write("\t\t\t\t\tIngrese una palabra para efectuar la búsqueda (ejemplos: \"argentina\",\"brasil\",\"boca\",\"ford\")\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"100%\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"key\" id=\"key\"/> \r\n");
      out.write("\t\t\t\t\t<input type=\"button\" class=\"btn secondary\" value=\"buscar\" onclick=\"buscar($('#key').val())\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td valign=\"top\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t<div class=\"box\"> \r\n");
      out.write("\t\t\t\t\t\t<ol id=\"categorias\" summary=\"Listado de Categorias\"></ol>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t \t\t<td>\r\n");
      out.write("\t\t\t\t\tHay un table adentro del tag \"li\", por eso se ven medio raras algunas filas. Deberiamos hacer estilos y sacar ese table.\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t \t\t\t<div class=\"box\"> \r\n");
      out.write("\t\t\t\t\t\t<ol id=\"listado\" summary=\"Listado de Resultados\"></ol>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"paginador\"></div>\r\n");
      out.write("\t\t\t\t\t</div> \r\n");
      out.write("\t\t \t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t</body>\r\n");
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
