package objetos;

public class Noticia extends Periodico {

	private int idNoticia;
	private String titulo;
	private String texto;
	private String idioma;
	private String fecha;
	
	public Noticia(int idPeriodico, String nombrePeriodico, String pais, int idNoticia, String titulo, String texto, String idioma,
			String fecha) {
		super(idPeriodico, nombrePeriodico, pais);
		this.idNoticia = idNoticia;
		this.titulo = titulo;
		this.texto = texto;
		this.idioma = idioma;
		this.fecha = fecha;
	}
	public int getIdNoticia() {
		return idNoticia;
	}
	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Noticia [idNoticia=" + idNoticia + ", titulo=" + titulo + ", texto=" + texto + ", idioma=" + idioma
				+ ", fecha=" + fecha + "]";
	}
		
}
