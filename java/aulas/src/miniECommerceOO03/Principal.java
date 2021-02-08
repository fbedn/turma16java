package miniECommerceOO03;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		
		Estoque estoque = new Estoque();
		estoque.inicializarComValoresPadrao();
		
		char comando;
		String codProduto;
		int qtdProduto;
		char comandoExterno;
		do { //loop principal. Sempre que inicia, os dados do usu�rio come�am zerados
			Cliente cliente = new Cliente();
			Pedido pedido = new Pedido();
			pedido.setCliente(cliente);
			linha(90);
			System.out.print("\nPAGUFE PET SHOP\nAqui, seu animal � mais feliz!\n");
			linha(90);
			System.out.print("\nInforme seu nome: ");
			cliente.setNome(ler.nextLine());
			System.out.print("Informe seu sexo [M/F/O]: ");
			char sexo = ler.next().toUpperCase().charAt(0);
			while (!(sexo == 'M' || sexo == 'F' || sexo == 'O')) {
				System.out.print("Informe seu sexo [M/F/O]: ");
				sexo = ler.next().toUpperCase().charAt(0);
			}
			cliente.setSexo(sexo);
			do { // la�o dos comandos do usu�rio
				linha(90);
				estoque.imprimirLista();
				linha(90);
				System.out.print("\nCOMANDOS:\na = Adicionar produto ao carrinho\nr = Retirar produto do carrinho\nc = Exibir o carrinho de compras\nf = Finalizar compra\ns = Sair\n");
				System.out.print("\nDigite o comando: ");
				comando = ler.next().toLowerCase().charAt(0);
				// comando para adicionar um produto ao carrinho
				if (comando == 'a') {
					System.out.print("\nC�DIGO DO PRODUTO: ");
					ler.nextLine(); // para limpar o final da linha
					codProduto = ler.nextLine();
					
					int indiceEstoque = estoque.encontrarIndice(codProduto);
					if (indiceEstoque > -1) { //verifica se o c�digo do produto foi encontrado ou n�o
						do {
							System.out.print("\nQUANTIDADE DO PRODUTO: ");
							qtdProduto = ler.nextInt();
							//boolean result = pedido.adicionarProdutos(codProduto, indiceEstoque, qtdProduto, estoque);
							boolean result = pedido.adicionarProdutos(codProduto, qtdProduto, estoque);
							linha(90);
							if (result) {
								System.out.print("\n\n\n***PRODUTO ADICIONADO AO CARRINHO***\n\n\n");
								comando = 'n';
							}
							else {
								if (estoque.qtdProdutosIndice(indiceEstoque) > 0) {
									System.out.print("\nH� APENAS " + estoque.qtdProdutosIndice(indiceEstoque) + " UNIDADES DISPON�VEIS\nDESEJA ADICIONAR OUTRA QUANTIDADE? [s/n]: ");
									comando = ler.next().toLowerCase().charAt(0);
								}
								else
									System.out.print("\nPRODUTO ESGOTADO\n");
							}
						} while (comando == 's');
					}
					else {
						System.out.print("\n\n\n***C�DIGO DO PRODUTO N�O ENCONTRADO***\n\n\n");
					}
				}
				// comando para retirar um produto ao carrinho
				else if (comando == 'r') {
					System.out.print("\nC�DIGO DO PRODUTO: ");
					ler.nextLine();
					codProduto = ler.nextLine();
					int indiceCarrinho = pedido.encontrarIndice(codProduto);
					if (indiceCarrinho > -1) { //verifica se o c�digo do produto existe no carrinho
						do {
							System.out.print("\nQUANTIDADE A REMOVER: ");
							qtdProduto = ler.nextInt();
							//boolean result = pedido.removerProdutos(codProduto, indiceCarrinho, qtdProduto, estoque);
							boolean result = pedido.removerProdutos(codProduto, qtdProduto, estoque);
							linha(90);
							if (result) {
								System.out.print("\n\n\n***PRODUTO(S) RETIRADO(S) DO CARRINHO***\n\n\n");
								comando = 'n';
							}
							else {
								if (pedido.qtdProdutosIndice(indiceCarrinho) > 0) {
									System.out.print("\nH� APENAS " + pedido.qtdProdutosIndice(indiceCarrinho) + " UNIDADES DISPON�VEIS\nDESEJA ADICIONAR OUTRA QUANTIDADE? [s/n]: ");
									comando = ler.next().toLowerCase().charAt(0);
								}
								else
									System.out.print("\n\n***N�O H� PRODUTOS DESTE TIPO NO SEU CARRINHO***\n\n");
							}
						} while (comando == 's');
					}
					else {
						linha(90);
						System.out.print("\n\n***C�DIGO DE PRODUTO N�O ENCONTRADO NO SEU CARRINHO***\n\n");
					}
				}
				// comando para exibir o carrinho
				else if (comando == 'c') {
					pedido.imprimirCarrinho();
				}
				// comando para sair do loop do usu�rio
				else if (comando == 's') {
					break;
				}
				// comando para finalizar a compra
				else if (comando == 'f') {
					Pagamento pagamento = new Pagamento();
					pedido.setPagamento(pagamento);
					
					pedido.subTotal();
					pagamento.setTotalGeral(pedido.getSubTotal());
					
					System.out.printf("\nTotal Geral: R$ %.2f + IMPOSTO (9%%): R$ %.2f  Total com imposto: R$ %.2f \n",pagamento.getTotalGeral(),pagamento.valorImposto(),pagamento.totalComImposto());
					System.out.printf("\nEscolha a forma de pagamento\n");
					System.out.print("\n1- ZERAR CARRINHO");
					System.out.printf("\n2- A VISTA - 10%% DESCONTO: R$%.2f",pagamento.precoAVista());	
					System.out.printf("\n3- CART�O - 1 VEZ:  R$%.2f SEM DESCONTO", pagamento.precoCartao1Vez());
					System.out.printf("\n4- CART�O - 2 VEZES - JUROS (10%%) - PARCELAS DE:  R$%.2f - TOTAL DE: R$%.2f",(pagamento.precoCartao2Vezes()/2),pagamento.precoCartao2Vezes());
					System.out.printf("\n5- CART�O - 3 VEZES - JUROS (15%%) - PARCELAS DE:  R$%.2f - TOTAL DE: R$%.2f",(pagamento.precoCartao3Vezes()/3),pagamento.precoCartao3Vezes());
					System.out.print("\n\nInsira Aqui: ");
					
					linha(80);
					try {
						int opcao = ler.nextInt();
						if (opcao == 1) {
							pedido.zerarCarrinho(estoque);
							System.out.println("Seu carrinho foi zerado!");
						}
						else if (opcao == 2) {
							pagamento.setOpcaoPagamento(opcao);
							pedido.notaFiscal();
							System.out.printf("� VISTA - 10%% DESCONTO: R$%.2f",pagamento.precoAVista());
							System.out.println("\nAgrademos pela compra, "+cliente.tratamento()+" "+cliente.getNome()+". Volte sempre !");
							break;
						}
						else if (opcao == 3) {
							pagamento.setOpcaoPagamento(opcao);
							pedido.notaFiscal();
							System.out.printf("CART�O - 1 VEZ:  R$%.2f SEM DESCONTO", pagamento.precoCartao1Vez());
							System.out.println("\nAgrademos pela compra, "+cliente.tratamento()+" "+cliente.getNome()+". Volte sempre !");
							break;
						}
						else if (opcao == 4) {
							pagamento.setOpcaoPagamento(opcao);
							pedido.notaFiscal();
							System.out.printf("CART�O - 2 VEZES - JUROS (10%%) - PARCELAS DE:  R$%.2f - TOTAL DE: R$%.2f",(pagamento.precoCartao2Vezes()/2),pagamento.precoCartao2Vezes());
							System.out.println("\nAgrademos pela compra, "+cliente.tratamento()+" "+cliente.getNome()+". Volte sempre !");
							break;
						}
						else if (opcao == 5) {
							pagamento.setOpcaoPagamento(opcao);
							pedido.notaFiscal();
							System.out.printf("CART�O - 3 VEZES - JUROS (15%%) - PARCELAS DE:  R$%.2f - TOTAL DE: R$%.2f",(pagamento.precoCartao3Vezes()/3),pagamento.precoCartao3Vezes());
							System.out.println("\nAgrademos pela compra, "+cliente.tratamento()+" "+cliente.getNome()+". Volte sempre !");
							break;
						}
						else {
							System.out.println("\nOp��o inv�lida!\nTente novamente\n");
						}
					}
					catch (Exception e) {
						System.out.println("\n�ndice inv�lido\n");
					}
				}
			} while (true);
			
			linha(90);
			System.out.println("\nDESEJA REINICIAR O PROGRAMA? [s/n]");
			comandoExterno = ler.next().toLowerCase().charAt(0);
			ler.nextLine();
			
		} while (comandoExterno == 's');
		
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
}
