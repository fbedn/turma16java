package listaPOO02;

import java.util.Locale;
import java.util.Scanner;

public class TestaFornecedor {

	public static void main(String[] args) {
		
		Locale.setDefault(new Locale ("en", "US")); //serve, entre outras coisas, para o sinal de decimal ser um ponto
		Scanner ler = new Scanner(System.in);

		Fornecedor fornecedor = new Fornecedor();
		
		System.out.println("Digite seu nome:");
		fornecedor.setNome(ler.nextLine());
		System.out.println("Digite seu endere�o:");
		fornecedor.setEndereco(ler.nextLine());
		System.out.println("Digite seu telefone:");
		fornecedor.setTelefone(ler.nextLine());
		
		char comando;
		while (true) {
			System.out.printf("_______________________________________\n"
								+ "Ol� fornecedor %s\n"
								+ "Saldo atual: R$ %.2f\n",
								fornecedor.getNome(), fornecedor.obterSaldo());
			System.out.print("\nComandos:\n"
								+ "c - inserir cr�dito\n"
								+ "d - inserir d�vida\n"
								+ "e - ver endere�o\n"
								+ "t - ver telefone\n"
								+ "q - sair\n");
			comando = ler.next().toLowerCase().charAt(0);
			if (comando == 'c') {
				System.out.print("Valor do cr�dito a colocar: R$ ");
				double valor = ler.nextDouble();
				fornecedor.inserirCredito(valor);
			} else if (comando == 'd') {
				System.out.print("Valor da nova d�vida: R$ ");
				double valor = ler.nextDouble();
				fornecedor.inserirDivida(valor);
			} else if (comando == 'e') {
				System.out.println("Endere�o: "+fornecedor.getEndereco());
			} else if (comando == 't') {
				System.out.println("Telefone: "+fornecedor.getTelefone());
			} else if (comando == 'q') {
				break;
			}
		}
		System.out.println("Fim do programa");
		ler.close();
	}

}
