package lista4;

import java.util.Scanner;

public class Tarefa1 {

	public static void main(String[] args) {

		/*
		 * Faça um programa que crie um vetor por leitura com 5 valores de pontuação de
		 * uma atividade e o escreva em seguida. Encontre após a maior pontuação e a
		 * apresente.
		 */

		Scanner ler = new Scanner(System.in);

		double pontuacao[] = new double[5];
		double maiorPontuacao = 0;

		for (int i = 0; i < 5; i++) {
			System.out.println("Informe uma nota de 0.00 a 10.00:");
			pontuacao[i] = ler.nextDouble();
			if (pontuacao[i] > maiorPontuacao) {
				maiorPontuacao = pontuacao[i];
			}
		}

		// saída
		System.out.println("\nNOTAS INFORMADAS:");
		for (int i = 0; i < 5; i++) {
			System.out.println("pontuação " + i + ":\t" + pontuacao[i]);
		}
		System.out.println("\nMaior pontuação: " + maiorPontuacao);
		ler.close();
	}
}
