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

/**
 *  
 */
public class TripleInformation {

	private String tripleUuid = null;
	private String predicateName = null;
	
	/**
	 * @param asJsonObject
	 */
	public TripleInformation(JsonObject object) {
		this.setTripleUuid( Utils.getContentElementAsString( object.get( "tripleUuid" ) ) );
		this.setPredicateName( Utils.getContentElementAsString( object.get( "predicateName" ) ) );
	}

	public String getTripleUuid() {
		return tripleUuid;
	}
	
	public void setTripleUuid(String tripleUuid) {
		this.tripleUuid = tripleUuid;
	}
	
	public String getPredicateName() {
		return predicateName;
	}
	
	public void setPredicateName(String predicateName) {
		this.predicateName = predicateName;
	}
	
	
}
