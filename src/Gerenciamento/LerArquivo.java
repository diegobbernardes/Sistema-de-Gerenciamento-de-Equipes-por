package Gerenciamento;

public class LerArquivo {
	protected <T> Vetor<T> lerArquivo(Parser<T> parser,CSVFile<T> csv){
		Vetor<T> vetT = new Vetor<>();
		T temp = null;
		csv.skipLine();
		do {
			temp = csv.readObject();
			if (temp != null)
				vetT.append(temp);
		} while (temp != null);
		
		return vetT;
	}
}
