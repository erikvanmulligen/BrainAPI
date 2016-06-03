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

/**
 *  
 */
public class FullPublicationResponse {

	private String id = null;
	private List<String> authors = new ArrayList<String>();
	private PublicationResponse publicationInfo = new PublicationResponse();
	private List<Triple> triples = new ArrayList<Triple>();
	private List<Triple> supportingTriples = new ArrayList<Triple>();
	private ScientificMeasures measures = new ScientificMeasures();
	private List<String> keywords = new ArrayList<String>();
	
	public List<String> getAuthors() {
		return authors;
	}
	
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public PublicationResponse getPublicationInfo() {
		return publicationInfo;
	}
	
	public void setPublicationInfo(PublicationResponse publicationInfo) {
		this.publicationInfo = publicationInfo;
	}
	
	public List<Triple> getTriples() {
		return triples;
	}
	
	public void setTriples(List<Triple> triples) {
		this.triples = triples;
	}
	
	public List<Triple> getSupportingTriples() {
		return supportingTriples;
	}
	
	public void setSupportingTriples(List<Triple> supportingTriples) {
		this.supportingTriples = supportingTriples;
	}
	
	public ScientificMeasures getMeasures() {
		return measures;
	}
	
	public void setMeasures(ScientificMeasures measures) {
		this.measures = measures;
	}
	
	public List<String> getKeywords() {
		return keywords;
	}
	
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
