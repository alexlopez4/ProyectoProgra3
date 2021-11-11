package objetos;

/** Representa una temporada
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

public class Temporada {

	/** La edicion o años a los que hace referencia la temporada
	 */
	private String edicion;

	/** Es el constructor de la clase temporada, que permite crear una temporada nueva
	 * @param edicion El año de la temporada
	 */
	public Temporada(String edicion) {
		super();
		this.edicion = edicion;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	@Override
	public String toString() {
		return edicion;
	}
	
	
}
