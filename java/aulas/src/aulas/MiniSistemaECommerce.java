package aulas;

import java.util.*;

public class MiniSistemaECommerce {
	
	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		final int n = 10;
		String[] codigoProdutos = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10" };
		String[] nomeProdutos = {"Bolinha de morder para c�es",
									"Tabuleiro roleta para c�es",
									"Rato Jo�o-Bobo para gatos",
									"Arranhador para gatos",
									"Pel�cia para c�es",
									"Rodinha para hamsters",
									"Mordedor de borracha para c�es",
									"Caixa toca para gatos",
									"Mordedor osso de pel�cia para c�es",
									"Piscina de bolinhas para c�es"};
		double precoProdutos[] = { 9.9, 22.9, 12, 35.9, 29.9, 16.9, 9.9, 20.9, 15.9, 9999.9 };
		int estoque[] = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		char comando;
		String codProduto;
		int qtdProduto;
		char comandoExterno = 'n';
		do { //loop principal. Sempre que inicia, os dados do usu�rio come�am zerados
			int carrinhoCompras[] = new int[n];
			String nome;
			char sexo;
			linha(90);
			System.out.print("\nPAGUFE PET SHOP\nAqui, seu animal � mais feliz!\n");
			linha(90);
			System.out.print("\nInforme seu nome: ");
			nome = ler.nextLine();
			System.out.print("Informe seu sexo [M/F/O]: ");
			sexo = ler.next().toUpperCase().charAt(0);
			while (!(sexo == 'M' || sexo == 'F' || sexo == 'O')) {
				System.out.print("Informe seu sexo [M/F/O]: ");
				sexo = ler.next().toUpperCase().charAt(0);
			}
			do { // la�o dos comandos do usu�rio
				linha(90);
				imprimeLista(n, codigoProdutos, nomeProdutos, estoque, precoProdutos);
				linha(90);
				System.out.print("\nCOMANDOS:\na = Adicionar produto ao carrinho\nr = Retirar produto do carrinho\nc = Exibir o carrinho de compras\nf = Finalizar compra\ns = Sair\n");
				System.out.print("\nDigite o comando: ");
				comando = ler.next().toLowerCase().charAt(0);
				// comando para adicionar um produto ao carrinho
				if (comando == 'a') {
					System.out.print("\nC�DIGO DO PRODUTO: ");
					ler.nextLine(); // para limpar o final da linha
					codProduto = ler.nextLine();
					int indice = encontraIndice(codProduto, n, codigoProdutos);
					if (indice > -1) {
						do {
							System.out.print("\nQUANTIDADE DO PRODUTO: ");
							qtdProduto = ler.nextInt();
							boolean result = adicionaAoCarrinho(indice, codProduto, qtdProduto, carrinhoCompras, n, codigoProdutos, estoque);
							linha(90);
							if (result) {
								
								System.out.print("\n\n\n***PRODUTO ADICIONADO AO CARRINHO***\n\n\n");
								comando = 'n';
							} else {
								if (estoque[indice] > 0) {
									System.out.print("\nH� APENAS " + estoque[indice] + " UNIDADES DISPON�VEIS\nDESEJA ADICIONAR OUTRA QUANTIDADE? [s/n]: ");
									comando = ler.next().toLowerCase().charAt(0);
								} else
									System.out.print("\nPRODUTO ESGOTADO\n");
							}
						} while (comando == 's');
					} else {
						System.out.print("\n\n\n***C�DIGO DO PRODUTO N�O ENCONTRADO***\n\n\n");
					}
				}
				// comando para retirar um produto ao carrinho
				else if (comando == 'r') {
					System.out.print("\nC�DIGO DO PRODUTO: ");
					ler.nextLine();
					codProduto = ler.nextLine();
					int indice = encontraIndice(codProduto, n, codigoProdutos);
					if (indice > -1) {
						do {
							System.out.print("\nQUANTIDADE A REMOVER: ");
							qtdProduto = ler.nextInt();
							boolean result = retiraDoCarrinho(indice, codProduto, qtdProduto, carrinhoCompras, n, codigoProdutos, estoque);
							linha(90);
							if (result) {
								System.out.print("\n\n\n***PRODUTO(S) RETIRADO(S) DO CARRINHO***\n\n\n");
								comando = 'n';
							} else {
								if (carrinhoCompras[indice] > 0) {
									System.out.print("\nH� APENAS" + carrinhoCompras[indice] + " UNIDADES EM SEU CARRINHO\nDESEJA REMOVER OUTRA QUANTIDADE? [s/n]: ");
									comando = ler.next().toLowerCase().charAt(0);
								} else
									System.out.print("\n\n***N�O H� PRODUTOS DESTE TIPO NO SEU CARRINHO***\n\n");
							}
						} while (comando == 's');
					} else {
						linha(90);
						System.out.print("\n\n***C�DIGO DO PRODUTO N�O ENCONTRADO***\n\n");
					}
				}
				// comando para retirar um produto ao carrinho
				else if (comando == 'c') {
					System.out.print("\n\n|\tCOD\t|\tPre�o\t|   Seu Carrinho   |\tProduto Restante\t\n");
					for (int i = 0; i < 10; i++) {
						if (carrinhoCompras[i] != 0) {
							System.out.print("|\t" + (i + 1) + "\t|\t" + precoProdutos[i] + "\t|\t" + carrinhoCompras[i] + "\t|\t" + estoque[i] + "\n");
						}
					}
				}
				// comando para sair do loop do usu�rio
				else if (comando == 's') {
					break;
				}
				// comando para finalizar a compra
				else if (comando == 'f') {
					boolean result = pagamento(estoque, carrinhoCompras, precoProdutos, nome, sexo);
					if (result) // se result for verdadeiro, sai do loop do usu�rio
						break;
					else { // se result for falso, o carrinho est� vazio, por isso n�o foi poss�vel finalizar. Avisa isso ao usu�rio 
						linha(90);
						System.out.println("\n\n***N�O FOI POSS�VEL FINALIZAR A COMPRA, POIS O CARRINHO EST� VAZIO***\n\n");
					}
				}
			} while (true);
			
			linha(90);
			System.out.println("\nDESEJA SAIR DO PROGRAMA? [s/n]");
			comandoExterno = ler.next().toLowerCase().charAt(0);
			ler.nextLine();
			
		} while (comandoExterno == 'n');
		
