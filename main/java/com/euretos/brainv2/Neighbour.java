package com.euretos.brainv2;

import java.util.Set;

public class Neighbour {

    private Concept neighbour = null;
    private Integer score = null;
    private Set<SourceConcept> sourceNodes = null;
    
    public Concept getNeighbour() {
        return neighbour;
    }
    
    public void setNeighbour(Concept neighbour) {
        this.neighbour = neighbour;
    }
    
    public Integer getScore() {
        return score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }
    
    public Set<SourceConcept> getSourceNodes() {
        return sourceNodes;
    }
    
    public void setSourceNodes(Set<SourceConcept> sourceNodes) {
        this.sourceNodes = sourceNodes;
    }
    
    
}
