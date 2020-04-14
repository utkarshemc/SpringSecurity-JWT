/**
 * 
 */
package com.dell.springSecurity.model;

/**
 * @author bhardu
 * @Since Apr 14, 2020
 */
public class AuthenticateResponse {
	
	private String jwtToken;

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public AuthenticateResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}
	
	

}
