package aulas;

import java.util.*;

public class MiniSistemaECommerce {
	
	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		final int n = 10;
		String[] codigoProdutos = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10" };
		String[] nomeProdutos = {"Bolinha de morder para cães",
									"Tabuleiro roleta para cães",
									"Rato João-Bobo para gatos",
									"Arranhador para gatos",
									"Pelúcia para cães",
									"Rodinha para hamsters",
									"Mordedor de borracha para cães",
									"Caixa toca para gatos",
									"Mordedor osso de pelúcia para cães",
									"Piscina de bolinhas para cães"};
		double precoProdutos[] = { 9.9, 22.9, 12, 35.9, 29.9, 16.9, 9.9, 20.9, 15.9, 9999.9 };
		int estoque[] = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		char comando;
		String codProduto;
		int qtdProduto;
		char comandoExterno = 'n';
		do { //loop principal. Sempre que inicia, os dados do usuário começam zerados
			int carrinhoCompras[] = new int[n];
			String nome;
			char sexo;
			linha(90);
			System.out.print("\nPAGUFE PET SHOP\nAqui, seu animal é mais feliz!\n");
			linha(90);
			System.out.print("\nInforme seu nome: ");
			nome = ler.nextLine();
			System.out.print("Informe seu sexo [M/F/O]: ");
			sexo = ler.next().toUpperCase().charAt(0);
			while (!(sexo == 'M' || sexo == 'F' || sexo == 'O')) {
				System.out.print("Informe seu sexo [M/F/O]: ");
				sexo = ler.next().toUpperCase().charAt(0);
			}
			do { // laço dos comandos do usuário
				linha(90);
				imprimeLista(n, codigoProdutos, nomeProdutos, estoque, precoProdutos);
				linha(90);
				System.out.print("\nCOMANDOS:\na = Adicionar produto ao carrinho\nr = Retirar produto do carrinho\nc = Exibir o carrinho de compras\nf = Finalizar compra\ns = Sair\n");
				System.out.print("\nDigite o comando: ");
				comando = ler.next().toLowerCase().charAt(0);
				// comando para adicionar um produto ao carrinho
				if (comando == 'a') {
					System.out.print("\nCÓDIGO DO PRODUTO: ");
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
									System.out.print("\nHÁ APENAS " + estoque[indice] + " UNIDADES DISPONÍVEIS\nDESEJA ADICIONAR OUTRA QUANTIDADE? [s/n]: ");
									comando = ler.next().toLowerCase().charAt(0);
								} else
									System.out.print("\nPRODUTO ESGOTADO\n");
							}
						} while (comando == 's');
					} else {
						System.out.print("\n\n\n***CÓDIGO DO PRODUTO NÃO ENCONTRADO***\n\n\n");
					}
				}
				// comando para retirar um produto ao carrinho
				else if (comando == 'r') {
					System.out.print("\nCÓDIGO DO PRODUTO: ");
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
									System.out.print("\nHÁ APENAS" + carrinhoCompras[indice] + " UNIDADES EM SEU CARRINHO\nDESEJA REMOVER OUTRA QUANTIDADE? [s/n]: ");
									comando = ler.next().toLowerCase().charAt(0);
								} else
									System.out.print("\n\n***NÃO HÁ PRODUTOS DESTE TIPO NO SEU CARRINHO***\n\n");
							}
						} while (comando == 's');
					} else {
						linha(90);
						System.out.print("\n\n***CÓDIGO DO PRODUTO NÃO ENCONTRADO***\n\n");
					}
				}
				// comando para retirar um produto ao carrinho
				else if (comando == 'c') {
					System.out.print("\n\n|\tCOD\t|\tPreço\t|   Seu Carrinho   |\tProduto Restante\t\n");
					for (int i = 0; i < 10; i++) {
						if (carrinhoCompras[i] != 0) {
							System.out.print("|\t" + (i + 1) + "\t|\t" + precoProdutos[i] + "\t|\t" + carrinhoCompras[i] + "\t|\t" + estoque[i] + "\n");
						}
					}
				}
				// comando para sair do loop do usuário
				else if (comando == 's') {
					break;
				}
				// comando para finalizar a compra
				else if (comando == 'f') {
					boolean result = pagamento(estoque, carrinhoCompras, precoProdutos, nome, sexo);
					if (result) // se result for verdadeiro, sai do loop do usuário
						break;
					else { // se result for falso, o carrinho está vazio, por isso não foi possível finalizar. Avisa isso ao usuário 
						linha(90);
						System.out.println("\n\n***NÃO FOI POSSÍVEL FINALIZAR A COMPRA, POIS O CARRINHO ESTÁ VAZIO***\n\n");
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
		System.out.print("\nCOD PRODUTO\tESTOQUE  \tPREÇO UNITÁRIO \t\tNOME DO PRODUTO\n");
		for (int i = 0; i < n; ++i) {
			//System.out.print(codigoProdutos[i] + " \t\t " + estoque[i] + " \t\t" + precoProdutos[i] + " \t\t " + nomeProdutos[i] + "\n");
			System.out.printf("%s \t\t %d \t\tR$ %.2f    \t\t%s\n", codigoProdutos[i], estoque[i], precoProdutos[i], nomeProdutos[i]);
		}
	}

	/* Encontra o índice de um prouto, dado um código de produto */
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
	
	/* Método que coloca produtos no carrinho do usuário */
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

	/* Método que retira produtos do carrinho do usuário */
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
	
	/* Método que trata do pagamento */
	static boolean pagamento(int[] estoque, int[] carrinhoCompras, double[] precoProdutos, String nome, char sexo) {
		Scanner ler = new Scanner(System.in);
		String formaPagamento, tratamento;
		int opcao;
		double totalGeral = 0, totalComImposto = 0;
		linha(90);
		if (sexo == 'F') { //define o tratamento que o usuário será tratado
			tratamento = "Sra.";
		} else if (sexo == 'M') {
			tratamento = "Sr.";
		} else {
			tratamento = "Srx.";
		}
		System.out.print("\n\n|\tCOD\t|\tPreço\t|   Seu Carrinho   |\tProduto Restante\t\n");
		for (int i = 0; i < 10; i++) {
			if (carrinhoCompras[i] != 0) {
				System.out.print("|\t" + (i + 1) + "\t|\t" + precoProdutos[i] + "\t|\t" + carrinhoCompras[i] + "\t|\t" + estoque[i] + "\n");
				totalGeral = carrinhoCompras[i] * precoProdutos[i];
			}
		}
		if (totalGeral == 0) { // se o totalGeral é zero, o carrinho está vazio, então retorna falso
			ler.close();
			return false;
		}
		totalComImposto = totalGeral + (totalGeral * 0.09);
		System.out.printf("\nTotal Geral: R$ %.2f + IMPOSTO (9%%): R$ %.2f  Total com imposto: R$ %.2f \n", totalGeral, totalGeral * 0.09, totalComImposto);
		System.out.printf("\nEscolha a forma de pagamento\n");
		System.out.print("\n1- ZERAR CARRINHO");
		System.out.printf("\n2- A VISTA - 10%% DESCONTO: R$%.2f", (totalComImposto * 0.9));
		System.out.printf("\n3- CARTÃO - 1 VEZ:  R$%.2f SEM DESCONTO", totalComImposto);
		System.out.printf("\n4- CARTÃO - 2 VEZES - JUROS (10%%) - PARCELAS DE:  R$%.2f - TOTAL DE: R$%.2f",((totalComImposto + (totalComImposto * 0.10)) / 2), (totalComImposto * 1.10));
		System.out.printf("\n5- CARTÃO - 3 VEZES - JUROS (15%%) - PARCELAS DE:  R$%.2f - TOTAL DE: R$%.2f",((totalComImposto + (totalComImposto * 0.15)) / 3), (totalComImposto * 1.15));
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
			System.out.printf(" Olá %s %s Você efetuou uma compra na opção %s \n", tratamento, nome, formaPagamento);
			for (int i = 0; i < 10; i++) {
				if (carrinhoCompras[i] != 0) {
					System.out.print("|\t" + (i + 1) + "\t|\t" + precoProdutos[i] + "\t|\t" + carrinhoCompras[i] + "\t|\t" + estoque[i] + "\n");
				}
			}
			System.out.printf("\nTotal a pagar: À vista c/ 10%% DESCONTO: R$%.2f\\n", totalComImposto * 0.9);
		} else if (opcao == 3) {
			formaPagamento = "1 VEZ NO CARTÃO";
			System.out.println(" NOTA FISCAL - PAGUFE PET - CNPJ XXXXXXXXX ");
			System.out.printf(" Olá %s %s Você efetuou uma compra na opção %s \n", tratamento, nome, formaPagamento);
			for (int i = 0; i < 10; i++) {
				if (carrinhoCompras[i] != 0) {
					System.out.print("|\t" + (i + 1) + "\t|\t" + precoProdutos[i] + "\t|\t" + carrinhoCompras[i] + "\t|\t" + estoque[i] + "\n");
				}
			}
			System.out.printf("\nTotal a pagar: 1 vez no cartão s/ Desconto: R$%.2f\n", totalComImposto);
		} else if (opcao == 4) {
			formaPagamento = "2 VEZES NO CARTÃO";
			System.out.println(" NOTA FISCAL - PAGUFE PET - CNPJ XXXXXXXXX ");
			System.out.printf(" Olá %s %s Você efetuou uma compra na opção %s \n", tratamento, nome, formaPagamento);
			for (int i = 0; i < 10; i++) {
				if (carrinhoCompras[i] != 0) {
					System.out.print("|\t" + (i + 1) + "\t|\t" + precoProdutos[i] + "\t|\t" + carrinhoCompras[i] + "\t|\t" + estoque[i] + "\n");
				}
			}
			System.out.printf("\nTotal a pagar: 2 VEZES + JUROS (10%%) - PARCELAS DE:  R$%.2f - TOTAL DE: R$%.2f \n",((totalComImposto + (totalComImposto * 0.10)) / 2), (totalComImposto * 1.10));
		} else if (opcao == 5) {
			formaPagamento = "3 VEZES NO CARTÃO";
			System.out.println(" NOTA FISCAL - PAGUFE PET - CNPJ XXXXXXXXX ");
			System.out.printf(" Olá %s %s Você efetuou uma compra na opção %s \n", tratamento, nome, formaPagamento);
			for (int i = 0; i < 10; i++) {
				if (carrinhoCompras[i] != 0) {
					System.out.print("|\t" + (i + 1) + "\t|\t" + precoProdutos[i] + "\t|\t" + carrinhoCompras[i] + "\t|\t" + estoque[i] + "\n");
				}
			}
			System.out.printf("\nTotal a pagar: 3 VEZES + JUROS (15%%) - PARCELAS DE: R$%.2f - TOTAL DE: R$%.2f \n",((totalComImposto + (totalComImposto * 0.15)) / 3), (totalComImposto * 1.15));
		} else {
			System.out.print("\nOpção inválida!\nTente novamente");
		}
		System.out.println("Agrademos pela compra. Volte sempre !");
		ler.close();
		return true;
	}
}