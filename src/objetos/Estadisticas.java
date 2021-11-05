package objetos;

public class Estadisticas extends Jugador{

	private Temporada temporada;
	private int idEstadisticas;
	private int goles;
	private int asistencias;
	private int tarjetasAmarillas;
	private int tarjetasRojas;
	
	public Estadisticas(String nombre, int edad, Equipo equipo, int idJugador, int precioEnMillones, Temporada temporada, int idEstadisticas,
			int goles, int asistencias, int tarjetasAmarillas, int tarjetasRojas) {
		super( nombre, edad, equipo,idJugador, precioEnMillones);
		this.temporada = temporada;
		this.idEstadisticas = idEstadisticas;
		this.goles = goles;
		this.asistencias = asistencias;
		this.tarjetasAmarillas = tarjetasAmarillas;
		this.tarjetasRojas = tarjetasRojas;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	public int getIdEstadisticas() {
		return idEstadisticas;
	}

	public void setIdEstadisticas(int idEstadisticas) {
		this.idEstadisticas = idEstadisticas;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public int getTarjetasAmarillas() {
		return tarjetasAmarillas;
	}

	public void setTarjetasAmarillas(int tarjetasAmarillas) {
		this.tarjetasAmarillas = tarjetasAmarillas;
	}

	public int getTarjetasRojas() {
		return tarjetasRojas;
	}

	public void setTarjetasRojas(int tarjetasRojas) {
		this.tarjetasRojas = tarjetasRojas;
	}

	@Override
	public String toString() {
		return "Estadisticas [temporada=" + temporada + ", idEstadisticas=" + idEstadisticas + ", goles=" + goles
				+ ", asistencias=" + asistencias + ", tarjetasAmarillas=" + tarjetasAmarillas + ", tarjetasRojas="
				+ tarjetasRojas + "]";
	}
	
	
}