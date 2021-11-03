package objetos;

public class Periodico{

	private String nombrePeriodico;
	private String pais;
	
	public Periodico(String nombrePeriodico, String pais) {
		super();
		this.nombrePeriodico = nombrePeriodico;
		this.pais = pais;
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
	
	

	
	
	
}
