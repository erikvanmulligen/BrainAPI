/**
 * 
 */
package com.euretos.brain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * (C) 2013,2014 Science and Technology Corporation, Delft, The Netherlands
 *
 * @author Erik van Mulligen
 * 
 *
 */
public class IdsObject {

	private List<String> ids = new ArrayList<String>();
	
	/**
	 * @param uuid
	 */
	public IdsObject(String id) {
		this.ids.add( id );
	}

	public IdsObject(List<String> ids) {
		this.ids = ids;
	}

	public IdsObject(Set<String> ids) {
		this.ids.addAll( ids );
	}

	public List<String> getIds() {
		return ids;
	}


	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	
	public void add( String id ){
		this.ids.add( id );
	}
}
