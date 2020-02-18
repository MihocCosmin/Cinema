package ClaseProiect;

public class RezervareOnline extends Rezervare {
	
	protected String nume;
	protected Double pret;
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public Double getPret() {
		return pret;
	}
	public void setPret(Double pret) {
		this.pret = pret;
	}
	
	public RezervareOnline(Integer id, Boolean activ, String nume, Double pret) {
		super(id, activ);
		this.nume = nume;
		this.pret = pret;
	}
	public RezervareOnline(){
		super();
	}
	@Override
	public String toString() {
		return "RezervareOnline [id=" + getId() + ", ecranizare=" + getEcranizare() + ", tip="
				+ getTip() + ", activ=" + getActiv() + ", nume=" + nume + ", pret=" + pret + "]";
	}
	
	

}
