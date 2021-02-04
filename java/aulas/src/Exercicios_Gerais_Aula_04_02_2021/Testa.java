package Exercicios_Gerais_Aula_04_02_2021;

import java.util.Locale;

public class Testa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Empregado empregado1 = new Empregado("João",1234);
		Empregado empregado2 = new Empregado("José",1904, 160,205.99);
		
		Terceiro terceiro1 = new Terceiro("Renata",4567,160,205.99);
		Terceiro terceiro2 = new Terceiro("Joana",1116,100,100);
		
		System.out.println("----------------------------------------------------------------");
		System.out.printf("O valor do salario do funcionario %s é de: R$%.2f%n",empregado1.getNome(),empregado1.salario());
		empregado1.setHoras(100);
		empregado1.setValorHora(190.99);
		System.out.printf("O valor do salario do funcionario %s é de: R$%.2f%n",empregado1.getNome(),empregado1.salario());
		System.out.println("----------------------------------------------------------------");
		System.out.printf("O valor do salario do funcionario %s é de: R$%.2f%n",empregado2.getNome(),empregado2.salario());
		System.out.println("----------------------------------------------------------------");
		System.out.printf("O valor do salario do funcionario %s é de: R$%.2f%n",terceiro1.getNome(),terceiro1.salario());
		System.out.println("----------------------------------------------------------------");
		System.out.printf("O valor do salario do funcionario %s é de: R$%.2f%n",terceiro2.getNome(),terceiro2.salario());
		System.out.println("----------------------------------------------------------------");
	}

}
