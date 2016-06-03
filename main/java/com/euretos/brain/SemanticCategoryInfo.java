/**
 * (C) Science and Technology Corporation, Delft, The Netherlands, 2015
 * All Rights Reserved
 * No part of this program or any of its contents may be reproduced, copied, modified or adapted, 
 * without the prior written consent of the author, unless otherwise indicated for stand-alone materials.
 * 
 * For any mode of sharing, please contact the author at the email below.
 * 
 * Commercial use and distribution of the contents of the website is not allowed without express and 
 * prior written consent of the author.
 * 
 * @author Erik van Mulligen, vanmulligen@stcorp.nl
 * @date
 */

package com.euretos.brain;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SemanticCategoryInfo {

	private String category = null;
	private List<SemanticCategory> types = new ArrayList<SemanticCategory>();
	
	/**
	 * @param asJsonObject
	 */
	public SemanticCategoryInfo(JsonObject object) {
		this.parse( object );
	}
	
	public SemanticCategoryInfo(String category) {
		this.category = category;
	}

	private void parse( JsonObject object ){
    	this.setCategory( object.get( "category" ).getAsString());
    	JsonArray typesArray = object.getAsJsonArray( "types" );
    	for ( int j = 0 ; j < typesArray.size() ; j++ ){
    		this.types.add( new SemanticCategory( typesArray.get(j).getAsJsonObject() ) );
    	}
	}

	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public List<SemanticCategory> getTypes() {
		return types;
	}
	
	public void setTypes(List<SemanticCategory> types) {
		this.types = types;
	}
}
