package aulas;

import java.util.Scanner;

public class Projeto_Mini_E_Commerce_Simples {
	
	//imprime lista de produtos disponíveis da loja
	static void imprimeLista(int n, String[] codigoProdutos, String[] nomeProdutos, int[] qtdProdutos, double[] precoProdutos)
	{
		System.out.print("\nCOD PRODUTO\tESTOQUE \tPREÇO UNITÁRIO \t NOME DO PRODUTO\n");
		for (int i = 0; i < n; ++i) {
			System.out.print(codigoProdutos[i]+" \t\t "+qtdProdutos[i]+" \t\t"+precoProdutos[i]+" \t\t "+nomeProdutos[i]+"\n");
		}
	}
	//encontra o índice do produto a partir do código dele. Retorna o índice se encontrou, e -1 se não encontrou
	static int encontraIndice(String codProduto, int n, String[] codigoProdutos)
	{
		int indice = -1;
		for (int i = 0; i < n; ++i) {//procura o índice do código
			if (codProduto.equals(codigoProdutos[i])) {
				indice = i;
			}
		}
		return indice;
	}
	//adiciona ao carrinho. Retorna verdadeiro se conseguiu e falso se não conseguiu
	static boolean adicionaAoCarrinho(int indice, String codProduto, int qtdProduto, int carrinhoCompras[], double precoUsuario, int n, String codigoProdutos[], int qtdProdutos[], double precoProdutos[]) {
		if (qtdProduto < 0) return false; //retorna falso se a quantidade a ser adicionada for menor que zero
		//verifica se ainda há a quantidade do produto informado
		int restante = qtdProdutos[indice]-qtdProduto;
		if (restante < 0) return false; //se não há produtos suficiente, retorna falso
		//se há produtos o suficiente, adiciona ao carrinho e retorna verdadeiro
		carrinhoCompras[indice] = carrinhoCompras[indice]+qtdProduto; //adiciona 1 à posição correta do carrinho do usuário
		qtdProdutos[indice] = qtdProdutos[indice]-qtdProduto; //retira 1 da posição correta do vetor dos produtos da loja
		return true;
	}
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		final int n = 10;
		String[] codigoProdutos = {"01", "02", "03", "04", "05", "06", "07", "08", "09","10"};
		String[] nomeProdutos = {"prod 1",
									"prod 2",
									"prod 3",
									"prod 4",
									"prod 5",
									"prod 6",
									"prod 7",
									"prod 8",
									"prod 9",
									"prod 10"};
		double precoProdutos[] = {25.90, 43.00, 55.80, 30.00, 41.20, 11.32, 130.90, 21.11, 98.50, 25.00};
		int qtdProdutos[] = {10,10,10,10,10,10,10,10,10,10};
		char comando;
		String codProduto;
		int qtdProduto;
		int carrinhoCompras[] = new int[n]; //quantidade dos produtos que o usuário colocou no carrinho
		double precoUsuario = 0; //preço total do usuário
		System.out.print("NOME LOJA\nSlogan\n");
		imprimeLista(n,codigoProdutos,nomeProdutos,qtdProdutos,precoProdutos);
		do
		{
			System.out.print("\nCOMANDOS\n - a - adicionar produto ao carrinho\n - c - ver carrinho\n - f - finalizar compra\n");
			comando = ler.next().toLowerCase().charAt(0);
			if (comando == 'a')
			{
				System.out.print("\nCÓDIGO DO PRODUTO: ");
				codProduto = ler.nextLine(); //lê o resto de linha 
				codProduto = ler.nextLine();
				int indice = encontraIndice(codProduto, n, codigoProdutos);
				//verifica se encontrou o índice
				if (indice > -1)
				{
					do //este laço foi colocado para: caso a quantidade informada pelo usuário ser maior que a quantidade em estoque, o usuário tem chance de inserir outra quantidade
					{
						System.out.print("\nQUANTIDADE DO PRODUTO: ");
						qtdProduto = ler.nextInt();
						boolean result = adicionaAoCarrinho(indice, codProduto, qtdProduto, carrinhoCompras, precoUsuario, n, codigoProdutos, qtdProdutos, precoProdutos);
						if (result)
						{
							System.out.print("\nPRODUTO ADICIONADO AO CARRINHO\n\n");
						}
						else
						{
							if (qtdProdutos[indice] > 0)
							{
								System.out.print("\nHÁ APENAS "+qtdProdutos[indice]+" UNIDADES DISPONÍVEIS\nDESEJA ADICIONAR OUTRA QUANTIDADE? [s/n]: ");
								comando = ler.next().toLowerCase().charAt(0);
							}
							else System.out.print("\nPRODUTO ESGOTADO\n");
						}
					}
					while (comando == 's');
				}
				else //índice retornado foi -1, então não encontrou o produto com o código informado
				{
					System.out.print("\n\n\n---CÓDIGO DO PRODUTO NÃO ENCONTRADO---\n");
				}
			}
		}
		while (comando != 'f');
		ler.close();
	}
}