package objetos;

public class Temporada {

	private String edicion;

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
		return "Temporada [edicion=" + edicion + "]";
	}
	
	
}
