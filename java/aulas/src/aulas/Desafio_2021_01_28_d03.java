package aulas;

import java.util.Scanner;

public class Desafio_2021_01_28_d03
{
	
	public static void main(String[] args)
	{
		Scanner ler = new Scanner(System.in);
		
		int opcaoExterna = 1;
		
		while (opcaoExterna == 1)
		{
			
			int opcao = 0;
			double saldo = 0;
		
			while (true) {
			
				System.out.print("NOME DO BANCO G#"
						+ "\nSLOGAN - FRASE"
						+ "\n"
						+ "\n"
						+ "1 - CONTA POUPANÇA\n"
						+ "2 - CONTA CORRENTE\n"
						+ "3 - CONTA ESPECIAL\n"
						+ "4 - CONTA EMPRESA\n"
						+ "5 - CONTA ESTUDANTIL\n"
						+ "6 - SAIR\n\n"
						+ "SELECIONE O TIPO DE CONTA: ");
				
				opcao = ler.nextInt();
				
				if (opcao == 1)
				{
					System.out.println("\nCONTA POUPANÇA");
				}
				else if (opcao == 2)
				{
					System.out.println("\nCONTA CORRENTE");
					saldo = menuContaCorrente(ler, saldo);
					
				}
				else if (opcao == 3)
				{
					System.out.println("\nCONTA ESPECIAL ");
				}
				else if (opcao == 4)
				{
					System.out.println("\nCONTA EMPRESA");
				}
				else if (opcao == 5)
				{
					System.out.println("\nCONTA ESTUDANTIL");
				}
				else if (opcao == 6)
				{
					System.out.print("SAINDO DA SUA CONTA...");
					break; //sai do loop
				}
				System.out.println("\n");
			}
			System.out.println("\nDESEJA ACESSAR O BANCO COM OUTRO USUÁRIO? [1 - SIM / 2 - NÃO]");
			opcaoExterna = ler.nextInt();
		}
		
		ler.close();
	}
	
	
	static double menuContaCorrente(Scanner ler, double saldo)
	{
		
		System.out.println("SELECIONE O MOVIMENTO (DÉBITO OU CRÉDITO) - D/C:");
		char movimento = ler.next().charAt(0);
		System.out.println("VALOR:");
		double valor = ler.nextDouble();
		System.out.println("DESCRIÇÃO:");
		String descricao = ler.next();
		System.out.printf("\nSALDO ATUAL: R$ %.2f\n",saldo);
		System.out.println("\nCONFIRMA A OPERAÇÃO? S/N:");
		char continua = ler.next().charAt(0);
		/*o código abaixo tentará realizar a operação de débito ou crédito*/
		if (continua == 's' || continua == 'S')
		{
			if (movimento == 'd' || movimento == 'D') //débito
			{
				if (saldo - valor >= 0) //verifica se o saldo fica positivo
				{
					saldo = saldo - valor;
					System.out.println("OPERAÇÃO REALIZADA COM SUCESSO!");
				}
				else System.out.println("NÃO FOI POSSÍVEL REALIZAR A OPERAÇÃO, POIS NÃO HÁ SALDO O SUFICIENTE...\nCANCELANDO OPERAÇÃO...");
			}
			else if (movimento == 'c' || movimento == 'C') //crédito
			{
				saldo = saldo + valor;
				System.out.println("OPERAÇÃO REALIZADA COM SUCESSO!");
			}
			else System.out.println("OPÇÃO "+movimento+" INVÁLIDA...\nCANCELANDO OPERAÇÃO...");
			
			System.out.printf("\nSALDO ATUAL: R$ %.2f\n",saldo);
		}
		else System.out.println("OPERAÇÃO CANCELADA...\n");
		
		/*parte referente aos talões de cheque*/
		System.out.println("\nDESEJA EMITIR TALÕES DE CHEQUE? S/N");
		continua = ler.next().charAt(0);
		if (continua == 's' || continua == 'S')
		{
			int qtdTaloes;
			do
			{
				System.out.println("QUANTIDADE DE TALÕES DE CHEQUE:");
				qtdTaloes = ler.nextInt();
				if (qtdTaloes < 0 || qtdTaloes>3)
				{
					System.out.println("VOCÊ SÓ PODE ESCOLHER ENTRE 1 E 3 TALÕES DE CHEQUE. INSERIR UMA OUTRA QUANTIDADE? S/N:");
					continua = ler.next().charAt(0);
					if (continua != 's' && continua != 'S') //sai do loop se o usuário não responder sim à pergunta anterior
					{
						break;
					}
				}
				if (qtdTaloes >= 0 && qtdTaloes <= 3) //se a quantidade de talões está dentro do aceitável
				{
					System.out.println("IMPRIMINDO TALÕES DE CHEQUE... ... ... FINALIZADO!");
				}
			} while (qtdTaloes < 0 || qtdTaloes>3);
			
		}
		
		return saldo;
	}
	
}
