package lista1;

import java.util.Scanner;

public class Tarefa7 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		double _a, _b, _c, _d, _e, _f, x, y; // coeficientes e variáveis
		System.out.print("Digite o coeficiente a: ");
		_a = ler.nextDouble();
		System.out.print("Digite o coeficiente b: ");
		_b = ler.nextDouble();
		System.out.print("Digite o coeficiente c: ");
		_c = ler.nextDouble();
		System.out.print("Digite o coeficiente d: ");
		_d = ler.nextDouble();
		System.out.print("Digite o coeficiente e: ");
		_e = ler.nextDouble();
		System.out.print("Digite o coeficiente f: ");
		_f = ler.nextDouble();
		x = ((_c * _e) - (_b * _f)) / ((_a * _e) - (_b * _d));
		y = ((_a * _f) - (_c * _d)) / ((_a * _e) - (_b * _d));

		System.out.printf("x = %.2f\ny = %.2f", x, y);

		ler.close();
	}
}
