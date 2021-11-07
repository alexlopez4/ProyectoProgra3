package objetos;

public class Liga {
	
	private int idLiga;
	private String nombreLiga;
	private String pais;
	
	public Liga(int idLiga, String nombreLiga, String pais) {
		super();
		this.idLiga = idLiga;
		this.nombreLiga = nombreLiga;
		this.pais = pais;
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
		return nombreLiga;
	}
	
	
	
	
}