		ler.close();
		System.out.println("\nPROGRAMA FINALIZADO");
	}

	/* Imprime uma linha de tamanho determinado */
	public static void linha(int tamanho) {
		for (int i = 1; i < tamanho; i++) {
			System.out.print("_");
		}
		System.out.println();
	}

	/* Imprime a lista de produtos do estoque */
	static void imprimeLista(int n, String[] codigoProdutos, String[] nomeProdutos, int[] estoque, double[] precoProdutos) {
		System.out.print("\nCOD PRODUTO\tESTOQUE  \tPRE�O UNIT�RIO \t\tNOME DO PRODUTO\n");
		for (int i = 0; i < n; ++i) {
			//System.out.print(codigoProdutos[i] + " \t\t " + estoque[i] + " \t\t" + precoProdutos[i] + " \t\t " + nomeProdutos[i] + "\n");
			System.out.printf("%s \t\t %d \t\tR$ %.2f    \t\t%s\n", codigoProdutos[i], estoque[i], precoProdutos[i], nomeProdutos[i]);
		}
	}

	/* Encontra o �ndice de um prouto, dado um c�digo de produto */
	static int encontraIndice(String codProduto, int n, String[] codigoProdutos) {
		int indice = -1;
		for (int i = 0; i < n; ++i) {
			if (codProduto.equals(codigoProdutos[i])) {
				indice = i;
				break;
			}
		}
		return indice;
	}
	
	/* M�todo que coloca produtos no carrinho do usu�rio */
	static boolean adicionaAoCarrinho(int indice, String codProduto, int qtdProduto, int carrinhoCompras[], int n, String codigoProdutos[], int estoque[]) {
		if (qtdProduto < 0)
			return false;
		int restante = estoque[indice] - qtdProduto;
		if (restante < 0)
			return false;
		carrinhoCompras[indice] = carrinhoCompras[indice] + qtdProduto;
		estoque[indice] = estoque[indice] - qtdProduto;
		return true;
	}

	/* M�todo que retira produtos do carrinho do usu�rio */
	static boolean retiraDoCarrinho(int indice, String codProduto, int qtdProduto, int carrinhoCompras[], int n, String codigoProdutos[], int estoque[]) {
		if (qtdProduto < 0)
			return false;
		int restante = carrinhoCompras[indice] - qtdProduto;
		if (restante < 0)
			return false;
		estoque[indice] = estoque[indice] + qtdProduto;
		carrinhoCompras[indice] = carrinhoCompras[indice] - qtdProduto;
		return true;
	}
	
	/* M�todo que trata do pagamento */
	static boolean pagamento(int[] estoque, int[] carrinhoCompras, double[] precoProdutos, String nome, char sexo) {
		Scanner ler = new Scanner(System.in);
		String formaPagamento, tratamento;
		int opcao;
		double totalGeral = 0, totalComImposto = 0;
		linha(90);
		if (sexo == 'F') { //define o tratamento que o usu�rio ser� tratado
			tratamento = "Sra.";
		} else if (sexo == 'M') {
			tratamento = "Sr.";
		} else {
			tratamento = "Srx.";
		}
		System.out.print("\n\n|\tCOD\t|\tPre�o\t|   Seu Carrinho   |\tProduto Restante\t\n");
		for (int i = 0; i < 10; i++) {
			if (carrinhoCompras[i] != 0) {
				System.out.print("|\t" + (i + 1) + "\t|\t" + precoProdutos[i] + "\t|\t" + carrinhoCompras[i] + "\t|\t" + estoque[i] + "\n");
				totalGeral = carrinhoCompras[i] * precoProdutos[i];
			}
		}
		if (totalGeral == 0) { // se o totalGeral � zero, o carrinho est� vazio, ent�o retorna falso
			ler.close();
			return false;
		}
		totalComImposto = totalGeral + (totalGeral * 0.09);
		System.out.printf("\nTotal Geral: R$ %.2f + IMPOSTO (9%%): R$ %.2f  Total com imposto: R$ %.2f \n", totalGeral, totalGeral * 0.09, totalComImposto);
		System.out.printf("\nEscolha a forma de pagamento\n");
		System.out.print("\n1- ZERAR CARRINHO");
		System.out.printf("\n2- A VISTA - 10%% DESCONTO: R$%.2f", (totalComImposto * 0.9));
		System.out.printf("\n3- CART�O - 1 VEZ:  R$%.2f SEM DESCONTO", totalComImposto);
		System.out.printf("\n4- CART�O - 2 VEZES - JUROS (10%%) - PARCELAS DE:  R$%.2f - TOTAL DE: R$%.2f",((totalComImposto + (totalComImposto * 0.10)) / 2), (totalComImposto * 1.10));
		System.out.printf("\n5- CART�O - 3 VEZES - JUROS (15%%) - PARCELAS DE:  R$%.2f - TOTAL DE: R$%.2f",((totalComImposto + (totalComImposto * 0.15)) / 3), (totalComImposto * 1.15));
		System.out.print("\n\nInsira Aqui: ");
		opcao = ler.nextInt();
		linha(90);
		if (opcao == 1) {
			for (int i = 0; i < 10; i++) {
				estoque[i] += carrinhoCompras[i];
				carrinhoCompras[i] = 0;
				totalGeral = 0.0;
			}
		} else if (opcao == 2) {
			formaPagamento = "A VISTA";
			System.out.println("\n NOTA FISCAL - PAGUFE PET - CNPJ XXXXXXXXX ");
			System.out.printf(" Ol� %s %s Voc� efetuou uma compra na op��o %s \n", tratamento, nome, formaPagamento);
			for (int i = 0; i < 10; i++) {
				if (carrinhoCompras[i] != 0) {
					System.out.print("|\t" + (i + 1) + "\t|\t" + precoProdutos[i] + "\t|\t" + carrinhoCompras[i] + "\t|\t" + estoque[i] + "\n");
				}
			}
			System.out.printf("\nTotal a pagar: � vista c/ 10%% DESCONTO: R$%.2f\\n", totalComImposto * 0.9);
		} else if (opcao == 3) {
			formaPagamento = "1 VEZ NO CART�O";
			System.out.println(" NOTA FISCAL - PAGUFE PET - CNPJ XXXXXXXXX ");
			System.out.printf(" Ol� %s %s Voc� efetuou uma compra na op��o %s \n", tratamento, nome, formaPagamento);
			for (int i = 0; i < 10; i++) {
				if (carrinhoCompras[i] != 0) {
					System.out.print("|\t" + (i + 1) + "\t|\t" + precoProdutos[i] + "\t|\t" + carrinhoCompras[i] + "\t|\t" + estoque[i] + "\n");
				}
			}
			System.out.printf("\nTotal a pagar: 1 vez no cart�o s/ Desconto: R$%.2f\n", totalComImposto);
		} else if (opcao == 4) {
			formaPagamento = "2 VEZES NO CART�O";
			System.out.println(" NOTA FISCAL - PAGUFE PET - CNPJ XXXXXXXXX ");
			System.out.printf(" Ol� %s %s Voc� efetuou uma compra na op��o %s \n", tratamento, nome, formaPagamento);
			for (int i = 0; i < 10; i++) {
				if (carrinhoCompras[i] != 0) {
					System.out.print("|\t" + (i + 1) + "\t|\t" + precoProdutos[i] + "\t|\t" + carrinhoCompras[i] + "\t|\t" + estoque[i] + "\n");
				}
			}
			System.out.printf("\nTotal a pagar: 2 VEZES + JUROS (10%%) - PARCELAS DE:  R$%.2f - TOTAL DE: R$%.2f \n",((totalComImposto + (totalComImposto * 0.10)) / 2), (totalComImposto * 1.10));
		} else if (opcao == 5) {
			formaPagamento = "3 VEZES NO CART�O";
			System.out.println(" NOTA FISCAL - PAGUFE PET - CNPJ XXXXXXXXX ");
			System.out.printf(" Ol� %s %s Voc� efetuou uma compra na op��o %s \n", tratamento, nome, formaPagamento);
			for (int i = 0; i < 10; i++) {
				if (carrinhoCompras[i] != 0) {
					System.out.print("|\t" + (i + 1) + "\t|\t" + precoProdutos[i] + "\t|\t" + carrinhoCompras[i] + "\t|\t" + estoque[i] + "\n");
				}
			}
			System.out.printf("\nTotal a pagar: 3 VEZES + JUROS (15%%) - PARCELAS DE: R$%.2f - TOTAL DE: R$%.2f \n",((totalComImposto + (totalComImposto * 0.15)) / 3), (totalComImposto * 1.15));
		} else {
			System.out.print("\nOp��o inv�lida!\nTente novamente");
		}
		System.out.println("Agrademos pela compra. Volte sempre !");
		ler.close();
		return true;
	}
}