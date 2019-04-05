package it.objectmethod.sakila.sakila.controller.rest;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.internal.util.privilegedactions.NewSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVWriter;

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

/*	@GetMapping("/{idFilm}/attori-csv") //senza CSVWriter
	public void attoriFileCsv(@PathVariable("idFilm") Long idFilm, HttpServletResponse response) throws Exception{
		
		OutputStream os = response.getOutputStream();
		List<Actor> attori = attoriRepo.findByFilmId(idFilm);
		for(Actor a: attori) {
			String attore = a.getNome()+";"+a.getCognome()+";";
			os.write(attore.getBytes());
		}
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "filename=Attori.csv");
	}*/

	@GetMapping("/{idFilm}/attori-csv") //con CSVWriter
	public void actorFileCsv(@PathVariable("idFilm") Long idFilm, HttpServletResponse response) throws Exception{
	
		OutputStream os = response.getOutputStream();
		CSVWriter writer = new CSVWriter( new OutputStreamWriter(os), CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.NO_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
		List<Actor> listAttori = attoriRepo.findByFilmId(idFilm);
		for(Actor a: listAttori) {
			System.out.print(a.getNome());
			String[] myArray = {a.getNome()+";"+a.getCognome()+";"};
		    writer.writeNext(myArray);
		}
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "filename=Attori.csv");
		writer.close();
		 
		 
	}


}
