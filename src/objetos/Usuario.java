package objetos;

/** Representa un usuario dentro de la app e implementa la interfaz Admin y hereda de persona
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

public class Usuario extends Persona implements IAdmin{

	/** El nombre de usuario del usuario
	 */
	private String nombreDeUsuario;
	
	/** La contrase�a del usuario
	 */
	private String contrase�a;
	
	/** Es el constructor de la clase usuario, permite crear un usuario nuevo
	 * 
	 * @param nombre El nombre de la persona que es usuario
	 * @param edad La edad del usuario
	 * @param nombreDeUsuario El nombre de usuario
	 * @param contrase�a La contrase�a del usuario
	 */
	public Usuario(String nombre, int edad, String nombreDeUsuario, String contrase�a) {
		super(nombre,edad);
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrase�a = contrase�a;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	/** Implementa el m�todo vacio de la interfaz IAdmin para tratar de averiguar si el usuario
	 * que intenta logear la aplicaci�n es el administrador
	 * 
	 * @return devuelve true si se trata del administrador y false si no lo es
	 */
	public boolean esAdmin(){
		boolean EsElAdministrador;
		if (this.getNombreDeUsuario().equals("Admin") && this.getContrase�a().equals("Admin")){
			EsElAdministrador =true;
		}
		else{
			EsElAdministrador=false;
		}
		return EsElAdministrador;
	}
	
	/** Metodo que comprueba si la constrase�a es un espacio y en el caso que sea elimina el usuario
	 * 
	 * @param u Usuario que se le pasa al metodo
	 */
	public static void Contrasena (Usuario u){
		if ( u.getContrase�a().equals(" ")){
			u= null;
		}
	}

	@Override
	public String toString() {
		return this.getNombre()+" " +this.getEdad()+" "+nombreDeUsuario+ " "+ contrase�a;
	}


}
