package Gerenciamento;

public class Funcionario implements Comparable<Funcionario>{
	
	public Funcionario(String nomeFuncionario,double salarioFuncionario){
		this.nomeFuncionario = nomeFuncionario;
		this.salarioFuncionario = salarioFuncionario;
		competenciaFuncionario = new String[0];
	}
	
	private String nomeFuncionario;
	private double salarioFuncionario;
	private String [] competenciaFuncionario;
	
	public void setNumeroCompetencia(int numeroCompetenciaFuncionario){
		if (numeroCompetenciaFuncionario > 0)
			this.competenciaFuncionario = new String[numeroCompetenciaFuncionario];
	}
	
	public void setCompetenciaFuncionario(int i , String competenciaFuncionario){
		if (i < 0 || i >= this.competenciaFuncionario.length)
			throw new ArrayIndexOutOfBoundsException(i);
		this.competenciaFuncionario[i] = competenciaFuncionario;
	}
	
	public String getFuncionario(){
		return nomeFuncionario + " " + salarioFuncionario;
	}

	@Override
	public int compareTo(Funcionario funcionario) {
		return nomeFuncionario.compareTo(funcionario.nomeFuncionario);
	}
}
