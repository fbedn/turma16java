package lista1;

import java.util.Scanner;

public class Tarefa8 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		double precoFinal, custoFabrica, taxaDistrib, taxaImpostos;

		taxaDistrib = 0.28;
		taxaImpostos = 0.45;

		System.out.print("Digite o custo de fábrica do carro: ");
		custoFabrica = ler.nextDouble();

		precoFinal = custoFabrica + (custoFabrica * taxaDistrib) + (custoFabrica * taxaImpostos);

		System.out.printf("Preço do carro incluídos a taxa de distribuição e o imposto: R$ %.2f", precoFinal);

		ler.close();
	}
}
