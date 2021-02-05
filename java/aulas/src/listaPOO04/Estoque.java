package listaPOO04;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
	
	public static void main(String[] args) {
		
		List <String> lista = new ArrayList<>(); //cria lista de objetos String
		
		//adiciona elemenmtos
		String elemento1 = "str1";
		lista.add(elemento1);
		String elemento2 = "str2";
		lista.add(elemento2);
		String elemento3 = "str3";
		lista.add(elemento3);
		
		
		//imprime (FOR comum)
		System.out.println("\nimprime usando FOR comum lista ORIGINAL");
		for (int i = 0; i<3; i++) {
			System.out.println(lista.get(i));
		}
		
		
		//imprime (FOR each)
		System.out.println("\nimprime usando FOR EACH lista ORIGINAL");
		for (String elemento : lista) {
			System.out.println(elemento);
		}
		
		
		//modifica a lista
		lista.set(0,"Elemento 1");
		lista.set(1,"Elemento 2");
		lista.set(2,"Elemento 3");
		//imprime
		System.out.println("\nimprime usando FOR EACH lista MODIFICADA");
		for (String elemento : lista) {
			System.out.println(elemento);
		}
		
		//remove o elemento de índice 1 (isto é, o segundo elemento)
		String elementoRemovido = lista.remove(1);
		System.out.println("\nElemento de índice 1 removido ("+elementoRemovido+")");
		//imprime
		System.out.println("\nimprime usando FOR EACH lista SEM ELEMENTO REMOVIDO");
		for (String elemento : lista) {
			System.out.println(elemento);
		}
		
		System.out.println("\nPrimeiro elemento da lista removido");
		lista.remove(0); //remove o primeiro elemento da lista
		System.out.println("\nimprime usando FOR EACH lista SEM OS DOIS ELEMENTOS REMOVIDOS");
		for (String elemento : lista) {
			System.out.println(elemento);
		}
	}
	
}
