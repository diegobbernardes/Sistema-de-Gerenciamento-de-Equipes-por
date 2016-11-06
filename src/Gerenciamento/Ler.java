package Gerenciamento;

public class Ler<T> {
	
	public Ler(Parser<T> parser,CSVFile<T> csv,String arquivo){
		this.parser = parser;
		this.csv = csv;
		this.arquivo = arquivo;
	}
	Parser<T> parser;
	CSVFile<T> csv;
	String arquivo;
	
}
