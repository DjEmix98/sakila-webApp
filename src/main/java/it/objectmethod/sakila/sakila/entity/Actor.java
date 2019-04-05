package it.objectmethod.sakila.sakila.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opencsv.bean.CsvBindByName;


@Entity
@Table(name="actor")
public class Actor {

	@Id
	@Column(name="actor_id")
	private Long id;
	
	@CsvBindByName(column = "Nome")
	@Column(name="first_name")
	private String nome;
	@CsvBindByName(column = "Cognome")
	@Column(name="last_name")
	private String cognome;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "actor_id")
	, inverseJoinColumns = @JoinColumn(name = "film_id"))
	private List<Film> film;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<Film> getFilm() {
		return film;
	}

	public void setFilm(List<Film> film) {
		this.film = film;
	}
	
}
