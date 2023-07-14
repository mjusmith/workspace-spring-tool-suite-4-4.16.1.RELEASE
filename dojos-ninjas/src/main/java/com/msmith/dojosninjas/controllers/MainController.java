package com.msmith.dojosninjas.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.msmith.dojosninjas.models.Dojo;
import com.msmith.dojosninjas.models.Ninja;
import com.msmith.dojosninjas.services.DojoServices;
import com.msmith.dojosninjas.services.NinjaServices;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	private DojoServices dojoService;
	
	@Autowired
	private NinjaServices ninjaService;
	
	//create dojo
	//render
	@GetMapping("/dojo/new")
	public String renderDojoCreate(@ModelAttribute("newDojo") Dojo newDojo) {
		return "newDojo.jsp";
	}
	//process
	@PostMapping("/dojo/new")
	public String processDojoCreate(@Valid @ModelAttribute("newDojo") Dojo newDojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		else {
			dojoService.createDojo(newDojo);
			return "redirect:/";
		}
	}
	
	//create ninja
	//render
	@GetMapping("/ninja/new")
	public String renderNinjaCreate(Model model) {
		model.addAttribute("newNinja", new Ninja());
		
		//selecting dojo (obsolete post log-reg)
		model.addAttribute("dojoList", dojoService.allDojos());
		
		return "newNinja.jsp";
	}
	//process
	@PostMapping("/ninja/new")
	public String processNinjaCreate(@Valid @ModelAttribute("newNinja") Ninja newNinja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojoList", dojoService.allDojos()); //this lets the dojo list load upon errors
			return "newNinja.jsp";
		}
		else {
			ninjaService.createNinja(newNinja);
			return "redirect:/";
		}
	}
	
	@GetMapping("/dojo/{id}")
	public String viewOneDojo(@PathVariable("id")Long id, Model model) {
		model.addAttribute("dojo", dojoService.oneDojo(id));
		model.addAttribute("ninjaList", ninjaService.allNinjas());
		return "allNinjasOneDojo.jsp";
	}
}
