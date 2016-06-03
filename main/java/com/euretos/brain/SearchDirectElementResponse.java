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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *  
 */
@XmlRootElement
public class SearchDirectElementResponse {

	private String tripleId = null;
	private String conceptName = null;
	private String conceptUuid = null;
	private String conceptCategory = null;
	private String predicateName = null;
	private Integer publicationsCount = null;
	private PublicationResponse highRankedPublication = new PublicationResponse();
	private List<PublicationInfoResponse> publications = new ArrayList<PublicationInfoResponse>();
	private ConceptInfoResponse linkedConcept = new ConceptInfoResponse();
	
	public SearchDirectElementResponse(){
	}

	public SearchDirectElementResponse( JsonObject object  ){
		this.parse( object );
	}
	
	public void parse( JsonObject object ){
		this.setTripleId( Utils.getContentElementAsString( object.get( "tripleId" ) ) );
		this.setConceptName( Utils.getContentElementAsString( object.get( "conceptName" ) ) );
		this.setConceptUuid( Utils.getContentElementAsString( object.get( "conceptUuid" ) ) );
		this.setConceptCategory( Utils.getContentElementAsString( object.get( "conceptCategory" ) ) );
		this.setPredicateName( Utils.getContentElementAsString( object.get( "predicatName" ) ) );
		this.setPublicationsCount( Utils.getContentElementAsInteger( object.get( "publicationCount" ) ) );
		this.setHighRankedPublication( new PublicationResponse( object.get( "highRankedPublication" ).getAsJsonObject() ) );
		
		JsonArray publicationsArray = object.get( "publications" ).getAsJsonArray();
		for ( int i = 0 ; i < publicationsArray.size() ; i++ ){
			//System.out.println( publicationsArray.get(i) );
			this.publications.add( new PublicationInfoResponse( publicationsArray.get(i).getAsJsonObject() ) );
		}

		this.setLinkedConcept( new ConceptInfoResponse( object.get( "linkedConcept" ).getAsJsonObject() ) );
	}

	public String getTripleId() {
		return tripleId;
	}
	
	public void setTripleId(String tripleId) {
		this.tripleId = tripleId;
	}
	
	public String getConceptName() {
		return conceptName;
	}
	
	public void setConceptName(String conceptName) {
		this.conceptName = conceptName;
	}
	
	public String getConceptUuid() {
		return conceptUuid;
	}
	
	public void setConceptUuid(String conceptUuid) {
		this.conceptUuid = conceptUuid;
	}
	
	public String getConceptCategory() {
		return conceptCategory;
	}
	
	public void setConceptCategory(String conceptCategory) {
		this.conceptCategory = conceptCategory;
	}
	
	public String getPredicateName() {
		return this.predicateName;
	}
	
	public void setPredicateName(String predicateName) {
		//System.out.println( "found predicate: " + predicateName );
		this.predicateName = predicateName;
	}
	
	public Integer getPublicationsCount() {
		return publicationsCount;
	}
	
	public void setPublicationsCount(Integer publicationsCount) {
		this.publicationsCount = publicationsCount;
	}
	
	public PublicationResponse getHighRankedPublication() {
		return highRankedPublication;
	}
	
	public void setHighRankedPublication(PublicationResponse highRankedPublication) {
		this.highRankedPublication = highRankedPublication;
	}
	
	public List<PublicationInfoResponse> getPublications() {
		return publications;
	}
	
	public void setPublications(List<PublicationInfoResponse> publications) {
		this.publications = publications;
	}
	
	public ConceptInfoResponse getLinkedConcept() {
		return linkedConcept;
	}
	
	public void setLinkedConcept(ConceptInfoResponse linkedConcept) {
		this.linkedConcept = linkedConcept;
	}
	
	
}
