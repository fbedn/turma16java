package aulas;

import java.util.Scanner;

public class Desafio_2021_01_28_d02 {

	/*
	 * Fa�a um programa que pegue um n�mero do teclado e calcule a soma de todos os
	 * n�meros de 1 at� ele. Ex.: o usu�rio entra 7, o programa vai mostrar 28, pois
	 * 1+2+3+4+5+6+7=28. Utilizar o do...while
	 */

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		int n;
		System.out.println(
				"Soma dos n�meros de 1 at� um n�mero inteiro positivo n\n\nInsira um n�mero inteiro positivo:");
		n = ler.nextInt();

		if (n < 1) {
			System.out.println("\nO programa s� funciona com n�mero maior ou igual a 1");
		} else { //n >= 1

			int nAtual = 1;
			int somatorio = 0;
			do {
				//imprime o n�mero que est� somando
				if (nAtual == 1) System.out.print(nAtual);
				else System.out.print(" + "+nAtual);
				//calcula o somat�rio
				somatorio = somatorio + nAtual;
				++nAtual;
			} while (nAtual <= n);
			System.out.println("\n= " + somatorio);
		}

		ler.close();
	}
}
