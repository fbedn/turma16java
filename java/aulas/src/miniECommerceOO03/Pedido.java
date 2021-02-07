package miniECommerceOO03;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private List <Produto> carrinho = new ArrayList<>();
	
	public int encontrarIndice(String codProduto) {
		int indice = -1;
		int n = carrinho.size();
		for (int i = 0; i < n; ++i) { //verifica se existe produto no estoque com o código codProduto
			if (codProduto.equals( carrinho.get(i).getCodigo()) ) {
				indice = i;
				break;
			}
		}
		return indice;
	}
	
	public int qtdProdutosIndice(int indice) {
		return carrinho.get(indice).getQuantidade();
	}
	
	public boolean adicionarProdutos(String codProduto, int iEstoque, int qtdProduto, Estoque estoque) {
		if (qtdProduto < 0) return false;
		if (iEstoque < 0) return false; //se o índice é negativo, retorna falso
		
		boolean removeDoEstoque = estoque.removerProdutosIndice(iEstoque, qtdProduto);
		if (removeDoEstoque == false) return false;
		
		Produto prodEstoque = estoque.retornarProduto(iEstoque);
		int iCarrinho = encontrarIndice(codProduto);
		if (iCarrinho < 0) { //se o índice do carrinho for menor que 0, o produto ainda não está no carrrinho
			Produto prodCarrinho = new Produto(codProduto, prodEstoque.getNome(), qtdProduto, prodEstoque.getPrecoUnitario());
			carrinho.add(prodCarrinho);
			//carrinho.add( new Produto(codProduto, prodEstoque.getNome(), qtdProduto, prodEstoque.getPrecoUnitario()) );
		}
		else { //senão, só atualiza a quantidade do produto no carrinho
			Produto prodCarrinho = carrinho.get(iCarrinho);
			prodCarrinho.setQuantidade( prodCarrinho.getQuantidade() + qtdProduto );
		}
		
		return true;
	}
	
	public void imprimirCarrinho() {
		System.out.print("\n\n|\tCOD\t|\tPreço\t|   Quantidade No Seu Carrinho\n");
		for (Produto p : carrinho) {
			System.out.print("|\t" + p.getCodigo() + "\t|\t" + p.getPrecoUnitario() + "\t|\t" + p.getQuantidade() +"\n");
		}
		
		/*
		System.out.print("\n\n|\tCOD\t|\tPreço\t|   Seu Carrinho   |\tProduto Restante\t\n");
		for (int i = 0; i < 10; i++) {
			if (carrinhoCompras[i] != 0) {
				System.out.print("|\t" + (i + 1) + "\t|\t" + precoProdutos[i] + "\t|\t" + carrinhoCompras[i] + "\t|\t" + estoque[i] + "\n");
			}
		}
		*/
	}
	
	public boolean removerProdutos(String codProduto, int iCarrinho, int qtdProduto, Estoque estoque) {
		
		if (qtdProduto < 0) return false;
		if (iCarrinho < 0) return false; //se o índice é negativo, retorna falso
		
		Produto prodCarrinho = carrinho.get(iCarrinho);
		if ( qtdProduto > prodCarrinho.getQuantidade() ) return false;
		
		if ( qtdProduto == prodCarrinho.getQuantidade() ) { //se a quantidade a ser removida é igual à quantidade no carrinho
			carrinho.remove(iCarrinho); //remove o próprio elemento de posição iCarrinho
		}
		else { //se a quantidade a ser removida é igual menor que a quantidade no carrinho
			prodCarrinho.setQuantidade( prodCarrinho.getQuantidade() - qtdProduto ); //apenas subtrai a quantidade qtdProduto
		}
		
		int iEstoque = estoque.encontrarIndice(codProduto);
		if (iEstoque < 0) return false; //se não encontrou, retorna falso
		boolean adicionaAoEstoque = estoque.adicionarProdutosIndice(iEstoque, qtdProduto);
		if (adicionaAoEstoque == false) return false;
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	//adiciona produtos sem informar índice do estoque
	public boolean adicionarProdutos(String codProduto, int qtdProduto, Estoque estoque) {
		
		if (qtdProduto < 0) return false;
		int iEstoque = estoque.encontrarIndice(codProduto);
		if (iEstoque < 0) return false; //se não encontrou, retorna falso
		boolean removeDoEstoque = estoque.removerProdutosIndice(iEstoque, qtdProduto);
		if (removeDoEstoque == false) return false;
		
		Produto prodEstoque = estoque.retornarProduto(iEstoque);
		int iCarrinho = encontrarIndice(codProduto);
		if (iCarrinho < 0) { //se o índice do carrinho for menor que 0, o produto ainda não está no carrrinho
			Produto prodCarrinho = new Produto(codProduto, prodEstoque.getNome(), qtdProduto, prodEstoque.getPrecoUnitario());
			carrinho.add(prodCarrinho);
			//carrinho.add( new Produto(codProduto, prodEstoque.getNome(), qtdProduto, prodEstoque.getPrecoUnitario()) );
		}
		else { //senão, só atualiza a quantidade do produto no carrinho
			Produto prodCarrinho = carrinho.get(iCarrinho);
			prodCarrinho.setQuantidade( prodCarrinho.getQuantidade() + qtdProduto );
		}
		
		return true;
	}
	
	
	
	//remove produtos sem informar índice do produto no carrinho
	public boolean removerProdutos(String codProduto, int qtdProduto, Estoque estoque) {
		
		if (qtdProduto < 0) return false;
		int iCarrinho = encontrarIndice(codProduto);
		Produto prodCarrinho = carrinho.get(iCarrinho);
		if ( qtdProduto > prodCarrinho.getQuantidade() ) return false;
		
		if ( qtdProduto == prodCarrinho.getQuantidade() ) { //se a quantidade a ser removida é igual à quantidade no carrinho
			carrinho.remove(iCarrinho); //remove o próprio elemento de posição iCarrinho
		}
		else { //se a quantidade a ser removida é igual menor que a quantidade no carrinho
			prodCarrinho.setQuantidade( prodCarrinho.getQuantidade() - qtdProduto ); //apenas subtrai a quantidade qtdProduto
		}
		
		int iEstoque = estoque.encontrarIndice(codProduto);
		if (iEstoque < 0) return false; //se não encontrou, retorna falso
		boolean adicionaAoEstoque = estoque.adicionarProdutosIndice(iEstoque, qtdProduto);
		if (adicionaAoEstoque == false) return false;
		
		return true;
	}
		
}
