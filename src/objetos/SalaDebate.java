package objetos;

/** Representa una sala de debate dentro de la app, donde los usuarios podrán intercambiar opiniones
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

public class SalaDebate {
	
	/** El usuario que crea la sala de debate
	 */
	private Usuario usuario;
	
	/** La liga a la que esta ligada la sala de debate
	 */
	private Liga liga;
	
	/** El identificador de la sala de debate
	 */
	private int idSalaDebate;
	
	/** El tema de debate
	 */
	private String temaDebate;
	
	/** Es el constructor de la sala de debate, que permite crear una instancia del objeto
	 * 
	 * @param usuario El usuario que crea la sala
	 * @param liga La liga relacionada a la sala debate
	 * @param idSalaDebate La identificacion de la salaDebate
	 * @param temaDebate El tema del debate
	 */
	public SalaDebate(Usuario usuario, Liga liga, int idSalaDebate, String temaDebate) {
		super();
		this.usuario = usuario;
		this.liga = liga;
		this.idSalaDebate = idSalaDebate;
		this.temaDebate=temaDebate;
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

	public void setIdSalaDebate(String temaDebate) {
		this.temaDebate = temaDebate;
	}
	


	@Override
	public String toString() {
		return temaDebate;
	}

}
