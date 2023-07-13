package com.msmith.travels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.msmith.travels.models.Travel;
import com.msmith.travels.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private TravelService travelService;
	
	
	// findAll & processCreateMain display
	@GetMapping("/travel-dash")
	public String travelDashboard(Model model) {
		model.addAttribute("travelList", travelService.allCosts());
		model.addAttribute("newTravel", new Travel());
		return"dashboard.jsp";
	}
	// create form process for combined w/ findAll
	@PostMapping("/travel-dash")
	public String processCreateMain(@Valid @ModelAttribute("newTravel") Travel newTravel, BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("travelList", travelService.allCosts());
			return "dashboard.jsp";
		}
		else {
			travelService.createTravel(newTravel);
			return "redirect:/travel-dash";
		}
	}
	
	// read one render
	@GetMapping("/travel/{id}")
		public String renderOne(@PathVariable("id")Long id, Model model){
			model.addAttribute("oneTravel", travelService.oneTravel(id));
			return "showOneTravel.jsp";
		}
	
	// update render
	@GetMapping("/travel/{id}/edit")
		public String renderEdit(@PathVariable("id") Long id, Model model) {
			Travel travel = travelService.oneTravel(id);
			model.addAttribute("travel", travel);
			return "updateTravel.jsp";
		}
	
	// update process
	@PutMapping("/travel/{id}/edit")
	public String processEdit(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
		if(result.hasErrors()) {
			return "updateTravel.jsp";
		}
		else {
			travelService.updateTravel(travel);
			return "redirect:/travel-dash";
		}
	}
	
	@DeleteMapping("/travel/{id}")
	public String processDelete(@PathVariable("id")Long id) {
		travelService.deleteTravelById(id);
		return "redirect:/travel-dash";
	}
	
	// create
//	@PostMapping("/travel/create")
//	public String processCreate(@Valid @ModelAttribute("newTravel")
//			BindingResult result
//			)	{
//		if(result.hasErrors()) {
//			System.out.println(result.getAllErrors());
//			return "dashboard.jsp";
//		}
//		else {
//			travelService.createTravel(newTravel);
//			return "redirect:/travel-dash";
//		}
//	}
//	 findAll
//	@GetMapping("/travels")
//	public String getTravels(Model model) {
//		List<Travel> travelList = travelService.allCosts();
//		model.addAttribute("travelList", travelList);
//		return"dashboard.jsp";
//	}
	
}
