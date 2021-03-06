package com.euretos.brainv2;

import com.google.gson.annotations.Expose;

public class Concept {
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
    
    @Override
    public String toString(){
	return "{\"id\":\""+id+"\",\"name\":\""+name+"\"}";
    }

    public String getSemanticCategory() {
	return semanticCategory;
    }

    public void setSemanticCategory(String semanticCategory) {
	this.semanticCategory = semanticCategory;
    }
}
