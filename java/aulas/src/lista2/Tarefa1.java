package lista2;

import java.util.Scanner;

public class Tarefa1 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		double numero1, numero2, numero3;
		double maiorNumero;

		System.out.println("Digite um número:");
		numero1 = ler.nextDouble();
		System.out.println("Digite mais um número:");
		numero2 = ler.nextDouble();
		System.out.println("Digite o último número:");
		numero3 = ler.nextDouble();

		maiorNumero = numero1;
		if (numero2 > maiorNumero)
			maiorNumero = numero2;
		if (numero3 > maiorNumero)
			maiorNumero = numero3;

		System.out.printf("O maior número é : %.2f\n", maiorNumero);

		ler.close();
	}

}
