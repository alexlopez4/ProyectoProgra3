package objetos;

public class Liga {
	
	private Temporada temporada;
	private int idLiga;
	private String nombreLiga;
	private String pais;
	
	public Liga(Temporada temporada, int idLiga, String nombreLiga, String pais) {
		super();
		this.temporada = temporada;
		this.idLiga = idLiga;
		this.nombreLiga = nombreLiga;
		this.pais = pais;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	public int getIdLiga() {
		return idLiga;
	}

	public void setIdLiga(int idLiga) {
		this.idLiga = idLiga;
	}

	public String getNombreLiga() {
		return nombreLiga;
	}

	public void setNombreLiga(String nombreLiga) {
		this.nombreLiga = nombreLiga;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Liga [temporada=" + temporada + ", IdLiga=" + idLiga + ", nombreLiga=" + nombreLiga + ", pais=" + pais
				+ "]";
	}
	
	
	
	
}
