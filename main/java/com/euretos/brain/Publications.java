/**
 * 
 */
package com.euretos.brain;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

/**
 * (C) 2013,2014 Science and Technology Corporation, Delft, The Netherlands
 *
 * @author Erik van Mulligen
 * 
 *
 */
public class Publications {

	private Integer publicationCount = null;
	private String keywordName = null;
	private String keywordUuid = null;
	private String tripleUuid = null;
	private String predicateName = null;
	private PublicationInfo mostRelevantPublication = null;
	private List<PublicationInfo> publications = new ArrayList<PublicationInfo>();

	public Publications(JsonObject object) {
		
		this.setPublicationCount( Utils.getContentElementAsInteger( object.get( "publicationCount" ) ) );
		this.setKeywordName( Utils.getContentElementAsString( object.get( "keywordName" ) ) );
		this.setKeywordUuid( Utils.getContentElementAsString( object.get( "keywordUuid" ) ) );
		this.setPredicateName( Utils.getContentElementAsString( object.get( "predicateName" ) ) );
		this.setMostRelevantPublication( new PublicationInfo( Utils.getContentElementAsString( object.get( "mostRelevantPublication" ) ) ) );
		for ( String uuid : Utils.getContentElementAsList( object.get( "publications" ) ) ){
			this.addPublications( new PublicationInfo( uuid ) );
		}
	}

	public Integer getPublicationCount() {
		return publicationCount;
	}
	public void setPublicationCount(Integer publicationCount) {
		this.publicationCount = publicationCount;
	}
	
	public String getKeywordName() {
		return keywordName;
	}
	
	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}
	
	public String getKeywordUuid() {
		return keywordUuid;
	}
	
	public void setKeywordUuid(String keywordUuid) {
		this.keywordUuid = keywordUuid;
	}
	
	public String getTripleUuid() {
		return tripleUuid;
	}
	
	public void setTripleUuid(String tripleUuid) {
		this.tripleUuid = tripleUuid;
	}
	
	public String getPredicateName() {
		return predicateName;
	}
	
	public void setPredicateName(String predicateName) {
		this.predicateName = predicateName;
	}
	
	public PublicationInfo getMostRelevantPublication() {
		return mostRelevantPublication;
	}
	
	public void setMostRelevantPublication(PublicationInfo mostRelevantPublication) {
		this.mostRelevantPublication = mostRelevantPublication;
	}
	
	public List<PublicationInfo> getPublications() {
		return publications;
	}
	
	public void setPublications(List<PublicationInfo> publications) {
		this.publications = publications;
	}
	
	public void addPublications( PublicationInfo publication ) {
		this.publications.add( publication );
	}
}
