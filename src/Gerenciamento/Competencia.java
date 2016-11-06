package Gerenciamento;

public class Competencia implements Comparable<Competencia>{
	
	public Competencia(String nomeCompetencia){
		this.nomeCompetencia = nomeCompetencia;
	}
	
	private String nomeCompetencia;	
	
	public String getCompetencia() {
		return nomeCompetencia;
	}

	@Override
	public int compareTo(Competencia competencia) {
		return nomeCompetencia.compareTo(competencia.nomeCompetencia);
	}
	
}
