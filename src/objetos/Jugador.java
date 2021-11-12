package objetos;

/** Representa un jugador de un equipo, hereda de persona
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */
public class Jugador extends Persona{

	/** El equipo en el que juega el jugador
	 */
	private Equipo equipo;
	
	/** El identificador del jugador
	 */
	private int idJugador;
	
	/** El precio actual en millones del jugador
	 */
	private int precioEnMillones;
	
	/** Es el constructor de la clase jugador, permite crear una isntancia del objeto 
	 * 
	 * @param nombre El nombre del jugador
	 * @param edad La edad de jugador
	 * @param equipo El equipo en le que juega el jugador
	 * @param idJugador La identificacion del jugador 
	 * @param precioEnMillones El valor del jugador
	 */
	public Jugador( String nombre, int edad, Equipo equipo,  int idJugador, int precioEnMillones) {
		super(nombre, edad);
		this.equipo = equipo;
		this.idJugador = idJugador;
		this.precioEnMillones = precioEnMillones;
	}
	
	/** Devuelve el equipo al que pertenece un jugador
	 * 
	 * @return equipo al que pertenece
	 */
	public Equipo getEquipo() {
		return equipo;
	}
	
	/** Establece o modifica el equipo al que pertenece el jugador
	 * 
	 * @param nuevo equipo
	 */
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	/** Devuelve el identificador del jugador
	 * 
	 * @return identificador del jugador
	 */
	public int getIdJugador() {
		return idJugador;
	}
	
	/** Establece o modifica el identificador del jugador
	 * 
	 * @param nuevo identificador
	 */
	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}
	
	/** Devuelve el precio del jugador
	 * 
	 * @return precio en millones de euros
	 */
	public int getPrecioEnMillones() {
		return precioEnMillones;
	}
	
	/** Establece o modifica el precio del jugador
	 * 
	 * @param precioEnMillones, nuevo precio
	 */
	public void setPrecioEnMillones(int precioEnMillones) {
		this.precioEnMillones = precioEnMillones;
	}
	
	public static int Millones (int u){
			if (u<0){
				return 0;
			}else{
			return u;
			}
		}
	
	
		
	
	
	@Override
	public String toString() {
		return "Jugador [equipo=" + equipo + ", IdJugador=" + idJugador + ", precioEnMillones=" + precioEnMillones
				+ "]";
	}
	
	
}
