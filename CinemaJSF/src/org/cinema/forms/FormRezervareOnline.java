package org.cinema.forms;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.app.cinema.Ecranizare;
import org.app.cinema.RezervareOnline;
import org.app.cinema.TipRezervare;

public class FormRezervareOnline {

	private RezervareOnline rezervareOnline;
	private List<RezervareOnline> rezervariOnline = new ArrayList<RezervareOnline>();
	
	public RezervareOnline getRezervareOnline() {
		return rezervareOnline;
	}
	public void setRezervareOnline(RezervareOnline rezervareOnline) {
		this.rezervareOnline = rezervareOnline;
	}
	public List<RezervareOnline> getRezervariOnline() {
		return rezervariOnline;
	}
	public void setRezervariOnline(List<RezervareOnline> rezervariOnline) {
		this.rezervariOnline = rezervariOnline;
	}
	
	private EntityManager em;
	public FormRezervareOnline() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CinemaJPA");
		em = emf.createEntityManager();
		this.rezervariOnline = em.createQuery("SELECT o FROM RezervareOnline o").getResultList();
		if (!this.rezervariOnline.isEmpty())
			rezervareOnline = this.rezervariOnline.get(0);
	}
	
	public void prev (ActionEvent evt){
		Integer idxCurent = this.rezervariOnline.indexOf(rezervareOnline);
		if (idxCurent -1 >= 0)
			this.rezervareOnline = this.rezervariOnline.get(idxCurent -1);
	}
	public void next (ActionEvent evt) {
		Integer idxCurent = this.rezervariOnline.indexOf(rezervareOnline);
		if (idxCurent +1 < this.rezervariOnline.size())
			this.rezervareOnline = this.rezervariOnline.get(idxCurent +1);
	}
	
	public void adaugaRo (ActionEvent evt) {
		this.rezervareOnline = new RezervareOnline();
		this.rezervareOnline.setId(999);
		this.rezervareOnline.setTip(new TipRezervare());
		this.rezervareOnline.setNume("Rezervare noua");
		this.rezervareOnline.setEcranizare(new Ecranizare());
		this.rezervareOnline.setPret(0.0);	
	}
	
	public void stergereRo (ActionEvent evt){
		this.rezervariOnline.remove(this.rezervareOnline);
		if (this.em.contains(this.rezervareOnline)){
		this.em.getTransaction().begin();
		this.em.remove(this.rezervareOnline);
		this.em.getTransaction().commit();
	}
		if (!this.rezervariOnline.isEmpty())
			this.rezervareOnline = this.rezervariOnline.get(0);
		else
			this.rezervareOnline = null;
	}
	
	public void salvareRo(ActionEvent evt){
		this.em.getTransaction().begin();
		this.em.persist(this.rezervareOnline);
		this.em.getTransaction().commit();
	}
	
	public void abandonRo (ActionEvent evt){
		if (this.em.contains(this.rezervareOnline))
			this.em.refresh(this.rezervareOnline);
	}
	
}
