package lista1;

import java.util.Scanner;

public class Tarefa2 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		int idade, anos, meses, dias;
		System.out.print("Digite o número total de dias vividos: ");
		idade = ler.nextInt();

		anos = (idade / 365);
		meses = (idade % 365) / 30;
		dias = (idade % 365) % 30;

		System.out.print(anos + " anos " + meses + " meses " + dias + " dias");

		ler.close();
	}
}
