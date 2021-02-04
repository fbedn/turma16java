package listaPOO02;

import java.util.Locale;
import java.util.Scanner;

public class TestaVendedor {

	public static void main(String[] args) {
		
		Locale.setDefault(new Locale ("en", "US")); //serve, entre outras coisas, para o sinal de decimal ser um ponto
		Scanner ler = new Scanner(System.in);

		Vendedor vendedor = new Vendedor();
		
		System.out.println("Digite seu nome:");
		vendedor.setNome(ler.nextLine());
		System.out.println("Digite seu endere�o:");
		vendedor.setEndereco(ler.nextLine());
		System.out.println("Digite seu telefone:");
		vendedor.setTelefone(ler.nextLine());
		
		char comando;
		while (true) {
			System.out.printf("_______________________________________\n"
								+ "Ol� vendedor %s\n"
								+ "Total de suas vendas: R$ %.2f\n"
								+ "Porcentagem de comiss�o: %.2f %%\n"
								+ "Total das suas comiss�es: R$ %.2f\n",
								vendedor.getNome(), vendedor.getValorVendas(), vendedor.getComissao(), vendedor.valorComissoes());
			System.out.print("\nComandos:\n"
								+ "c - inserir venda\n"
								+ "e - ver endere�o\n"
								+ "t - ver telefone\n"
								+ "q - sair\n");
			comando = ler.next().toLowerCase().charAt(0);
			if (comando == 'c') {
				System.out.print("Valor da venda: R$ ");
				double valor = ler.nextDouble();
				vendedor.inserirVenda(valor);
			} else if (comando == 'e') {
				System.out.println("Endere�o: "+vendedor.getEndereco());
			} else if (comando == 't') {
				System.out.println("Telefone: "+vendedor.getTelefone());
			} else if (comando == 'q') {
				break;
			}
		}
		System.out.println("Fim do programa");
		ler.close();
	}
}
