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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *  
 */
public class SearchDirectResponse {
	private Boolean last = null;
	private Integer totalElements = null;
	private Integer totalPages = null;
	private String sort = null;
	private Integer numberOfElements = null;
	private Boolean first = null;
	private Integer size = null;
	private Integer number = null;
	private List<SearchDirectElementResponse> content = new ArrayList<SearchDirectElementResponse>();

	public SearchDirectResponse( JsonObject object ){
		this.parse( object );
	}
	
	public void parse( JsonObject object ){
    	this.setLast( Utils.getContentElementAsBoolean( object.get( "first" ) ) );
    	this.setTotalElements( Utils.getContentElementAsInteger( object.get( "totalElements" ) ) );
    	this.setTotalPages( Utils.getContentElementAsInteger( object.get( "totalPages" ) ) );
    	this.setSort( Utils.getContentElementAsString( object.get( "sort" ) ) );
    	this.setNumberOfElements( Utils.getContentElementAsInteger( object.get( "numberOfElements" ) ) );
    	this.setFirst( Utils.getContentElementAsBoolean( object.get( "first" ) ) );
    	this.setSize( Utils.getContentElementAsInteger( object.get( "size" ) ) );
    	this.setNumber( Utils.getContentElementAsInteger( object.get( "number" ) ) );
		
    	JsonArray jarray = object.get( "content" ).getAsJsonArray();
	    for (int i = 0 ; i < jarray.size() ; i++){
	    	this.content.add( new SearchDirectElementResponse( jarray.get(i).getAsJsonObject() ) );
	    }
	}

	public List<SearchDirectElementResponse> getContent() {
		return content;
	}

	public void setContent(List<SearchDirectElementResponse> content) {
		this.content = content;
	}
	
	public void addContent( SearchDirectElementResponse item) {
		this.content.add( item );
	}

	public Boolean getLast() {
		return last;
	}

	public void setLast(Boolean last) {
		this.last = last;
	}

	public Integer getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public Boolean getFirst() {
		return first;
	}

	public void setFirst(Boolean first) {
		this.first = first;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
