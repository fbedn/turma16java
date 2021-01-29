package lista4;

import java.util.Scanner;

public class Tarefa4 {

	/*
	 * Crie um programa que receba valores do usuário para preencher uma matriz 3X3,
	 * e em seguida, exiba a soma dos valores dela e a soma dos valores da primeira
	 * diagonal, ou seja, diagonal principal.
	 */

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		final int N_LINHAS = 3;
		final int N_COLUNAS = 3;
		double matriz[][] = new double[N_LINHAS][N_COLUNAS];
		double somaDiagPrinc = 0.0;

		// leitura da entrada
		for (int i = 0; i < N_LINHAS; i++) {
			System.out.println("LINHA " + i);
			for (int j = 0; j < N_COLUNAS; j++) {
				System.out.print(
						"Digite o elemento da linha " + i + " e coluna " + j + " (elemento [" + i + "][" + j + "]):");
				matriz[i][j] = ler.nextDouble();
			}
		}

		// saída
		System.out.println("\nMATRIZ INFORMADA:");
		for (int i = 0; i < N_LINHAS; i++) {
			System.out.println();
			for (int j = 0; j < N_COLUNAS; j++) {
				System.out.printf("\t%.1f", matriz[i][j]);
			}
		}
		// questão da diagonal principal
		if (N_LINHAS == N_COLUNAS) {
			// calcula a diagonal principal
			for (int k = 0; k < N_LINHAS; k++) {
				somaDiagPrinc = somaDiagPrinc + matriz[k][k];
			}
			System.out.printf("\n\nSOMA DA DIAGONAL PRINCIPAL: %.1f\n", somaDiagPrinc);
		} else {// senao, não há diagonal principal
			System.out.print("\n\nNÃO HÁ DIAGONAL PRINCIPAL\n");
		}

		ler.close();
	}
}
