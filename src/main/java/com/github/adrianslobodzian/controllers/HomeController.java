package com.github.adrianslobodzian.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.adrianslobodzian.entities.User;



@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("")
	public String home(HttpSession sess, Model model) {
	if(sess.getAttribute("loggedUser") != null) {
		User user = (User)sess.getAttribute("loggedUser");
		model.addAttribute("infoLoged", "jestes zalogowany jako "+ user.getEmail());
	}
		return "index";
	}
	@RequestMapping("test")
	public String test() {
		return "test";
	}
}
