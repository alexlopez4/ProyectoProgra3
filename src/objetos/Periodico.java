package objetos;

public class Periodico{

	private int idPeriodico;
	private String nombrePeriodico;
	private String pais;
	
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
