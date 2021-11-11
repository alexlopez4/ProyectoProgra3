package objetos;

/** Representa la clase abstracta persona de la que heredan usuario y jugador
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

public abstract class Persona {

	private String nombreCompleto;
	private int edad;
	
	public Persona(){
		
	}
	
	/** Es el constructor de la clase persona, pero no se puede instanciar porque es una clase abstracta
	 * podría ser usado desde las clases hijas
	 * 
	 * @param nombre El nombre de la persona
	 * @param edad La edad de la persona
	 */
	public Persona(String nombre, int edad) {
		super();
		this.nombreCompleto = nombre;
		this.edad = edad;
	}
	public String getNombre() {
		return nombreCompleto;
	}
	public void setNombre(String nombre) {
		this.nombreCompleto = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
