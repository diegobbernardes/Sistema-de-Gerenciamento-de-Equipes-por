package Gerenciamento;

import java.util.Comparator;

//public class Vetor<T extends Comparable<T>> {
public class Vetor<T> {

	int numeroElementos = 0;

	@SuppressWarnings("unchecked")
	T[] dados = (T[])new Object[2];

	/*
	@SuppressWarnings("unchecked")
	T[] dados = (T[])new Comparable[2];
	
	public void insertOrdenado(T valor) {
		append(valor);
		for (int i = numeroElementos-1; i > 0; i--) {
			if (dados[i].compareTo(dados[i - 1]) < 0) {
				T troca = dados[i-1];
				dados[i-1] = dados[i];
				dados[i] = troca;
			} else {
				break;
			}
		}
	}
	*/
	public void insertOrdenado(T valor, Comparator<T> cmp) {
		append(valor);
		for (int i = numeroElementos-1; i > 0; i--) {
			if (cmp.compare(dados[i], dados[i - 1]) < 0) {
				T troca = dados[i-1];
				dados[i-1] = dados[i];
				dados[i] = troca;
			} else {
				break;
			}
		}
	}

	public void append(T valor) {	
		garantirEspaco();
		// Inserir no fim dos elementos
		dados[numeroElementos] = valor;

		// Incrementar elementos
		numeroElementos++;
	}

	public int getSize() {
		return numeroElementos;
	}

	public void validaIndice(int index) {
		if (index < 0 || index >= numeroElementos)
			throw new ArrayIndexOutOfBoundsException(index);
	}

	public void insert(int index, T valor) {
		validaIndice(index);
		garantirEspaco();
		for (int i = numeroElementos; i > index; i--) {
			dados[i] = dados[i-1];
		}
		dados[index] = valor;
		numeroElementos++;
	}
	
	private void garantirEspaco() {
		if (numeroElementos >= dados.length) {
			
			@SuppressWarnings("unchecked")
			// Use Comparable quando o comparador por o proprio objeto.
			//T[] novosDados = (T[])new Comparable[numeroElementos * 2];
			T[] novosDados = (T[])new Object[numeroElementos * 2];

			for (int contador = 0; contador < numeroElementos; contador++) {
				novosDados[contador] = this.dados[contador];
			}
			this.dados = novosDados;
		}
	}
	
	public void remove(int index){
		validaIndice(index);		
		for(int i = index; i < numeroElementos-1; i++){
			dados[i] = dados[i+1];
		}
		numeroElementos--;
		
	}

	public T get(int index) {
		validaIndice(index);
		return dados[index];
	}

}
