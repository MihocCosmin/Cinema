package ClaseProiect;

import java.util.ArrayList;
import java.util.List;

public class Ecranizare {
	
	private Integer id;
	private List<Film> film = new ArrayList<Film>();
	private List<Sala> sala = new ArrayList<Sala>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Film> getFilm() {
		return film;
	}
	public void setFilm(List<Film> film) {
		this.film = film;
	}
	public List<Sala> getSala() {
		return sala;
	}
	public void setSala(List<Sala> sala) {
		this.sala = sala;
	}
	
	public Ecranizare(Integer id) {
		super();
		this.id = id;
	}
	public Ecranizare() {
		super();
	}
	
	public void adaugaFilm (Film film){
		this.film.add(film);
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
		Ecranizare other = (Ecranizare) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ecranizare [id=" + id + ", film=" + film + ", sala=" + sala
				+ "]";
	}
	

	
}
