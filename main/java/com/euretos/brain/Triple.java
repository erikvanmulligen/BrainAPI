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

/**
 *  
 */
public class Triple {
	
	private String id = null;
	private IdName object = new IdName(); 
	private IdName predicate = new IdName(); 
	private IdName subject = new IdName();
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public IdName getObject() {
		return object;
	}
	
	public void setObject(IdName object) {
		this.object = object;
	}
	
	public IdName getPredicate() {
		return predicate;
	}
	
	public void setPredicate(IdName predicate) {
		this.predicate = predicate;
	}
	
	public IdName getSubject() {
		return subject;
	}
	
	public void setSubject(IdName subject) {
		this.subject = subject;
	} 
	
}
