package ClaseProiect;

public class Sala {
	
	private Integer id;
    private Integer nrLocuri;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNrLocuri() {
		return nrLocuri;
	}
	public void setNrLocuri(Integer nrLocuri) {
		this.nrLocuri = nrLocuri;
	}
	
	public Sala(Integer id, Integer nrLocuri) {
		super();
		this.id = id;
		this.nrLocuri = nrLocuri;
	}
	public Sala() {
		super();
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
		Sala other = (Sala) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sala [id=" + id + ", nrLocuri=" + nrLocuri + "]";
	}
	

    
}
