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
public class SearchDirectInput {
	
	private List<String> excludedKeywords = null;
	private ComplexSearchSetting complexSearchSetting = null;
	private List<SemanticCategoryInfo> semantics = new ArrayList<SemanticCategoryInfo>();
	private List<String> inputTerms = new ArrayList<String>();
	private Boolean excludePublicationsInfo = false;
	
	/**
	 * @param uuid
	 * @param semanticCategory
	 */
	public SearchDirectInput(String uuid, SemanticCategoryInfo semanticCategory) {
		this.inputTerms.add( uuid );
		this.semantics.add( semanticCategory );
	}

	public List<String> getExcludedKeywords() {
		return excludedKeywords;
	}
	
	public void setExcludedKeywords(List<String> excludedKeywords) {
		this.excludedKeywords = excludedKeywords;
	}
	
	public ComplexSearchSetting getComplexSearchSetting() {
		return complexSearchSetting;
	}
	
	public void setComplexSearchSetting(ComplexSearchSetting complexSearchSetting) {
		this.complexSearchSetting = complexSearchSetting;
	}
	
	public List<SemanticCategoryInfo> getSemantics() {
		return semantics;
	}
	
	public void setSemantics(List<SemanticCategoryInfo> semantics) {
		this.semantics = semantics;
	}
	
	public List<String> getInputTerms() {
		return inputTerms;
	}
	
	public void setInputTerms(List<String> inputTerms) {
		this.inputTerms = inputTerms;
	}
	
	public Boolean getExcludePublicationsInfo() {
		return excludePublicationsInfo;
	}
	
	public void setExcludePublicationsInfo(Boolean excludePublicationsInfo) {
		this.excludePublicationsInfo = excludePublicationsInfo;
	}
	
}
