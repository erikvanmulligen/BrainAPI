package com.euretos.brainv2;

public class LoginObject {

    private String username = null;
    private String password = null;

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
