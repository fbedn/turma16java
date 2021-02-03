package lista5;

import java.util.Locale;
import java.util.Scanner;

public class UsaContaBancaria {
	
	/*
	 * EXERCÍCIO 6
	 * Crie uma classe conta bancaria e apresente os atributos e métodos referentes esta classe.
	 * Em seguida crie um objeto conta bancaria, defina as instâncias deste objeto e apresente as 
	 * informações deste objeto no console.
	 */


	public static void main(String[] args) {
		
		Locale.setDefault(new Locale ("en", "US")); //serve, entre outras coisas, para o sinal de decimal ser um ponto
		
		Scanner ler = new Scanner(System.in);

		ContaBancaria conta = new ContaBancaria(100607,"Zé Bonitinho", 6854.72);

		char comando;
		while (true) {
			System.out.printf("_______________________________________\n"
								+ "BANCO BRASUCA\n"
								+ "Número da conta:\t %d\n"
								+ "Titular:\t\t %s\n"
								+ "Saldo:\t\t\t R$ %.2f\n",
								conta.getNumeroConta(), conta.getTitular(), conta.getSaldo());
			System.out.print("\nComandos:\n"
								+ "d - depositar\n"
								+ "e - debitar\n"
								+ "q - sair\n");
			comando = ler.next().toLowerCase().charAt(0);
			if (comando == 'd') {
				System.out.print("Valor a depositar: R$ ");
				double valor = ler.nextDouble();
				conta.depositar(valor);
			} else if (comando == 'e') {
				System.out.print("Valor a debitar: R$ ");
				double valor = ler.nextDouble();
				conta.debitar(valor);
			} else if (comando == 'q') {
				break;
			}
		}
		System.out.println("Fim do programa");
		ler.close();

	}

}
