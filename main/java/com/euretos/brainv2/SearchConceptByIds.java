package com.euretos.brainv2;

import java.util.Arrays;
import java.util.List;

public class SearchConceptByIds {

    private List<String> ids = null;
    private List<String> additionalFields = null;
    
    public SearchConceptByIds(String idsCommaSeparated){
	this.additionalFields = Arrays.asList("description", "semanticCategory", "semanticTypes","taxonomies", "measures", "accessMappings", "hasTriples", "synonyms", "source", "knowledgebase");
	this.ids = Arrays.asList(idsCommaSeparated.split(","));
    }
    
    public List<String> getIds() {
        return ids;
    }
    
    public void setIds(List<String> ids) {
        this.ids = ids;
    }
    
    public List<String> getAdditionalFields() {
        return additionalFields;
    }
    
    public void setAdditionalFields(List<String> additionalFields) {
        this.additionalFields = additionalFields;
    } 
}
