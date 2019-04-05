package it.objectmethod.sakila.sakila.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.objectmethod.sakila.sakila.repo.ActorRepo;

@Controller
public class HomeController {

	@Autowired
	private ActorRepo attoriRepo;
	
	@RequestMapping("/home")
	public String home() {
		
		return "home";
	}
	
}
