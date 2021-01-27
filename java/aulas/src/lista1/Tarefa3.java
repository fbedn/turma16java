package lista1;

import java.util.Scanner;

public class Tarefa3 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		int totalSegundos, horas, minutos, segundos;

		System.out.print("Digite o tempo total em segundos: ");

		totalSegundos = ler.nextInt();

		horas = (totalSegundos / 3600);
		minutos = (totalSegundos % 3600) / 60;
		segundos = (totalSegundos % 3600) % 60;

		System.out.println("\n" + horas + "h " + minutos + "min " + segundos + "s");

		ler.close();
	}
}
