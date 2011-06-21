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
		ObjectifyService.register(Car.class);
	}

	public Car getMyCar(String id) {
		Car found = ofy().get(Car.class, Long.valueOf(id));
		return found;
	}

	public Long putMyCar(String vin, String color) {
		Car porsche = new Car(vin, color);
		ofy().put(porsche);
		return porsche.id;
	}

}
