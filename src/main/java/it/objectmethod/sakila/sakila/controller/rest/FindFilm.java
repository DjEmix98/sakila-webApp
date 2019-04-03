package it.objectmethod.sakila.sakila.controller.rest;

public class FindFilm {

	private String titolo;
	private String rating;
	private String filmCategory;
	private float prezzoMaggiore;
	private float prezzoMinore;
	

	
	
	public String getFilmCategory() {
		return filmCategory;
	}
	public void setFilmCategory(String filmCategory) {
		this.filmCategory = filmCategory;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public float getPrezzoMaggiore() {
		return prezzoMaggiore;
	}
	public void setPrezzoMaggiore(float prezzoMaggiore) {
		this.prezzoMaggiore = prezzoMaggiore;
	}
	public float getPrezzoMinore() {
		return prezzoMinore;
	}
	public void setPrezzoMinore(float prezzoMinore) {
		this.prezzoMinore = prezzoMinore;
	}

	
}
