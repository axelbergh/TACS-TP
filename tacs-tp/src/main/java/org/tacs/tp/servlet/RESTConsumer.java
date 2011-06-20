package org.tacs.tp.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.tacs.tp.objectifyObjects.*;

public class RESTConsumer extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		DAO d = DAO.getInstance();
		
		if(request.getParameter("action").equals("get")){
			Car c = d.getMyCar(request.getParameter("id"));			
			out.println(c.getColor() + c.getVin());
		}
		else if(request.getParameter("action").equals("put")){
			out.println(d.putMyCar(request.getParameter("vin"),request.getParameter("color")));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
