package lista1;

import java.util.Scanner;

public class Tarefa1 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		int anos, meses, dias, diasTotais;

		System.out.print("Informe número de anos completos da pessoa: ");
		anos = ler.nextInt();
		System.out.print("Informe número de meses (a partir do último aniversário) da pessoa: ");
		meses = ler.nextInt();
		System.out.print("Informe número de dias (a partir do último mês completo): ");
		dias = ler.nextInt();

		diasTotais = (anos * 365) + (meses * 30) + dias;

		System.out.println("Número (aproximado) de dias vividos : " + diasTotais);

		ler.close();
	}
}
