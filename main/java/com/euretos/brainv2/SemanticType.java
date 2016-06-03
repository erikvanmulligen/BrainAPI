package com.euretos.brainv2;

import org.apache.commons.lang3.StringUtils;

public class SemanticType {
    private String id = null;
    private String name = null;
    private String semanticCategory = null;
    
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
    
    public String getSemanticCategory() {
        return semanticCategory;
    }
    
    public void setSemanticCategory(String semanticCategory) {
        this.semanticCategory = semanticCategory;
    }
    
    @Override
    public String toString(){
	return "{"+StringUtils.join(new String[]{Utils.toQuoteString("id",id), Utils.toQuoteString("name",name),Utils.toQuoteString("semanticCategory",semanticCategory)},",")+"}";
    }
    

    
}