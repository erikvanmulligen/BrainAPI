package com.euretos.brainv2;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ConnectionCountResponse {
    
    private List<NameCount> categories = null;
    private List<NameCount> predicates = null;
    
    public List<NameCount> getCategories() {
        return categories;
    }
    
    public void setCategories(List<NameCount> categories) {
        this.categories = categories;
    }
    
    public List<NameCount> getPredicates() {
        return predicates;
    }
    
    public void setPredicates(List<NameCount> predicates) {
        this.predicates = predicates;
    }
    
    @Override
    public String toString(){
	return "{\"predicates\":[" + StringUtils.join(predicates,",")+"],\"categories\":["+StringUtils.join(categories,",")+"]";
    }
}
