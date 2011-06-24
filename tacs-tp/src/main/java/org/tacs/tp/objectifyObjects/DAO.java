package org.tacs.tp.objectifyObjects;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Key;
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
		Item found = ofy().get(Item.class, id);
		return found;
	}

	public String putItem(Item item) {
		ofy().put(item);
		return "item guardado: " + item.getId();
	}

//	public List<Item> getAllItems() {
//		List<Item> queryResults = ofy().query(Item.class).list();
//		return new ArrayList<Item>(queryResults);
//		return ofy().query(Item.class).list();
//		
//	}
//	public List<Item> getAllItems() {
//		return (List<Item>) ofy().query(Item.class);
//		Map<Key<Item>, Item> bla = ofy().get(Item.class).;
//		return new ArrayList<Item>(bla.values());
//	}
	
	public List<Item> getAllItems() {
		Iterable<Key<Item>> keys =	ofy().query(Item.class).fetchKeys();
		return new ArrayList<Item>(ofy().get(keys).values()); 
	}

}
