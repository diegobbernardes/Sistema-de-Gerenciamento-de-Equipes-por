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
			System.out.println( vetCompetencia.get(i).getCompetencia());
		}
	}
	
}
