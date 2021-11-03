package objetos;

public class Usuario extends Persona implements Admin{

	private String nombreDeUsuario;
	private String contraseña;
	
	public Usuario(String nombre, int edad, String nombreDeUsuario, String contraseña) {
		super(nombre,edad);
		this.nombreDeUsuario = nombreDeUsuario;
		this.contraseña = contraseña;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public boolean esAdmin(){
		boolean EsElAdministrador;
		if (this.getNombreDeUsuario().equals("Admin") && this.getContraseña().equals("Admin")){
			EsElAdministrador =true;
		}
		else{
			EsElAdministrador=false;
		}
		return EsElAdministrador;
	}

	@Override
	public String toString() {
		return this.getNombre()+this.getEdad()+nombreDeUsuario + contraseña;
	}


}
