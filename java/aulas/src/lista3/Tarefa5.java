package lista3;

import java.util.Scanner;

public class Tarefa5 {

	/*
	 * Crie um programa que leia um número do teclado até que encontre um número
	 * igual a zero. No final, mostre a soma dos números digitados. (USAR
	 * DO...WHILE)
	 */

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		double numero, somatorio = 0;

		do {
			System.out.println("Digite um número:");
			numero = ler.nextDouble();
			somatorio += numero;
		} while (numero != 0);

		System.out.println("Somatório = " + somatorio);

		ler.close();
	}

}
