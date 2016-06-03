package com.euretos.brain;

import java.util.ArrayList;

public class KeywordToSemanticTypeInput {

	private ArrayList<String> inputTerms = new ArrayList<String>();
	private ArrayList<SemanticCategoryInfo> semantics = new ArrayList<SemanticCategoryInfo>();
	private String linkWeightAlgorithm = null;
	private String sort = null;
	
	public KeywordToSemanticTypeInput(){
	}

	public KeywordToSemanticTypeInput(String sourceUuid, String category, String algorithm, String sort) {
		this.inputTerms.add( sourceUuid );
		this.semantics.add( new SemanticCategoryInfo( category ) );
		this.setLinkWeightAlgorithm( algorithm );
		this.setSort( sort );
	}

	public void setLinkWeightAlgorithm(String algorithm) {
		this.linkWeightAlgorithm = algorithm;
	}

	public String getLinkWeightAlgorithm() {
		return this.linkWeightAlgorithm;
	}

	public ArrayList<String> getInputTerms() {
		return inputTerms;
	}
	
	public void setInputTerms(ArrayList<String> inputTerms) {
		this.inputTerms = inputTerms;
	}
	
	public ArrayList<SemanticCategoryInfo> getSemantics() {
		return semantics;
	}
	
	public void setSemantics(ArrayList<SemanticCategoryInfo> semantics) {
		this.semantics = semantics;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
