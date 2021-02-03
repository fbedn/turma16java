package aulas;

import entidades.Produto;

public class Desafio_2021_02_02_d03 {
	
	public static void main(String[] args) {
		
		Produto item1 = new Produto("a001", "Camisa preta tamanho M", 70.99);
		
		System.out.println("CÓDIGO : "+item1.codigo);
		System.out.println("NOME DO PRODUTO : "+item1.nome);
		System.out.printf("PREÇO : %.2f",item1.valorUnitario);
		
	}
}
