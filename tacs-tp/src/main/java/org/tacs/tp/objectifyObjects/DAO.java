package org.tacs.tp.objectifyObjects;

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

	public Item getItem(String id) {
		Item found = ofy().get(Item.class, Long.valueOf(id));
		return found;
	}

	public void putItem(Item item) {
		ofy().put(item);
		System.out.println("item guardado: " + item.getId());
	}

}
