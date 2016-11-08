package Gerenciamento;
import java.io.FileNotFoundException;

public class Competencias extends LerArquivo{
	
	public Competencias() throws FileNotFoundException{
		vetCompetencia = new Vetor<>();
		parser = new CompetenciaParser();
		csvCompetencia = new CSVFile<>("files/competencias.csv", parser);
		vetCompetencia = lerArquivo(parser,csvCompetencia);
	}
	
	private Vetor<Competencia> vetCompetencia;
	private Parser<Competencia> parser;		
	private CSVFile<Competencia> csvCompetencia;	
	
	public void listaCompetencias(){
		for (int i = 0; i < vetCompetencia.getSize(); i++) {
			System.out.println(i+" "+ vetCompetencia.get(i).getCompetencia());
		}
	}
	
	public void excluirCompetencia(int index){
		vetCompetencia.remove(index);
	}
	
	public void incluirCompetencia(String competencia) {
		vetCompetencia.append(new Competencia(competencia));		
	}
	
}
