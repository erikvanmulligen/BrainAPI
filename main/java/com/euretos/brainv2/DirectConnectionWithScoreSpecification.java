package com.euretos.brainv2;

import java.util.HashSet;
import java.util.Set;

public class DirectConnectionWithScoreSpecification {

    private Set<String> ids = null;
    private Set<Filter> filterGroups = null;
    private Set<String> additionalFields = null;
    private String groupExternalCombinationType = null;
    private String groupInternalCombinationType = null;
    private String relationshipWeightAlgorithm = "pws";

    public void setFilterGroups(Set<Set<String>> filterGroups) {
	if (filterGroups != null){
	    for (Set<String> filterGroup : filterGroups){
		if (this.filterGroups == null){
		    this.filterGroups = new HashSet<Filter>();
		}
		this.filterGroups.add(new Filter(filterGroup));
	    }
	}
    }

    public Set<Filter> getFilterGroups() {
	return filterGroups;
    }

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

    public void addAdditionalField(String additionalField){
	if (this.additionalFields == null){
	    this.additionalFields = new HashSet<String>();
	}
	this.additionalFields.add(additionalField);
    }

    public String getGroupExternalCombinationType() {
	return groupExternalCombinationType;
    }

    public void setGroupExternalCombinationType(String groupExternalCombinationType) {
	this.groupExternalCombinationType = groupExternalCombinationType;
    }

    public String getGroupInternalCombinationType() {
	return groupInternalCombinationType;
    }

    public void setGroupInternalCombinationType(String groupInternalCombinationType) {
	this.groupInternalCombinationType = groupInternalCombinationType;
    }

    public String getRelationshipWeightAlgorithm() {
	return relationshipWeightAlgorithm;
    }

    public void setRelationshipWeightAlgorithm(String relationshipWeightAlgorithm) {
	this.relationshipWeightAlgorithm = relationshipWeightAlgorithm;
    }
}
