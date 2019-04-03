package it.objectmethod.sakila.sakila.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="film")
public class Film {

	@Id
	@Column(name="film_id")
	private Long id;

	@Column(name="title")
	private String titolo;

	@Column(name="description")
	private String descrizione;

	@Column(name="replacement_cost")
	private Float prezzo;
	
	@Column(name="rating")
	private String rating;

	@Column(name="release_year")
	private int annoDiUscita;
	
	@ManyToMany
	@JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id")
	, inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private List<Actor> attori;

	
	@JsonIgnore
	@ManyToOne
	@JoinTable(name = "film_category", joinColumns = @JoinColumn(name = "film_id")
	, inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Category categoria;

	

	public int getAnnoDiUscita() {
		return annoDiUscita;
	}

	public void setAnnoDiUscita(int annoDiUscita) {
		this.annoDiUscita = annoDiUscita;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Actor> getAttori() {
		return attori;
	}

	public void setAttori(List<Actor> attori) {
		this.attori = attori;
	}

	public Category getCategoria() {
		return categoria;
	}

	public void setCategoria(Category categoria) {
		this.categoria = categoria;
	}


	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

}
