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
public class PathElt {

	private String sourceName = null;
	private String sourceUuid = null;
	private String sourceCategory = null;
	private String targetName = null;
	private String targetUuid = null;
	private String targetCategory = null;
	private List<PublicationInfo> publications = new ArrayList<PublicationInfo>();
	private String predicateName = null;
	private String tripleUuid = null;
	
	public String getSourceName() {
		return sourceName;
	}
	
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	
	//@XmlTransient
	public String getSourceUuid() {
		return sourceUuid;
	}
	
	public void setSourceUuid(String sourceUuid) {
		this.sourceUuid = sourceUuid;
	}
	
	public String getTargetName() {
		return targetName;
	}
	
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	
	//@XmlTransient
	public String getTargetUuid() {
		return targetUuid;
	}
	
	public void setTargetUuid(String targetUuid) {
		this.targetUuid = targetUuid;
	}

	public List<PublicationInfo> getPublications() {
		return publications;
	}

	public void setPublications(List<PublicationInfo> publications) {
		this.publications = publications;
	}
	
	public void addPublication( PublicationInfo publicationInfo ){
		this.publications.add( publicationInfo );
	}

	public void setPredicateName(String predicateName) {
		this.predicateName  = predicateName;
	}

	public String getPredicateName() {
		return predicateName;
	}

	public void setTripleUuid(String tripleUuid) {
		this.tripleUuid  = tripleUuid;
	}

	public String getTripleUuid() {
		return tripleUuid;
	}

	public String getSourceCategory() {
		return sourceCategory;
	}

	public void setSourceCategory(String sourceCategory) {
		this.sourceCategory = sourceCategory;
	}

	public String getTargetCategory() {
		return targetCategory;
	}

	public void setTargetCategory(String targetCategory) {
		this.targetCategory = targetCategory;
	}
}
