package objetos;

public class Jugador extends Persona{

	private Equipo equipo;
	private int precioEnMillones;
	private int goles;
	private int asistencias;
	private int tarjetasAmarillas;
	private int tarjetasRojas;
	
	public Jugador(){
	}
	
	public Jugador(String nombre, int edad, Equipo equipo, int precioEnMillones, int goles, int asistencias,
			int tarjetasAmarillas, int tarjetasRojas) {
		super(nombre, edad);
		this.equipo = equipo;
		this.precioEnMillones = precioEnMillones;
		this.goles = goles;
		this.asistencias = asistencias;
		this.tarjetasAmarillas = tarjetasAmarillas;
		this.tarjetasRojas = tarjetasRojas;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getPrecioEnMillones() {
		return precioEnMillones;
	}

	public void setPrecioEnMillones(int precioEnMillones) {
		this.precioEnMillones = precioEnMillones;
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
		return this.getNombre()+ this.getEdad()+equipo + precioEnMillones +goles
				+ asistencias + tarjetasAmarillas + tarjetasRojas;
	}

}
