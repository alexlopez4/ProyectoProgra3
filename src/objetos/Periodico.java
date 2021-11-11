package objetos;

/** Representa un peri�dico dentro de la App
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

public class Periodico{

	/** El identificador del peri�dico
	 */
	private int idPeriodico;
	
	/** El nombre del peri�dico
	 */
	private String nombrePeriodico;
	
	/** El pa�s donde se encuentra la sede del peri�dico
	 */
	private String pais;
	
	/** Es el constructor de la clase peri�dico, que permite crear una instancia del objeto
	 * 
	 * @param idPeriodico La identificacion del periodico
	 * @param nombrePeriodico El nombre del periodico
	 * @param pais El pais de origen del periodico
	 */
	public Periodico(int idPeriodico, String nombrePeriodico, String pais) {
		super();
		this.idPeriodico = idPeriodico;
		this.nombrePeriodico = nombrePeriodico;
		this.pais = pais;
	}

	public int getIdPeriodico() {
		return idPeriodico;
	}

	public void setIdPeriodico(int idPeriodico) {
		this.idPeriodico = idPeriodico;
	}

	public String getNombrePeriodico() {
		return nombrePeriodico;
	}

	public void setNombrePeriodico(String nombrePeriodico) {
		this.nombrePeriodico = nombrePeriodico;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Periodico [idPeriodico=" + idPeriodico + ", nombrePeriodico=" + nombrePeriodico + ", pais=" + pais
				+ "]";
	}
		
}
