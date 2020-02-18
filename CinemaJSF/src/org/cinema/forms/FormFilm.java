package org.cinema.forms;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.app.cinema.Film;

public class FormFilm{

	private Film film;
	private List<Film> filme = new ArrayList<Film>();
	private EntityManager em;
	
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public List<Film> getFilme() {
		return this.filme;
	}
	public void setFilme(List<Film> filme) {
		this.filme = filme;
	}
	
	public FormFilm(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CinemaJPA");
		em = emf.createEntityManager();
		this.filme = em.createQuery("SELECT f FROM Film f").getResultList();
		if (!this.filme.isEmpty())
			film = this.filme.get(0); 
	}
	
	//Butoane Navigare
	
	public void prevFilm (ActionEvent evt){
		Integer idxCurent = this.filme.indexOf(film);
		if (idxCurent > 0)
			this.film = this.filme.get(idxCurent -1);
	}
	
	public void nextFilm (ActionEvent evt){
		Integer idxCurent = this.filme.indexOf(film);
		if ((idxCurent+1) < this.filme.size())
			this.film = this.filme.get(idxCurent +1);
	}
	
	
	//Butoane CRUD
	
	public void adaugaFilm (ActionEvent evt){
		this.film = new Film();
		this.film.setId(999);
		this.film.setTitlu("Film Nou");
		this.film.setDescriere("Film Nou");
		this.film.setDurata(0);
		this.filme.add(this.film);
	}
	
	public void stergereFilm (ActionEvent evt){
		this.filme.remove(this.film);
		if (this.em.contains(this.film)){
			this.em.getTransaction().begin();
			this.em.remove(this.film);
			this.em.getTransaction().commit();
		}
		if (!this.filme.isEmpty())
			this.film = this.filme.get(0);
		else
			this.film = null;
	}
	
	public void salvareFilm (ActionEvent evt){
		this.em.getTransaction().begin();
		this.em.persist(this.film);
		this.em.getTransaction().commit();
	}
	
	public void abandonFilm (ActionEvent evt){
		if (this.em.contains(this.film))
			this.em.refresh(this.film);
	}
	
	//lista selectie
	
	public Integer getIdFilm(){
		return this.film.getId();
	}
	
	public void setIdFilm(Integer id){
		Integer idx = this.filme.indexOf(new Film(id, "", "", null));
		this.film = this.filme.get(idx);
	}
}
