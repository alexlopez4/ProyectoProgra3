package objetos;

public abstract class Persona {

	private String nombreCompleto;
	private int edad;
	
	public Persona(){
		
	}
	
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
