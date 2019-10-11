package com.blessy.application.service;


import com.blessy.application.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

	User addUser(User user);
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);	
	List<User> findAll();
	 
}
