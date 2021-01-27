package lista1;

import java.util.Scanner;

public class Tarefa5 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		double nota1, nota2, nota3, media;
		System.out.print("Nota 1 do aluno: ");
		nota1 = ler.nextInt();
		System.out.print("Nota 2 do aluno: ");
		nota2 = ler.nextInt();
		System.out.print("Nota 3 do aluno: ");
		nota3 = ler.nextInt();

		media = (nota1 * 0.2) + (nota2 * 0.3) + (nota3 * 0.5);

		System.out.printf("Media final = %.2f", media);

		ler.close();
	}
}
