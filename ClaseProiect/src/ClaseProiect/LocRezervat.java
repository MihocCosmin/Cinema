package ClaseProiect;

import java.util.ArrayList;
import java.util.List;

public class LocRezervat {
	
	private Integer id;
	private List<Loc> loc = new ArrayList<Loc>();
	private List<Rezervare> rezervare = new ArrayList<Rezervare>();
	private List<Ecranizare> ecranizare = new ArrayList<Ecranizare>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Loc> getLoc() {
		return loc;
	}
	public void setLoc(List<Loc> loc) {
		this.loc = loc;
	}
	public List<Rezervare> getRezervare() {
		return rezervare;
	}
	public void setRezervare(List<Rezervare> rezervare) {
		this.rezervare = rezervare;
	}
	public List<Ecranizare> getEcranizare() {
		return ecranizare;
	}
	public void setEcranizare(List<Ecranizare> ecranizare) {
		this.ecranizare = ecranizare;
	}
	
	public LocRezervat(Integer id) {
		super();
		this.id = id;
	}
	public LocRezervat() {
		super();
	}
	
	public void adaugaLoc (Loc loc){
		this.loc.add(loc);
	}
	public void adaugaRezervare(Rezervare rezervare){
		this.rezervare.add(rezervare);
	}
	public void adaugaEcranizare(Ecranizare ecranizare){
		this.ecranizare.add(ecranizare);
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
		LocRezervat other = (LocRezervat) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LocRezervat [id=" + id + ", loc=" + loc + ", rezervare="
				+ rezervare + ", ecranizare=" + ecranizare + "]";
	}

	
	
	
}
