package aulas;

import java.util.Scanner;

public class Desafio_2021_01_28_d02 {

	/*
	 * Faça um programa que pegue um número do teclado e calcule a soma de todos os
	 * números de 1 até ele. Ex.: o usuário entra 7, o programa vai mostrar 28, pois
	 * 1+2+3+4+5+6+7=28. Utilizar o do...while
	 */

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		int n;
		System.out.println(
				"Soma dos números de 1 até um número inteiro positivo n\n\nInsira um número inteiro positivo:");
		n = ler.nextInt();

		if (n < 1) {
			System.out.println("\nO programa só funciona com número maior ou igual a 1");
		} else { //n >= 1

			int nAtual = 1;
			int somatorio = 0;
			do {
				//imprime o número que está somando
				if (nAtual == 1) System.out.print(nAtual);
				else System.out.print(" + "+nAtual);
				//calcula o somatório
				somatorio = somatorio + nAtual;
				++nAtual;
			} while (nAtual <= n);
			System.out.println("\n= " + somatorio);
		}

		ler.close();
	}
}
