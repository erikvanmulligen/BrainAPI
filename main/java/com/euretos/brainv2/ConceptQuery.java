package com.euretos.brainv2;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ConceptQuery {
    private String searchType = "TOKEN";
    private String queryString = null;
    private List<String> additionalFields = null;
    
    public ConceptQuery(String query, Boolean preferred, List<String> knowledgeBases, List<String> semanticCategories, List<String> semanticTypes, String searchType){
	if (searchType != null){
	    this.searchType = searchType;
	}
	
	this.queryString = "term:'" + query + "'";
	if (semanticTypes != null && !semanticTypes.isEmpty()){
	    queryString += " AND semantictype:'" + StringUtils.join(semanticCategories, "' AND semantictype:'") + "'";
	}
	
	if (semanticCategories != null && !semanticCategories.isEmpty()){
	    queryString += " AND semanticcategory:'" + StringUtils.join(semanticCategories, "' AND semanticcategory:'") + "'";
	}

	if (knowledgeBases != null && !knowledgeBases.isEmpty()){
	    queryString += " AND knowledgebase:'" + StringUtils.join(knowledgeBases, "' AND knowledgebase:'") + "'";
	}

	if (preferred != null){
	    queryString += " AND preferred:'" + preferred.toString() + "'";
	}
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getQueryString() {
        return queryString;
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
}
