package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(document).ready( function(){ \r\n");
      out.write("\t\t\t$(\"input:submit\").click(function () {\r\n");
      out.write("\t\t\t\tvar tags = $(\"#tags\").val();\r\n");
      out.write("\t\t\t\t$.getJSON(\"https://api.mercadolibre.com/sites/MLA/search?q=\"+tags+\"&callback=?\", hacerAlgoConDatos);\r\n");
      out.write("\t\t\t\t$(\"#tagsToSearch\").text(tags);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(\"#loading\").hide();\r\n");
      out.write("\t\t\t$(\"#loading\").ajaxStart(function(){ \r\n");
      out.write("\t\t\t\t$(this).show(); \r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#loading\").ajaxComplete( \r\n");
      out.write("\t\t\t\tfunction(event,request, settings) { \r\n");
      out.write("\t\t\t\t\t$(this).hide(); \r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction hacerAlgoConDatos(data){\r\n");
      out.write("\t\t\t//DO SOMETHING!\r\n");
      out.write("\t\t\t$(\"#resultados\").empty(); \r\n");
      out.write("\t\t\t$.each(data[2].results, function(i,item){ \r\n");
      out.write("\t\t\t\t$(\"#resultados\").append(item.title + \"<br/>\");\r\n");
      out.write("\t\t\t}); \r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<h1>Consumir API de MercadoLibre</h1>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!--#buscador -->\r\n");
      out.write("\t\t<fieldset><legend>Consumer de la API de ML</legend>\r\n");
      out.write("\t\t\t<div id=\"search\"><label for=\"tags\">Tags: </label> <input\r\n");
      out.write("\t\t    \ttype=\"text\" id=\"tags\" value=\"\" /> <input type=\"submit\"\r\n");
      out.write("\t\t    \tvalue=\"Buscar\" /> <span> </span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"loading\"> loading ... </div>\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!--#resultado -->\r\n");
      out.write("\t\t<fieldset><legend>Resultados para: <span id=\"tagsToSearch\"></span></legend>\r\n");
      out.write("\t\t\t<div id=\"resultados\"></div>\r\n");
      out.write("\t\t</fieldset>\r\n");
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
