package Gerenciamento;

import java.io.FileNotFoundException;

public class Colaboradores extends LerArquivo{
	
	public Colaboradores() throws FileNotFoundException{
		vetColaborador = new Vetor<>();
		parser = new ColaboradorParser();
		csvColaborador = new CSVFile<>("files/colaboradores.csv", parser);
		vetColaborador = lerArquivo(parser, csvColaborador);
	}
	
	private Vetor<Colaborador> vetColaborador;
	private Parser<Colaborador> parser; 		
	private CSVFile<Colaborador> csvColaborador;
	
	public void excluirColaborador(int index){
		vetColaborador.remove(index);
	}
	
	public void listaColaboradores(){
		for (int i = 0; i < vetColaborador.getSize(); i++) {
			System.out.println(i+" - "+vetColaborador.get(i).getColaborador());
		}
	}
	
	public void incluirColaboradores(String a,String b,String c) {
		vetColaborador.append(new Colaborador(a,b,c));
	}
}
