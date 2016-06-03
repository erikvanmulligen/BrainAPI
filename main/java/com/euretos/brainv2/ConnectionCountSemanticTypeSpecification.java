package com.euretos.brainv2;

import java.util.HashSet;
import java.util.Set;

public class ConnectionCountSemanticTypeSpecification {

    private Set<String> ids = null;
    private Set<String> additionalFields = null;
    private Set<String> semanticCategories = null;
    
    public Set<String> getIds() {
        return ids;
    }
    
    public void setIds(Set<String> ids) {
        this.ids = ids;
    }
    
    public void addId(String id){
	if (this.ids == null){
	    this.ids = new HashSet<String>();
	}
	this.ids.add(id);
    }
    
    public Set<String> getAdditionalFields() {
        return additionalFields;
    }
    
    public void setAdditionalFields(Set<String> additionalFields) {
        this.additionalFields = additionalFields;
    }
    
    public void addAdditionalField(String additionalField){
	if (this.additionalFields == null){
	    this.additionalFields = new HashSet<String>();
	}
	this.additionalFields.add(additionalField);
    }

    public Set<String> getSemanticCategories() {
	return semanticCategories;
    }

    public void setSemanticCategories(Set<String> semanticCategories) {
	this.semanticCategories = semanticCategories;
    }

    public void addSemanticCategory(String semanticCategory){
	if (this.semanticCategories == null){
	    this.semanticCategories = new HashSet<String>();
	}
	this.semanticCategories.add(semanticCategory);
    }

}
