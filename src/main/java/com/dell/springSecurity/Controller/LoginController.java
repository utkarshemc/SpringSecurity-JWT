/**
 * 
 */
package com.dell.springSecurity.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dell.springSecurity.model.AuthenticateRequest;
import com.dell.springSecurity.model.AuthenticateResponse;
import com.dell.springSecurity.services.MyUserDetailService;
import com.dell.springSecurity.util.JwtUtil;

/**
 * @author bhardu
 * @Since Apr 13, 2020
 */
@RestController
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailService myUserDetailsService;
	
	@Autowired
	private JwtUtil myJwtToken;
	

	@RequestMapping("/hello")
	public String hello() {
		return ("hello World");
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> generateAutheticationToken(@RequestBody AuthenticateRequest authenticateRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticateRequest.getUsername(), authenticateRequest.getPassword()));
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("Username or Password is incorrect", e);
		}
		
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticateRequest.getUsername());
		
		String jwt = myJwtToken.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticateResponse(jwt));

	}
	
	@GetMapping("/")
	public String home() {
		return ("Home");
	}
	
	@GetMapping("/user")
	public String User() {
		return ("user");
	}
	
	@GetMapping("/admin")
	public String admin() {
		return("admin");
	}
}
