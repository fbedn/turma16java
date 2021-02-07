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
		do { //loop principal. Sempre que inicia, os dados do usuário começam zerados
			Cliente cliente = new Cliente();
			Pedido pedido = new Pedido();
			linha(90);
			System.out.print("\nPAGUFE PET SHOP\nAqui, seu animal é mais feliz!\n");
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
			do { // laço dos comandos do usuário
				linha(90);
				estoque.imprimirLista();
				linha(90);
				System.out.print("\nCOMANDOS:\na = Adicionar produto ao carrinho\nr = Retirar produto do carrinho\nc = Exibir o carrinho de compras\nf = Finalizar compra\ns = Sair\n");
				System.out.print("\nDigite o comando: ");
				comando = ler.next().toLowerCase().charAt(0);
				// comando para adicionar um produto ao carrinho
				if (comando == 'a') {
					System.out.print("\nCÓDIGO DO PRODUTO: ");
					ler.nextLine(); // para limpar o final da linha
					codProduto = ler.nextLine();
					
					int indiceEstoque = estoque.encontrarIndice(codProduto);
					if (indiceEstoque > -1) { //verifica se o código do produto foi encontrado ou não
						do {
							System.out.print("\nQUANTIDADE DO PRODUTO: ");
							qtdProduto = ler.nextInt();
							boolean result = pedido.adicionarProdutos(codProduto, indiceEstoque, qtdProduto, estoque);
							linha(90);
							if (result) {
								System.out.print("\n\n\n***PRODUTO ADICIONADO AO CARRINHO***\n\n\n");
								comando = 'n';
							}
							else {
								if (estoque.qtdProdutosIndice(indiceEstoque) > 0) {
									System.out.print("\nHÁ APENAS " + estoque.qtdProdutosIndice(indiceEstoque) + " UNIDADES DISPONÍVEIS\nDESEJA ADICIONAR OUTRA QUANTIDADE? [s/n]: ");
									comando = ler.next().toLowerCase().charAt(0);
								}
								else
									System.out.print("\nPRODUTO ESGOTADO\n");
							}
						} while (comando == 's');
					}
					else {
						System.out.print("\n\n\n***CÓDIGO DO PRODUTO NÃO ENCONTRADO***\n\n\n");
					}
				}
				// comando para retirar um produto ao carrinho
				else if (comando == 'r') {
					System.out.print("\nCÓDIGO DO PRODUTO: ");
					ler.nextLine();
					codProduto = ler.nextLine();
					int indiceCarrinho = pedido.encontrarIndice(codProduto);
					if (indiceCarrinho > -1) { //verifica se o código do produto existe no carrinho
						do {
							System.out.print("\nQUANTIDADE A REMOVER: ");
							qtdProduto = ler.nextInt();
							boolean result = pedido.removerProdutos(codProduto, indiceCarrinho, qtdProduto, estoque);
							linha(90);
							if (result) {
								System.out.print("\n\n\n***PRODUTO(S) RETIRADO(S) DO CARRINHO***\n\n\n");
								comando = 'n';
							}
							else {
								if (pedido.qtdProdutosIndice(indiceCarrinho) > 0) {
									System.out.print("\nHÁ APENAS " + pedido.qtdProdutosIndice(indiceCarrinho) + " UNIDADES DISPONÍVEIS\nDESEJA ADICIONAR OUTRA QUANTIDADE? [s/n]: ");
									comando = ler.next().toLowerCase().charAt(0);
								}
								else
									System.out.print("\n\n***NÃO HÁ PRODUTOS DESTE TIPO NO SEU CARRINHO***\n\n");
							}
						} while (comando == 's');
					}
					else {
						linha(90);
						System.out.print("\n\n***CÓDIGO DE PRODUTO NÃO ENCONTRADO NO SEU CARRINHO***\n\n");
					}
				}
				// comando para exibir o carrinho
				else if (comando == 'c') {
					pedido.imprimirCarrinho();
				}
				// comando para sair do loop do usuário
				else if (comando == 's') {
					break;
				}
				// comando para finalizar a compra
				else if (comando == 'f') {
					boolean result = true; //pedido.pagamento(estoque, cliente);
					if (result) // se result for verdadeiro, sai do loop do usuário
						break;
					else { // se result for falso, o carrinho está vazio, por isso não foi possível finalizar. Avisa isso ao usuário 
						linha(90);
						System.out.println("\n\n***NÃO FOI POSSÍVEL FINALIZAR A COMPRA, POIS O CARRINHO ESTÁ VAZIO***\n\n");
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
