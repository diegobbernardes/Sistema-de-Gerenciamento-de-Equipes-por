package Gerenciamento;

public class LerArquivo {
	protected <T> Vetor<T> lerArquivo(Parser<T> parser,CSVFile<T> csv){
		Vetor<T> vetT = new Vetor<>();
		T coringa = null;
		csv.skipLine();
		do {
			coringa = csv.readObject();
			if (coringa != null)
				vetT.append(coringa);
				//System.out.println(competencia.getCompetencia());
		} while (coringa != null);
		
		return vetT;
	}
}
