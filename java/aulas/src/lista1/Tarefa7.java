package lista1;

import java.util.Scanner;

public class Tarefa7 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		double a, b, c, d, e, f, x, y; // coeficientes e variáveis
		System.out.print("Digite o coeficiente a: ");
		a = ler.nextDouble();
		System.out.print("Digite o coeficiente b: ");
		b = ler.nextDouble();
		System.out.print("Digite o coeficiente c: ");
		c = ler.nextDouble();
		System.out.print("Digite o coeficiente d: ");
		d = ler.nextDouble();
		System.out.print("Digite o coeficiente e: ");
		e = ler.nextDouble();
		System.out.print("Digite o coeficiente f: ");
		f = ler.nextDouble();
		x = ((c * e) - (b * f)) / ((a * e) - (b * d));
		y = ((a * f) - (c * d)) / ((a * e) - (b * d));

		System.out.printf("x = %.2f\ny = %.2f", x, y);

		ler.close();
	}
}
