/**
 * (C) Science and Technology Corporation, Delft, The Netherlands, 2015
 * All Rights Reserved
 * No part of this program or any of its contents may be reproduced, copied, modified or adapted, 
 * without the prior written consent of the author, unless otherwise indicated for stand-alone materials.
 * 
 * For any mode of sharing, please contact the author at the email below.
 * 
 * Commercial use and distribution of the contents of the website is not allowed without express and 
 * prior written consent of the author.
 * 
 * @author Erik van Mulligen, vanmulligen@stcorp.nl
 * @date
 */

package com.euretos.brain;

import com.google.gson.JsonObject;

/**
 *  
 */
public class SearchIndirectElementResponse {

	private Publications lhPublications = null;
	private Publications rhPublications = null;
	private ConceptInfoResponse leftConcept = null;
	private SearchResultDto leftPathSearchResultDto = null;
	private SearchResultDto rightPathSearchResultDto = null;
	
	public SearchIndirectElementResponse( JsonObject object ){
		this.setLhPublications( new Publications( object.get( "lhPublications" ).getAsJsonObject() ) );
		this.setRhPublications( new Publications( object.get( "rhPublications" ).getAsJsonObject() ) );
		this.setLeftConcept( new ConceptInfoResponse( object.get( "leftConcept" ).getAsJsonObject() ) );
		this.setLeftPathSearchResultDto( new SearchResultDto( object.get( "leftPathSearchResultDto" ).getAsJsonObject() ) );
		this.setRightPathSearchResultDto( new SearchResultDto( object.get( "rightPathSearchResultDto" ).getAsJsonObject() ) );

	}
	
	public Publications getLhPublications() {
		return lhPublications;
	}
	
	public void setLhPublications(Publications lhPublications) {
		this.lhPublications = lhPublications;
	}
	
	public Publications getRhPublications() {
		return rhPublications;
	}
	
	public void setRhPublications(Publications rhPublications) {
		this.rhPublications = rhPublications;
	}
	
	public ConceptInfoResponse getLeftConcept() {
		return leftConcept;
	}
	
	public void setLeftConcept(ConceptInfoResponse leftConcept) {
		this.leftConcept = leftConcept;
	}
	
	public SearchResultDto getLeftPathSearchResultDto() {
		return leftPathSearchResultDto;
	}
	
	public void setLeftPathSearchResultDto(SearchResultDto leftPathSearchResultDto) {
		this.leftPathSearchResultDto = leftPathSearchResultDto;
	}
	
	public SearchResultDto getRightPathSearchResultDto() {
		return rightPathSearchResultDto;
	}
	
	public void setRightPathSearchResultDto(SearchResultDto rightPathSearchResultDto) {
		this.rightPathSearchResultDto = rightPathSearchResultDto;
	}
	
	
}
