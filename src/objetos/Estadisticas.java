package objetos;

import java.util.ArrayList;
import Recursividad.I_Comparable;


/** Representa las estadisticas de un jugador por cada temporada, hereda de Jugador, ya que las 
 * estadisticas pertenecen a un jugador
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

public class Estadisticas <T> extends Jugador implements I_Comparable{

	/** Temporada a la que pertenecen las estadisticas
	 */
	private Temporada temporada;
	
	/** El identificador de las estadisticas
	 */
	private int idEstadisticas;
	
	/** El número de goles que ha logrado el jugador en la temporada
	 */
	private int goles;
	
	/** El número de asistencias que ha dado el jugador en la temporada
	 */
	private int asistencias;
	
	/** El número de tarjetas amarillas que ha recibido el jugador en la temporada
	 */
	private int tarjetasAmarillas;
	
	/** El número de tarjetas rojas que ha recibido el jugador en la temporada
	 */
	private int tarjetasRojas;
	
	/** Es el constructor de la clase estadisticas, permite crear una instancia del objeto
	 * 
	 * @param nombre Representa el nombre del jugador
	 * @param edad Representa la edad del jugador
	 * @param equipo Representa el equipo en el que juega el jugador
	 * @param idJugador Indica la identificacion del jugador
	 * @param precioEnMillones Indica el valor del jugador
	 * @param temporada Indica en que temporada realiza estas estaditicas
	 * @param idEstadisticas Indica la identificacion de las estadisticas
	 * @param goles Indica el numero de goles que ha marcado el jugador
	 * @param asistencias Indica el numero de asistencias que a realizado un jugador
	 * @param tarjetasAmarillas Indica el numero de tarjetas que le han mostrado a un jugador 
	 * @param tarjetasRojas Indica el numero de tarjetas rojas que le han mostrado a un jugador
	 */
	public Estadisticas(String nombre, int edad, Equipo equipo, int idJugador, int precioEnMillones, 
			Temporada temporada, int idEstadisticas,int goles, int asistencias, int tarjetasAmarillas, int tarjetasRojas) {
		super( nombre, edad, equipo,idJugador, precioEnMillones);
		this.temporada = temporada;
		this.idEstadisticas = idEstadisticas;
		this.goles = goles;
		this.asistencias = asistencias;
		this.tarjetasAmarillas = tarjetasAmarillas;
		this.tarjetasRojas = tarjetasRojas;
	}

	/** Devuelve la temporada a la que hacen referencia las estadisticas
	 * 
	 * @return temporada o año al que pertenecen las estadisticas
	 */
	public Temporada getTemporada() {
		return temporada;
	}

	/** Establece o modifica la temporada a la que hacen referencia las estadisticas
	 * 
	 * @param temporada nueva temporada que se le pasa al objeto estadisticas
	 */
	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}
	
	/** Devuelve el identificador de las estadisticas
	 * 
	 * @return el identificador
	 */
	public int getIdEstadisticas() {
		return idEstadisticas;
	}

	/** Establece o modifica el identificador de las estadisticas
	 * 
	 * @param nuevo identificador
	 */
	public void setIdEstadisticas(int idEstadisticas) {
		this.idEstadisticas = idEstadisticas;
	}

	/** Devuelve los goles logrados en esa temporada por el jugador
	 * 
	 * @return goles logrados
	 */
	public int getGoles() {
		return goles;
	}

	/** Establece o modifica los goles logrados por el jugador
	 * 
	 * @param nuevo número de goles logrados
	 */
	public void setGoles(int goles) {
		this.goles = goles;
	}

	/** Devuelve las asistencias logradas esa temporada por el jugador
	 * 
	 * @return asistencias logradas
	 */
	public int getAsistencias() {
		return asistencias;
	}

	/** Establece o modifica las asistencias logradas por el jugador
	 * 
	 * @param nuevo numero de asistencias
	 */
	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	/** Devuelve las tarjetas amarillas recibidas esa temporada por el jugador
	 * 
	 * @return tarjetas amarillas recibidas
	 */
	public int getTarjetasAmarillas() {
		return tarjetasAmarillas;
	}

	/** Establece o modifica las tarjetas amarillas obtenidas por el jugador
	 * 
	 * @param tarjetas amarillas recibidas
	 */
	public void setTarjetasAmarillas(int tarjetasAmarillas) {
		this.tarjetasAmarillas = tarjetasAmarillas;
	}

	/** Devuelve las tarjetas rojas recibidas esa temporada por el jugador
	 * 
	 * @return tarjetas rojas recibidas
	 */
	public int getTarjetasRojas() {
		return tarjetasRojas;
	}
	
	/** Establece o modifica las tarjetas rojas recibidas por el jugador
	 * 
	 * @param nuevo numero de tarjetas rojas recibidas
	 */
	public void setTarjetasRojas(int tarjetasRojas) {
		this.tarjetasRojas = tarjetasRojas;
	}
	
	/** Este método ayuda a obtener el identificador del jugador que ha logrado un mayor numero de goles 
	 * entre los jugadores que se le pasan en un arrayList por parametro
	 * 
	 * @param arrayEstadisticas Le pasa las estadisticas de los jugadores seleccionados que figuran
	 * dentro del arrayList
	 * @return el identificador del jugador con un mayor numero de goles
	 */
	public static int getMaximoGoleador(ArrayList <Estadisticas> arrayEstadisticas){
		int iD = 0;
		int goles = 0;
		for (Estadisticas es: arrayEstadisticas){
			if (es.getGoles()>goles){
				goles = es.getGoles();
				iD = es.getIdJugador();
			}
		}
		return iD;
		
	}
	
	/** Este método ayuda a obtener el identificador del jugador que ha logrado un mayor numero de 
	 * asistencias entre los jugadores que se le pasan en un arrayList por parametro
	 * 
	 * @param arrayEstadisticas Le pasa las estadisticas de los jugadores seleccionados que figuran
	 * dentro del arrayList
	 * @return el identificador del jugador con un mayor numero de asistencias
	 */
	public static int getMaximoAsistente(ArrayList <Estadisticas> arrayEstadisticas){
		int iDAsistente = 0;
		int asistencias=0;
		for (Estadisticas es: arrayEstadisticas){
			if (es.getAsistencias()>asistencias){
				asistencias = es.getAsistencias();
				iDAsistente = es.getIdJugador();
			}
		}
		return iDAsistente;
	}
		

	@Override
	public String toString() {
		return "Estadisticas [temporada=" + temporada + ", idEstadisticas=" + idEstadisticas + ", goles=" + goles
				+ ", asistencias=" + asistencias + ", tarjetasAmarillas=" + tarjetasAmarillas + ", tarjetasRojas="
				+ tarjetasRojas + "]";
	}

	

	@Override
	public boolean compareNum(Object o) {
		if(this.goles >  ((Estadisticas)o).getGoles()){
			return true;
		}else return false;
	}

	@Override
	public boolean compareStr(Object o) {
		// TODO Auto-generated method stub
		return false;
	}



	
}
