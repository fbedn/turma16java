package lista1;

import java.util.Scanner;

public class Tarefa1 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		int anos, meses, dias, diasTotais;

		System.out.print("Informe n�mero de anos completos da pessoa: ");
		anos = ler.nextInt();
		System.out.print("Informe n�mero de meses (a partir do �ltimo anivers�rio) da pessoa: ");
		meses = ler.nextInt();
		System.out.print("Informe n�mero de dias (a partir do �ltimo m�s completo): ");
		dias = ler.nextInt();

		diasTotais = (anos * 365) + (meses * 30) + dias;

		System.out.println("N�mero (aproximado) de dias vividos : " + diasTotais);

		ler.close();
	}
}
