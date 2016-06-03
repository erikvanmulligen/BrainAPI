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
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.JsonObject;

/**
 *  
 */
@XmlRootElement
public class PublicationResponse {

	private String documentTitle = null;
	private String documentIdentifier = null;
	private Date documentPublicationDate = null;
	private String publicationSourceName = null;
	private String publicationSourceId = null;
	private String publishInfo = null;
	private Date lastUpdateDate = null;
	private String url = null;
	private List<String> keywordList = null;
	private List<String> geneSymList = null;
	private List<String> chemSubList = null;
	private List<String> meshHeadList = null;
	private String abstractInfo = null;
	
	public PublicationResponse(){
	}
	
	public PublicationResponse( JsonObject object ){
		this.parse( object );
	}
	
	public void parse( JsonObject object ){ 
		this.setDocumentTitle( Utils.getContentElementAsString( object.get( "documentTitle" ) ) );
		this.setDocumentIdentifier( Utils.getContentElementAsString( object.get( "documentIdentifier" ) ) );
		this.setDocumentPublicationDate( Utils.getContentElementAsDate( object.get( "documentPublicationDate" ) ) );
		this.setPublicationSourceName( Utils.getContentElementAsString( object.get( "publicationSourceName" ) ) );
		this.setPublicationSourceId( Utils.getContentElementAsString( object.get( "publicationSourceId" ) ) );
		this.setPublishInfo( Utils.getContentElementAsString( object.get( "publishInfo" ) ) );
		this.setLastUpdateDate( Utils.getContentElementAsDate( object.get( "lastUpdateDate" ) ) );
		this.setUrl( Utils.getContentElementAsString( object.get( "url" ) ) );
		this.setKeywordList( Utils.getContentElementAsList( object.get( "keywordList" ) ) );
		this.setGeneSymList( Utils.getContentElementAsList( object.get( "geneSymList" ) ) );
		this.setChemSubList( Utils.getContentElementAsList( object.get( "chemSubList" ) ) );
		this.setMeshHeadList( Utils.getContentElementAsList( object.get( "meshHeadList" ) ) );
		this.setAbstractInfo( Utils.getContentElementAsString( object.get( "asbtractInfo" ) ) );
	}
	
	public String getDocumentTitle() {
		return documentTitle;
	}
	
	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}
	
	public String getDocumentIdentifier() {
		return documentIdentifier;
	}
	
	public void setDocumentIdentifier(String documentIdentifier) {
		this.documentIdentifier = documentIdentifier;
	}
	
	public Date getDocumentPublicationDate() {
		return documentPublicationDate;
	}
	
	public void setDocumentPublicationDate(Date documentPublicationDate) {
		this.documentPublicationDate = documentPublicationDate;
	}
	
	public String getPublicationSourceName() {
		return publicationSourceName;
	}
	
	public void setPublicationSourceName(String publicationSourceName) {
		this.publicationSourceName = publicationSourceName;
	}
	
	public String getPublicationSourceId() {
		return publicationSourceId;
	}
	
	public void setPublicationSourceId(String publicationSourceId) {
		this.publicationSourceId = publicationSourceId;
	}
	
	public String getPublishInfo() {
		return publishInfo;
	}
	
	public void setPublishInfo(String publishInfo) {
		this.publishInfo = publishInfo;
	}
	
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	
	public void setLastUpdateDate(Date lastUpdate) {
		this.lastUpdateDate = lastUpdate;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public List<String> getKeywordList() {
		return keywordList;
	}
	
	public void setKeywordList(List<String> keywordList) {
		this.keywordList = keywordList;
	}
	
	public void addKeywordList( String item ){
		if ( this.keywordList == null ){
			this.keywordList = new ArrayList<String>();
		}
	}
	
	public List<String> getGeneSymList() {
		return geneSymList;
	}
	
	public void setGeneSymList(List<String> geneSymList) {
		this.geneSymList = geneSymList;
	}
	
	public void addGeneSymList( String item ){
		if ( this.geneSymList == null ){
			this.geneSymList = new ArrayList<String>();
		}
	}

	public List<String> getChemSubList() {
		return chemSubList;
	}
	
	public void setChemSubList(List<String> chemSubList) {
		this.chemSubList = chemSubList;
	}
	
	public void addChemSubList( String item ){
		if ( this.chemSubList == null ){
			this.chemSubList = new ArrayList<String>();
		}
	}

	public List<String> getMeshHeadList() {
		return meshHeadList;
	}
	
	public void setMeshHeadList(List<String> meshHeadList) {
		this.meshHeadList = meshHeadList;
	}
	
	public void addMeshHeadList( String item ){
		if ( this.meshHeadList == null ){
			this.meshHeadList = new ArrayList<String>();
		}
	}
	
	public String getAbstractInfo() {
		return abstractInfo;
	}
	
	public void setAbstractInfo(String abstractInfo) {
		this.abstractInfo = abstractInfo;
	}

	public void setDocumentPublicationDate(Long date) {
		if ( date != null ){
			this.documentPublicationDate = new Date( date );
		}
	}

	public void setLastUpdateDate(Long date) {
		if ( date != null ){
			this.documentPublicationDate = new Date( date );
		}
	}

	public PublicationInfo convert(ScientificMeasures scientificMeasures) {
		PublicationInfo response = new PublicationInfo();
		response.setSourceId( this.getPublicationSourceId() );
		response.setId( this.getDocumentIdentifier() );
		response.setTitle( this.getDocumentTitle() );
		response.setPublicationDate( this.getDocumentPublicationDate() );
		response.setUrl( this.getUrl() );
		response.setSourceName( this.getPublicationSourceName() );
		
		if ( scientificMeasures != null ){
			response.setScientificValue( scientificMeasures.getScientific_value() );
		}
		return response;
	}

	public PublicationInfo convert(String scientific_value) {
		PublicationInfo response = new PublicationInfo();
		response.setSourceId( this.getPublicationSourceId() );
		response.setId( this.getDocumentIdentifier() );
		response.setTitle( this.getDocumentTitle() );
		response.setPublicationDate( this.getDocumentPublicationDate() );
		response.setUrl( this.getUrl() );
		response.setSourceName( this.getPublicationSourceName() );
		
		if ( scientific_value != null ){
			response.setScientificValue( scientific_value );
		}
		return response;
	}

}
