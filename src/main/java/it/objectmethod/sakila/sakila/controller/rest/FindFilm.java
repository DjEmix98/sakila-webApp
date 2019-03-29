package it.objectmethod.sakila.sakila.controller.rest;

public class FindFilm {

	private String titolo;
	private String category;
	private String rating;
	private Float prezzoMaggiore;
	private Float prezzoMinore;
	

	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Float getPrezzoMaggiore() {
		return prezzoMaggiore;
	}
	public void setPrezzoMaggiore(Float prezzoMaggiore) {
		this.prezzoMaggiore = prezzoMaggiore;
	}
	public Float getPrezzoMinore() {
		return prezzoMinore;
	}
	public void setPrezzoMinore(Float prezzoMinore) {
		this.prezzoMinore = prezzoMinore;
	}
	
}
