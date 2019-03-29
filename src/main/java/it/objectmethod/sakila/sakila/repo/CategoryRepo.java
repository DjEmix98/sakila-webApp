package it.objectmethod.sakila.sakila.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.sakila.sakila.entity.Category;

@Repository
public interface CategoryRepo  extends JpaRepository<Category, Long> {

	
}
