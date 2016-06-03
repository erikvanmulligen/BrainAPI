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

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.JsonObject;

/**
 *  
 */
@XmlRootElement
public class ConceptInfoResponse {

	private String uuid = null;
	private String name = null;
	private String category = null;
	private String gi = null;
	
	public ConceptInfoResponse(){
	}
	
	public ConceptInfoResponse( JsonObject object ) {
		this.uuid = Utils.getContentElementAsString( object.get( "uuid" ) );
		this.name = Utils.getContentElementAsString( object.get( "name" ) );
		this.category = Utils.getContentElementAsString( object.get( "category" ) );
		this.gi = Utils.getContentElementAsString( object.get( "gi" ) );
	}

	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getGi() {
		return gi;
	}
	
	public void setGi(String gi) {
		this.gi = gi;
	}

}
