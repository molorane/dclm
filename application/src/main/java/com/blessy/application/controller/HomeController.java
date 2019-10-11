package com.blessy.application.controller;

import com.blessy.application.service.RoleService;
import com.blessy.application.service.UserService;
import com.blessy.application.utils.WebPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	private final UserService userService;
	private final RoleService roleService;

	@Autowired
	public HomeController(UserService userService, RoleService roleService) {
		this.roleService = roleService;
		this.userService = userService;
	}

	@RequestMapping({"", "/"})
	public String showHome() {
		return WebPage.HOME.getPageName();
	}

}
