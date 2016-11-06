package Gerenciamento;

public class Colaborador implements Comparable<Colaborador>{
	
	public Colaborador(String nomeProjeto, String nomeFuncionario, String competencia){
		this.nomeProjeto = nomeProjeto;
		this.nomeFuncionario = nomeFuncionario;
		this.competencia = competencia;
	}
	
	private String nomeProjeto;
	private String nomeFuncionario;
	private String competencia;
	
	public String getColaborador(){
		return nomeProjeto + " " + nomeFuncionario + " " + competencia;
	}

	@Override
	public int compareTo(Colaborador colaborador) {
		return nomeProjeto.compareTo(colaborador.nomeProjeto);
	}
	
}
