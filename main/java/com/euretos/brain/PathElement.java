/**
 * 
 */
package com.euretos.brain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * (C) 2013,2014 Science and Technology Corporation, Delft, The Netherlands
 *
 * @author Erik van Mulligen
 * 
 *
 */
public class PathElement {

	private Integer source = null;
	private String sourceName = null;
	private Integer target = null;
	private String targetName = null;
	private String relation = null;
	private String relationName = null;
	private List<Integer> sourceSchemes = new ArrayList<Integer>();
	private List<Integer> targetSchemes = new ArrayList<Integer>();
	private Float pathWeight = null;
	
	public Integer getSource() {
		return source;
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
	
	public List<Integer> getSourceSchemes() {
		return sourceSchemes;
	}
	
	public void setSourceSchemes(List<Integer> sourceSchemes) {
		this.sourceSchemes = sourceSchemes;
	}
	
	public List<Integer> getTargetSchemes() {
		return targetSchemes;
	}
	
	public void setTargetSchemes(List<Integer> targetSchemes) {
		this.targetSchemes = targetSchemes;
	}
	
	@Override
	public String toString(){
		return this.sourceName + "[" + this.source + "]" + "->" + this.relationName + "[" + this.relation + "]" + "->" + this.targetName + "[" + this.target + "]";
	}

	/**
	 * @param uuid
	 * @param predicate
	 * @param uuid2
	 */
	public void setRelation(String subject, String predicate, String object) {
		this.relation = UUID.nameUUIDFromBytes( ( subject + ":" + predicate + ":" + object ).getBytes() ).toString();
	}

	public void setPathWeight(Float pathWeight) {
		this.pathWeight  = pathWeight;
	}

	public Float getPathWeight() {
		return pathWeight;
	}
	
}
