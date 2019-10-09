package com.blessy.application.service;


import com.blessy.application.model.Role;

public interface IRoleService {
	Role addRole(Role role);
	Role getRole(int role_id);
}
