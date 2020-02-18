package org.cinema.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.app.cinema.Loc;
import org.app.cinema.Sala;

public class FormSali{
	
	private List<Sala> sali = new ArrayList<Sala>();
	private Sala sala;
	private List<Loc> locuri = new ArrayList<Loc>();
	private Loc loc;
	
	public List<Sala> getSaliList(){
		return sali;
	}
	public Map<String, Sala> getSali(){
		Map<String, Sala> saliMap = new HashMap<String, Sala>();
		for (Sala s: this.sali)
			saliMap.put(s.getId().toString(), s);
		return saliMap;
	}
	public Sala getSala(){
		return sala;
	}
	public void setSala(Sala sala){
		this.sala = sala;
	}
	public List<Loc> getLocuriList(){
		return locuri;
	}
	public Map<String, Loc> getLocuri(){
		Map<String, Loc> locuriMap = new HashMap<String, Loc>();
		for (Loc l: this.locuri)
			locuriMap.put(l.getId().toString(), l);
		return locuriMap;
	}
	public Loc getLoc() {
		return loc;
	}
	public void setLoc(Loc loc) {
		this.loc = loc;
	}

	private EntityManager em;
	public FormSali(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CinemaJPA");
		em = emf.createEntityManager();
		
		this.sali = em.createQuery("SELECT o FROM Sala o").getResultList();
		if (!this.sali.isEmpty()){
			this.sala = this.sali.get(0);
		}
		
		this.locuri = em.createQuery("SELECT o FROM Loc o").getResultList();
		if (!this.locuri.isEmpty()){
			this.loc = this.locuri.get(0);
		}
	}
	
	public void prevSala (ActionEvent evt){
		Integer idxCurent = this.sali.indexOf(this.sala);
		if (idxCurent > 0)
			this.sala = this.sali.get(idxCurent -1);
	}
	
	public void nextSala (ActionEvent evt){
		Integer idxCurent = this.sali.indexOf(this.sala);
		if ((idxCurent +1) < this.sali.size())
			this.sala = this.sali.get(idxCurent +1);
	}

	
	public void adaugareSala (ActionEvent evt){
		Sala salaNoua = new Sala(999, 0);
		this.sali.add(salaNoua);
		this.sala = salaNoua;
	}
	
	public void stergereSala (ActionEvent evt){
		if (this.em.contains(this.sala)){
			this.em.getTransaction().begin();
			this.em.remove(this.sala);
			this.em.getTransaction().commit();
			this.sali.remove(this.sala);
		}
		if (this.sali.size() > 0)
			this.sala = this.sali.get(0);
		else
			this.sala = null;
	}
	
	public void salvareSala (ActionEvent evt){
		this.em.getTransaction().begin();
		this.em.persist(this.sala);
		this.em.getTransaction().commit();
	}
	
	public void abandon(ActionEvent evt){
		if (this.em.contains(this.sala)){
			this.em.getTransaction().begin();
			this.em.refresh(this.sala);
			this.em.getTransaction().commit();
		}
		else{
			if (this.sali.size() > 0)
				this.sala = this.sali.get(0);
		}

	}
	
	public void adaugaLoc (ActionEvent evt){
		Loc locNou = new Loc(9999, 0, 0, this.sali.get(0));
		this.sala.getLocuri().add(locNou);
		locNou.setSala(this.sala);
	}
	public void stergeLoc (ActionEvent evt){
		Integer selectedId = Integer.valueOf(evt.getComponent().getAttributes().get("selectedId").toString());
		Loc locSablon = new Loc();
		locSablon.setId(selectedId);
		this.sala.getLocuri().remove(locSablon);
	}

}
