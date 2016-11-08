package Gerenciamento;
import java.time.LocalDate;

import java.util.Scanner;

public class ProjetoParser implements Parser<Projeto>{

	@Override
	public Projeto parseObject(String dadosCSV) {
		Scanner parser = new Scanner(dadosCSV);
		parser.useDelimiter(";");
		
		String nomeProjeto = parser.next();
		LocalDate dataInicioProjeto = LocalDate.parse(parser.next());
		LocalDate dataFimProjeto = LocalDate.parse(parser.next());
		
		Projeto projeto = new Projeto(nomeProjeto,dataInicioProjeto,dataFimProjeto);
		
		int numeroCompetencias = parser.nextInt();
		
		for (int i = 0; i < numeroCompetencias; i++) {
			projeto.setCompetenciaProjeto(parser.next());
		}
		
		parser.close();
		return projeto;
	}

}
