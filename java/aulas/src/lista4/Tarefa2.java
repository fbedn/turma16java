package lista4;

import java.util.Random;
import java.util.Scanner;

public class Tarefa2 {

	/*
	 * Um dado é lançado 10 vezes e o valor correspondente é anotado. Faça um
	 * programa que gere um vetor com os lançamentos, escreva esse vetor. A seguir
	 * determine e imprima a média aritmética dos lançamentos, contabilize e
	 * apresente também quantas foram as ocorrências da maior pontuação.
	 */

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		final int n = 10; // número de lançamentos
		int lancamentos[] = new int[n]; // vetor de lançamentos
		int maior = 0; // maior valor de lançamento
		int qtdMaior = 0; // quantidade de vezes que apareceu o maior valor
		double somaLancamentos = 0; // soma dos lançamentos
		double mediaLancamentos; // média dos lançamentos

		Random r = new Random();
		for (int i = 0; i < n; i++) {

			lancamentos[i] = r.nextInt(6) + 1; // gera um número de 1 a 6 e coloca na variável dos lançamentos

			somaLancamentos += lancamentos[i];

			if (lancamentos[i] > maior) {
				maior = lancamentos[i];
			}
		}

		// verifica a quantidade de ocorrências do maior valor
		for (int i = 0; i < n; i++) {
			if (lancamentos[i] == maior) {
				++qtdMaior;
			}
		}

		mediaLancamentos = (somaLancamentos) / n;

		// saída
		System.out.println("Lançamentos realizados:\n");
		for (int lanc : lancamentos) {
			System.out.print(lanc + "  ");
		}
		System.out.printf("\n\nMédia dos lançamentos: %.2f\n", mediaLancamentos);
		System.out.println("Maior valor dos lançamentos: " + maior);
		System.out.println("Quantidade de vezes que o maior valor apareceu: " + qtdMaior + " vezes");

		ler.close();
	}
}
