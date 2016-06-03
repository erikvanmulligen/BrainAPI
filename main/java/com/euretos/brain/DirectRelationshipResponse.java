/**
 * 
 */
package com.euretos.brain;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DirectRelationshipResponse {
	
	public class ElementPath {
		private TierConcept tier0Concept = null;
		private TierConcept tier1Concept = null;
		private Float pathWeight = null;
		private List<TripleInformation> tier01TripleInformation = new ArrayList<TripleInformation>();
		
		/**
		 * @param asJsonObject
		 */
		public ElementPath(JsonObject object) {
			this.setTier0Concept( new TierConcept( object.get( "tier0Concept" ).getAsJsonObject() ) );
			this.setTier1Concept( new TierConcept( object.get( "tier1Concept" ).getAsJsonObject() ) );
			this.setPathWeight( object.get( "pathWeight").getAsFloat() );
			for ( JsonElement tripleInformationObject : object.get( "tier01TripleInformation" ).getAsJsonArray() ){
				this.tier01TripleInformation.add( new TripleInformation( tripleInformationObject.getAsJsonObject() ) ); 
			}
		}

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

		public List<TripleInformation> getTier01TripleInformation() {
			return tier01TripleInformation;
		}

		public void setTier01TripleInformation(List<TripleInformation> tier01TripleInformation) {
			this.tier01TripleInformation = tier01TripleInformation;
		}

		public Float getPathWeight() {
			return pathWeight;
		}

		public void setPathWeight(Float pathWeight) {
			this.pathWeight = pathWeight;
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
	private Float maxPathWeight = null;
	private List<ElementPath> content = new ArrayList<ElementPath>();
	
	/**
	 * @param asJsonObject
	 */
	public DirectRelationshipResponse(JsonObject object ) {
		this.parse( object );
	}
	
	public void parse( JsonObject object ){
    	this.setLast( Utils.getContentElementAsBoolean( object.get( "last" ) ) );
    	this.setTotalElements( Utils.getContentElementAsInteger( object.get( "totalElements" ) ) );
    	this.setTotalPages( Utils.getContentElementAsInteger( object.get( "totalPages" ) ) );
    	this.setSort( Utils.getContentElementAsString( object.get( "sort" ) ) );
    	this.setNumberOfElements( Utils.getContentElementAsInteger( object.get( "numberOfElements" ) ) );
    	this.setFirst( Utils.getContentElementAsBoolean( object.get( "first" ) ) );
    	this.setSize( Utils.getContentElementAsInteger( object.get( "size" ) ) );
    	this.setNumber( Utils.getContentElementAsInteger( object.get( "number" ) ) );
    	this.setMaxPathWeight( Utils.getContentElementAsFloat( object.get( "maxPathWeight" ) ) );

    	JsonArray jarray = object.get( "content" ).getAsJsonArray();
	    for (int i = 0 ; i < jarray.size() ; i++){
	    	this.content.add( new ElementPath( jarray.get(i).getAsJsonObject() ) );
	    }

	}

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

		for ( ElementPath pathElt : this.content ){
			for ( TripleInformation tripleInformation : pathElt.getTier01TripleInformation() ){
    			PathElement pathElement = new PathElement();
    			pathElement.setSource( pathElt.getTier1Concept().getGi() );
    			pathElement.setSourceName( pathElt.getTier1Concept().getName() );
    			pathElement.setPathWeight( pathElt.getPathWeight() );
    			pathElement.getSourceSchemes().add( SemanticType.convert( pathElt.getTier1Concept().getCategory() ) );
    			pathElement.setTarget( pathElt.getTier0Concept().getGi() );
    			pathElement.setTargetName( pathElt.getTier0Concept().getName() );
    			pathElement.getTargetSchemes().add( SemanticType.convert( pathElt.getTier0Concept().getCategory() ) );
    			pathElement.setRelationName( tripleInformation.getPredicateName() );
    			pathElement.setRelation( tripleInformation.getTripleUuid() );
    			result.add( pathElement );
			}
		}
		
		return result;
	}

	public List<Path> convertToPaths( boolean showPredicates, Float maxScore ) {
		List<Path> result = new ArrayList<Path>();

		for ( ElementPath pathElt : this.content ){
			Path path = new Path();
			for ( TripleInformation tripleInformation : pathElt.getTier01TripleInformation() ){
    			PathElt triple = new PathElt();
    			triple.setSourceUuid( pathElt.getTier0Concept().getUuid() );
    			triple.setSourceName( pathElt.getTier0Concept().getName() );
    			triple.setSourceCategory( pathElt.getTier0Concept().getCategory() );
    			triple.setTargetUuid( pathElt.getTier1Concept().getUuid() );
    			triple.setTargetName( pathElt.getTier1Concept().getName() );
    			triple.setTargetCategory( pathElt.getTier1Concept().getCategory() );
    			if ( showPredicates ){
    				triple.setPredicateName( tripleInformation.getPredicateName() );
    			}
    			triple.setTripleUuid( tripleInformation.getTripleUuid() );
    			path.addTriple( triple );
			}
			path.setMaxScore( maxScore );
			path.setPathWeight( pathElt.getPathWeight() );
			path.setSourceName( pathElt.getTier0Concept().getName() );
			path.setSourceUuid( pathElt.getTier0Concept().getUuid() );
			path.setTargetName( pathElt.getTier1Concept().getName() );
			path.setTargetUuid( pathElt.getTier1Concept().getUuid() );
			result.add( path );
		}
		
		return result;
	}

	public Float getMaxPathWeight() {
		return maxPathWeight;
	}

	public void setMaxPathWeight(Float maxPathWeight) {
		this.maxPathWeight = maxPathWeight;
	}

}
