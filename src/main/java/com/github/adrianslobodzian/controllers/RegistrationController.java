package com.github.adrianslobodzian.controllers;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.adrianslobodzian.entities.User;
import com.github.adrianslobodzian.repositories.UserRepository;



@Controller
public class RegistrationController {

	@Autowired
	UserRepository userRepository;
	

	@GetMapping("/register")
	public String register(Model model) {

		model.addAttribute("user", new User());

		return "userForm";
	}
	
	@PostMapping("/register")
	public String register(@Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "userForm";
		}
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		userRepository.save(user);
		
		return"redirect:/login";
	}
}