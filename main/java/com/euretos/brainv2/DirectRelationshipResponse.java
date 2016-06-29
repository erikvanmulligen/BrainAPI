/**
 * 
 */
package com.euretos.brainv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DirectRelationshipResponse {

    static Logger logger = LogManager.getLogger();

    private List<RelationElt> content = null;
    private Integer totalElements = null;
    private Boolean first = null;
    private Boolean last = null;
    private Integer totalPages = null;
    private Integer numberOfElements = null;
    private String sort = null;
    private Integer size = null;
    private Integer number = null;

    public Integer getTotalElements() {
	return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
	this.totalElements = totalElements;
    }

    public Boolean getFirst() {
	return first;
    }

    public void setFirst(Boolean first) {
	this.first = first;
    }

    public Boolean getLast() {
	return last;
    }

    public void setLast(Boolean last) {
	this.last = last;
    }

    public Integer getTotalPages() {
	return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
	this.totalPages = totalPages;
    }

    public Integer getNumberOfElements() {
	return numberOfElements;
    }

    public void setNumberOfElements(Integer numberOfElements) {
	this.numberOfElements = numberOfElements;
    }

    public String getSort() {
	return sort;
    }

    public void setSort(String sort) {
	this.sort = sort;
    }

    public Integer getSize() {
	return size;
    }

    public void setSize(Integer size) {
	this.size = size;
    }

    public Integer getNumber() {
	return number;
    }

    public void setNumber(Integer number) {
	this.number = number;
    }

    public List<List<PathElement>> getPaths(Brain brain) {
	List<List<PathElement>> result = null;
	try{
	    result = new ArrayList<List<PathElement>>();
	    for (RelationElt relationElt : this.content){
		List<List<PathElement>> newpaths = new ArrayList<List<PathElement>>();
		for (Relation relationship : relationElt.getRelationships()){
		    /* add unknown predicate if list is empty */
		    if (relationship.getPredicateIds().isEmpty()){
			relationship.getPredicateIds().add("-1");
		    }
		    
		    List<PathElement> subpaths = new ArrayList<PathElement>();
		    for (String predicateId : relationship.getPredicateIds()){
			PathElement pathElement = new PathElement();
			pathElement.setSource(Integer.parseInt(relationship.getConcept0Id()));
			pathElement.setSourceName(brain.getConcepts(relationship.getConcept0Id(),null).iterator().next().getName());
			pathElement.setTarget(Integer.parseInt(relationship.getConcept1Id()));
			pathElement.setTargetName(brain.getConcepts(relationship.getConcept1Id(),null).iterator().next().getName());
			pathElement.setRelation(predicateId);
			pathElement.setRelationName(brain.getPredicate(predicateId).getName());
			if (relationship.getTripleIds()!=null){
			    Iterator<String> iterator = relationship.getTripleIds().iterator();
			    while (iterator.hasNext()){
				pathElement.addTripleId(iterator.next());
			    }
			}
			if (relationship.getPublicationIds()!=null){
			    Iterator<String> iterator = relationship.getPublicationIds().iterator();
			    while (iterator.hasNext()){
				pathElement.addPublicationId(iterator.next());
			    }
			}
			subpaths.add(pathElement);
		    }
		    
		    if (newpaths.isEmpty()){
			for ( int j = 0 ; j < subpaths.size() ; j++ ){
			    ArrayList<PathElement> newpath = new ArrayList<PathElement>();
			    newpath.add(subpaths.get(j));
			    newpaths.add(newpath);
			}
		    }
		    else {
			/* duplicate the paths because as much as  the subpaths to get unique paths */
			List<List<PathElement>> tmppaths = new ArrayList<List<PathElement>>();
			for (int i = 0 ; i < newpaths.size(); i++ ){
			    for ( int j = 0 ; j < subpaths.size() ; j++ ){
				List<PathElement> tmppath = duplicate(newpaths.get(i));
				tmppath.addAll(Arrays.asList(subpaths.get(j)));
				tmppaths.add(tmppath);
			    }
			}
			newpaths = tmppaths;
		    }
		}
		
		for (List<PathElement>newpath : newpaths){
		    result.add(newpath);
		}
	    }
	}catch (Exception e){
	    logger.error(e);
	}
	return result;
    }

    private List<PathElement> duplicate(List<PathElement> list) throws CloneNotSupportedException {
	ArrayList<PathElement> result = new ArrayList<PathElement>();
	for (PathElement pathElement : list){
	    PathElement clone = (PathElement) pathElement.clone();
	    result.add(clone);
	}
	return result;
    }

    public List<RelationElt> getContent() {
        return content;
    }
}
