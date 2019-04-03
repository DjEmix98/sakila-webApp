package it.objectmethod.sakila.sakila.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.sakila.sakila.entity.Actor;
import it.objectmethod.sakila.sakila.repo.ActorRepo;


@RestController
@RequestMapping("api/attori")
public class ActorControllerRest {

	@Autowired
	private ActorRepo attoriRepo;
	
	@PostMapping("/{id}/by-id")
	public Actor findById(@PathVariable("id") Long id) {
		
		return attoriRepo.getOne(id);
	} 
}
