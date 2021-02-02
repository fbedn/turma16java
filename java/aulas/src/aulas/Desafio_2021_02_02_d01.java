package aulas;

import java.util.Scanner;

public class Desafio_2021_02_02_d01 {
	
	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		
		double base, altura, areaTriang1, areaTriang2, areaTriang3, maiorArea;
		int maior;
		
		System.out.println("Digite a base do primeiro triângulo: ");
		base = ler.nextDouble();
		System.out.println("Digite a altura do primeiro triângulo: ");
		altura = ler.nextDouble();
		areaTriang1 = (base * altura) / 2;
		
		System.out.println("Digite a base do segundo triângulo: ");
		base = ler.nextDouble();
		System.out.println("Digite a altura do segundo triângulo: ");
		altura = ler.nextDouble();
		areaTriang2 = (base * altura) / 2;
		
		System.out.println("Digite a base do terceiro triângulo: ");
		base = ler.nextDouble();
		System.out.println("Digite a altura do terceiro triângulo: ");
		altura = ler.nextDouble();
		areaTriang3 = (base * altura) / 2;
		
		maiorArea = areaTriang1;
		maior = 1;
		if (areaTriang2 > maiorArea) {
			maiorArea = areaTriang2;
			maior = 2;
		}
		if (areaTriang3 > maiorArea) {
			maiorArea = areaTriang3;
			maior = 3;
		}
		
		System.out.println("O Triângulo "+maior+" é o maior, e tem área "+maiorArea);
		
		ler.close();
	}
}
