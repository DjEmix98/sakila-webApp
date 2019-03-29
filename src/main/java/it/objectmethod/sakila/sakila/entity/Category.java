package it.objectmethod.sakila.sakila.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="category")
public class Category {


	@Id
	@Column(name="category_id")
	private Long id;
	
	@Column(name="name")
	private String nome;
	

	@JoinTable(name = "film_category", joinColumns = @JoinColumn(name = "category_id")
	, inverseJoinColumns = @JoinColumn(name = "film_id"))
	@OneToMany(fetch=FetchType.EAGER)
	List<Film> filmPerCategoria;

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

	public List<Film> getFilmPerCategoria() {
		return filmPerCategoria;
	}

	public void setFilmPerCategoria(List<Film> filmPerCategoria) {
		this.filmPerCategoria = filmPerCategoria;
	}
	
}
