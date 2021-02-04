package listaPOO02;

import java.util.Locale;
import java.util.Scanner;

public class TestaPessoa {

	public static void main(String[] args) {
		
		Locale.setDefault(new Locale ("en", "US")); //serve, entre outras coisas, para o sinal de decimal ser um ponto
		Scanner ler = new Scanner(System.in);

		Pessoa pessoa = new Pessoa();
		
		System.out.println("Digite seu nome:");
		pessoa.setNome(ler.nextLine());
		System.out.println("Digite seu endereço:");
		pessoa.setEndereco(ler.nextLine());
		System.out.println("Digite seu telefone:");
		pessoa.setTelefone(ler.nextLine());
		
		char comando;
		while (true) {
			System.out.printf("_______________________________________\n"
								+ "Olá %s\n", pessoa.getNome());
			System.out.print("\nComandos:\n"
								+ "e - ver endereço\n"
								+ "a - atualizar endereço\n"
								+ "t - ver telefone\n"
								+ "b - atualizar telefone\n"
								+ "n - atualizar nome\n"
								+ "q - sair\n");
			comando = ler.next().toLowerCase().charAt(0);
			if (comando == 'e') {
				System.out.println("Endereço: "+pessoa.getEndereco());
			} else if (comando == 'a') {
				System.out.println("Digite seu endereço:");
				ler.nextLine();
				pessoa.setEndereco(ler.nextLine());
			} else if (comando == 't') {
				System.out.println("Telefone: "+pessoa.getTelefone());
			} else if (comando == 'b') {
				System.out.println("Digite seu telefone:");
				ler.nextLine();
				pessoa.setTelefone(ler.nextLine());
			} else if (comando == 'n') {
				System.out.println("Digite seu nome:");
				ler.nextLine();
				pessoa.setNome(ler.nextLine());
			} else if (comando == 'q') {
				break;
			}
		}
		System.out.println("Fim do programa");
		ler.close();
	}
}
