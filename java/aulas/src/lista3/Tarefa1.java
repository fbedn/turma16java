package lista3;

import java.util.Scanner;

public class Tarefa1 {

	/*
	 * Informar todos os n�meros (inteiros) de 1000 a 1999 que quando divididos por
	 * 11 obtemos resto = 5 (USAR O FOR)
	 */

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		final int inicio = 1000;
		final int fim = 1999;

		System.out.println("N�meros inteiros de 1000 a 1999, que quando divididos por 11, o resto � 5:\n");
		for (int numero = inicio; numero <= fim; numero++) {
			if (numero % 11 == 5) { // se o resto da divis�o por 11 for 5
				System.out.println(numero);
			}
		}

		ler.close();
	}

}
