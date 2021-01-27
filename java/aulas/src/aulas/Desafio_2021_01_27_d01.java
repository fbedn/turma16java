package aulas;

import java.util.Scanner;

public class Desafio_2021_01_27_d01 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		int numero;
		System.out.println("Escreva um número inteiro positivo:");
		numero = ler.nextInt();
		if (numero < 0) {
			System.out.println("O programa apenas funciona com números maiores ou iguais a zero");
		} else if (numero == 0) {
			System.out.println("\n0 (zero) neste programa é considerado neutro\n");
		} else {
			if (numero % 2 == 0) { // verifica o resto da divisão por 2
				System.out.println(numero + " é par");
			} else {
				System.out.println(numero + " é ímpar");
			}
		}

		ler.close();
	}
}
