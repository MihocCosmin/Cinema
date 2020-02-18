package ClaseProiect;

import java.util.ArrayList;
import java.util.List;

public class RezervareFizica extends Rezervare {
	
	protected String nume;
	protected List<Angajat> angajat = new ArrayList<Angajat>();
	protected Integer varsta;
	protected Double pret;
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public List<Angajat> getAngajat() {
		return angajat;
	}
	public void setAngajat(List<Angajat> angajat) {
		this.angajat = angajat;
	}
	public Integer getVarsta() {
		return varsta;
	}
	public void setVarsta(Integer varsta) {
		this.varsta = varsta;
	}
	public Double getPret() {
		return pret;
	}
	public void setPret(Double pret) {
        this.pret = pret;
	}
	
	public RezervareFizica(Integer id, Boolean activ, String nume, Integer varsta) {
		super(id, activ);
		this.nume = nume;
		this.varsta = varsta;
	}
	public RezervareFizica() {
		super();
	}
	
	public void adaugaAngajat(Angajat angajat){
		this.angajat.add(angajat);
	}
	public Double getValoarePret(){
		if (varsta < 18)
			return 16.00;
		else if (varsta >= 18)
			return 20.00;
		return getValoarePret();
	}
	@Override
	public String toString() {
		return "RezervareFizica [id=" + getId() + ", ecranizare=" + getEcranizare() + ", tip="
				+ getTip() + ", activ=" + getActiv() + "nume=" + nume + ", angajat=" + angajat
				+ ", varsta=" + varsta + ", pret=" + getValoarePret() + "]";
	}
	
	

}
