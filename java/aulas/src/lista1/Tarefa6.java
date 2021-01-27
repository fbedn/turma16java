package lista1;

import java.util.Scanner;

public class Tarefa6 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		double x1, y1, x2, y2, d;
		System.out.print("Coordenadas do Ponto 1\nx1 = ");
		x1 = ler.nextDouble();
		System.out.print("y1 = ");
		y1 = ler.nextDouble();
		System.out.print("Coordenadas do Ponto 2\nx2 = ");
		x2 = ler.nextDouble();
		System.out.print("y2 = ");
		y2 = ler.nextDouble();

		double termo1 = Math.pow((x2 - x1), 2);
		double termo2 = Math.pow((y2 - y1), 2);
		d = Math.sqrt(termo1 + termo2);

		System.out.printf("Distância d = %.2f", d);

		ler.close();
	}
}
