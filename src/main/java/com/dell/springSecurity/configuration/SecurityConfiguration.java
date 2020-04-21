/**
 * 
 */
package com.dell.springSecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dell.springSecurity.filter.JwtRequestFilter;
import com.dell.springSecurity.services.MyUserDetailService;

/**
 * @author bhardu
 * @Since Apr 14, 2020
 */

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailService myUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		  http.csrf().disable().authorizeRequests()
		  .antMatchers("/admin").hasRole("ADMIN")
		  .antMatchers("/authenticate").
		  permitAll().anyRequest().authenticated()
		  .and().exceptionHandling().and().sessionManagement()
		  .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		  http.addFilterBefore(jwtRequestFilter,
		   UsernamePasswordAuthenticationFilter.class);
		 
		/*
		 * http.authorizeRequests() .antMatchers("/admin").hasRole("ADMIN")
		 * .antMatchers("/users").hasAnyRole("ADMIN","USERS")
		 * .antMatchers("/").permitAll() .and().formLogin();
		 */
		       
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
