package com.euretos.brainv2;

import java.util.HashSet;
import java.util.Set;

public class PublicationSpecification {
    private String id = null;
    private Set<String> additionalFields = new HashSet<String>();

    public PublicationSpecification(){
	additionalFields.add("url");
	additionalFields.add("sourceId");
	additionalFields.add("sourceName");
	additionalFields.add("publicationDateHumanReadableUTC");
    }
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
