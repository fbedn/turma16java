package aulas;

import java.util.Scanner;

public class MiniSistemaBancario {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		char opcao;

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

			opcao = ler.next().charAt(0);

			if (opcao == '1') {
				
				System.out.println("\nCONTA POUPANÇA");
				//menuContaPoupanca(ler);
			}
			else if (opcao == '2') {
				
				System.out.println("\nCONTA CORRENTE");
				menuContaCorrente(ler);
			}
			else if (opcao == '3') {
				
				System.out.println("\nCONTA ESPECIAL ");
				menuContaEspecial(ler);
			}
			else if (opcao == '4') {
				
				System.out.println("\nCONTA EMPRESA");
				//menuContaEmpresa(ler);
			}
			else if (opcao == '5') {
				
				System.out.println("\nCONTA ESTUDANTIL");
				menuContaEstudantil(ler);
			}
			else if (opcao == '6') {
				
				System.out.print("SAINDO DA SUA CONTA...");
				break; // sai do loop
			}
			System.out.println("\n");
		}

		ler.close();
	}
	
	/***FUNÇÃO DO MENU CONTA CORRENTE***/
	static void menuContaCorrente(Scanner ler) {
		
		double saldo = 0;
		
		int taloesEmitidos;
		
		for (int giro=1; giro<=10; giro++) {
			System.out.println("SELECIONE O MOVIMENTO (DÉBITO OU CRÉDITO) - D/C:");
			char movimento = ler.next().charAt(0);
			System.out.println("VALOR:");
			double valor = ler.nextDouble();
			System.out.println("DESCRIÇÃO:");
			String descricao = ler.next();
			System.out.printf("\nSALDO ATUAL: R$ %.2f\n", saldo);
			System.out.println("\nCONFIRMA A OPERAÇÃO? S/N:");
			char continua = ler.next().charAt(0);
			/* o código abaixo tentará realizar a operação de débito ou crédito */
			if (continua == 's' || continua == 'S') {
				if (movimento == 'd' || movimento == 'D') { // débito
					if (saldo - valor >= 0) { // verifica se o saldo fica positivo
						saldo = saldo - valor;
						System.out.println("OPERAÇÃO REALIZADA COM SUCESSO!");
					} else
						System.out.println("\nNÃO FOI POSSÍVEL REALIZAR A OPERAÇÃO, POIS NÃO HÁ SALDO O SUFICIENTE...\nCANCELANDO OPERAÇÃO...");
				} else if (movimento == 'c' || movimento == 'C') { // crédito
					saldo = saldo + valor;
					System.out.println("OPERAÇÃO REALIZADA COM SUCESSO!");
				} else
					System.out.println("OPÇÃO " + movimento + " INVÁLIDA...\nCANCELANDO OPERAÇÃO...");
	
				System.out.printf("\nSALDO ATUAL: R$ %.2f\n", saldo);
			} else
				System.out.println("OPERAÇÃO CANCELADA...\n");

			//parte referente aos talões de cheque
			System.out.println("\nDESEJA EMITIR TALÕES DE CHEQUE? S/N");
			continua = ler.next().charAt(0);
			if (continua == 's' || continua == 'S') {
				int qtdTaloes;
				do {
					System.out.println("QUANTIDADE DE TALÕES DE CHEQUE:");
					qtdTaloes = ler.nextInt();
					if (qtdTaloes <= 0 || qtdTaloes > 3) {
						System.out.println("VOCÊ PODE ESCOLHER ENTRE 1 E 3 TALÕES DE CHEQUE. INSERIR UMA OUTRA QUANTIDADE? S/N:");
						continua = ler.next().charAt(0);
						if (continua != 's' && continua != 'S') { // sai do loop se o usuário não responder sim à pergunta anterior
							break;
						}
					}
					if (qtdTaloes > 0 && qtdTaloes <= 3) { // se a quantidade de talões está dentro do aceitável
						System.out.println("\nIMPRIMINDO TALÕES DE CHEQUE... ... ... FINALIZADO!");
					}
				} while (qtdTaloes < 0 || qtdTaloes > 3);
			}
			
			System.out.println("REALIZA OUTRA OPERAÇÃO NA SUA CONTA CORRENTE? S/N :");
			continua = ler.next().charAt(0);
			if (continua == 'N' || continua == 'n') {
				System.out.printf("SALDO FINAL DA CONTA CORRENTE R$ %.2f \n", saldo);
				System.out.println();
				break;
			}
			
		}
	}

	/***FUNÇÃO DO MENU CONTA ESPECIAL***/
	static void menuContaEspecial(Scanner ler) {
		double total=0, limite=0, soma=0, valor = 0;
		char opcao, recomecar = 's', debtar= 'd', continuar='s' ;
		String descricao;
		
		System.out.println("\nVocê selecionou a conta especial.");
		for(int giro=0; giro<10; giro++) {
			do {
				System.out.println("Você deseja D - debtar ou C - creditar o valor da conta?");
				debtar = ler.next().charAt(0);
				if(debtar=='C' || debtar=='c') {
					System.out.println("Qual o valor?");
					valor = ler.nextDouble();
					total += valor;
					System.out.println("Qual a descriçao: ");
					descricao = ler.next();
				}
				else if(debtar=='D' || debtar=='d') {
					System.out.println("Qual o valor?");
					valor = ler.nextDouble();
					System.out.println("Qual a descriçao: ");
					descricao = ler.next();
					total -= valor;	
				}
				else {
					System.out.println("Resposta não reconhecida. Deseja recomeçar? S/N");
					continuar = ler.next().charAt(0);
				}
				if(total<0) {
					System.out.print("Saldo negativo. Deseja recomeçar? S/N ");
					continuar = ler.next().charAt(0);
				}
				else {
					System.out.printf("Ok, seu saldo é %.2f. Deseja realizar outra operação na sua conta poupança? S/N ", total);
					continuar = ler.next().charAt(0);
					
				}
			}while(continuar=='s' || continuar == 'S'); 
			if (continuar == 'N' || continuar == 'n')
			{
				break;
			}
		}
			System.out.println("Ok, agora vamos falar sobre se limite especial.\nO seu saldo é de "+total);
			
			System.out.print("Você deseja usar seu limite? S/N ");
			recomecar = ler.next().charAt(0);
			
			while (recomecar=='S' || recomecar=='s') {
				System.out.print("Quanto do limite você deseja usar? ");
				limite = ler.nextDouble();
				soma +=limite;
				if (soma>1000) {
					System.out.print("Você ultrapassou o valor do seu limite ");
					System.out.print("Você deseja recomeçar? S/N ");
					recomecar = ler.next().charAt(0);
				}
				else if(soma<0) {
					System.out.println("Valor incorreto!");
					System.out.print("Você deseja recomeçar? S/N ");
					recomecar = ler.next().charAt(0);
				}
			
				else {
					System.out.printf("Ok, obrigada! Você está usando R$%.2f do seu limite especial, então seu saldo agora é de R$%.2f", limite, total+limite);
					System.out.print("\nDesejar usar o limite novamente?");
					recomecar = ler.next().charAt(0);
				}
				total+=limite;
			}
		
		System.out.println("Obrigada por usar nossos serviços!");
		
	}
	
	/*** FUNÇÃO DO MENU CONTA ESTUDANTIL ***/
	static void menuContaEstudantil(Scanner ler) {
		int tipo;
		char mov, opc, ces, fim;
		String desc;
		double valor = 0.0, saldo = 0.0, saldoAtual = 0.0, credito = 0.0, debito = 0.0;
		double emprestimo = 0.0, valorEmprestimo = 0.00, saldoFinal = 0.00;
		char opcao;

		System.out.print("\nVocê selecionou a Conta Estudandil");
		for (int i = 1; i <= 10; i++) {

			System.out.printf("\n%d°Consulta: Escolha D-Débito/C-Crédito", i);
			mov = ler.next().toUpperCase().charAt(0);
			if (mov == 'D') {
				System.out.printf("\nDigite o valor para débito: ");
				debito = ler.nextDouble();
				if (saldo > 0) {
					while (saldo < debito) {
						System.out.printf("\nSaldo indisponivel, atual %.2f, tente de novo!!!\n", saldo);
						System.out.print("\nDigite o valor para débito :");
						debito = ler.nextDouble();
					}
					ler.nextLine();
					System.out.print("\nDescrição do débito :");
					desc = ler.nextLine();
					saldo = saldo - debito;
					System.out.printf("\nSaldo atual é R$ %.2f\n", saldo);
				} else if (saldo == 0) {
					System.out.println("\n0 saldo, faça um crédito primeiro!!!");
				}
			} else if (mov == 'C') {
				System.out.print("\nDigite o valor do crédito: ");
				credito = ler.nextDouble();
				while (credito <= 0) {
					System.out.print("\nValor informado negativo ou zero, tente de novo:");
					System.out.print("\nDigite o valor do crédito: ");
					credito = ler.nextDouble();
				}
				ler.nextLine();
				System.out.print("\nDigite a descrição do crédito: ");
				desc = ler.nextLine();
				saldo = saldo + credito;
				System.out.printf("\nSaldo atual é R$ %.2f \n", saldo);
			} else {
				System.out.println("\nVocê não escolheu Debito ou Crédito!!!");
			}

			System.out.print("\nContinua S/N :");
			fim = ler.next().toUpperCase().charAt(0);
			if (fim == 'N') {
				break;
			}
		}
		System.out.printf("\nDESEJA USAR O LIMITE DE ESTUDANTE - S/N:");
		System.out.printf("\nSE SIM ELE TE PODE USAR 5 MIL: ");
		opcao = ler.next().toUpperCase().charAt(0);

		do
		{

			System.out.printf("\nInsira o valor do Empréstimo:");
			emprestimo = ler.nextDouble();
			if (emprestimo < 5000) {
				valorEmprestimo = emprestimo;

			} else {
				System.out.printf("\nValor Inválido");
			}

			saldoFinal = valorEmprestimo + saldo;
			System.out.printf("\nO saldo final da sua conta é: %.2f\n", saldoFinal);

			System.out.printf("\nDESEJA CONTINUAR?- S/N: ");
			opcao = ler.next().toUpperCase().charAt(0);
		} while (opcao == 'S');

		System.out.printf("\nOBRIGADO POR UTILIZAR NOSSOS SERVIÇOS ");

	}
}
