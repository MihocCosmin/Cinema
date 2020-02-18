package ClaseProiect;

import java.util.ArrayList;
import java.util.List;


public class Loc {
	
	private Integer id;
	private Integer rand;
	private Integer numar;
	private List<Sala> sala = new ArrayList<Sala>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRand() {
		return rand;
	}
	public void setRand(Integer rand) {
		this.rand = rand;
	}
	public Integer getNumar() {
		return numar;
	}
	public void setNumar(Integer numar) {
		this.numar = numar;
	}
	public List<Sala> getSala() {
		return sala;
	}
	public void setSala(List<Sala> sala) {
		this.sala = sala;
	}
	
	public Loc(Integer id, Integer rand, Integer numar) {
		super();
		this.id = id;
		this.rand = rand;
		this.numar = numar;
	}
	public Loc() {
		super();
	}
	
	public void adaugaSala (Sala sala){
		this.sala.add(sala);
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
		Loc other = (Loc) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Loc [id=" + id + ", rand=" + rand + ", numar=" + numar
				+ ", sala=" + sala + "]";
	}
	

}
