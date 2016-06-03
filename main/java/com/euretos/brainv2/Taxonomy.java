package com.euretos.brainv2;

public class Taxonomy {
    private String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
	return "{"+Utils.toQuoteString("name", name)+"}";
    }
}
