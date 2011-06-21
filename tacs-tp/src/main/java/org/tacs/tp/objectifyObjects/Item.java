package org.tacs.tp.objectifyObjects;

import javax.persistence.*;

public class Item {

	@Id
	private String id;
	private String nombre;
	private String fotoURL;
	private String linkURL;
	
	@SuppressWarnings("unused")
	private Item(){};
	
	public Item(String id, String nombre, String fotoURL, String linkURL){
		this.id = id;
		this.nombre = nombre;
		this.fotoURL = fotoURL;
		this.linkURL = linkURL;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	public String getId(){
		return this.id;
	}
	public String getFotoURL(){
		return this.fotoURL;
	}
	public String getLinkURL(){
		return this.linkURL;
	}
}
