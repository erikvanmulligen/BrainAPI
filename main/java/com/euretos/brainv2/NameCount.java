package com.euretos.brainv2;

public class NameCount {
    private String name = null;
    private Integer count = null;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getCount() {
        return count;
    }
    
    public void setCount(Integer count) {
        this.count = count;
    }
    
    @Override
    public String toString(){
	return "{\"name\":\""+name+"\",\"count\":"+count+"\"}";
    }
}
