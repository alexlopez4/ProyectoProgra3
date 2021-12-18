package objetos;

import java.util.ArrayList;


/** Representa una liga dentro de la aplicación e implementa la interfaz IComparable
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

public class Liga{
	
	/** El identificador de la liga
	 */
	private int idLiga;
	
	/** El nombre de la liga
	 */
	private String nombreLiga;
	
	/** El país en el que se disputa la liga
	 */
	private String pais;
	
	/** Es el constructor de la clase liga, permite crear una instancia del objeto
	 * 
	 * @param temporada La temporada de la liga
	 * @param idLiga La identificacion de la liga
	 * @param nombreLiga El nombre de la liga
	 * @param pais El pais de la liga
	 */
	public Liga(int idLiga, String nombreLiga, String pais) {
		super();
		this.idLiga = idLiga;
		this.nombreLiga = nombreLiga;
		this.pais = pais;
	}


	/** Devuelve el identificador de la liga
	 * 
	 * @return identificador
	 */
	public int getIdLiga() {
		return idLiga;
	}

	/** Establece el identificador de la liga
	 * 
	 * @param nuevo identificador
	 */
	public void setIdLiga(int idLiga) {
		this.idLiga = idLiga;
	}

	/** Devuelve el nombre de la liga
	 * 
	 * @return nombre de la liga
	 */
	public String getNombreLiga() {
		return nombreLiga;
	}

	/** Establece o modifica el nombre de la liga
	 * 
	 * @param nuevo nombre de la liga
	 */
	public void setNombreLiga(String nombreLiga) {
		this.nombreLiga = nombreLiga;
	}

	/** Devuelve el país en el que se disputa la liga
	 * 
	 * @return pais donde se disputa
	 */
	public String getPais() {
		return pais;
	}

	/** Establece o modifica el pais donde se disputa la liga
	 * 
	 * @param nuevo pais donde se disputa
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public static void LigaDuplicada(Liga u , ArrayList<Liga> a){
			
			for (Liga z:a){
				if (u.getNombreLiga().equals(z.getNombreLiga())){
					System.out.println(z.getNombreLiga());
					z=null;
				}
			}
	}

	@Override
	public String toString() {
		return nombreLiga;
	}
	
	
	
	
}
