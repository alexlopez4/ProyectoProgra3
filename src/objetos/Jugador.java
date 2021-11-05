package objetos;

public class Jugador extends Persona{

	private Equipo equipo;
	private int idJugador;
	private int precioEnMillones;
	public Jugador( String nombre, int edad, Equipo equipo,  int idJugador, int precioEnMillones) {
		super(nombre, edad);
		this.equipo = equipo;
		this.idJugador = idJugador;
		this.precioEnMillones = precioEnMillones;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public int getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}
	public int getPrecioEnMillones() {
		return precioEnMillones;
	}
	public void setPrecioEnMillones(int precioEnMillones) {
		this.precioEnMillones = precioEnMillones;
	}
	@Override
	public String toString() {
		return "Jugador [equipo=" + equipo + ", IdJugador=" + idJugador + ", precioEnMillones=" + precioEnMillones
				+ "]";
	}
	
	
}
