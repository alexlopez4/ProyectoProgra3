package objetos;

import java.util.ArrayList;

/** Representa un equipo de una liga
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

public class Equipo {

	/**La liga en la que participa el equipo
	 */
	private Liga liga;
	
	/**El identificador del equipo
	 */
	private int idEquipo;
	
	/**El nombre del equipo
	 */
	private String nombreEquipo;
	
	/**El nombre del estadio en el que juega el equipo
	 */
	private String estadio;
	
	
	/** Es el constructor de la clase equipo, permite crear una instancia del objeto
	 * 
	 * @param liga liga en la que participa el equipo
	 * @param idEquipo identificación del equipo
	 * @param nombreEquipo El nombre del equipo
	 * @param estadio donde juega el equipo
	 */
	public Equipo(Liga liga, int idEquipo, String nombreEquipo, String estadio) {
		super();
		this.liga = liga;
		this.idEquipo = idEquipo;
		this.nombreEquipo = nombreEquipo;
		this.estadio = estadio;
	}
	
	/**Devuelve la liga en la que juega el equipo 
	 * @return Devuelve una liga
	 */
	public Liga getLiga() {
		return liga;
	}
	
	/**Establece o modifica la liga en la que juega un equipo
	 * @param la liga en la que juega el equipo
	 */
	public void setLiga(Liga liga) {
		this.liga = liga;
	}
	
	/**Devuelve la id del equipo 
	 * @return Devuelve un int con la identificacion
	 */
	public int getIdEquipo() {
		return idEquipo;
	}
	
	/**Establece o modifica la identificacion de un equipo
	 * @param idEquipo Añade al parametro idEquipo, un int con la identificacion del equipo
	 */
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	
	/**Devuelve el nombre del equipo 
	 * @return Devuelve un String con el nombre del equipo
	 */
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	
	/**Establece o modifica el nombre del equipo 
	 * @param nombreEquipo Añade al parametro nombreEquipo , un String con el nombre del equipo
	 */
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	
	/**Devuelve el estadio en el que juega el equipo 
	 * 
	 * @return Devuelve un int con la identificacion
	 */
	public String getEstadio() {
		return estadio;
	}
	
	/** Establece el estadio en el que juega el equipo
	 * 
	 * @param estadio Añade al parametro estadio , un string con el nombre del estadio donde el equipo juega
	 */
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	
	/** Metodo que permite calcular el precio medio de los jugadores de un equipo
	 * 
	 * @param jugadores arrayList con los jugadores
	 * @param numeroJugadores numero de jugadores en el equipo
	 * @return media de precio
	 */
	public static double mediaPrecioEquipo (ArrayList<Jugador> jugadores, int numeroJugadores){
		int precioEquipo=0;
		for (Jugador player: jugadores){
			int precioJugador= player.getPrecioEnMillones();
			precioEquipo=precioEquipo + precioJugador;
		}
		double media = precioEquipo/numeroJugadores;
		return media;
	}
	
	/** Al realizar un syso del objeto devuelve el nombre del equipo
	 * @return nombre del equipo
	 */
	@Override
	public String toString() {
		return nombreEquipo;
	}
	
	
}
