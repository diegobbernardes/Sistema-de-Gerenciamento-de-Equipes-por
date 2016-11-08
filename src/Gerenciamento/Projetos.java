package Gerenciamento;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Projetos extends LerArquivo{
	
	public Projetos() throws FileNotFoundException{
		vetProjetos = new Vetor<>();
		parser = new ProjetoParser();
		csvProjeto = new CSVFile<>("files/projetos.csv", parser);
		vetProjetos = lerArquivo(parser, csvProjeto);
	}
	
	private Vetor<Projeto> vetProjetos;
	private Parser<Projeto> parser;		
	private	CSVFile<Projeto> csvProjeto;
	
	public void listaProjetos(){
		for (int i = 0; i < vetProjetos.getSize(); i++) {
			System.out.println(i+" - "+ vetProjetos.get(i).getProjeto());
		}
	}
	
	public void excluirProjeto(int index){
		vetProjetos.remove(index);
	}
	
	public void incluirProjeto(String nomeProjeto,LocalDate dataInicio,LocalDate dataFim,Vetor<String> competencias) {
		Projeto projeto = new Projeto(nomeProjeto,dataInicio,dataFim);
		projeto.setCompetenciaProjeto(competencias);
		vetProjetos.append(projeto);		
	}
	
}
