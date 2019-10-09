package com.blessy.application.controller;

import com.blessy.application.model.User;
import com.blessy.application.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class AuthenticationController {

	private final IUserService userService;

	@Autowired
	public AuthenticationController(IUserService userService){
		this.userService = userService;
	}
	
	
	@GetMapping({"/login","/"})
    public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
		    /* The user is logged in :) */
		    return "redirect:/home";
		}
		return "login";
    }
	
	@GetMapping("/register")
    public String register(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = new User();
		model.addAttribute("user", user);
		if (!(auth instanceof AnonymousAuthenticationToken)) {
		    /* The user is logged in :) */
		    return "redirect:/home";
		}
		return "register";
    }
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") @Valid User saveUser, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "register";
		}

		User user = userService.findByUsername(saveUser.getUsername()).orElse(null);
		if(user != null) {
			model.addAttribute("error", "exist_username");
			return "register";
		}
		
		user = userService.findByEmail(saveUser.getEmail()).orElse(null);
		if(user != null) {
			model.addAttribute("error", "exist_email");
			return "register";
		}

		userService.addUser(saveUser);
		
		return "redirect:/login";
	}
	
	
	@GetMapping("/access-denied")
    public String accessDenied() {
		return "error/403";
    }
	

}
