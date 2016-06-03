/**
 * 
 */
package com.euretos.brain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * (C) 2013,2014 Science and Technology Corporation, Delft, The Netherlands
 *
 * @author Erik van Mulligen
 * 
 *
 */
public class ConceptResponse {
	public class ConceptMeasure {
		private String value = null;
		private String key = null;
		private String context = null;
		
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getContext() {
			return context;
		}
		public void setContext(String context) {
			this.context = context;
		}
	}

	private ArrayList<ConceptMeasure> measures = new ArrayList<ConceptMeasure>();
	private HashMap<String,Integer> ingress = new HashMap<String,Integer>();
	private HashMap<String,Integer> egress  = new HashMap<String,Integer>();
	private Integer degreeIngress = null;
	private Integer degreeEgress = null;
	private String semanticCategory = null;
	private Date lastUpdated = null;
	private ArrayList<String> semanticTypes = new ArrayList<String>();
	private String description = null;
	private String name = null;
	private String id = null;
	private String type = null;

	public ArrayList<ConceptMeasure> getMeasures() {
		return measures;
	}
	public void setMeasures(ArrayList<ConceptMeasure> measures) {
		this.measures = measures;
	}
	public HashMap<String, Integer> getIngress() {
		return ingress;
	}
	public void setIngress(HashMap<String, Integer> ingress) {
		this.ingress = ingress;
	}
	public HashMap<String, Integer> getEgress() {
		return egress;
	}
	public void setEgress(HashMap<String, Integer> egress) {
		this.egress = egress;
	}
	public Integer getDegreeIngress() {
		return degreeIngress;
	}
	public void setDegreeIngress(Integer degreeIngress) {
		this.degreeIngress = degreeIngress;
	}
	public Integer getDegreeEgress() {
		return degreeEgress;
	}
	public void setDegreeEgress(Integer degreeEgress) {
		this.degreeEgress = degreeEgress;
	}
	public String getSemanticCategory() {
		return semanticCategory;
	}
	public void setSemanticCategory(String semanticCategory) {
		this.semanticCategory = semanticCategory;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public ArrayList<String> getSemanticTypes() {
		return semanticTypes;
	}
	public void setSemanticTypes(ArrayList<String> semanticTypes) {
		this.semanticTypes = semanticTypes;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String toString(){
		return this.name;
	}
}
