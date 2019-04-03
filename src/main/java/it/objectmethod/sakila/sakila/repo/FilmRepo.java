package it.objectmethod.sakila.sakila.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.objectmethod.sakila.sakila.entity.Film;
@Repository
public interface FilmRepo extends JpaRepository<Film, Long> {

	@Query(value="select distinct rating from Film")
	public List<String> findRatings();
	
	@Query(value="select f from Film f "
			+ "where f.titolo like :titolo"
			+ " and (f.categoria.nome=:category or :category='NO')"
			+ " and (f.prezzo<:prezzoMaggiore or :prezzoMaggiore=0)"
			+ " and (f.prezzo>:prezzoMinore or :prezzoMinore=0)"
			+ " and (f.rating=:rating or :rating='NO')")
	public List<Film> findFilm(@Param("titolo") String titolo, @Param("category") String cateogry,
			@Param("prezzoMaggiore") Float prezzoMaggiore, @Param("prezzoMinore") Float prezzoMinore, @Param("rating") String rating);
	
	@Query(value="select f"
			   + " from Film f"
			   + " join f.attori a"
			   + " where a.id = ?1")
			 public List<Film> getFilmByActorId(long actorId);
}
