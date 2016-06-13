package com.euretos.brainv2;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.annotations.Expose;

public class ConceptQuery {
    private String term = null;
    @Expose private String searchType = "TOKEN";
    @Expose private String queryString = null;
    private Boolean preferred = null;
    @Expose private List<String> additionalFields = null;
    private List<String> semanticCategories = null;
    private List<String> semanticTypes = null;
    private List<String> knowledgeBases = null;
    
    public ConceptQuery(String term, Boolean preferred, List<String> knowledgeBases, List<String> semanticCategories, List<String> semanticTypes, String searchType){
	
	if (term != null){
	    setTerm(term);
	}
	
	if (searchType != null){
	    this.searchType = searchType;
	}
	
	if (semanticTypes != null && !semanticTypes.isEmpty()){
	    setSemanticTypes(semanticTypes);
	}
	
	if (semanticCategories != null && !semanticCategories.isEmpty()){
	    setSemanticCategories(semanticCategories);
	}

	if (knowledgeBases != null && !knowledgeBases.isEmpty()){
	    setKnowledgeBases(knowledgeBases);
	}
	
	if (preferred != null){
	    this.preferred = preferred;
	}

	this.getQueryString();
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getQueryString() {
	this.queryString = "term:'" + this.term + "'";
	if (this.semanticTypes != null){
	    this.queryString += " AND (semantictype:'" + StringUtils.join(this.semanticTypes, "' OR semantictype:'") + "')";
	}
	
	if (this.semanticCategories != null){
	    this.queryString += " AND semanticcategory:'" + StringUtils.join(this.semanticCategories, "' OR semanticcategory:'") + "'";
	}
	
	if (this.knowledgeBases != null){
	    this.queryString += " AND (knowledgebase:'" + StringUtils.join(this.knowledgeBases, "' OR knowledgebase:'") + "')";
	}

	if (preferred != null){
	    this.queryString += " AND preferred:'" + preferred.toString() + "'";
	}
        return this.queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public List<String> getAdditionalFields() {
        return additionalFields;
    }

    public void setAdditionalFields(List<String> additionalFields) {
        this.additionalFields = additionalFields;
    }

    public List<String> getSemanticCategories() {
	return semanticCategories;
    }

    public void setSemanticCategories(List<String> semanticCategories) {
	this.semanticCategories = semanticCategories;
    }

    public List<String> getSemanticTypes() {
	return semanticTypes;
    }

    public void setSemanticTypes(List<String> semanticTypes) {
	this.semanticTypes = semanticTypes;
    }

    public List<String> getKnowledgeBases() {
	return knowledgeBases;
    }

    public void setKnowledgeBases(List<String> knowledgeBases) {
	this.knowledgeBases = knowledgeBases;
    }

    public String getTerm() {
	return term;
    }

    public void setTerm(String term) {
	this.term = term;
    }
}
