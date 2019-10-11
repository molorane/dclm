package com.blessy.application.service.internal;


import com.blessy.application.model.Role;
import com.blessy.application.model.User;
import com.blessy.application.repository.RoleRepository;
import com.blessy.application.repository.UserRepository;
import com.blessy.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
	
	 @Autowired
	 private UserRepository userRepository;
	 
	 @Autowired
	 private RoleRepository roleRepository;

	 @Autowired
	 private PasswordEncoder passwordEncoder;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		Role role = roleRepository.findByRole("SITE_USER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<Role>(Arrays.asList(role)));
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
