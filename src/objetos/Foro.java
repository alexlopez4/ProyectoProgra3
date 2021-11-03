package objetos;

public class Foro {
	private Usuario usuario;
	private String texto;
	
	public Foro(Usuario usuario, String texto) {
		super();
		this.usuario = usuario;
		this.texto = texto;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Foro [usuario=" + usuario + ", texto=" + texto + "]";
	}
	
	

}
