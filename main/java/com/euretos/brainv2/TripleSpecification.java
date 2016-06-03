package com.euretos.brainv2;

import java.util.Set;

public class TripleSpecification {
    private String id = null;
    private Set<String> additionalFields = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<String> getAdditionalFields() {
	return additionalFields;
    }

    public void setAdditionalFields(Set<String> additionalFields) {
	this.additionalFields = additionalFields;
    } 
}
