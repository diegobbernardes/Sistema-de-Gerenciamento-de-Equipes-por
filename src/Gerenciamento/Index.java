package Gerenciamento;

import java.io.FileNotFoundException;
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
		
		Menu menu = new Menu();
		Menu menuColaborador = new Menu();
		Menu menuFuncionario = new Menu();
		Menu menu4 = new Menu();
		
		Opcao voltar = new Opcao("Voltar");
		Opcao opcaoColaboradores = new Opcao("Colaboradores");
		Opcao opcaoFuncionarios = new Opcao("Funcionarios");
		//opcoes menuColaborador
		Opcao listarColaboradores = new Opcao("Listar Colaboradores");
		Opcao incluirColaborador = new Opcao("Adicionar Colaborador");
		Opcao excluirColaborador = new Opcao("Remover Colaborador");
		//opcoes menuFuncionario
		Opcao listarFuncionarios = new Opcao("Listar Funcionarios");
		Opcao incluirFuncionario = new Opcao("Adicionar Funcionario");
		Opcao excluirFuncionario = new Opcao("Remover Funcionario");
		
		menu.addOpcao(opcaoColaboradores);
		menu.addOpcao(opcaoFuncionarios);
		menu.addOpcao(voltar);
		
		menuColaborador.addOpcao(listarColaboradores);
		menuColaborador.addOpcao(incluirColaborador);
		menuColaborador.addOpcao(excluirColaborador);	
		
		menuFuncionario.addOpcao(listarFuncionarios);
		menuFuncionario.addOpcao(incluirFuncionario);
		menuFuncionario.addOpcao(excluirFuncionario);
		
		while(true){
			menu.show();
			switch(menu.getOpcaoUsuario()){
				case 0:
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
						default:
							System.out.println("-------\nOpção Invalida.\n-------");
							break;
					}
					break;
				case 1:
					menuFuncionario.show();
					switch(menuFuncionario.getOpcaoUsuario()){ 
						case 0:
							funcionarios.listaFuncionarios();
							break;
						case 1:
							//getInfoColaborador(colaboradores);							
							break;
						case 2:
							funcionarios.excluirFuncionario(Integer.parseInt(digita("Digite o codigo a ser deletado:")));
							break;
						default:
							System.out.println("-------\nOpção Invalida.\n-------");
							break;
					}
					break;
				default:
					System.out.println("-------\nOpção Invalida.\n-------");
					break;
			}
		}
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
