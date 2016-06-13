/**
 * 
 */
package com.euretos.brainv2;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PathElement implements Cloneable{

    private Integer source = null;
    private String sourceName = null;
    private Integer target = null;
    private String targetName = null;
    private String relation = null;
    private String relationName = null;
    private Set<Integer> sourceSchemes = new HashSet<Integer>();
    private Set<Integer> targetSchemes = new HashSet<Integer>();
    private Set<String> tripleIds = new HashSet<String>();
    private Set<String> publicationIds = new HashSet<String>();
    private Set<PublicationInfo> publications = new HashSet<PublicationInfo>();

    public Integer getSource() {
	return source;
    }

    public PathElement clone() throws CloneNotSupportedException{
	return (PathElement) super.clone();
    }
    
    public void setSource(Integer source) {
	this.source = source;
    }

    public String getSourceName() {
	return sourceName;
    }

    public void setSourceName(String sourceName) {
	this.sourceName = sourceName;
    }

    public Integer getTarget() {
	return target;
    }

    public void setTarget(Integer target) {
	this.target = target;
    }

    public String getTargetName() {
	return targetName;
    }

    public void setTargetName(String targetName) {
	this.targetName = targetName;
    }

    public String getRelation() {
	return relation;
    }

    public void setRelation(String relation) {
	this.relation = relation;
    }

    public String getRelationName() {
	return relationName;
    }

    public void setRelationName(String relationName) {
	this.relationName = relationName;
    }

    public Set<Integer> getSourceSchemes() {
	return sourceSchemes;
    }

    public void setSourceSchemes(Set<Integer> sourceSchemes) {
	this.sourceSchemes = sourceSchemes;
    }

    public Set<Integer> getTargetSchemes() {
	return targetSchemes;
    }

    public void setTargetSchemes(Set<Integer> targetSchemes) {
	this.targetSchemes = targetSchemes;
    }

    public Set<String> getTripleIds() {
	return tripleIds;
    }

    public void setTripleIds(Set<String> tripleIds) {
	this.tripleIds = tripleIds;
    }

    public void addTripleId(String tripleId){
	this.tripleIds.add(tripleId);
    }
    
    @Override
    public String toString(){
	return this.sourceName + "[" + this.source + "]" + "->" + this.relationName + "[" + this.relation + "]" + "->" + this.targetName + "[" + this.target + "]";
    }

    public void setRelation(String subject, String predicate, String object) {
	this.relation = UUID.nameUUIDFromBytes( ( subject + ":" + predicate + ":" + object ).getBytes() ).toString();
    }

    public Set<String> getPublicationIds() {
	return publicationIds;
    }

    public void setPublicationIds(Set<String> publicationIds) {
	this.publicationIds = publicationIds;
    }

    public void addPublicationId(String publicationId) {
	this.publicationIds.add(publicationId);
    }

    public Set<PublicationInfo> getPublications() {
	return publications;
    }

    public void setPublications(Set<PublicationInfo> publications) {
	this.publications = publications;
    }
    
    public void add(PublicationInfo publication){
	this.publications.add(publication);
    }

}
