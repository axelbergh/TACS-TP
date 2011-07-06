package org.tacs.tp.objectifyObjects;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
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
	
	public List<Item> getAllItems() {
		Iterable<Key<Item>> keys =	ofy().query(Item.class).fetchKeys();
		return new ArrayList<Item>(ofy().get(keys).values()); 
	}
	
	public List<Item> getWishlist(String uid){
		Query<Item> items =	ofy().query(Item.class).filter("uid", uid);
		return items.list();
	}

}
