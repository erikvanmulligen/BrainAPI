/**
 * 
 */
package com.euretos.brain;

import com.google.gson.JsonObject;

/**
 * (C) 2013,2014 Science and Technology Corporation, Delft, The Netherlands
 *
 * @author Erik van Mulligen
 * 
 *
 */
public class SemanticCategory {
	
	private String id = null;
	private String name = null;
	
	public SemanticCategory() {
	}

	public SemanticCategory( JsonObject object ) {
		this.parse( object );
	}
	
	private void parse( JsonObject object ){
		this.setId( object.get( "id" ).getAsString() );
		this.setName( object.get( "name" ).getAsString() );
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "{'name':'" + name + "'; 'id':'" + id + "'}";
	}

}
