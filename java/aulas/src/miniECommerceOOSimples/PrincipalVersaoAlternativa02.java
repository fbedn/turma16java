package miniECommerceOOSimples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalVersaoAlternativa02 {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		
		List <Produto> estoque = new ArrayList<>();
		inicializarEstoqueValores(estoque);
		
		char comando;
		String codProduto;
		int qtdProduto;
		char comandoExterno;
		do { //loop principal. Sempre que inicia, os dados do usuário começam zerados
			Cliente cliente = new Cliente();
			List <Produto> carrinho = new ArrayList<>();
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
				imprimirEstoque(estoque);
				linha(90);
				System.out.print("\nCOMANDOS:\na = Adicionar produto ao carrinho\nr = Retirar produto do carrinho\nc = Exibir o carrinho de compras\nf = Finalizar compra\ns = Sair\n");
				System.out.print("\nDigite o comando: ");
				comando = ler.next().toLowerCase().charAt(0);
				// comando para adicionar um produto ao carrinho
				if (comando == 'a') {
					System.out.print("\nCÓDIGO DO PRODUTO: ");
					ler.nextLine(); // para limpar o final da linha
					codProduto = ler.nextLine();
					System.out.print("\nQUANTIDADE DO PRODUTO: ");
					qtdProduto = ler.nextInt();
					trocarProdutos(codProduto, qtdProduto, carrinho, estoque); //adiciona qtdProduto ao carrinho, e retira a mesma quantidade do estoque
				}
				// comando para retirar um produto ao carrinho
				else if (comando == 'r') {
					System.out.print("\nCÓDIGO DO PRODUTO: ");
					ler.nextLine();
					codProduto = ler.nextLine();
					System.out.print("\nQUANTIDADE A REMOVER: ");
					qtdProduto = ler.nextInt();
					trocarProdutos(codProduto, qtdProduto, estoque, carrinho); //retira qtdProduto do carrinho, e coloca a mesma quantidade no estoque
				}
				// comando para exibir o carrinho
				else if (comando == 'c') {
					imprimirCarrinho(carrinho);
				}
				// comando para sair do loop do usuário
				else if (comando == 's') {
					break;
				}
				// comando para finalizar a compra
				else if (comando == 'f') {
					
					Pagamento pagamento = new Pagamento();
					pagamento.calcularTotalGeral(carrinho);
					
					System.out.printf("\nTotal Geral: R$ %.2f + IMPOSTO (9%%): R$ %.2f  Total com imposto: R$ %.2f \n",pagamento.getTotalGeral(),pagamento.valorImposto(),pagamento.totalComImposto());
					System.out.printf("\nEscolha a forma de pagamento\n");
					System.out.print("\n1- ZERAR CARRINHO");
					System.out.printf("\n2- A VISTA - 10%% DESCONTO: R$%.2f",pagamento.precoAVista());	
					System.out.printf("\n3- CARTÃO - 1 VEZ:  R$%.2f SEM DESCONTO", pagamento.precoCartao1Vez());
					System.out.printf("\n4- CARTÃO - 2 VEZES - JUROS (10%%) - PARCELAS DE:  R$%.2f - TOTAL DE: R$%.2f",(pagamento.precoCartao2Vezes()/2),pagamento.precoCartao2Vezes());
					System.out.printf("\n5- CARTÃO - 3 VEZES - JUROS (15%%) - PARCELAS DE:  R$%.2f - TOTAL DE: R$%.2f",(pagamento.precoCartao3Vezes()/3),pagamento.precoCartao3Vezes());
					System.out.print("\n\nInsira Aqui: ");
					
					linha(80);
					int opcao = ler.nextInt();
					if (opcao == 1) {
						zerarCarrinho(carrinho, estoque);
						System.out.println("Seu carrinho foi zerado!");
					}
					else if (opcao == 2) {
						pagamento.setOpcaoPagamento(opcao);
						pagamento.notaFiscal(carrinho);
						System.out.printf("À VISTA - 10%% DESCONTO: R$%.2f",pagamento.precoAVista());
						System.out.println("\nAgrademos pela compra, "+cliente.tratamento()+" "+cliente.getNome()+". Volte sempre !");
						break;
					}
					else if (opcao == 3) {
						pagamento.setOpcaoPagamento(opcao);
						pagamento.notaFiscal(carrinho);
						System.out.printf("CARTÃO - 1 VEZ:  R$%.2f SEM DESCONTO", pagamento.precoCartao1Vez());
						System.out.println("\nAgrademos pela compra, "+cliente.tratamento()+" "+cliente.getNome()+". Volte sempre !");
						break;
					}
					else if (opcao == 4) {
						pagamento.setOpcaoPagamento(opcao);
						pagamento.notaFiscal(carrinho);
						System.out.printf("CARTÃO - 2 VEZES - JUROS (10%%) - PARCELAS DE:  R$%.2f - TOTAL DE: R$%.2f",(pagamento.precoCartao2Vezes()/2),pagamento.precoCartao2Vezes());
						System.out.println("\nAgrademos pela compra, "+cliente.tratamento()+" "+cliente.getNome()+". Volte sempre !");
						break;
					}
					else if (opcao == 5) {
						pagamento.setOpcaoPagamento(opcao);
						pagamento.notaFiscal(carrinho);
						System.out.printf("CARTÃO - 3 VEZES - JUROS (15%%) - PARCELAS DE:  R$%.2f - TOTAL DE: R$%.2f",(pagamento.precoCartao3Vezes()/3),pagamento.precoCartao3Vezes());
						System.out.println("\nAgrademos pela compra, "+cliente.tratamento()+" "+cliente.getNome()+". Volte sempre !");
						break;
					}
					else {
						System.out.println("\nOpção inválida!\nTente novamente\n");
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
	static void linha(int tamanho) {
		for (int i = 1; i < tamanho; i++) {
			System.out.print("_");
		}
		System.out.println();
	}
	
	
	public static int encontrarIndice(List<Produto> produtos, String codProduto) {
		int indice = -1;
		int n = produtos.size();
		for (int i = 0; i < n; ++i) { //verifica se existe produto no estoque com o código codProduto
			if ( codProduto.equals(produtos.get(i).getCodigo()) ) {
				indice = i;
				break;
			}
		}
		return indice;
	}
	
	
	static boolean trocarProdutos(String codProduto, int qtd, List<Produto> listaAdiciona, List<Produto> listaRemove) {
		
		int iListaRemove = encontrarIndice(listaRemove, codProduto);
		if (iListaRemove == -1) return false; //retorna falso se NÃO encontrou o índice do elemento a ser removido
		Produto produtoListaRemove = listaRemove.get(iListaRemove);
		if ( qtd > produtoListaRemove.getQuantidade() ) return false;
		
		if ( qtd == produtoListaRemove.getQuantidade() ) {
			listaAdiciona.add(produtoListaRemove);
			listaRemove.remove(iListaRemove);
		}
		else {
			int iListaAdiciona = encontrarIndice(listaAdiciona, codProduto);
			if (iListaAdiciona == -1) {
				Produto produtoListaAdiciona = new Produto(codProduto, produtoListaRemove.getNome(), qtd, produtoListaRemove.getPrecoUnitario());
				listaAdiciona.add(produtoListaAdiciona); //adiciona à lista a adicionar
				produtoListaRemove.setQuantidade(produtoListaRemove.getQuantidade() - qtd); //retira da lista a remover
			}
			else {
				Produto produtoListaAdiciona = listaAdiciona.get(iListaAdiciona);
				produtoListaAdiciona.setQuantidade(produtoListaAdiciona.getQuantidade() + qtd); //adiciona à lista a adicionar
				produtoListaRemove.setQuantidade(produtoListaRemove.getQuantidade() - qtd); //retira da lista a remover
			}
		}
		int iListaAdiciona = encontrarIndice(listaAdiciona, codProduto);
		if (iListaAdiciona == -1) {
			
		}
		return true;
	}
	
	
	static void imprimirCarrinho(List<Produto> carrinho) {
		System.out.print("\n\n|\tCOD\t|\tPreço\t|   Quantidade No Seu Carrinho\n");
		for (Produto p : carrinho) {
			System.out.print("|\t" + p.getCodigo() + "\t|\t" + p.getPrecoUnitario() + "\t|\t" + p.getQuantidade() +"\n");
		}
	}
	
	static void zerarCarrinho(List<Produto> carrinho, List<Produto> estoque) {
		int n = carrinho.size();
		for(int i = 0; i < n; i++) {
			Produto p = carrinho.get(i);
			int qtd = p.getQuantidade();
			String codigo = p.getCodigo();
			trocarProdutos(codigo, qtd, estoque, carrinho);
		}
	}
	
	
	static void inicializarEstoqueValores(List<Produto> estoque) {
		
		estoque.add( new Produto("01", "Bolinha de morder para cães", 10, 9.9) );
		estoque.add( new Produto("02", "Tabuleiro roleta para cães", 10, 22.9) );
		estoque.add( new Produto("03", "Rato João-Bobo para gatos", 10, 12.0) );
		estoque.add( new Produto("04", "Arranhador para gatos", 10, 35.9) );
		estoque.add( new Produto("05", "Pelúcia para cães", 10, 29.9) );
		estoque.add( new Produto("06", "Rodinha para hamsters", 10, 16.9) );
		estoque.add( new Produto("07", "Mordedor de borracha para cães", 10, 9.9) );
		estoque.add( new Produto("08", "Caixa toca para gatos", 10, 20.9) );
		estoque.add( new Produto("09", "Mordedor osso de pelúcia para cães", 10, 15.9) );
		estoque.add( new Produto("10", "Piscina de bolinhas para cães", 10, 99.9) );
	}
	
	
	static void imprimirEstoque(List<Produto> estoque) {
		System.out.print("\nCOD PRODUTO\tESTOQUE  \tPREÇO UNITÁRIO \t\tNOME DO PRODUTO\n");
		for (Produto p : estoque) {
			System.out.printf("%s \t\t %d \t\tR$ %.2f    \t\t%s\n", p.getCodigo(), p.getQuantidade(), p.getPrecoUnitario(), p.getNome());
		}
	}
}
	
