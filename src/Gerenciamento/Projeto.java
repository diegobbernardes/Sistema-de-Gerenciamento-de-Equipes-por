package Gerenciamento;
import java.time.LocalDate;

public class Projeto implements Comparable<Projeto>{
	
	public Projeto(String nomeProjeto,LocalDate dataInicioProjeto,LocalDate dataFinalProjeto){
		this.nomeProjeto = nomeProjeto;
		this.dataInicioProjeto = dataInicioProjeto;
		this.dataFinalProjeto = dataFinalProjeto;
		this.vetCompetencias = new Vetor<>();
	}
	
	private String nomeProjeto;
	private LocalDate dataInicioProjeto;
	private LocalDate dataFinalProjeto;
	private Vetor<String> vetCompetencias;
	
	public void setCompetenciaProjeto(Vetor<String> competenciaProjeto){
		this.vetCompetencias = competenciaProjeto;
	}
	
	public void setCompetenciaProjeto(String competenciaProjeto){
		this.vetCompetencias.append(competenciaProjeto);
	}
	
	public String listaCompetenciaProjetos(){
		String retorno = "";
		for (int i = 0; i < vetCompetencias.getSize(); i++) {
			retorno+=", "+vetCompetencias.get(i);
		}
		return retorno;
	}
	
	public String getProjeto(){
		return nomeProjeto + " " + dataInicioProjeto + " " + dataFinalProjeto + " " + listaCompetenciaProjetos();
	}

	@Override
	public int compareTo(Projeto projeto) {
		return nomeProjeto.compareTo(projeto.nomeProjeto);
	}
}
