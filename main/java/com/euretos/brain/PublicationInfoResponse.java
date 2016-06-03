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
public class PublicationInfoResponse {
	
	private String uuid = null;
	private PublicationResponse publicationInfo = null;
	
	public PublicationInfoResponse(){
	}
	
	public PublicationInfoResponse( JsonObject object ){
		parse( object );
	}

	public void parse( JsonObject object ){
//		List<PublicationInfoResponse> response = new ArrayList<PublicationInfoResponse>();
		
//		JsonArray publicationsArray = object.getAsJsonArray();
//		for ( int i = 0 ; i < publicationsArray.size() ; i++ ){
//			PublicationInfoResponse publicationInfoResponse = new PublicationInfoResponse();
//			JsonObject publicationObject = publicationsArray.get(i).getAsJsonObject();
//			publicationInfoResponse.setUuid( Utils.getContentElementAsString( publicationObject.get( "uuid" ) ) );
//			publicationInfoResponse.setPublicationInfo( new PublicationResponse( publicationObject.get( "publicationInfo" ).getAsJsonObject() ) );
//			response.add( publicationInfoResponse );
//		}
//		JsonArray publicationsArray = object.getAsJsonArray();

		this.setUuid( Utils.getContentElementAsString( object.get( "uuid" ) ) );
		this.setPublicationInfo( new PublicationResponse( object.get( "publicationInfo" ).getAsJsonObject() ) );
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public PublicationResponse getPublicationInfo() {
		return publicationInfo;
	}
	
	public void setPublicationInfo(PublicationResponse publicationInfo) {
		this.publicationInfo = publicationInfo;
	}

}
