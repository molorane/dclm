package com.blessy.application.controller;

import com.blessy.application.service.IRoleService;
import com.blessy.application.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private final IUserService userService;
	private final IRoleService roleService;

	@Autowired
	public HomeController(IUserService userService, IRoleService roleService) {
		this.roleService = roleService;
		this.userService = userService;
	}

	@RequestMapping({"", "/", "/home"})
	public String showHome() {

		return "index";
	}
}
