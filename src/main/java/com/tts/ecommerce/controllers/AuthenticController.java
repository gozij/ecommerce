package com.tts.ecommerce.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.catalina.User;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import com.tts.ecommerce.services.UserService;

@Controller
public class AuthenticController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/signin")
	public String login() {
		return "signin";
	}
		
	@PostMapping("/signin")
	public String signup(@Valid User user,
			@RequestParam String submit, 
			BindingResult bindingResult,
			HttpServletRequest request) throws ServiceException {
		String password = user.getPassword();
		if(submit.equals("up")) {
			if(userService.findByUsername(user.getUsername()) == null) {
				userService.saveNew(user);
			}else {
				bindingResult.rejectValue("username", "error.user", "Username is already taken.");
			
			}
		}        return "signin";
		
		
	
		
	request.login(user.getUsername(), password);
	System.out.println(user);
	return "redirect";
	
	
}
	

}
