package it.objectmethod.sakila.sakila.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.sakila.sakila.entity.Actor;

@Repository
public interface ActorRepo  extends JpaRepository<Actor, Long>{

	public List<Actor>findByFilmId(Long idFilm);
	
}
