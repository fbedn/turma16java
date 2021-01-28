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
						+ "1 - CONTA POUPAN�A\n"
						+ "2 - CONTA CORRENTE\n"
						+ "3 - CONTA ESPECIAL\n"
						+ "4 - CONTA EMPRESA\n"
						+ "5 - CONTA ESTUDANTIL\n"
						+ "6 - SAIR\n\n"
						+ "SELECIONE O TIPO DE CONTA: ");
				
				opcao = ler.nextInt();
				
				if (opcao == 1)
				{
					System.out.println("\nCONTA POUPAN�A");
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
			System.out.println("\nDESEJA ACESSAR O BANCO COM OUTRO USU�RIO? [1 - SIM / 2 - N�O]");
			opcaoExterna = ler.nextInt();
		}
		
		ler.close();
	}
	
	
	static double menuContaCorrente(Scanner ler, double saldo)
	{
		
		System.out.println("SELECIONE O MOVIMENTO (D�BITO OU CR�DITO) - D/C:");
		char movimento = ler.next().charAt(0);
		System.out.println("VALOR:");
		double valor = ler.nextDouble();
		System.out.println("DESCRI��O:");
		String descricao = ler.next();
		System.out.printf("\nSALDO ATUAL: R$ %.2f\n",saldo);
		System.out.println("\nCONFIRMA A OPERA��O? S/N:");
		char continua = ler.next().charAt(0);
		/*o c�digo abaixo tentar� realizar a opera��o de d�bito ou cr�dito*/
		if (continua == 's' || continua == 'S')
		{
			if (movimento == 'd' || movimento == 'D') //d�bito
			{
				if (saldo - valor >= 0) //verifica se o saldo fica positivo
				{
					saldo = saldo - valor;
					System.out.println("OPERA��O REALIZADA COM SUCESSO!");
				}
				else System.out.println("N�O FOI POSS�VEL REALIZAR A OPERA��O, POIS N�O H� SALDO O SUFICIENTE...\nCANCELANDO OPERA��O...");
			}
			else if (movimento == 'c' || movimento == 'C') //cr�dito
			{
				saldo = saldo + valor;
				System.out.println("OPERA��O REALIZADA COM SUCESSO!");
			}
			else System.out.println("OP��O "+movimento+" INV�LIDA...\nCANCELANDO OPERA��O...");
			
			System.out.printf("\nSALDO ATUAL: R$ %.2f\n",saldo);
		}
		else System.out.println("OPERA��O CANCELADA...\n");
		
		/*parte referente aos tal�es de cheque*/
		System.out.println("\nDESEJA EMITIR TAL�ES DE CHEQUE? S/N");
		continua = ler.next().charAt(0);
		if (continua == 's' || continua == 'S')
		{
			int qtdTaloes;
			do
			{
				System.out.println("QUANTIDADE DE TAL�ES DE CHEQUE:");
				qtdTaloes = ler.nextInt();
				if (qtdTaloes < 0 || qtdTaloes>3)
				{
					System.out.println("VOC� S� PODE ESCOLHER ENTRE 1 E 3 TAL�ES DE CHEQUE. INSERIR UMA OUTRA QUANTIDADE? S/N:");
					continua = ler.next().charAt(0);
					if (continua != 's' && continua != 'S') //sai do loop se o usu�rio n�o responder sim � pergunta anterior
					{
						break;
					}
				}
				if (qtdTaloes >= 0 && qtdTaloes <= 3) //se a quantidade de tal�es est� dentro do aceit�vel
				{
					System.out.println("IMPRIMINDO TAL�ES DE CHEQUE... ... ... FINALIZADO!");
				}
			} while (qtdTaloes < 0 || qtdTaloes>3);
			
		}
		
		return saldo;
	}
	
}
