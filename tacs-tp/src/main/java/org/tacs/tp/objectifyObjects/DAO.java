package org.tacs.tp.objectifyObjects;

import javax.servlet.http.HttpServletRequest;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;

public class DAO extends DAOBase {
	
	private DAO(){};

	private static class DAOHolder{
		private static final DAO INSTANACE = new DAO();
	}
	
	public static DAO getInstance(){
		return DAOHolder.INSTANACE;
	}
	
	static {
		ObjectifyService.register(Item.class);
	}

	public Item getOrCreateItem(HttpServletRequest request) {
		Item found = ofy().get(Item.class, request.getParameter("id"));
		if (found == null){
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String fotoURL = request.getParameter("fotoURL");
			String linkURL = request.getParameter("linkURL");
			return new Item(id, nombre, fotoURL, linkURL);
		}
		else{
			return found;
		}
	}

	public String putItem(Item item) {
		ofy().put(item);
		return "item guardado: " + item.getId();
	}

}
