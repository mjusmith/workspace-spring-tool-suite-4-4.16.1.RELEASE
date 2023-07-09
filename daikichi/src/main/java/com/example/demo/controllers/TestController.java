package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/daikichi/travel/{destination}") // @PostMapping , @PutMapping , @DeleteMapping
	public String travel(@PathVariable("destination") String destination) {
		return "Congratulations! You will soon travel to " + destination + "!";
	}
	
	@GetMapping("/daikichi/lotto/{number}") // @PostMapping , @PutMapping , @DeleteMapping
	public String lotto(@PathVariable("number") Integer number) {
		if(number % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		}
		else return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
	}
}
