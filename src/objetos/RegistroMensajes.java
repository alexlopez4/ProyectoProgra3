package objetos;

public class RegistroMensajes {

	private Usuario user;
	private SalaDebate sala;
	private String mensaje;
	private String fecha;
	
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
