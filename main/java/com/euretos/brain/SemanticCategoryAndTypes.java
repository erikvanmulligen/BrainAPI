/**
 * 
 */
package com.euretos.brain;

import java.util.List;

/**
 * (C) 2013,2014 Science and Technology Corporation, Delft, The Netherlands
 *
 * @author Erik van Mulligen
 * 
 *
 */
public class SemanticCategoryAndTypes {

	private List<SemanticCategory> types = null;
	private String category = null;
	
	public List<SemanticCategory> getTypes() {
		return types;
	}
	
	public void setTypes(List<SemanticCategory> types) {
		this.types = types;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
}
