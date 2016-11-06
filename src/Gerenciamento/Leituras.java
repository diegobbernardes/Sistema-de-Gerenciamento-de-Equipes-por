package Gerenciamento;

import java.io.FileNotFoundException;

public class Leituras {
	
	public static void main(String[] args) {
		try {
			(new Leituras()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nao encontrado");
			System.err.println(e.getMessage());
		}
	}
	
	public void run() throws FileNotFoundException {
		
		Competencias competencias = new Competencias();
		competencias.listaCompetencias();
		
		Colaboradores colaboradores = new Colaboradores();
		colaboradores.listaColaboradores();
		
		Funcionarios funcionarios = new Funcionarios();
		funcionarios.listaFuncionarios();
		
		Projetos projetos = new Projetos();
		projetos.listaProjetos();
		
		/*Parser<Competencia> parser = new CompetenciaParser();		
		CSVFile<Competencia> csvCompetencia;
		csvCompetencia = new CSVFile<>("files/competencias.csv", parser);
		//vetCompetencia = lerArquivo(parser,csvCompetencia);
		
		Vetor<Competencia> vetCompetencia = new Vetor<>();
		lerCompetencias(vetCompetencia);
		for (int i = 0; i < vetCompetencia.getSize(); i++) {
			System.out.println( vetCompetencia.get(i).getCompetencia() );
		}	
		
		Vetor<Colaborador> vetColaborador = new Vetor<>();
		lerColaboradores(vetColaborador);
		for (int i = 0; i < vetColaborador.getSize(); i++) {
			System.out.println( vetColaborador.get(i).getColaborador() );
		}
		
		Vetor<Projeto> vetProjetos = new Vetor<>();
		lerProjetos(vetProjetos);
		for (int i = 0; i < vetProjetos.getSize(); i++) {
			System.out.println( vetProjetos.get(i).getProjeto() );
		}
		
		Vetor<Funcionario> vetFuncionarios = new Vetor<>();
		lerFuncionarios(vetFuncionarios);
		for (int i = 0; i < vetFuncionarios.getSize(); i++) {
			System.out.println( vetFuncionarios.get(i).getFuncionario() );
		}*/
		
	}

	private void lerFuncionarios(Vetor<Funcionario> vetFuncionarios) throws FileNotFoundException {
		Parser<Funcionario> parser = new FuncionarioParser();		
		CSVFile<Funcionario> csvFuncionario;
		csvFuncionario = new CSVFile<>("files/funcionarios.csv", parser);
		Funcionario funcionario = null;
		csvFuncionario.skipLine();
		do {
			funcionario = csvFuncionario.readObject();
			if (funcionario != null)
				vetFuncionarios.insertOrdenado(funcionario, (a,b)->a.compareTo(b));
				//System.out.println(funcionario.getFuncionario());
		} while (funcionario != null);
		
	}

	private void lerProjetos(Vetor<Projeto> vetProjeto) throws FileNotFoundException {
		Parser<Projeto> parser = new ProjetoParser();		
		CSVFile<Projeto> csvProjeto;
		csvProjeto = new CSVFile<>("files/projetos.csv", parser);
		Projeto projeto = null;
		csvProjeto.skipLine();
		do {
			projeto = csvProjeto.readObject();
			if (projeto != null)
				vetProjeto.insertOrdenado(projeto, (a,b)->a.compareTo(b));
				//System.out.println(projeto.getProjeto());
		} while (projeto != null);
		
	}

	private void lerColaboradores(Vetor<Colaborador> vetColaborador) throws FileNotFoundException {
		Parser<Colaborador> parser = new ColaboradorParser();		
		CSVFile<Colaborador> csvColaborador;
		csvColaborador = new CSVFile<>("files/colaboradores.csv", parser);
		Colaborador colaborador = null;
		csvColaborador.skipLine();
		do {
			colaborador = csvColaborador.readObject();
			if (colaborador != null)
				vetColaborador.insertOrdenado(colaborador, (a,b)->a.compareTo(b));
				//System.out.println(colaborador.getColaborador());
		} while (colaborador != null);
		
	}

	private void lerCompetencias(Vetor<Competencia> vetCompetencia) throws FileNotFoundException {
		Parser<Competencia> parser = new CompetenciaParser();		
		CSVFile<Competencia> csvCompetencia;
		csvCompetencia = new CSVFile<>("files/competencias.csv", parser);
		Competencia competencia = null;
		csvCompetencia.skipLine();
		do {
			competencia = csvCompetencia.readObject();
			if (competencia != null)
				vetCompetencia.insertOrdenado(competencia, (a,b)->a.compareTo(b));
				//System.out.println(competencia.getCompetencia());
		} while (competencia != null);		
	}
	
	/*private <T> Vetor<T> lerArquivo(Parser<T> parser,CSVFile<T> csv){
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
	}*/
	
}
