package Gerenciamento;
import java.util.Scanner;

public class FuncionarioParser implements Parser<Funcionario>{

	@Override
	public Funcionario parseObject(String dadosCSV) {
		Scanner parser = new Scanner(dadosCSV);
		parser.useDelimiter(";");
		
		String nomeFuncionario = parser.next();
		double salarioFuncionario = Double.parseDouble(parser.next());		
		
		Funcionario funcionario = new Funcionario(nomeFuncionario,salarioFuncionario);
		
		int numeroCompetencias = parser.nextInt();
		funcionario.setNumeroCompetencia(numeroCompetencias);
		
		for (int i = 0; i < numeroCompetencias; i++) {
			funcionario.setCompetenciaFuncionario(i, parser.next());
		}
		
		parser.close();
		return funcionario;
	}

}
