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

import java.util.List;

/**
 *  
 */
public class Triples {

	public class Triple{
		private String id = null;
		private String subjectUuid = null;
		private String predicateUuid = null;
		private String objectUuid = null;
		private String subjectName = null;
		private String objectName = null;
		private String objectsSemanticCategory = null;
		private String subjectsSemanticCategory = null;
		private List<String> publications = null;
		
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public String getSubjectUuid() {
			return subjectUuid;
		}
		
		public void setSubjectUuid(String subjectUuid) {
			this.subjectUuid = subjectUuid;
		}
		
		public String getPredicateUuid() {
			return predicateUuid;
		}
		
		public void setPredicateUuid(String predicateUuid) {
			this.predicateUuid = predicateUuid;
		}
		
		public String getObjectUuid() {
			return objectUuid;
		}
		
		public void setObjectUuid(String objectUuid) {
			this.objectUuid = objectUuid;
		}
		
		public String getSubjectName() {
			return subjectName;
		}
		
		public void setSubjectName(String subjectName) {
			this.subjectName = subjectName;
		}
		
		public String getObjectName() {
			return objectName;
		}
		
		public void setObjectName(String objectName) {
			this.objectName = objectName;
		}
		
		public String getObjectsSemanticCategory() {
			return objectsSemanticCategory;
		}
		
		public void setObjectsSemanticCategory(String objectsSemanticCategory) {
			this.objectsSemanticCategory = objectsSemanticCategory;
		}
		
		public String getSubjectsSemanticCategory() {
			return subjectsSemanticCategory;
		}
		
		public void setSubjectsSemanticCategory(String subjectsSemanticCategory) {
			this.subjectsSemanticCategory = subjectsSemanticCategory;
		}
		
		public List<String> getPublications() {
			return publications;
		}
		
		public void setPublications(List<String> publications) {
			this.publications = publications;
		}
	
	}
	
	private List<Triple> triples = null;

	public List<Triple> getTriples() {
		return triples;
	}

	public void setTriples(List<Triple> triples) {
		this.triples = triples;
	}
	
	
}
