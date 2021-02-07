package miniECommerceOO03;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
	
	private List <Produto> produtos = new ArrayList<>();
	
	
	public int encontrarIndice(String codProduto) {
		int indice = -1;
		int n = produtos.size();
		for (int i = 0; i < n; ++i) { //verifica se existe produto no estoque com o código codProduto
			if (codProduto.equals( produtos.get(i).getCodigo()) ) {
				indice = i;
				break;
			}
		}
		return indice;
	}
	
	public Produto retornarProduto(int indice) {
		return produtos.get(indice);
	}
	
	public int qtdProdutosIndice(int indice) {
		return produtos.get(indice).getQuantidade();
	}
	
	public boolean removerProdutosIndice(int indice, int qtdProduto) {
		
		if (qtdProduto < 0) return false;
		if (indice >= produtos.size()) return false; //indice precisa ser menor que o tamanho da lista de produtos
		Produto produto = produtos.get(indice);
		if (produto.getQuantidade() < qtdProduto) return false; //se não há produto o suficiente no carrinho, retorna falso
		
		//senão, atualiza a quantidade do produto
		produto.setQuantidade(produto.getQuantidade() - qtdProduto);
		return true;
	}
	
	public boolean adicionarProdutosIndice(int indice, int qtdProduto) {
		
		if (indice < 0) return false;
		if (indice >= produtos.size()) return false;
		
		Produto p = produtos.get(indice);
		p.setQuantidade( p.getQuantidade() + qtdProduto );
		
		return true;
	}
	
	public void renovarProdutos() { //renova todos os produtos, com 10 no estoque
		for (Produto p : produtos) {
			p.setQuantidade(10);
		}
	}
	
	public void inicializarComValoresPadrao() { //renovar estoque
		//Produto p = new Produto(codigo, nome, quantidade, precoUnitario);
		Produto p = new Produto("01", "Bolinha de morder para cães", 10, 9.9);
		produtos.add(p);
		p = new Produto("02", "Tabuleiro roleta para cães", 10, 22.9);
		produtos.add(p);
		p = new Produto("03", "Rato João-Bobo para gatos", 10, 12.0);
		produtos.add(p);
		p = new Produto("04", "Arranhador para gatos", 10, 35.9);
		produtos.add(p);
		p = new Produto("05", "Pelúcia para cães", 10, 29.9);
		produtos.add(p);
		p = new Produto("06", "Rodinha para hamsters", 10, 16.9);
		produtos.add(p);
		p = new Produto("07", "Mordedor de borracha para cães", 10, 9.9);
		produtos.add(p);
		p = new Produto("08", "Caixa toca para gatos", 10, 20.9);
		produtos.add(p);
		p = new Produto("09", "Mordedor osso de pelúcia para cães", 10, 15.9);
		produtos.add(p);
		p = new Produto("10", "Piscina de bolinhas para cães", 10, 99.9);
		produtos.add(p);
		
	}
	
	public void imprimirLista() {
		
		System.out.print("\nPRODUTOS:\nCOD PRODUTO\tESTOQUE  \tPREÇO UNITÁRIO \t\tNOME DO PRODUTO\n");
		for (Produto p : produtos) {
			System.out.printf("%s \t\t %d \t\tR$ %.2f    \t\t%s\n", p.getCodigo(), p.getQuantidade(), p.getPrecoUnitario(), p.getNome());
		}
	}

}
