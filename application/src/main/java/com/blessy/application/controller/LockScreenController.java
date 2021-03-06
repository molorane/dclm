package com.blessy.application.controller;

import com.blessy.application.model.CustomUserDetails;
import com.blessy.application.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LockScreenController {
	
	
	@RequestMapping("/lockscreen")
	public ModelAndView lockScreen(Authentication authentication) {
		
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		User user = userDetails.getUser();
		
		ModelAndView modelAndView = new ModelAndView("lock-screen");
		modelAndView.addObject("user", user);
		
		return modelAndView;
	}

}
