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
public class UuidsObject {

	private List<String> uids = new ArrayList<String>();
	
	/**
	 * @param uuid
	 */
	public UuidsObject(String uuid) {
		this.uids.add( uuid );
	}

	public UuidsObject(List<String> uuids) {
		this.uids = uuids;
	}

	public List<String> getUids() {
		return uids;
	}


	public void setUids(List<String> uids) {
		this.uids = uids;
	}
	
	public void add( String uuid ){
		this.uids.add( uuid );
	}
}
