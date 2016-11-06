package Gerenciamento;
import java.time.LocalDate;

public class Projeto implements Comparable<Projeto>{
	
	public Projeto(String nomeProjeto,LocalDate dataInicioProjeto,LocalDate dataFinalProjeto){
		this.nomeProjeto = nomeProjeto;
		this.dataInicioProjeto = dataInicioProjeto;
		this.dataFinalProjeto = dataFinalProjeto;
		this.competenciaProjeto = new String[0];
	}
	
	private String nomeProjeto;
	private LocalDate dataInicioProjeto;
	private LocalDate dataFinalProjeto;
	private String[] competenciaProjeto;
	
	public void setNumeroProjeto(int numeroCompetenciaProjeto){
		if (numeroCompetenciaProjeto > 0)
			this.competenciaProjeto = new String[numeroCompetenciaProjeto];
	}
	
	public void setCompetenciaProjeto(int i , String competenciaProjeto){
		if (i < 0 || i >= this.competenciaProjeto.length)
			throw new ArrayIndexOutOfBoundsException(i);
		this.competenciaProjeto[i] = competenciaProjeto;
	}
	
	public String getProjeto(){
		return nomeProjeto + " " + dataInicioProjeto + " " + dataFinalProjeto;
	}

	@Override
	public int compareTo(Projeto projeto) {
		return nomeProjeto.compareTo(projeto.nomeProjeto);
	}
}
