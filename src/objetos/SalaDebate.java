package objetos;

public class SalaDebate {
	private Usuario usuario;
	private Liga liga;
	private int idSalaDebate;
	private String temaDebate;
	
	public SalaDebate(Usuario usuario, Liga liga, int idSalaDebate, String temaDebate) {
		super();
		this.usuario = usuario;
		this.liga = liga;
		this.idSalaDebate = idSalaDebate;
		this.temaDebate=temaDebate;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	public int getIdSalaDebate() {
		return idSalaDebate;
	}

	public void setIdSalaDebate(int idSalaDebate) {
		this.idSalaDebate = idSalaDebate;
	}

	public String getTemaDebate() {
		return temaDebate;
	}

	public void setIdSalaDebate(String temaDebate) {
		this.temaDebate = temaDebate;
	}
	


	@Override
	public String toString() {
		return temaDebate;
	}

}
