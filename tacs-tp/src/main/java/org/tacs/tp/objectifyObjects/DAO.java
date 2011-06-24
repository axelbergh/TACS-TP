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

	public Item geItem(String id) {
		Item found = ofy().get(Item.class, id);
		return found;
	}
	
//	public void deleteAll(){
//		Iterable<Key<Item>> allKeys = ofy().query(Item.class).fetchKeys();
//		ofy().delete(allKeys);
//	}

	public String putItem(Item item) {
		ofy().put(item);
		return "item guardado: " + item.getId();
	}

}
