package com.euretos.brainv2;

import com.google.gson.annotations.Expose;

public class LoginObject {

    @Expose private String username = null;
    @Expose private String password = null;

    public LoginObject(String username, String password) {
	this.setUsername(username);
	this.setPassword(password);
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
}
