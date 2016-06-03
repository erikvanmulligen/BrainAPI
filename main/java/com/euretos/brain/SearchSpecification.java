/**
 * 
 */
package com.euretos.brain;

import java.util.ArrayList;
import java.util.List;

/**
 * (C) 2013,2014 Science and Technology Corporation, Delft, The Netherlands
 *
 * @author Erik van Mulligen
 * 
 *
 */
public class SearchSpecification {

	private List<String> excludedKeywords = null;
	private List<String> lhKeywords = new ArrayList<String>();
	private List<String> rhKeywords = new ArrayList<String>();
	//private Filter filter = new Filter();
	private String linkWeightAlgorithm = "plws";
	private String sort = "DESC";
	private ComplexSearchSetting complexSearchSetting = new ComplexSearchSetting();
	
	
	public SearchSpecification( List<String> sourceUUIDs, List<String> targetUUIDs ) {
		this.lhKeywords = sourceUUIDs;
		this.rhKeywords = targetUUIDs;
	}

	public List<String> getExcludedKeywords() {
		return excludedKeywords;
	}

	public void setExcludedKeywords(List<String> excludedKeywords) {
		this.excludedKeywords = excludedKeywords;
	}

	public List<String> getLhKeywords() {
		return lhKeywords;
	}

	public void setLhKeywords(List<String> lhKeywords) {
		this.lhKeywords = lhKeywords;
	}

	public List<String> getRhKeywords() {
		return rhKeywords;
	}

	public void setRhKeywords(List<String> rhKeywords) {
		this.rhKeywords = rhKeywords;
	}

//	public Filter getFilter() {
//		return filter;
//	}
//
//	public void setFilter(Filter filter) {
//		this.filter = filter;
//	}

	@Override
	public String toString() {
		return "Keyword2KeywordObject [ excludedKeywords=" + excludedKeywords + ", lhKeywords=" + lhKeywords + ", rhKeywords=" + rhKeywords + "]";
	}

	public String getLinkWeightAlgorithm() {
		return linkWeightAlgorithm;
	}

	public void setLinkWeightAlgorithm(String linkWeightAlgorithm) {
		this.linkWeightAlgorithm = linkWeightAlgorithm;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public ComplexSearchSetting getComplexSearchSetting() {
		return complexSearchSetting;
	}

	public void setComplexSearchSetting(ComplexSearchSetting complexSearchSetting) {
		this.complexSearchSetting = complexSearchSetting;
	}
}
