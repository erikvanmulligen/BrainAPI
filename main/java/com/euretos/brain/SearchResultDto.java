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

import com.google.gson.JsonObject;

public class SearchResultDto {
	
	private Integer graphIndexFrom = null;
	private Integer graphIndexTo = null;
	
	public SearchResultDto(JsonObject object) {
		this.graphIndexFrom = Utils.getContentElementAsInteger( object.get( "graphIndexFrom" ) );
		this.graphIndexTo = Utils.getContentElementAsInteger( object.get( "graphIndexTo" ) );
	}

	public Integer getGraphIndexFrom() {
		return graphIndexFrom;
	}
	
	public void setGraphIndexFrom(Integer graphIndexFrom) {
		this.graphIndexFrom = graphIndexFrom;
	}
	
	public Integer getGraphIndexTo() {
		return graphIndexTo;
	}
	
	public void setGraphIndexTo(Integer graphIndexTo) {
		this.graphIndexTo = graphIndexTo;
	}

}
