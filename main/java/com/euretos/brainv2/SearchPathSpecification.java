package com.euretos.brainv2;

import java.util.HashSet;
import java.util.Set;

public class SearchPathSpecification {

    private Set<String> leftInputs = null;
    private Set<String> rightInputs = null;
    private Set<String> additionalFields = null;
    private String relationshipWeightAlgorithm = null;
    private String sort = null;
    
    public Set<String> getLeftInputs() {
        return leftInputs;
    }
    
    public void setLeftInputs(Set<String> leftInputs) {
        this.leftInputs = leftInputs;
    }
    
    public void addLeftInput(String leftInput){
	if (this.leftInputs == null){
	    this.leftInputs = new HashSet<String>();
	}
	this.leftInputs.add(leftInput);
    }
    
    public Set<String> getRightInputs() {
        return rightInputs;
    }
    
    public void setRightInputs(Set<String> rightInputs) {
        this.rightInputs = rightInputs;
    }
    
    public void addRightInput(String rightInput){
	if (this.rightInputs == null){
	    this.rightInputs = new HashSet<String>();
	}
	this.rightInputs.add(rightInput);
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

    public String getRelationshipWeightAlgorithm() {
        return relationshipWeightAlgorithm;
    }
    
    public void setRelationshipWeightAlgorithm(String relationshipWeightAlgorithm) {
        this.relationshipWeightAlgorithm = relationshipWeightAlgorithm;
    }
    
    public String getSort() {
        return sort;
    }
    
    public void setSort(String sort) {
        this.sort = sort;
    }
}
