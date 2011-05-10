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

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<script type=\"text/javascript\" src=\"jquery.js\">\n");
      out.write("</script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t    $(document).ready( function(){  \n");
      out.write("\t    \talert(\"FUNCA!\");\n");
      out.write("\t    \t$(\"input:submit\").click(function () {\n");
      out.write("\t    \t\tvar tags = $(\"input:tags\").val();\n");
      out.write("\t    \t\t$.getJSON(\"http://api.mercadolibre.com\", \n");
      out.write("\t    \t\t  function(data){\n");
      out.write("\t\t    \t\t  //DO SOMETHING!\n");
      out.write("\t    \t\t});\n");
      out.write("\t    \t});\t\n");
      out.write("\t    }); \n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\t\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<h1>Ajax getJSON Flickr Web Service</h1>\n");
      out.write("\n");
      out.write("<!--#buscador -->\n");
      out.write("<fieldset><legend>Consumer de la API de ML</legend>\n");
      out.write("<div id=\"search\"><label for=\"tags\">Tags: </label> <input\n");
      out.write("\ttype=\"text\" name=\"tags\" value=\"\" /> <input type=\"submit\"\n");
      out.write("\tvalue=\"Buscar\" /> <span> </span><img src=\"./images/ajax-loader.gif\"\n");
      out.write("\tid=\"loading\" style=\"display: none;\" /></div>\n");
      out.write("</fieldset>\n");
      out.write("\n");
      out.write("<!--#resultado -->\n");
      out.write("<fieldset><legend>Resultados para: <span\n");
      out.write("\tid=\"tagsToSearch\"></span></legend>\n");
      out.write("<div id=\"images\"></div>\n");
      out.write("</fieldset>\n");
      out.write("</body>\n");
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
