package Gerenciamento;

import java.io.FileNotFoundException;

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
			System.out.println( vetProjetos.get(i).getProjeto());
		}
	}
	
}
