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
		Menu menu2 = new Menu();
		Menu menu3 = new Menu();
		Menu menu4 = new Menu();
		
		Opcao voltar = new Opcao("Voltar");
		Opcao opcaoColaboradores = new Opcao("Colaboradores");
		Opcao opcaoFuncionarios = new Opcao("Funcionarios");
		//opcoes menu2
		Opcao listarColaboradores = new Opcao("Listar Colaboradores");
		Opcao incluirColaborador = new Opcao("Adicionar Colaborador");
		Opcao excluirColaborador = new Opcao("Remover Colaborador");
		//opcoes menu3
		Opcao listarFuncionarios = new Opcao("Listar Funcionarios");
		Opcao incluirFuncionario = new Opcao("Adicionar Funcionario");
		Opcao excluirFuncionario = new Opcao("Remover Funcionario");
		
		menu.addOpcao(opcaoColaboradores);
		menu.addOpcao(opcaoFuncionarios);
		menu.addOpcao(voltar);
		
		menu2.addOpcao(listarColaboradores);
		menu2.addOpcao(incluirColaborador);
		menu2.addOpcao(excluirColaborador);	
		
		menu3.addOpcao(listarFuncionarios);
		menu3.addOpcao(incluirFuncionario);
		menu3.addOpcao(excluirFuncionario);
		
		while(true){
			menu.show();
			switch(menu.getOpcaoUsuario()){
				case 0:
					menu2.show();
					switch(menu2.getOpcaoUsuario()){
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
					menu3.show();
					switch(menu3.getOpcaoUsuario()){ 
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
	private void getInfoColaborador(Colaboradores colaboradores) {
		String a = digita("Digite o nome do projeto: ");
		String b = digita("Digite o nome do funcionario: ");
		String c = digita("Digite a competencia: ");
		colaboradores.incluirColaboradores(a,b,c);		
	}
	public String digita(String texto){
		Scanner ler  = new Scanner(System.in);
		System.out.print(texto);
			return ler.next();
	}	
}
