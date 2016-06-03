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

import java.util.Date;

import javax.xml.bind.annotation.XmlTransient;

/**
 *  
 */
public class PublicationInfo {

	private String uuid = null;
	private String title = null;
	private String sourceId = null;
	private String sourceName = null;
	private Date publicationDate = null;
	private String url = null;
	private String id = null;
	private String scientificValue = null;
	
	public PublicationInfo(String uuid) {
		this.uuid = uuid;
	}

	public PublicationInfo() {
	}

	@XmlTransient
	public String getUuid() {
		if ( this.uuid != null && ( this.title == null || this.sourceId == null ) ){
			Brain.getPublication( this.uuid );
		}
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getTitle() {
		if ( this.title == null ){
			PublicationInfo publication = Brain.getPublication( this.uuid );
			if ( publication != null ){
				this.title = publication.getTitle();
			}
		}
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSourceId() {
		if ( this.sourceId == null ){
			PublicationInfo publication = Brain.getPublication( this.uuid );
			if ( publication != null ){
				this.sourceId = publication.getSourceId();
			}
		}
		return this.sourceId;
	}
	
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceName() {
		if ( this.sourceName == null ){
			PublicationInfo publication = Brain.getPublication( this.uuid );
			if ( publication != null ){
				this.sourceName = publication.getSourceName();
			}
		}
		return this.sourceName ;
	}

	public void setSourceName( String sourceName ) {
		this.sourceName = sourceName;
	}

	public void setId(String id) {
		this.id  = id;
	}

	public String getId() {
		if ( this.id == null ){
			PublicationInfo publication = Brain.getPublication( this.uuid );
			if ( publication != null ){
				this.id = publication.getId();
			}
		}
		return this.id;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setScientificValue(String scientific_value) {
		this.scientificValue  = scientific_value;
	}
	
	public String getScientificValue(){
		return this.scientificValue;
	}
	
}
