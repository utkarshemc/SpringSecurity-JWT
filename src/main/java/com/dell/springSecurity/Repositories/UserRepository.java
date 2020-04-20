/**
 * 
 */
package com.dell.springSecurity.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.dell.springSecurity.model.User;

/**
 * @author bhardu
 * @Since Apr 21, 2020
 */
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
}
