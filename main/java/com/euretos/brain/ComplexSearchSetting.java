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
public class ComplexSearchSetting {

	private List<Taxonomy> taxonomy = null;
	private List<String> excludedConcepts = null;
	private List<SemanticCategoryInfo> excludedSemantics = null;
	private List<Taxonomy> excludedTaxonomy = null;
	private List<SemanticCategoryInfo> semantics = null;
	
	public List<Taxonomy> getTaxonomy() {
		return taxonomy;
	}
	
	public void setTaxonomy(List<Taxonomy> taxonomy) {
		this.taxonomy = taxonomy;
	}
	
	public List<String> getExcludedConcepts() {
		return excludedConcepts;
	}
	
	public void setExcludedConcepts(List<String> excludedConcepts) {
		this.excludedConcepts = excludedConcepts;
	}
	
	public List<SemanticCategoryInfo> getExcludedSemantics() {
		return excludedSemantics;
	}
	
	public void setExcludedSemantics(List<SemanticCategoryInfo> excludedSemantics) {
		this.excludedSemantics = excludedSemantics;
	}
	
	public List<Taxonomy> getExcludedTaxonomy() {
		return excludedTaxonomy;
	}
	
	public void setExcludedTaxonomy(List<Taxonomy> excludedTaxonomy) {
		this.excludedTaxonomy = excludedTaxonomy;
	}
	
	public List<SemanticCategoryInfo> getSemantics() {
		return semantics;
	}
	
	public void setSemantics(List<SemanticCategoryInfo> semantics) {
		this.semantics = semantics;
	}
	
}
