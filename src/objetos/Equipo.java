package objetos;

public class Equipo {

	private Liga liga;
	private int idEquipo;
	private String nombreEquipo;
	private String estadio;
	
	
	public Equipo(Liga liga, int idEquipo, String nombreEquipo, String estadio) {
		super();
		this.liga = liga;
		this.idEquipo = idEquipo;
		this.nombreEquipo = nombreEquipo;
		this.estadio = estadio;
	}
	public Liga getLiga() {
		return liga;
	}
	public void setLiga(Liga liga) {
		this.liga = liga;
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	@Override
	public String toString() {
		return nombreEquipo;
	}
	
	
}
