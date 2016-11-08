package Gerenciamento;

import java.io.FileNotFoundException;

public class Funcionarios extends LerArquivo{
	
	public Funcionarios() throws FileNotFoundException{
		vetFuncionarios = new Vetor<>();
		parser = new FuncionarioParser();
		csvFuncionario = new CSVFile<>("files/funcionarios.csv", parser);
		vetFuncionarios = lerArquivo(parser, csvFuncionario);
	}
	
	private Vetor<Funcionario> vetFuncionarios;
	private Parser<Funcionario> parser;		
	private CSVFile<Funcionario> csvFuncionario;
	
	public void excluirFuncionario(int index){
		vetFuncionarios.remove(index);
	}
	
	public void listaFuncionarios(){
		for (int i = 0; i < vetFuncionarios.getSize(); i++) {
			System.out.println(i+" - "+vetFuncionarios.get(i).getFuncionario());
		}
	}

	public void incluirFuncionario(String nomeFuncionario, double salarioFuncionario, Vetor<String> competencias) {
		Funcionario funcionario = new Funcionario(nomeFuncionario,salarioFuncionario);
		funcionario.setCompetenciaFuncionario(competencias);
		vetFuncionarios.append(funcionario);		
	}
}
