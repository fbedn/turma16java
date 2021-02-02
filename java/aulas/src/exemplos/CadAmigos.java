package exemplos;

import java.util.Scanner;

import entidades.Pessoa;

public class CadAmigos {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		Pessoa pessoa = new Pessoa();

		System.out.println("Seu nome: ");
		pessoa.nome = ler.next();
		System.out.println("Seu g�nero [m/f/o]: ");
		pessoa.genero = ler.next().toUpperCase().charAt(0);
		System.out.println("Seu ano de nascimento [aaaa]: ");
		pessoa.anoNascimento = ler.nextInt();

		System.out.println("\nOl� " + pessoa.pronome() + " " + pessoa.nome + "!\n");
		if (pessoa.idade() < 18) {
			System.out.println("Desculpe, � proibida a venda de bebidas alco�licas a menores de 18 anos");
		} else {
			System.out.println("Voc� est� na Adega Canabrava\nFique � vontade e n�o esque�a de visitar nossa �rea de degusta��o!!");
		}

		ler.close();
	}

}
