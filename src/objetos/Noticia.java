package objetos;

/** Representa una noticia que podrá leerse en la aplicación, hereda de periódico
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

public class Noticia extends Periodico {

	/** El identificador de la noticia
	 */
	private int idNoticia;
	
	/** El título de la noticia
	 */
	private String titulo;
	
	/** El contenido de la noticia
	 */
	private String texto;
	
	/** El idioma en el que esta redactada la noticia
	 */
	private String idioma;
	
	/** La fecha en la que se redactó la noticia
	 */
	private String fecha;
	
	/** Es el constructor de la clase noticia, permite crear una instancia del objeto
	 * 
	 * @param idPeriodico La identificacion del periodico
	 * @param nombrePeriodico El nombre del periodico
	 * @param pais El pais de origen del periodico
	 * @param idNoticia La identificacion de la noticia
	 * @param titulo El titulo de la noticia
	 * @param texto El contenido de la noticia
	 * @param idioma El idioma de la noticia
	 * @param fecha La fecha de publicacion de la noticia
	 */
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
