package lista1;

import java.util.Scanner;

public class Tarefa4 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		int A, B, C;
		double R, S, D;
		System.out.print("Escreva um número inteiro positivo: A = ");
		A = ler.nextInt();
		System.out.print("Escreva um número inteiro positivo: B = ");
		B = ler.nextInt();
		System.out.print("Escreva um número inteiro positivo: C = ");
		C = ler.nextInt();

		R = Math.pow((A + B), 2);
		S = Math.pow((B + C), 2);
		D = (R + S) / 2;

		System.out.printf("D = (R+S)/2 = %.2f",D);

		ler.close();
	}
}
