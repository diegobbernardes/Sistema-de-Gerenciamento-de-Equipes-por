package Gerenciamento;
import java.util.Scanner;

public class CompetenciaParser implements Parser<Competencia> {
	public Competencia parseObject(String dadosCSV) {
		Scanner parser = new Scanner(dadosCSV);		
		String competenciaNome = parser.nextLine();
		
		Competencia competencia = new Competencia(competenciaNome);
		
		parser.close();		
		return competencia;
	}
} 