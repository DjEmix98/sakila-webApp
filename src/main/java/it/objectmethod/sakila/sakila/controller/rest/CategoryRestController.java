package it.objectmethod.sakila.sakila.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.sakila.sakila.entity.Category;
import it.objectmethod.sakila.sakila.repo.CategoryRepo;

@RestController
@RequestMapping("api/category")
public class CategoryRestController {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@GetMapping("/find-all")
	public List<Category> getAllCategory(){
		
		return categoryRepo.findAll();
	}
	
}