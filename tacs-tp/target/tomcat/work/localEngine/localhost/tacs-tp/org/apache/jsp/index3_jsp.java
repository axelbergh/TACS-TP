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

      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"ml.css\" />\n");
      out.write("\t<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"chico-0.6.2.js\"></script>\n");
      out.write("\t\t\n");
      out.write("\t\t<script type=\"text/javascript\">    \n");
      out.write("\t\t\tvar paginaActual = 1;\n");
      out.write("\t\t\tvar cantidadPorPagina = 10;\n");
      out.write("\t\t\tvar offset = (paginaActual-1) * cantidadPorPagina;\n");
      out.write("\t\t\tvar resultadosTotales = 0;\n");
      out.write("\t\t\tvar busqueda = \"\";\n");
      out.write("\t\t\tvar categoria = \"\";\n");
      out.write("\t\t\tvar paisId = \"MLA\";  //TODO: Parametrizar luego\n");
      out.write("\t\t\tvar breadcrumb = new Array();\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tfunction completarComboPaises(){\n");
      out.write("\t\t\t\t$.getJSON(\"https://api.mercadolibre.com/sites?callback=?\", function(response){\n");
      out.write("\t\t\t\t\t$(\"#listaPaises\").html(\"\");\n");
      out.write("\t\t\t\t\t$.each(response[2], function(i, country) {\n");
      out.write("\t\t\t        \t$(\"<li><a href='javascript:cambiarPaisA(\\\"\" + country.id + \"\\\")'>\" + country.name + \"</li>\").appendTo(\"#listaPaises\");\n");
      out.write("\t\t\t        });  \n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t}\n");
      out.write("\t    \t\n");
      out.write("\t\t\tfunction cambiarPaisA(countryId){\n");
      out.write("\t\t\t\tpaisId = countryId;\n");
      out.write("\t\t\t\tactualizarCategoriasPrincipales();\n");
      out.write("\t\t\t\tresetearBusquedas();\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\n");
      out.write("\t\t\tfunction resetearBusquedas(){\n");
      out.write("\t\t\t\t$('#key').val(\"\");\n");
      out.write("\t\t\t\t$(\"#listado\").html(\"\");\n");
      out.write("\t\t\t\t$(\"#paginador\").html(\"\");\n");
      out.write("\t\t\t\tcategoria = \"\";\n");
      out.write("\t\t\t\tpaginaActual = 1;\n");
      out.write("\t\t\t\tresultadosTotales = 0;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tfunction buscar(key){\n");
      out.write("\t\t\t\tbusqueda = key;\n");
      out.write("\t\t\t\tif (busqueda == null) busqueda = \"\";\n");
      out.write("\t\t\t\tactualizarBusqueda();\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tfunction filtrarPorCategoria(categoriaId){\n");
      out.write("\t\t\t\tactualizarBreadcrumb(categoriaId);\n");
      out.write("\t\t\t\tcategoria = categoriaId;\n");
      out.write("\t\t\t\tactualizarCategoriasSecundarias();\n");
      out.write("\t\t\t\tactualizarBusqueda();\n");
      out.write("\t\t\t}\n");
      out.write("\n");
      out.write("\t\t\tfunction actualizarBreadcrumb(categoriaId){\n");
      out.write("\t\t\t\tif (categoria != \"\"){\n");
      out.write("\t\t\t\t\t$('#breadcrumb').html(\"\");\n");
      out.write("\t\t\t\t\t$(\"<li><a href='javascript:filtrarPorCategoria(\\\"\" + category.id + \"\\\")'>\" + category.name + \"</li>\").appendTo('#breadcrumb');\t\t\t\t\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\telse{\n");
      out.write("\t\t\t\t\t$('#breadcrumb').html(\"\");\n");
      out.write("\t\t\t\t\t$(\"<li><a href='javascript:filtrarPorCategoria(\\\"\" + paisId + \"\\\")'>\" + \"Inicio\" + \"</li>\").appendTo('#breadcrumb');\n");
      out.write("\t\t\t\t\t$(\"<li><a href='javascript:filtrarPorCategoria(\\\"\" + categoria.id + \"\\\")'>\" + categoria.name + \"</li>\").appendTo('#breadcrumb');\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tfunction actualizarCategoriasSecundarias(){\n");
      out.write("\t\t\t\t$.getJSON(\"https://api.mercadolibre.com/categories/\" + categoria + \"?callback=?\", function(response){\n");
      out.write("\t\t\t\t\tmostrarCategorias(response[2].children_categories);\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tfunction actualizarCategoriasPrincipales(){\n");
      out.write("\t\t\t\t$.getJSON(\"https://api.mercadolibre.com/sites/\" + paisId + \"?callback=?\", function(response){\n");
      out.write("\t\t\t\t\tmostrarCategorias(response[2].categories);\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tfunction mostrarCategorias(listadoCategorias){\t \n");
      out.write("\t            $(\"#categorias\").html(\"\");\n");
      out.write("\t            $.each(listadoCategorias, function(i, category) {\n");
      out.write("\t            \t$(\"<li><a href='javascript:filtrarPorCategoria(\\\"\" + category.id + \"\\\")'>\" + category.name + \"</li>\").appendTo(\"#categorias\");\n");
      out.write("\t            });  \n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tfunction actualizarBusqueda(){\n");
      out.write("\t\t\t\tvar parameters = \"?q=\" + busqueda +\n");
      out.write("\t\t\t\t\t\t\t\t \"&category=\" + categoria + \n");
      out.write("\t\t\t\t\t\t         \"&limit=\" + cantidadPorPagina + \n");
      out.write("\t\t\t\t\t\t         \"&offset=\"+ offset;\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t$.getJSON(\"https://api.mercadolibre.com/sites/\" + paisId + \"/search\" + parameters + \"&callback=?\", mostrarResultados);\n");
      out.write("\t\t\t}\n");
      out.write("\t\n");
      out.write("\t\t\tfunction mostrarResultados(response){\n");
      out.write("\t            \n");
      out.write("\t            resultadosTotales = response[2].paging.total;\n");
      out.write("\t            \n");
      out.write("\t            $(\"#listado\").html(\"\");\n");
      out.write("\t            $.each(response[2].results, function(i, item) {\n");
      out.write("\t            \t$(\"<li><table><tr height='100px'>\"+\n");
      out.write("\t            \t\t\t\"<td>\" +\n");
      out.write("\t            \t\t\t\t\"<a href='\" + item.permalink + \"' target='_blank'>\" +\n");
      out.write("\t            \t\t\t\t\t\"<img src='\" + item.thumbnail + \"'>\" +\n");
      out.write("\t            \t\t\t\t\"</a>\" +\n");
      out.write("\t            \t\t\t\"</td>\" +\t\n");
      out.write("\t        \t\t\t\t\"<td>\" + \n");
      out.write("\t        \t\t\t\t\t\"<a href='\" + item.permalink + \"' target='_blank'>\" +\n");
      out.write("\t        \t\t\t\t\t\titem.title +\n");
      out.write("\t    \t\t\t\t\t\t\"</a>\"+\n");
      out.write("\t        \t\t\t\t\"</td>\" +\n");
      out.write("\t        \t\t\t\t\"<td>\" + item.price + \"</td>\" +             \t\t\t\t\n");
      out.write("\t        \t\t\t\t\"<td>\" + item.condition + \"</td>\" + \n");
      out.write("\t        \t\t\t\t\"<td>\" + item.buying_mode + \"</td>\" + \n");
      out.write("\t        \t\t\t\t\"<td>\" + item.address.city_name + \"</td>\" +                 \t\t\t \t\n");
      out.write("\t           \t\t  \"</tr></table></li>\").appendTo(\"#listado\");\n");
      out.write("\t            });  \n");
      out.write("\t            armarPaginador();\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tfunction irAPagina(pagina){\n");
      out.write("\t\t\t\tpaginaActual = pagina;\n");
      out.write("\t\t\t\tActualizarBusqueda();\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tfunction armarPaginador(pagAnt, pagDesp){\n");
      out.write("\t\t\t\t$(\"#paginador\").html(\"\");\n");
      out.write("\t\t\t\tif (resultadosTotales == 0) return;\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tvar cantPaginas = Math.ceil(resultadosTotales / cantidadPorPagina);\n");
      out.write("\t\t\t\tif (cantPaginas == 1) return; \n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tif (pagAnt == null) pagAnt=6;\n");
      out.write("\t\t\t\tif (pagDesp == null) pagDesp=6;\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tvar paginaLimiteInf = Math.max(1,(paginaActual - pagAnt));\n");
      out.write("\t\t\t\tvar paginaLimiteSup = Math.min(cantPaginas,(paginaActual + pagDesp));\n");
      out.write("\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tvar paginadorHTML = \"<h2>Paginación</h2><ul class='pagination'>\";\n");
      out.write("\t\t\t\tif (paginaActual > 1) paginadorHTML += \"<li><a type='prev' href='javascript:irAPagina(\" + (paginaActual-1) + \")'>&lt; Anterior</a></li>\";\n");
      out.write("\t\t\t\tfor(pagina = paginaLimiteInf ; pagina <= paginaLimiteSup ; pagina++){\n");
      out.write("\t\t\t\t\tvar selected = \"\";\n");
      out.write("\t\t\t\t\tif (pagina == paginaActual) selected = \"class='current'\";\n");
      out.write("\t\t\t\t\tpaginadorHTML += \"<li \" + selected + \"><a href='javascript:irAPagina(\" + pagina + \")'>\" + pagina + \"</a></li>\";\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\tif (paginaActual < cantPaginas) paginadorHTML += \"<li><a type='next' href='javascript:irAPagina(\" + (paginaActual+1) + \")'>Siguiente &gt;</a></li>\";\n");
      out.write("\t\t\t\tpaginadorHTML += \"</ul>\";\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t$(\"#paginador\").html(paginadorHTML);\t\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t$(document).ready(function(){\n");
      out.write("\t\t\t\tactualizarCategoriasPrincipales();\n");
      out.write("\t\t\t\tcompletarComboPaises();\n");
      out.write("\t\t\t\t$(\".demoDropdown\").dropdown();\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\t\n");
      out.write("\t\t</script>\n");
      out.write("\t\n");
      out.write("\t\t\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("\t<body>\n");
      out.write("\t\t<table width=\"100%\">\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td align=\"center\">\n");
      out.write("\t\t\t\t\t<h3>TACS - Mercado Libre</h3> \n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t<div class=\"demoDropdown\">\n");
      out.write("\t\t\t\t\t    <span>País</span>\n");
      out.write("\t\t\t\t\t    <ul id=\"listaPaises\"></ul>\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t\t<br/>\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t<table width=\"100%\">\t\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td colspan=\"100%\">\n");
      out.write("\t\t\t\t\tIngrese una palabra para efectuar la búsqueda (ejemplos: \"argentina\",\"brasil\",\"boca\",\"ford\")\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td colspan=\"100%\">\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"key\" id=\"key\"/> \n");
      out.write("\t\t\t\t\t<input type=\"button\" class=\"btn secondary\" value=\"buscar\" onclick=\"buscar($('#key').val())\"/>\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td valign=\"top\" align=\"left\">\n");
      out.write("\t\t\t\t\t<div class=\"box\"> \n");
      out.write("\t\t\t\t\t\t<div id=breadcrumb></div>\n");
      out.write("\t\t\t\t\t\t<ol id=\"categorias\" summary=\"Listado de Categorias\"></ol>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t \t\t</td>\n");
      out.write("\t\t \t\t<td>\n");
      out.write("\t\t\t\t\t<!--Hay un table adentro del tag \"li\", por eso se ven medio raras algunas filas. Deberiamos hacer estilos y sacar ese table.-->\n");
      out.write("\t\t\t\t\t<br/>\n");
      out.write("\t\t \t\t\t<div class=\"box\"> \n");
      out.write("\t\t\t\t\t\t<ol id=\"listado\" summary=\"Listado de Resultados\"></ol>\n");
      out.write("\t\t\t\t\t\t<div id=\"paginador\"></div>\n");
      out.write("\t\t\t\t\t</div> \n");
      out.write("\t\t \t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
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
