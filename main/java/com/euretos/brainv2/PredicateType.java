package com.euretos.brainv2;

public class PredicateType {
    private String id = null;
    private String name = null;
    private String definition = null;
    
    public PredicateType(){
    }

    public PredicateType(String id, String name, String definition){
	this.id = id;
	this.name = name;
	this.definition = definition;
    }

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
    
    public String getDefinition() {
        return definition;
    }
    
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString(){
	return "{\"id\":\""+id+"\",\"name\":\""+name+"\",\"definition\":\""+definition+"\"}";
    }
}
