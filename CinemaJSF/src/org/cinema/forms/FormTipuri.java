package org.cinema.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.app.cinema.Loc;
import org.app.cinema.Rezervare;
import org.app.cinema.TipRezervare;

public class FormTipuri {
	
	private List<TipRezervare> tipuriRezervare = new ArrayList<TipRezervare>();
	private TipRezervare tip;
	
	private List<Rezervare> rezervari = new ArrayList<Rezervare>();
	private Rezervare rezervare;
	
	public List<TipRezervare> getTipRezervareList(){
		return tipuriRezervare;
	}
	public Map<String, TipRezervare> getTipuriRezervari(){
		Map<String, TipRezervare> tipuriRezervareMap = new HashMap<String, TipRezervare>();
		for (TipRezervare tr: this.tipuriRezervare)
			tipuriRezervareMap.put(tr.getId().toString(), tr);
		return tipuriRezervareMap;
	}
	public TipRezervare getTip() {
		return tip;
	}
	public void setTip(TipRezervare tip) {
		this.tip = tip;
	}
	
	public Rezervare getRezervare() {
		return rezervare;
	}
	public void setRezervare(Rezervare rezervare) {
		this.rezervare = rezervare;
	}


	private EntityManager em;
	public FormTipuri (){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CinemaJPA");
		em = emf.createEntityManager();
		
		this.tipuriRezervare = em.createQuery("SELECT o FROM TipRezervare o").getResultList();
		if(!this.tipuriRezervare.isEmpty())
			this.tip = this.tipuriRezervare.get(0);
	}
	
	public void prev (ActionEvent evt){
		Integer idxCurent = this.tipuriRezervare.indexOf(this.tip);
		if (idxCurent -1 >= 0)
			this.tip = this.tipuriRezervare.get(idxCurent -1);
	}
	public void next (ActionEvent evt){
		Integer idxCurent = this.tipuriRezervare.indexOf(this.tip);
		if ((idxCurent +1) < this.tipuriRezervare.size())
			this.tip = this.tipuriRezervare.get(idxCurent + 1);
	}
	
	public void adaugare (ActionEvent evt){
		TipRezervare tipNou = new TipRezervare(0, "");
		this.tipuriRezervare.add(tipNou);
		this.tip = tipNou;
	}
	
	public void stergere (ActionEvent evt){
		if (this.em.contains(this.tip)){
			this.em.getTransaction().begin();
			this.em.remove(this.tip);
			this.em.getTransaction().commit();
			this.tipuriRezervare.remove(this.tip);
		}
		if (this.tipuriRezervare.size() > 0)
			this.tip = this.tipuriRezervare.get(0);
		else
			this.tip = null;
	}
	
	public void salvare (ActionEvent evt){
		this.em.getTransaction().begin();
		this.em.persist(this.tip);
		this.em.getTransaction().commit();
	}
	
	public void abandon(ActionEvent evt){
		if (this.em.contains(this.tip)){
			this.em.getTransaction().begin();
			this.em.refresh(this.tip);
			this.em.getTransaction().commit();
		}
		else{
			if (this.tipuriRezervare.size() > 0)
				this.tip = this.tipuriRezervare.get(0);
		}
	}
	
	public void adaugaR (ActionEvent evt){
		Rezervare rezervareNoua = new Rezervare();
		this.tip.getRezervari().add(rezervareNoua);
		rezervareNoua.setTip(this.tip);
	}
	public void stergeR (ActionEvent evt){
		Integer selectedId = Integer.valueOf(evt.getComponent().getAttributes().get("selectedId").toString());
		Rezervare rezervareSablon = new Rezervare();
		rezervareSablon.setId(selectedId);
	    this.tip.getRezervari().remove(rezervareSablon);
	}
	
}


