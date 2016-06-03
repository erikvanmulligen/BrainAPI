package com.euretos.brainv2;

import java.util.HashSet;
import java.util.Set;

public class Filter {

    private Set<String> filters = null;

    public Filter(){
    }
    
    public Filter(Set<String> filterGroup) {
	this.filters = filterGroup;
    }

    public Set<String> getFilters() {
	return filters;
    }

    public void setFilters(Set<String> filters) {
	this.filters = filters;
    }
    
    public void add(String filter){
	if (this.filters==null){
	    this.filters = new HashSet<String>();
	}
	this.filters.add(filter);
    }
}
