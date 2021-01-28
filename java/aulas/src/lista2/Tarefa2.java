package lista2;

import java.util.Scanner;

public class Tarefa2 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		final int n = 3;
		double numero1, numero2, numero3;
		double vetorOrganizado[] = new double[n];

		System.out.println("Digite um número:");
		numero1 = ler.nextDouble();
		System.out.println("Digite mais um número:");
		numero2 = ler.nextDouble();
		System.out.println("Digite o último número:");
		numero3 = ler.nextDouble();

		// iniclializando o vetor
		vetorOrganizado[0] = numero1;
		vetorOrganizado[1] = numero2;
		vetorOrganizado[2] = numero3;

		// selection sort
		for (int i = 0; i < n; ++i) { // para cada posição, procurará e colocará o menor elemento
			int iMenorEl = i; // índice do menor elemento
			for (int j = i + 1; j < n; ++j) { // verifica de i+1 para frente
				if (vetorOrganizado[j] < vetorOrganizado[iMenorEl]) { // encontra o menor elemento
					iMenorEl = j;
				}
			}
			// troca o elemento da posição i com o menor elemento encontrado
			double aux = vetorOrganizado[i];
			vetorOrganizado[i] = vetorOrganizado[iMenorEl];
			vetorOrganizado[iMenorEl] = aux;
		}

		// saída de informações
		System.out.println("Números em ordem");
		for (int i = 0; i < n; ++i) {
			System.out.printf("%.0f ", vetorOrganizado[i]);
		}

		ler.close();
	}
}
