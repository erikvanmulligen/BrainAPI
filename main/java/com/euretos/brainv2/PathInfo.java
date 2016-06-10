package com.euretos.brainv2;

import java.util.Set;

public class PathInfo {
    private Set<ConceptInfo> concepts = null;
    private Set<RelationShipInfo> relationships = null;
    private Integer publicationsCount = null;
    
    public Set<ConceptInfo> getConcepts() {
        return concepts;
    }
    
    public void setConcepts(Set<ConceptInfo> concepts) {
        this.concepts = concepts;
    }
    
    public Set<RelationShipInfo> getRelationships() {
        return relationships;
    }
    
    public void setRelationships(Set<RelationShipInfo> relationships) {
        this.relationships = relationships;
    }
    
    public Integer getPublicationsCount() {
        return publicationsCount;
    }
    
    public void setPublicationsCount(Integer publicationsCount) {
        this.publicationsCount = publicationsCount;
    }
    	
}
