package miniECommerceOO;

import java.util.Scanner;

import miniECommerceOO03.Cliente;
import miniECommerceOO03.Estoque;
import miniECommerceOO03.Pedido;

public class PrincipalVersaoAlternativa {

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
					System.out.print("\nQUANTIDADE DO PRODUTO: ");
					qtdProduto = ler.nextInt();
					boolean result = pedido.adicionarProdutos(codProduto, qtdProduto, estoque);
					linha(90);
					if (result) {
						System.out.print("\n\n\n***PRODUTO ADICIONADO AO CARRINHO***\n\n\n");
						comando = 'n';
					}
					else {
						System.out.print("\n\n\n***N�O FOI POSS�VEL ADICIONAR O PRODUTO AO CARRINHO***\n\n\n");
					}
				}
				// comando para retirar um produto ao carrinho
				else if (comando == 'r') {
					System.out.print("\nC�DIGO DO PRODUTO: ");
					ler.nextLine();
					codProduto = ler.nextLine();
					System.out.print("\nQUANTIDADE A REMOVER: ");
					qtdProduto = ler.nextInt();
					boolean result = pedido.removerProdutos(codProduto, qtdProduto, estoque);
					linha(90);
					if (result) {
						System.out.print("\n\n\n***PRODUTO(S) RETIRADO(S) DO CARRINHO***\n\n\n");
						comando = 'n';
					}
					else {
						System.out.print("\n\n\n***N�O FOI POSS�VEL RETIRAR O PRODUTO DO CARRINHO***\n\n\n");
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
					boolean result = true; //pedido.pagamento(estoque, cliente);
					if (result) // se result for verdadeiro, sai do loop do usu�rio
						break;
					else { // se result for falso, o carrinho est� vazio, por isso n�o foi poss�vel finalizar. Avisa isso ao usu�rio 
						linha(90);
						System.out.println("\n\n***N�O FOI POSS�VEL FINALIZAR A COMPRA, POIS O CARRINHO EST� VAZIO***\n\n");
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
