package aulas;

import java.util.Scanner;

public class Desafio_2021_02_02_d01 {
	
	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		
		double base, altura, areaTriang1, areaTriang2, areaTriang3, maiorArea;
		int maior;
		
		System.out.println("Digite a base do primeiro tri�ngulo: ");
		base = ler.nextDouble();
		System.out.println("Digite a altura do primeiro tri�ngulo: ");
		altura = ler.nextDouble();
		areaTriang1 = (base * altura) / 2;
		
		System.out.println("Digite a base do segundo tri�ngulo: ");
		base = ler.nextDouble();
		System.out.println("Digite a altura do segundo tri�ngulo: ");
		altura = ler.nextDouble();
		areaTriang2 = (base * altura) / 2;
		
		System.out.println("Digite a base do terceiro tri�ngulo: ");
		base = ler.nextDouble();
		System.out.println("Digite a altura do terceiro tri�ngulo: ");
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
		
		System.out.println("O Tri�ngulo "+maior+" � o maior, e tem �rea "+maiorArea);
		
		ler.close();
	}
}
