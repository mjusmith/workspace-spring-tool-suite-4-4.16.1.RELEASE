package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/daikichi") // @PostMapping , @PutMapping , @DeleteMapping
	public String welcome() {
		return "Welcome!";
	}
	
	@GetMapping("/daikichi/today") // @PostMapping , @PutMapping , @DeleteMapping
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@GetMapping("/daikichi/tomorrow") // @PostMapping , @PutMapping , @DeleteMapping
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
}
