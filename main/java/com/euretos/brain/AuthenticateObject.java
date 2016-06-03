/**
 * 
 */
package com.euretos.brain;

/**
 * (C) 2013,2014 Science and Technology Corporation, Delft, The Netherlands
 *
 * @author Erik van Mulligen
 * 
 *
 */
public class AuthenticateObject {

	private String username = null;
	private String password = null;
	
	public AuthenticateObject(String username, String password) {
		this.username=username;
		this.password=password;
	}

	@Override
	public String toString() {
		return "DataObject [username=" + username + ", password=" + password + "]";
	}
}
