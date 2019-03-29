package it.objectmethod.sakila.sakila.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.sakila.sakila.entity.Film;
import it.objectmethod.sakila.sakila.repo.FilmRepo;

@RestController
@RequestMapping("api/film")
public class FilmRestController {

	@Autowired
	private FilmRepo filmRepo;
	
	@GetMapping("/find-all")
	public List<String> getAllRating(){
		
		return filmRepo.findRatings();
	}
	
	@PostMapping("/search")
	public List<Film> findFilm(@RequestBody FindFilm film){
		
		
	}
}
