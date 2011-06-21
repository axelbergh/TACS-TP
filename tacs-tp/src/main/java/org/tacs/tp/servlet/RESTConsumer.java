package org.tacs.tp.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.tacs.tp.objectifyObjects.DAO;
import org.tacs.tp.objectifyObjects.Item;

public class RESTConsumer extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DAO d = DAO.getInstance();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("action");
		if("get".equals(accion)){
			recuperar(request, response.getWriter());
		}
		else if("put".equals(accion)){
			guardar(request, response.getWriter());
		}
	}

	public void guardar(HttpServletRequest  request, PrintWriter out){
		Item item = d.getOrCreateItem(request);
		out.println(d.putItem(item));
	}
	
	public void recuperar(HttpServletRequest  request, PrintWriter out){
		Item item = d.getOrCreateItem(request);
		out.println(item.getId() + " - " + item.getNombre() + " - " + item.getFotoURL() + " - " + item.getLinkURL());
		
	}
	

}
