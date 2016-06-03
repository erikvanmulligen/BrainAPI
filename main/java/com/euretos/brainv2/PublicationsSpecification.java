package com.euretos.brainv2;

import java.util.Set;

public class PublicationsSpecification {
    private Set<String> ids = null;
    private Set<String> additionalFields = null;

    public Set<String> getIds() {
        return ids;
    }

    public void setIds(Set<String> ids) {
        this.ids = ids;
    }

    public Set<String> getAdditionalFields() {
	return additionalFields;
    }

    public void setAdditionalFields(Set<String> additionalFields) {
	this.additionalFields = additionalFields;
    } 
}
