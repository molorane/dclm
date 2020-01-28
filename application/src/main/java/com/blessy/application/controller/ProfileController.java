package com.blessy.application.controller;

import com.blessy.application.model.User;
import com.blessy.application.service.DenominationService;
import com.blessy.application.service.UserService;
import com.blessy.application.utils.WebPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	private final UserService userService;
	private final DenominationService denominationService;

	@Autowired
	public ProfileController(UserService userService, DenominationService denominationService){
		this.userService = userService;
		this.denominationService = denominationService;
	}

	@RequestMapping
	public String profile(Principal principal, Model model) {
		String username = principal.getName();
		User user = userService.findByUsername(username).get();
		System.out.println("User has authorities: " + user.getRoles());
		System.out.println("User ID: " + user.getUser_id());
		model.addAttribute("user", user);
		model.addAttribute("denomination", denominationService.getDenomination(1));
		return WebPage.PROFILE.getPageName();
	}

	@RequestMapping("/change_password")
	public String profile() {
		return WebPage.CHANGE_PASSWORD.getPageName();
	}

}
