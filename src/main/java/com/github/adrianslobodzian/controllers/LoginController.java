package com.github.adrianslobodzian.controllers;

import javax.servlet.http.HttpSession;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.adrianslobodzian.entities.User;
import com.github.adrianslobodzian.repositories.UserRepository;



@Controller
public class LoginController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/login")
	public String Login() {
		return "login";
	}

	@PostMapping("/login")
	public String Login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
		User user = userRepository.findFirstByEmail(email);
		if (user != null && BCrypt.checkpw(password, user.getPassword())) {
				System.out.println("it matches");
			session.setAttribute("loggedUser", user);
		} else {

			System.out.println("nie pasuje");
			model.addAttribute("infoLog", "błędny login lub hasło");
			session.setAttribute("loggedUser", null);
			return "login";
		}
		return "redirect:/home";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("loggedUser", null);
		return "redirect:/home";
	}
}
