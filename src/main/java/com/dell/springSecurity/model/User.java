/**
 * 
 */
package com.dell.springSecurity.model;

/**
 * @author bhardu
 * @Since Apr 14, 2020
 */
public class User {
	
	private String username;
	private String password;
	private String emailId;
	
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User() {
	}
}
