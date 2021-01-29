package lista3;

import java.util.Scanner;

public class Tarefa5 {

	/*
	 * Crie um programa que leia um n�mero do teclado at� que encontre um n�mero
	 * igual a zero. No final, mostre a soma dos n�meros digitados. (USAR
	 * DO...WHILE)
	 */

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		double numero, somatorio = 0;

		do {
			System.out.println("Digite um n�mero:");
			numero = ler.nextDouble();
			somatorio += numero;
		} while (numero != 0);

		System.out.println("Somat�rio = " + somatorio);

		ler.close();
	}

}
