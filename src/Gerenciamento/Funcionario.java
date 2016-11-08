package Gerenciamento;

public class Funcionario implements Comparable<Funcionario>{
	
	public Funcionario(String nomeFuncionario,double salarioFuncionario){
		this.nomeFuncionario = nomeFuncionario;
		this.salarioFuncionario = salarioFuncionario;
		this.vetCompetencias = new Vetor<>();
	}
	
	private String nomeFuncionario;
	private double salarioFuncionario;
	private Vetor<String> vetCompetencias;
	
	public void setCompetenciaFuncionario(Vetor<String> competenciaFuncionario){
		this.vetCompetencias = competenciaFuncionario;
	}
	public void setCompetenciaFuncionario(String competenciaProjeto){
		this.vetCompetencias.append(competenciaProjeto);
	}
	
	public String getFuncionario(){
		return nomeFuncionario + " " + salarioFuncionario + " " + listaCompetenciaFuncionario();
	}
	
	public String listaCompetenciaFuncionario(){
		String retorno = "";
		for (int i = 0; i < vetCompetencias.getSize(); i++) {
			retorno+=", "+vetCompetencias.get(i);
		}
		return retorno;
	}

	@Override
	public int compareTo(Funcionario funcionario) {
		return nomeFuncionario.compareTo(funcionario.nomeFuncionario);
	}
}
