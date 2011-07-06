package org.tacs.tp.servlet;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import org.tacs.tp.objectifyObjects.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
			recuperar(request, response);
		}
		else if("getall".equals(accion)){
			recuperarTodo(request, response);
		}
		else if("put".equals(accion)){
			guardar(request, response.getWriter());
		}
	}
	
	private void recuperarTodo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
			this.enviarComoJson(d.getAllItems(), response);
	}

	public void guardar(HttpServletRequest  request, PrintWriter out){

		String uid = request.getParameter("uid");
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String fotoURL = request.getParameter("fotoURL");
		String linkURL = request.getParameter("linkURL");
		Item item = new Item(uid, id, nombre, fotoURL, linkURL);
		out.println(d.putItem(item));
	}
	
	public void recuperar(HttpServletRequest  request, HttpServletResponse response) throws IOException{
		List<Item> item = d.getWishlist(request.getParameter("uid"));
		this.enviarComoJson(item, response);
	}
	
	protected void enviarComoJson(Item item, HttpServletResponse response) throws IOException{
		response.setContentType("text/javascript");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(item));
	}
	
	protected void enviarComoJson(List<Item> items, HttpServletResponse response) throws IOException{
		response.setContentType("text/javascript");
		response.setCharacterEncoding("UTF-8");
		
		Type listType = new TypeToken<List<Item>>() {}.getType();
		response.getWriter().write(new Gson().toJson(items, listType));
	}

}
