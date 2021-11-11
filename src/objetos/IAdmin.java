package objetos;

/** Es una interfaz que permitira identificar al administrador de la app
 * @author Alex Lopez de Lacalle and Giovanni Locatelli
 * @version 1.0
 */
public interface IAdmin {

	/**Es un método que se implementa en la clase de usuario y que trata de averiguar si el usuario
	 * que trata de iniciar la aplicación es el administrador o no
	 * @return devuelve un boolean que es True si se trata del administrador y false si no lo es
	 */
	public boolean esAdmin();
}
