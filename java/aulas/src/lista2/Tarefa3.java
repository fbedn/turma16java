package lista2;

import java.util.Scanner;

public class Tarefa3 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		int idade;

		System.out.println("Digite a idade da pessoa:");
		idade = ler.nextInt();
		if (idade >= 10 && idade <= 14) {
			System.out.println("A pessoa está na categoria infantil");
		} else if (idade >= 15 && idade <= 17) {
			System.out.println("A pessoa está na categoria juvenil");
		} else if (idade >= 18 && idade <= 25) {
			System.out.println("A pessoa está na categoria adulto");
		} else {
			System.out.println("A pessoa está sem categoria");
		}

		ler.close();
	}
}
