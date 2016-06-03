/**
 * 
 */
package com.euretos.brain;

import java.util.ArrayList;
import java.util.List;

public class TwoStepRelationshipResponse {
	
	public class PathElt {
		private TierConcept tier0Concept = null;
		private TierConcept tier1Concept = null;
		private TierConcept tier2Concept = null;
		private ArrayList<String> tier01PredicateNames = null;
		private ArrayList<String> tier12PredicateNames = null;
		
		public TierConcept getTier0Concept() {
			return tier0Concept;
		}
		
		public void setTier0Concept(TierConcept tier0Concept) {
			this.tier0Concept = tier0Concept;
		}
		
		public TierConcept getTier1Concept() {
			return tier1Concept;
		}
		
		public void setTier1Concept(TierConcept tier1Concept) {
			this.tier1Concept = tier1Concept;
		}
		
		public ArrayList<String> getTier01PredicateNames() {
			return tier01PredicateNames;
		}
		
		public void setTier01PredicateNames(ArrayList<String> tier01PredicateNames) {
			this.tier01PredicateNames = tier01PredicateNames;
		}

		public TierConcept getTier2Concept() {
			return tier2Concept;
		}

		public void setTier2Concept(TierConcept tier2Concept) {
			this.tier2Concept = tier2Concept;
		}

		public ArrayList<String> getTier12PredicateNames() {
			return tier12PredicateNames;
		}

		public void setTier12PredicateNames(ArrayList<String> tier12PredicateNames) {
			this.tier12PredicateNames = tier12PredicateNames;
		}
		
	}
	
	private Integer totalElements = null;
	private Boolean first = null;
	private Boolean last = null;
	private Integer totalPages = null;
	private Integer numberOfElements = null;
	private String sort = null;
	private Integer size = null;
	private Integer number = null;
	private List<PathElt> content = null;
	
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

	/**
	 * This method will convert the DirectRelationshipResponse into an List of PathElements
	 * @return
	 */
	public List<PathElement> convert() {
		List<PathElement> result = new ArrayList<PathElement>();

		for ( PathElt pathElt : this.content ){
			
			for ( String predicate : pathElt.getTier01PredicateNames() ){
    			PathElement pathElement = new PathElement();
    			pathElement.setSource( pathElt.getTier1Concept().getGi() );
    			pathElement.setSourceName( pathElt.getTier1Concept().getName() );
    			pathElement.getSourceSchemes().add( SemanticType.convert( pathElt.getTier1Concept().getCategory() ) );
    			pathElement.setTarget( pathElt.getTier0Concept().getGi() );
    			pathElement.setTargetName( pathElt.getTier0Concept().getName() );
    			pathElement.getTargetSchemes().add( SemanticType.convert( pathElt.getTier0Concept().getCategory() ) );
    			pathElement.setRelationName( predicate );
    			pathElement.setRelation( pathElt.getTier0Concept().getUuid(), predicate, pathElt.getTier1Concept().getUuid() );
    			result.add( pathElement );
			}
			
			for ( String predicate : pathElt.getTier12PredicateNames() ){
    			PathElement pathElement = new PathElement();
    			pathElement.setSource( pathElt.getTier2Concept().getGi() );
    			pathElement.setSourceName( pathElt.getTier2Concept().getName() );
    			pathElement.getSourceSchemes().add( SemanticType.convert( pathElt.getTier2Concept().getCategory() ) );
    			pathElement.setTarget( pathElt.getTier1Concept().getGi() );
    			pathElement.setTargetName( pathElt.getTier1Concept().getName() );
    			pathElement.getTargetSchemes().add( SemanticType.convert( pathElt.getTier1Concept().getCategory() ) );
    			pathElement.setRelationName( predicate );
    			pathElement.setRelation( pathElt.getTier1Concept().getUuid(), predicate, pathElt.getTier2Concept().getUuid() );
    			result.add( pathElement );
			}
		}
		
		return result;
	}
}
