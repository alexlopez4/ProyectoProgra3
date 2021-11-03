package objetos;

public class Noticia extends Periodico {

	private String titulo;
	private String texto;
	private String idioma;
	private String fecha ;
	
	
	public Noticia(String nombrePeriodico, String pais, String titulo, String texto, String idioma, String fecha) {
		super(nombrePeriodico, pais);
		this.titulo = titulo;
		this.texto = texto;
		this.idioma = idioma;
		this.fecha = fecha;
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
	
	
	
	
}
