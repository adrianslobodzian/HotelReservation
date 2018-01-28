package com.github.adrianslobodzian.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.adrianslobodzian.entities.Room;
import com.github.adrianslobodzian.repositories.RoomRepository;

@RequestMapping("/room")
@Controller
public class RoomController {

	@Autowired
	RoomRepository roomRepository;
	
	@GetMapping("/add")
	public String roomAdd(Model model) {
		model.addAttribute("room", new Room());
		return"roomForm";
	}
	@PostMapping("/add")
	public String roomAdd(@ModelAttribute Room room) {
		roomRepository.save(room);
		return"redirect:all";
	}
	@GetMapping("/all")
	public String roomAll(Model model) {
		model.addAttribute("rooms", roomRepository.findAll());
		return"roomAll";
	}
			
}
