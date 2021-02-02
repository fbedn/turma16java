package exemplos;

import java.util.Scanner;

import entidades.Pessoa;

public class CadAmigos {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		Pessoa pessoa = new Pessoa();

		System.out.println("Seu nome: ");
		pessoa.nome = ler.next();
		System.out.println("Seu gênero [m/f/o]: ");
		pessoa.genero = ler.next().toUpperCase().charAt(0);
		System.out.println("Seu ano de nascimento [aaaa]: ");
		pessoa.anoNascimento = ler.nextInt();

		System.out.println("\nOlá " + pessoa.pronome() + " " + pessoa.nome + "!\n");
		if (pessoa.idade() < 18) {
			System.out.println("Desculpe, é proibida a venda de bebidas alcoólicas a menores de 18 anos");
		} else {
			System.out.println("Você está na Adega Canabrava\nFique à vontade e não esqueça de visitar nossa área de degustação!!");
		}

		ler.close();
	}

}
