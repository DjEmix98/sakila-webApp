package it.objectmethod.sakila.sakila.controller.rest;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.sakila.sakila.entity.Actor;
import it.objectmethod.sakila.sakila.file.ByteWrite;
import it.objectmethod.sakila.sakila.repo.ActorRepo;


@RestController
@RequestMapping("api/attori")
public class ActorControllerRest {

	@Autowired
	private ActorRepo attoriRepo;
	@Autowired
	private ByteWrite atorSerializer;

	@PostMapping("/{id}/by-id")
	public Actor findById(@PathVariable("id") Long id) {

		return attoriRepo.getOne(id);
	} 

	@GetMapping("/{idFilm}/attori-csv")
	public OutputStream attoriFileCsv(@PathVariable("idFilm") Long idFilm, HttpServletResponse response) throws Exception{

		OutputStream os = response.getOutputStream();
		byte[] csvArray = atorSerializer.attoriToCSV(attoriRepo.findByFilmId(idFilm), os);
		List<Actor> attori = attoriRepo.findByFilmId(idFilm);
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "filename=Attori.csv");
		response.setContentLength(csvArray.length);
		for(Actor a: attori) {
			String attore = a.getNome()+";"+a.getCognome()+";";
			os.write(attore.getBytes());
		}
//		os.write(csvArray, 0, csvArray.length);
		
		return os;

	}




}
