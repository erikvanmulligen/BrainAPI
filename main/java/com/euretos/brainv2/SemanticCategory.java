package com.euretos.brainv2;

public class SemanticCategory {
    private String name = null;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
	return "{\"name\":\""+name+"\"}";
    }
}
