package com.euretos.brainv2;

import org.apache.commons.lang3.StringUtils;

public class SemanticTypeCount {
    private String id = null;
    private String name = null;
    private Integer count = null;

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

    public Integer getCount() {
	return count;
    }

    public void setCount(Integer count) {
	this.count = count;
    }

    @Override
    public String toString(){
	return "{"+StringUtils.join(new String[]{Utils.toQuoteString("id",id), Utils.toQuoteString("name",name),Utils.toQuoteString("count",count)},",")+"}";
    }

}
