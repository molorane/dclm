package com.blessy.application.service.internal;

import com.blessy.application.model.Role;
import com.blessy.application.repository.RoleRepository;
import com.blessy.application.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepo;

	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepo.save(role);
	}

	@Override
	public Role getRole(int role_id) {
		// TODO Auto-generated method stub
		return roleRepo.findById(role_id).get();
	}

}
