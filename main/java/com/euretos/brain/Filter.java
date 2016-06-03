/**
 * 
 */
package com.euretos.brain;

import java.util.List;

/**
 * (C) 2013,2014 Science and Technology Corporation, Delft, The Netherlands
 *
 * @author Erik van Mulligen
 * 
 *
 */
public class Filter {
	private String publicationDateFrom = null;
    private String publicationDateTo = null;
    private String relationType = null;
    private List<String> sources = null;
    private List<SemanticCategoryAndTypes> categories = null;
    private Boolean lastYear = false;
    private Boolean lastMonth = false;

	public String getPublicationDateFrom() {
		return publicationDateFrom;
	}
	
	public void setPublicationDateFrom(String publicationDateFrom) {
		this.publicationDateFrom = publicationDateFrom;
	}
	
	public String getPublicationDateTo() {
		return publicationDateTo;
	}
	
	public void setPublicationDateTo(String publicationDateTo) {
		this.publicationDateTo = publicationDateTo;
	}
	
	public String getRelationType() {
		return relationType;
	}
	
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
	
	public List<String> getSources() {
		return sources;
	}
	
	public void setSources(List<String> sources) {
		this.sources = sources;
	}

	public List<SemanticCategoryAndTypes> getCategories() {
		return categories;
	}

	public void setCategories(List<SemanticCategoryAndTypes> categories) {
		this.categories = categories;
	}

	public Boolean getLastYear() {
		return lastYear;
	}

	public void setLastYear(Boolean lastYear) {
		this.lastYear = lastYear;
	}

	public Boolean getLastMonth() {
		return lastMonth;
	}

	public void setLastMonth(Boolean lastMonth) {
		this.lastMonth = lastMonth;
	}
    
}
