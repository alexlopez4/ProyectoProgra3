package objetos;

public class SalaDebate {
	private Usuario usuario;
	private Liga liga;
	private int idSalaDebate;
	private String temaDebate;
	private String texto;
	
	public SalaDebate(Usuario usuario, Liga liga, int idSalaDebate, String temaDebate, String texto) {
		super();
		this.usuario = usuario;
		this.liga = liga;
		this.idSalaDebate = idSalaDebate;
		this.temaDebate = temaDebate;
		this.texto = texto;
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

	public void setTemaDebate(String temaDebate) {
		this.temaDebate = temaDebate;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "SalaDebate [usuario=" + usuario + ", liga=" + liga + ", IdSalaDebate=" + idSalaDebate + ", temaDebate="
				+ temaDebate + ", texto=" + texto + "]";
	}
	
	
	

}
