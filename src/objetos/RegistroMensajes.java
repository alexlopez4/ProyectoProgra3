package objetos;

/** Representa los mensajes que quedarán registrados en los foros de la app
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

public class RegistroMensajes {

	/** El usuario que ha redactado el mensaje
	 */
	private Usuario user;
	
	/** La sala de debate o foro en la que se ha redactado el mensaje
	 */
	private SalaDebate sala;
	
	/** El contenido del mensaje
	 */
	private String mensaje;
	
	/** La fecha en la que se redactó el mensaje
	 */
	private String fecha;
	
	/** Es el constructor de la clase de Registro de Mensajes, permite crear un nuevo mensaje
	 * 
	 * @param usuario El usuario que manda el mensaje
	 * @param sala la sala en la que se redacta el mensaje
	 * @param mensaje el contenido del mensaje
	 * @param fecha cuando se redacta
	 */
	public RegistroMensajes(Usuario user, SalaDebate sala, String mensaje, String fecha) {
		super();
		this.user = user;
		this.sala = sala;
		this.mensaje = mensaje;
		this.fecha = fecha;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public SalaDebate getSala() {
		return sala;
	}

	public void setSala(SalaDebate sala) {
		this.sala = sala;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "RegistroMensajes [user=" + user + ", mensaje=" + mensaje + ", fecha=" + fecha + "]";
	}
	
	
	
	
}
