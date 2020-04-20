/**
 * 
 */
package com.dell.springSecurity.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dell.springSecurity.Repositories.UserRepository;
import com.dell.springSecurity.model.MyUserDetails;

//import com.dell.springSecurity.model.MyUserDetails;



/**
 * @author bhardu
 * @Since Apr 14, 2020
 */

@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//return new User("foo","foo", new ArrayList<>());
		com.dell.springSecurity.model.User user = userRepository.findByUsername(username);
		return new MyUserDetails(user);
	}

}
