package aulas;

import java.util.Scanner;

public class Projeto_Mini_E_Commerce_Simples {
	
	//imprime lista de produtos dispon�veis da loja
	static void imprimeLista(int n, String[] codigoProdutos, String[] nomeProdutos, int[] qtdProdutos, double[] precoProdutos)
	{
		System.out.print("\nCOD PRODUTO\tESTOQUE \tPRE�O UNIT�RIO \t NOME DO PRODUTO\n");
		for (int i = 0; i < n; ++i) {
			System.out.print(codigoProdutos[i]+" \t\t "+qtdProdutos[i]+" \t\t"+precoProdutos[i]+" \t\t "+nomeProdutos[i]+"\n");
		}
	}
	//encontra o �ndice do produto a partir do c�digo dele. Retorna o �ndice se encontrou, e -1 se n�o encontrou
	static int encontraIndice(String codProduto, int n, String[] codigoProdutos)
	{
		int indice = -1;
		for (int i = 0; i < n; ++i) {//procura o �ndice do c�digo
			if (codProduto.equals(codigoProdutos[i])) {
				indice = i;
			}
		}
		return indice;
	}
	//adiciona ao carrinho. Retorna verdadeiro se conseguiu e falso se n�o conseguiu
	static boolean adicionaAoCarrinho(int indice, String codProduto, int qtdProduto, int carrinhoCompras[], double precoUsuario, int n, String codigoProdutos[], int qtdProdutos[], double precoProdutos[]) {
		if (qtdProduto < 0) return false; //retorna falso se a quantidade a ser adicionada for menor que zero
		//verifica se ainda h� a quantidade do produto informado
		int restante = qtdProdutos[indice]-qtdProduto;
		if (restante < 0) return false; //se n�o h� produtos suficiente, retorna falso
		//se h� produtos o suficiente, adiciona ao carrinho e retorna verdadeiro
		carrinhoCompras[indice] = carrinhoCompras[indice]+qtdProduto; //adiciona 1 � posi��o correta do carrinho do usu�rio
		qtdProdutos[indice] = qtdProdutos[indice]-qtdProduto; //retira 1 da posi��o correta do vetor dos produtos da loja
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
		int carrinhoCompras[] = new int[n]; //quantidade dos produtos que o usu�rio colocou no carrinho
		double precoUsuario = 0; //pre�o total do usu�rio
		System.out.print("NOME LOJA\nSlogan\n");
		imprimeLista(n,codigoProdutos,nomeProdutos,qtdProdutos,precoProdutos);
		do
		{
			System.out.print("\nCOMANDOS\n - a - adicionar produto ao carrinho\n - c - ver carrinho\n - f - finalizar compra\n");
			comando = ler.next().toLowerCase().charAt(0);
			if (comando == 'a')
			{
				System.out.print("\nC�DIGO DO PRODUTO: ");
				codProduto = ler.nextLine(); //l� o resto de linha 
				codProduto = ler.nextLine();
				int indice = encontraIndice(codProduto, n, codigoProdutos);
				//verifica se encontrou o �ndice
				if (indice > -1)
				{
					do //este la�o foi colocado para: caso a quantidade informada pelo usu�rio ser maior que a quantidade em estoque, o usu�rio tem chance de inserir outra quantidade
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
								System.out.print("\nH� APENAS "+qtdProdutos[indice]+" UNIDADES DISPON�VEIS\nDESEJA ADICIONAR OUTRA QUANTIDADE? [s/n]: ");
								comando = ler.next().toLowerCase().charAt(0);
							}
							else System.out.print("\nPRODUTO ESGOTADO\n");
						}
					}
					while (comando == 's');
				}
				else //�ndice retornado foi -1, ent�o n�o encontrou o produto com o c�digo informado
				{
					System.out.print("\n\n\n---C�DIGO DO PRODUTO N�O ENCONTRADO---\n");
				}
			}
		}
		while (comando != 'f');
		ler.close();
	}
}