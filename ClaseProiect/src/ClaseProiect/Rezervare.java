package ClaseProiect;

import java.util.ArrayList;
import java.util.List;

public class Rezervare {
	
	private Integer id;
  	private List<Ecranizare> ecranizare = new ArrayList<Ecranizare>();
  	private List<TipRezervare> tip = new ArrayList<TipRezervare>();
  	private Boolean activ;
  	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Ecranizare> getEcranizare() {
		return ecranizare;
	}
	public void setEcranizare(List<Ecranizare> ecranizare) {
		this.ecranizare = ecranizare;
	}
	public List<TipRezervare> getTip() {
		return tip;
	}
	public void setTip(List<TipRezervare> tip) {
		this.tip = tip;
	}
	public Boolean getActiv() {
		return activ;
	}
	public void setActiv(Boolean activ) {
		this.activ = activ;
	}
	
	public Rezervare(Integer id, Boolean activ) {
		super();
		this.id = id;
		this.setActiv(activ);
	}
	public Rezervare() {
		super();
	}
	
	public void adaugaEcranizare (Ecranizare ecranizare){
		this.ecranizare.add(ecranizare);
	}
	public void adaugaTipRezervare (TipRezervare TipRezervare){
		this.tip.add(TipRezervare);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rezervare other = (Rezervare) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Rezervare [id=" + id + ", ecranizare=" + ecranizare + ", tip="
				+ tip + ", activ=" + getActiv() + "]";
	}
  	
}

