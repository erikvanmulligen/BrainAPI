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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  
 */
@XmlRootElement
public class EntityResponse {

	private List<String> entities = new ArrayList<String>();

	@XmlElement( name = "name" )
	public List<String> getEntities() {
		return entities;
	}
	
	@XmlElement( name = "count" )
	public Integer getCount(){
		return this.entities.size();
	}
	
	public void setEntities(List<String> entities) {
		this.entities = entities;
	}

	public void addEntitities(List<ModelItem> list) {
		for ( ModelItem item : list ){
			//System.out.println( item.getName() );
			this.entities.add( item.getName() );
		}
	}

}
