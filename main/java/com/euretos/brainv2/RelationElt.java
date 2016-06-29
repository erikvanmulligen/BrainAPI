package com.euretos.brainv2;

import java.util.List;

public class RelationElt {

    private List<Concept> concepts = null;
    private List<Relation> relationships = null;
    private Float score = null;
    
    public List<Concept> getConcepts() {
        return concepts;
    }
    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }
    public List<Relation> getRelationships() {
        return relationships;
    }
    public void setRelationships(List<Relation> relationships) {
        this.relationships = relationships;
    }
    public Float getScore() {
	return score;
    }
    public void setScore(Float score) {
	this.score = score;
    }
}
