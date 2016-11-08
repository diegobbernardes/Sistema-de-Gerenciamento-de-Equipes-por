package Gerenciamento;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		try {
			(new Index()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nao encontrado");
			System.err.println(e.getMessage());
		}
		
	}
	public void run() throws FileNotFoundException {
		
		Colaboradores colaboradores = new Colaboradores();
		Funcionarios funcionarios = new Funcionarios();
		Projetos projetos = new Projetos();
		Competencias competencias = new Competencias();
		
		boolean bool;
		
		Menu menu = new Menu();
		Menu menuColaborador = new Menu();
		Menu menuFuncionario = new Menu();
		Menu menuProjeto = new Menu();
		Menu menuCompetencia = new Menu();
		Menu menu4 = new Menu();
		
		Opcao voltar = new Opcao("Voltar");
		Opcao opcaoColaboradores = new Opcao("Colaboradores");
		Opcao opcaoFuncionarios = new Opcao("Funcionarios");
		Opcao opcaoProjeto = new Opcao("Projeto");
		Opcao opcaoCompetencia = new Opcao("Competencia");
		
		//opcoes menuColaborador
		Opcao listarColaboradores = new Opcao("Listar Colaboradores");
		Opcao incluirColaborador = new Opcao("Adicionar Colaborador");
		Opcao excluirColaborador = new Opcao("Remover Colaborador");
		
		//opcoes menuFuncionario
		Opcao listarFuncionarios = new Opcao("Listar Funcionarios");
		Opcao incluirFuncionario = new Opcao("Adicionar Funcionario");
		Opcao excluirFuncionario = new Opcao("Remover Funcionario");
		
		//opcoes menuProjeto
		Opcao listarProjeto = new Opcao("Listar Projeto");
		Opcao excluirProjeto = new Opcao("Remover Projeto");
		Opcao editarProjeto = new Opcao("Adicionar Projeto");
		
		//opcoes menuCompetencia
		Opcao listarCompetencia = new Opcao("Listar Competencia");
		
		menu.addOpcao(opcaoProjeto);		
		menu.addOpcao(opcaoFuncionarios);
		menu.addOpcao(opcaoColaboradores);
		menu.addOpcao(opcaoCompetencia);
		menu.addOpcao(voltar);
		
		menuColaborador.addOpcao(listarColaboradores);
		menuColaborador.addOpcao(incluirColaborador);
		menuColaborador.addOpcao(excluirColaborador);	
		menuColaborador.addOpcao(voltar);
		
		menuFuncionario.addOpcao(listarFuncionarios);
		menuFuncionario.addOpcao(incluirFuncionario);
		menuFuncionario.addOpcao(excluirFuncionario);
		menuFuncionario.addOpcao(voltar);
		
		menuProjeto.addOpcao(listarProjeto);
		menuProjeto.addOpcao(excluirProjeto);
		menuProjeto.addOpcao(editarProjeto);
		menuProjeto.addOpcao(voltar);
		
		menuCompetencia.addOpcao(listarCompetencia);
		
		while(true){
			menu.show();
			switch(menu.getOpcaoUsuario()){
				case 0:
					menuProjeto.show();
					switch(menuProjeto.getOpcaoUsuario()){ 
						case 0:
							projetos.listaProjetos();
							break;
						case 1:
							projetos.excluirProjeto(Integer.parseInt(digita("Digite o codigo a ser deletado:")));
							break;
						case 2:
							getInfoProjeto(projetos);							
							break;
					}
					break;
				case 2:
					do{
						bool = true;
						menuColaborador.show();
						switch(menuColaborador.getOpcaoUsuario()){
							case 0:
								colaboradores.listaColaboradores();
								break;
							case 1:
								getInfoColaborador(colaboradores);							
								break;
							case 2:
								colaboradores.excluirColaborador(Integer.parseInt(digita("Digite o codigo a ser deletado:")));
								break;
							case 3:
								bool = false;
								break;
							default:
								System.out.println("-------\nOpção Invalida.\n-------");
								break;
						}
					}while(bool);
					break;
				case 1:
					do{
						bool = true;
						menuFuncionario.show();
						switch(menuFuncionario.getOpcaoUsuario()){ 
							case 0:
								funcionarios.listaFuncionarios();
								break;
							case 1:
								getInfoFuncionario(funcionarios);							
								break;
							case 2:
								funcionarios.excluirFuncionario(Integer.parseInt(digita("Digite o codigo a ser deletado:")));
								break;
							case 3:
								bool = false;
								break;
							default:
								System.out.println("-------\nOpção Invalida.\n-------");
								break;
						}
					}while(bool);
					break;				
				case 3:
					menuCompetencia.show();
					switch(menuCompetencia.getOpcaoUsuario()){ 
					case 0:
						competencias.listaCompetencias();
						break;
					}
					break;	
				default:
					System.out.println("-------\nOpção Invalida.\n-------");
					break;
			}
		}
	}
	private void getInfoProjeto(Projetos projetos) {
		String nomeProjeto = digita("Digite o nome do projeto: ");
		LocalDate dataInicio = LocalDate.parse(digita("Digite a data de inicio do projeto: "));
		LocalDate dataFim = LocalDate.parse(digita("Digite a data do fim do projeto: "));
		Vetor<String> competencias = new Vetor<>();
		do{
			competencias.append(digita("Digite a competencia do projeto: "));
		}while(Integer.parseInt(digita("Incluir nova competencia? 1 para sim: "))==1);
		projetos.incluirProjeto(nomeProjeto,dataInicio,dataFim,competencias);
	}
	private void getInfoFuncionario(Funcionarios funcionarios) {
		// TODO Auto-generated method stub
		
	}
	public String digita(String texto){
		Scanner sc  = new Scanner(System.in);
		System.out.print(texto);
		return sc.next();
	}	
	private void getInfoColaborador(Colaboradores colaboradores) {
		String a = digita("Digite o nome do projeto: ");
		String b = digita("Digite o nome do funcionario: ");
		String c = digita("Digite a competencia: ");
		colaboradores.incluirColaboradores(a,b,c);		
	}
	
}
