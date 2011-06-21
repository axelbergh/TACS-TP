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
			recuperar(request);
		}
		else if("put".equals(accion)){
			guardar(request);
		}
	}

	public void guardar(HttpServletRequest  request){
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String fotoURL = request.getParameter("fotoURL");
		String linkURL = request.getParameter("linkURL");
		
		Item item = new Item(id, nombre, fotoURL, linkURL);
		d.putItem(item);
	}
	
	public void recuperar(HttpServletRequest  request){
		String id = request.getParameter("id");
		Item item = d.getItem(id);
		System.out.println(item.getId() + " - " + item.getNombre() + " - " + item.getFotoURL() + " - " + item.getLinkURL());
		
	}
	

}
