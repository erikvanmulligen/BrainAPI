/**
 * 
 */
package com.euretos.brainv2;

/**
 * (C) 2013,2014 Science and Technology Corporation, Delft, The Netherlands
 *
 * @author Erik van Mulligen
 * 
 *
 */
public class PostResponse {
	
	private Integer status = null;
	private String content = null;
	
	PostResponse(Integer status, String content){
		this.status = status;
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
