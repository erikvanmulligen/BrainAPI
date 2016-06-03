package com.euretos.brain;

import com.google.gson.JsonObject;

public class TierConcept {

	private Integer gi = null;
	private String uuid = null;
	private String name = null;
	private String category = null;

	/**
	 * @param asJsonObject
	 */
	public TierConcept(JsonObject object) {
		this.setGi( Utils.getContentElementAsInteger( object.get( "gi" ) ) ); 
		this.setUuid( Utils.getContentElementAsString( object.get( "uuid" ) ) ); 
		this.setName( Utils.getContentElementAsString( object.get( "name" ) ) ); 
		this.setCategory( Utils.getContentElementAsString( object.get( "category" ) ) ); 
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getGi() {
		return gi;
	}

	public void setGi(Integer gi) {
		this.gi = gi;
	}
}

