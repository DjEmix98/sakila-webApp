package it.objectmethod.sakila.sakila.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.sakila.sakila.entity.Actor;
import it.objectmethod.sakila.sakila.entity.Film;
import it.objectmethod.sakila.sakila.repo.FilmRepo;

@RestController
@RequestMapping("api/film")
public class FilmRestController {

	@Autowired
	private FilmRepo filmRepo;
	
	@GetMapping("/list-all")
	public List<String> getAllRating(){
		
		return filmRepo.findRatings();
	}
	
	@PostMapping("/search")
	public List<Film> findFilm(@RequestBody FindFilm film){
		
		film.setFilmCategory(film.getFilmCategory() == null? "NO":film.getFilmCategory());
		film.setRating(film.getRating()==null?"NO":film.getRating());
		film.setTitolo("%"+film.getTitolo()==null?"":film.getTitolo()+"%");
		return filmRepo.findFilm(film.getTitolo(), film.getFilmCategory(), film.getPrezzoMaggiore(), film.getPrezzoMinore(), film.getRating());
		
	}
	
	@PostMapping("/{id}/by-id")
	public Film findFilmById(@PathVariable("id") Long id) {

		return filmRepo.getOne(id);
	}
	
	@PostMapping("/{idActor}/by-actor")
	public List<Film> findFilmByActor(@PathVariable("idActor") Long id){
		
		return filmRepo.getFilmByActorId(id);
	}
}
