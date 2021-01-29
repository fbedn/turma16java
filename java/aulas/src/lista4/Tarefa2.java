package lista4;

import java.util.Random;
import java.util.Scanner;

public class Tarefa2 {

	/*
	 * Um dado � lan�ado 10 vezes e o valor correspondente � anotado. Fa�a um
	 * programa que gere um vetor com os lan�amentos, escreva esse vetor. A seguir
	 * determine e imprima a m�dia aritm�tica dos lan�amentos, contabilize e
	 * apresente tamb�m quantas foram as ocorr�ncias da maior pontua��o.
	 */

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		final int n = 10; // n�mero de lan�amentos
		int lancamentos[] = new int[n]; // vetor de lan�amentos
		int maior = 0; // maior valor de lan�amento
		int qtdMaior = 0; // quantidade de vezes que apareceu o maior valor
		double somaLancamentos = 0; // soma dos lan�amentos
		double mediaLancamentos; // m�dia dos lan�amentos

		Random r = new Random();
		for (int i = 0; i < n; i++) {

			lancamentos[i] = r.nextInt(6) + 1; // gera um n�mero de 1 a 6 e coloca na vari�vel dos lan�amentos

			somaLancamentos += lancamentos[i];

			if (lancamentos[i] > maior) {
				maior = lancamentos[i];
			}
		}

		// verifica a quantidade de ocorr�ncias do maior valor
		for (int i = 0; i < n; i++) {
			if (lancamentos[i] == maior) {
				++qtdMaior;
			}
		}

		mediaLancamentos = (somaLancamentos) / n;

		// sa�da
		System.out.println("Lan�amentos realizados:\n");
		for (int lanc : lancamentos) {
			System.out.print(lanc + "  ");
		}
		System.out.printf("\n\nM�dia dos lan�amentos: %.2f\n", mediaLancamentos);
		System.out.println("Maior valor dos lan�amentos: " + maior);
		System.out.println("Quantidade de vezes que o maior valor apareceu: " + qtdMaior + " vezes");

		ler.close();
	}
}
