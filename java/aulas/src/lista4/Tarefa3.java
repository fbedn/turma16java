package lista4;

import java.util.Scanner;

public class Tarefa3 {

	/*
	 * Escreve um programa que lê duas matrizes N1 (4,6) e N2(4,6) e cria:
	 * a) Uma matriz M1 cujos elementos serão as somas dos elementos de mesma posição das matrizes N1 e N2; 
	 * b) Uma matriz M2 cujos elementos serão as diferenças dos elementos de mesma posição das matrizes N1 e N2.
	 */

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		final int N_LINHAS = 4;
		final int N_COLUNAS = 6;

		double N1[][] = new double[N_LINHAS][N_COLUNAS];
		double N2[][] = new double[N_LINHAS][N_COLUNAS];

		double M1[][] = new double[N_LINHAS][N_COLUNAS];
		double M2[][] = new double[N_LINHAS][N_COLUNAS];

		// monta matriz N1
		System.out.println("MATRIZ N1");
		for (int i = 0; i < N_LINHAS; i++) {
			System.out.println("Linha " + i);
			for (int j = 0; j < N_COLUNAS; j++) {
				System.out.println(
						"Digite o elemento da linha " + i + " e coluna " + j + " (elemento [" + i + "][" + j + "]):");
				N1[i][j] = ler.nextDouble();
			}
		}
		// monta matriz N2
		System.out.println("MATRIZ N2");
		for (int i = 0; i < N_LINHAS; i++) {
			System.out.println("Linha " + i);
			for (int j = 0; j < N_COLUNAS; j++) {
				System.out.println(
						"Digite o elemento da linha " + i + " e coluna " + j + " (elemento [" + i + "][" + j + "]):");
				N2[i][j] = ler.nextDouble();
			}
		}

		// calcula matriz M1
		for (int i = 0; i < N_LINHAS; i++) {
			for (int j = 0; j < N_COLUNAS; j++) {
				M1[i][j] = N1[i][j] + N2[i][j];
			}
		}
		// calcula matriz M2
		for (int i = 0; i < N_LINHAS; i++) {
			for (int j = 0; j < N_COLUNAS; j++) {
				M2[i][j] = N1[i][j] - N2[i][j];
			}
		}

		// saída matriz N1
		System.out.println("\n\nMATRIZ INFORMADA N1:");
		for (int i = 0; i < N_LINHAS; i++) {
			System.out.println();
			for (int j = 0; j < N_COLUNAS; j++) {
				System.out.printf("\t%.1f", N1[i][j]);
			}
		}
		// saída matriz N2
		System.out.println("\n\nMATRIZ INFORMADA N2:");
		for (int i = 0; i < N_LINHAS; i++) {
			System.out.println();
			for (int j = 0; j < N_COLUNAS; j++) {
				System.out.printf("\t%.1f", N2[i][j]);
			}
		}
		// saída matriz M1
		System.out.println("\n\nMATRIZ CALCULADA M1:");
		for (int i = 0; i < N_LINHAS; i++) {
			System.out.println();
			for (int j = 0; j < N_COLUNAS; j++) {
				System.out.printf("\t%.1f", M1[i][j]);
			}
		}
		// saída matriz M2
		System.out.println("\n\nMATRIZ CALCULADA M2:");
		for (int i = 0; i < N_LINHAS; i++) {
			System.out.println();
			for (int j = 0; j < N_COLUNAS; j++) {
				System.out.printf("\t%.1f", M2[i][j]);
			}
		}
		ler.close();
	}
}
