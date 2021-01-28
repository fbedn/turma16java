package lista2;

import java.util.Scanner;

public class Tarefa4 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		int numero;

		System.out.println("Digite um n�mero inteiro:");
		numero = ler.nextInt();
		if (numero % 2 == 0) { // par
			System.out.printf("%d � par\n\n(%d)^2 = %.0f", numero, numero, Math.pow(numero, 2));
		} else { // �mpar
			System.out.printf("%d � �mpar\n\n", numero);

			if (numero < 0) {
				System.out.printf("n�o h� raiz quadrada real, pois %d � negativo", numero);
			} else { // numero >= 0
				System.out.printf(
						"raiz quadrada de %d = +-%.2f\nOBS: quando a raiz for irracional, o resultado � aproximado",
						numero, Math.sqrt(numero));
			}

		}

		ler.close();
	}
}
