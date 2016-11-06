package Gerenciamento;
import java.util.Scanner;

public class ColaboradorParser implements Parser<Colaborador> {

	@Override
	public Colaborador parseObject(String dadosCSV) {
		Scanner parser = new Scanner(dadosCSV);
		parser.useDelimiter(";");
		
		String nomeProjeto = parser.next();
		String nomeFuncionario = parser.next();
		String competencia = parser.next();
		
		Colaborador colaborador = new Colaborador(nomeProjeto,nomeFuncionario,competencia);
		
		parser.close();
		
		return colaborador;
	}

}
