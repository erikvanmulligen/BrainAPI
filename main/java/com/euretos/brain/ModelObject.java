/**
 * (C) 2013,2014 Science and Technology Corporation, Delft, The Netherlands
 *
 * @author Erik van Mulligen
 * 
 *
 */
package com.euretos.brain;

public class ModelObject {
	private String type = "CONCEPT";
	private String term = null;
	private String searchModel = "EXACT";
	private SemanticParameter semanticParam = null;
	
	public ModelObject(String term) {
		this.term=term;
	}

	public ModelObject(String term, String category) {
		this.term = term.toLowerCase();
		this.setSemanticParam( new SemanticParameter( "CATEGORY", category ) );
	}

	@Override
	public String toString() {
		return "ModelObject [type=" + type + ", term=" + term + ", searchModel=" + searchModel + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getSearchModel() {
		return searchModel;
	}

	public void setSearchModel(String searchModel) {
		this.searchModel = searchModel;
	}

	public SemanticParameter getSemanticParam() {
		return semanticParam;
	}

	public void setSemanticParam(SemanticParameter semanticParam) {
		this.semanticParam = semanticParam;
	}

}
