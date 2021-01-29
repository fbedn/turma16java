package lista3;

import java.util.Scanner;

public class Tarefa3 {

	/*
	 * Solicitar a idade de várias pessoas e imprimir: Total de pessoas com menos de
	 * 21 anos. Total de pessoas com mais de 50 anos. O programa termina quando
	 * idade for =-99 (USAR WHILE)
	 **/

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		int n;
		int totalMenores21 = 0;
		int totalMaiores50 = 0;

		System.out.println("Digite o número de pessoas a inserir a idade: ");
		n = ler.nextInt();

		int i = 0;
		while (i < n) {
			System.out.println("Digite a idade da pessoa " + (i + 1) + " :");
			int idade = ler.nextInt();
			if (idade < 21) {
				++totalMenores21;
			} else if (idade > 50) {
				++totalMaiores50;
			}
			i++;
		}
		System.out.println("Total de pessoas com menos de 21 anos: " + totalMenores21);
		System.out.println("Total de pessoas com mais de 50 anos: " + totalMaiores50);

		ler.close();
	}
}
