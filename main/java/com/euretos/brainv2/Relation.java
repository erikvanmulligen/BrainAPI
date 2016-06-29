package com.euretos.brainv2;

import java.util.HashSet;
import java.util.Set;

public class Relation {

    private String concept0Id = null;
    private String concept1Id = null;
    private Set<String> predicateIds = null;
    private Set<String> tripleIds = null;
    private Set<String> publicationIds = null;
    
    public String getConcept0Id() {
        return concept0Id;
    }
    public void setConcept0Id(String concept0Id) {
        this.concept0Id = concept0Id;
    }
    public String getConcept1Id() {
        return concept1Id;
    }
    public void setConcept1Id(String concept1Id) {
        this.concept1Id = concept1Id;
    }
    public Set<String> getPredicateIds() {
        return predicateIds;
    }
    public void setPredicateIds(Set<String> predicateIds) {
        this.predicateIds = predicateIds;
    }
    public Set<String> getTripleIds() {
	return tripleIds;
    }
    public void setTripleIds(Set<String> tripleIds) {
	this.tripleIds = tripleIds;
    }
    public void addTripleId(String tripleId){
	if (this.tripleIds == null){
	    this.tripleIds = new HashSet<String>();
	}
	this.tripleIds.add(tripleId);
    }
    public Set<String> getPublicationIds() {
	return publicationIds;
    }
    public void setPublicationIds(Set<String> publicationIds) {
	this.publicationIds = publicationIds;
    }
    public void addPublicationId(String publicationId){
	if (this.publicationIds == null){
	    this.publicationIds = new HashSet<String>();
	}
	this.publicationIds.add(publicationId);
    }
}
