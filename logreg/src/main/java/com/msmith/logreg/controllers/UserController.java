package com.msmith.logreg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.msmith.logreg.models.Login;
import com.msmith.logreg.models.User;
import com.msmith.logreg.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String renderDashboard(Model model, HttpSession session) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new Login());
		return "Dashboard.jsp";
	}
	
	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, Model model, HttpSession session) {
		User registeredUser = userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new Login());
			return "Dashboard.jsp";
		}
		else {
			session.setAttribute("userId", registeredUser.getId());
			session.setAttribute("userName", registeredUser.getUserName());
			return "redirect:/home";
		}
	}
	
	@PostMapping("/login")
	public String processRegister(@Valid @ModelAttribute("newLogin") Login newLogin,
			BindingResult result, Model model, HttpSession session) {
		User loggedUser = userService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "Dashboard.jsp";
		}
		session.setAttribute("userId", loggedUser.getId());
		session.setAttribute("userName", loggedUser.getUserName());
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String renderHome(HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		return "Logged.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
