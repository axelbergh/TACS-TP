package org.tacs.tp.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class RESTConsumer extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			    response.setContentType("text/html");
			    PrintWriter out = response.getWriter();
			    out.println("<BODY>\n" +
			                "<H1 ALIGN=CENTER></H1>\n" +
			                "<UL>\n" +
			                "  <LI>param1: "
			                + request.getParameter("param1") + "\n" +
			                "  <LI>param2: "
			                + request.getParameter("param2") + "\n" +
			                "  <LI>param3: "
			                + request.getParameter("param3") + "\n" +
			                "</UL>\n" +
			                "</BODY></HTML>");
			    out.close();
	}

	  public void doPost(HttpServletRequest request,
	                     HttpServletResponse response)
	      throws ServletException, IOException {
	    doGet(request, response);
	  }
		
}

