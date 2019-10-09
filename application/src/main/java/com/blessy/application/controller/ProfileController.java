package com.blessy.application.controller;

import com.blessy.application.model.User;
import com.blessy.application.service.IDenominationService;
import com.blessy.application.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class ProfileController {

	private final IUserService userService;
	private final IDenominationService denominationService;

	@Autowired
	public ProfileController(IUserService userService, IDenominationService denominationService){
		this.userService = userService;
		this.denominationService = denominationService;
	}
	
	@RequestMapping("/profile")
	public String profile(Principal principal, Model model) {
		String username = principal.getName();
		User user = userService.findByUsername(username).get();
		System.out.println("User has authorities: " + user.getRoles());
		System.out.println("User ID: " + user.getUser_id());
		model.addAttribute("user", user);
		model.addAttribute("denomination", denominationService.getDenomination(1));
		return "profile";
	}

}
