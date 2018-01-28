package com.github.adrianslobodzian.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.adrianslobodzian.entities.Reservation;
import com.github.adrianslobodzian.entities.Room;
import com.github.adrianslobodzian.entities.User;
import com.github.adrianslobodzian.repositories.ReservationRepository;
import com.github.adrianslobodzian.repositories.RoomRepository;

@RequestMapping("/reservation")
@Controller
public class ReservationController {

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@GetMapping("/serch")
	public String reservationSerch(Model model) {
		model.addAttribute("reservation", new Reservation());
		return "reservationSerch";
	}

	@PostMapping("/serch")
	public String reservationSerch(@Valid Reservation reservation, BindingResult result, HttpSession sess, Model model) {
		LocalDate d1 = reservation.getStarts();
		LocalDate d2 = reservation.getEnds().minusDays(1);
		List<Room> reservedRooms = roomRepository.customFindByDateStartsEnds2(d1, d2);
		List<Room> rooms = roomRepository.findAll();
		rooms.removeAll(reservedRooms);
		if (result.hasErrors() || rooms.isEmpty()) {
			model.addAttribute("info", "Brak wolnych pokojów w wybranym terminie");
			return "reservationSerch";
		} else {
			sess.setAttribute("rooms", rooms);
			sess.setAttribute("reservation", reservation);
		}
		return "redirect:add";
	}
	

	@GetMapping("/add")
	public String reservationAdd(Model model, HttpSession sess) {
		List<Room> rooms = (List<Room>) sess.getAttribute("rooms");
		List<Room> result = new ArrayList<Room>();
		
		List<Integer> roomsGroupBy = roomRepository.customFindByRoomSizeGroupByRoomSize();
		for (int i = 0; i < roomsGroupBy.size(); i++) {
			for (int j = 0; j < rooms.size(); j++) {
				if (rooms.get(j).getRoomSize() == roomsGroupBy.get(i)) {
					result.add(rooms.get(j));
					break;
				}
			}
		}
		
		Reservation res = (Reservation) sess.getAttribute("reservation");
		model.addAttribute("reservation", res);
		model.addAttribute("serchRooms", result);
		return "reservationAdd";
	}

	@PostMapping("/add")
	public String reservationAdd(@ModelAttribute Reservation reservation, HttpSession sess, Model model) {
		if (sess.getAttribute("loggedUser") != null) {
		User user = (User) sess.getAttribute("loggedUser");
		reservation.setUser(user);
		LocalDate ends = reservation.getEnds().minusDays(1);
		reservation.setEnds(ends);
		reservationRepository.save(reservation);
		sess.removeAttribute("reservation");
		sess.removeAttribute("rooms");
		Room room = roomRepository.findOne(reservation.getRoom().getId());
		String info = "Super udało Ci się zarezerwować pokój " + room.getRoomSize() + "-osobowy w terminie: od "
				+ reservation.getStarts() + "do " + reservation.getEnds();
		sess.setAttribute("succes", info);

		}else {
			String notLoged = "Zaloguj się by dokonać rezerwacji";
			sess.setAttribute("notLoged", notLoged);
			return "redirect:/login";
		}
		return "redirect:/home";
	}

	@GetMapping("/all")
	public String rreservationAll(Model model) {
		model.addAttribute("reservations", reservationRepository.findAll());
		return "reservationAll";
	}

}
