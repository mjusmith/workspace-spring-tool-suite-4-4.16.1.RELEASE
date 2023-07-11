package com.msmith.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@GetMapping("/omikuji")
	public String form() {
		return "test.jsp";
	}
	
	@PostMapping("/omikuji")
	public String formSubmit(
			@RequestParam("number") Integer number,
			@RequestParam("city") String city,
			@RequestParam("person") String person,
			@RequestParam("hobby") String hobby,
			@RequestParam("thingLiving") String thingLiving,
			@RequestParam("niceComment") String niceComment,
			HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thingLiving", thingLiving);
		session.setAttribute("niceComment", niceComment);
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String formDisplay() {
		return "formDisplay.jsp";
	}
}
