package miniECommerceOO;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private List <Produto> carrinho = new ArrayList<>();
	
	public int encontrarIndice(String codProduto) {
		int indice = -1;
		int n = carrinho.size();
		for (int i = 0; i < n; ++i) { //verifica se existe produto no estoque com o c�digo codProduto
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
		if (iEstoque < 0) return false; //se o �ndice � negativo, retorna falso
		
		boolean removeDoEstoque = estoque.removerProdutosIndice(iEstoque, qtdProduto);
		if (removeDoEstoque == false) return false;
		
		Produto prodEstoque = estoque.retornarProduto(iEstoque);
		int iCarrinho = encontrarIndice(codProduto);
		if (iCarrinho < 0) { //se o �ndice do carrinho for menor que 0, o produto ainda n�o est� no carrrinho
			Produto prodCarrinho = new Produto(codProduto, prodEstoque.getNome(), qtdProduto, prodEstoque.getPrecoUnitario());
			carrinho.add(prodCarrinho);
			//carrinho.add( new Produto(codProduto, prodEstoque.getNome(), qtdProduto, prodEstoque.getPrecoUnitario()) );
		}
		else { //sen�o, s� atualiza a quantidade do produto no carrinho
			Produto prodCarrinho = carrinho.get(iCarrinho);
			prodCarrinho.setQuantidade( prodCarrinho.getQuantidade() + qtdProduto );
		}
		
		return true;
	}
	
	public boolean removerProdutos(String codProduto, int iCarrinho, int qtdProduto, Estoque estoque) {
		
		if (qtdProduto < 0) return false;
		if (iCarrinho < 0) return false; //se o �ndice � negativo, retorna falso
		
		Produto prodCarrinho = carrinho.get(iCarrinho);
		if ( qtdProduto > prodCarrinho.getQuantidade() ) return false;
		
		if ( qtdProduto == prodCarrinho.getQuantidade() ) { //se a quantidade a ser removida � igual � quantidade no carrinho
			carrinho.remove(iCarrinho); //remove o pr�prio elemento de posi��o iCarrinho
		}
		else { //se a quantidade a ser removida � igual menor que a quantidade no carrinho
			prodCarrinho.setQuantidade( prodCarrinho.getQuantidade() - qtdProduto ); //apenas subtrai a quantidade qtdProduto
		}
		
		int iEstoque = estoque.encontrarIndice(codProduto);
		if (iEstoque < 0) return false; //se n�o encontrou, retorna falso
		boolean adicionaAoEstoque = estoque.adicionarProdutosIndice(iEstoque, qtdProduto);
		if (adicionaAoEstoque == false) return false;
		
		return true;
	}
	
	public void imprimirCarrinho() {
		System.out.print("\nCARINHO DE COMPRAS:\nCOD PRODUTO\t|\tPre�o unit�rio\t|\tQuantidade\t|\tNome\n");
		for (Produto p : carrinho) {
			System.out.print(p.getCodigo() + "\t\t|\tR$ " + p.getPrecoUnitario() + "\t\t|\t" + p.getQuantidade() +"\t\t|\t"+p.getNome()+"\n");
		}
	}
	
	
	
	//adiciona produtos sem informar �ndice do estoque
	public boolean adicionarProdutos(String codProduto, int qtdProduto, Estoque estoque) {
		
		if (qtdProduto < 0) return false;
		int iEstoque = estoque.encontrarIndice(codProduto);
		if (iEstoque < 0) return false; //se n�o encontrou, retorna falso
		boolean removeDoEstoque = estoque.removerProdutosIndice(iEstoque, qtdProduto);
		if (removeDoEstoque == false) return false;
		
		Produto prodEstoque = estoque.retornarProduto(iEstoque);
		int iCarrinho = encontrarIndice(codProduto);
		if (iCarrinho < 0) { //se o �ndice do carrinho for menor que 0, o produto ainda n�o est� no carrrinho
			Produto prodCarrinho = new Produto(codProduto, prodEstoque.getNome(), qtdProduto, prodEstoque.getPrecoUnitario());
			carrinho.add(prodCarrinho);
			//carrinho.add( new Produto(codProduto, prodEstoque.getNome(), qtdProduto, prodEstoque.getPrecoUnitario()) );
		}
		else { //sen�o, s� atualiza a quantidade do produto no carrinho
			Produto prodCarrinho = carrinho.get(iCarrinho);
			prodCarrinho.setQuantidade( prodCarrinho.getQuantidade() + qtdProduto );
		}
		
		return true;
	}
	
	
	//remove produtos sem informar �ndice do produto no carrinho
	public boolean removerProdutos(String codProduto, int qtdProduto, Estoque estoque) {
		
		if (qtdProduto < 0) return false;
		int iCarrinho = encontrarIndice(codProduto);
		Produto prodCarrinho = carrinho.get(iCarrinho);
		if ( qtdProduto > prodCarrinho.getQuantidade() ) return false;
		
		if ( qtdProduto == prodCarrinho.getQuantidade() ) { //se a quantidade a ser removida � igual � quantidade no carrinho
			carrinho.remove(iCarrinho); //remove o pr�prio elemento de posi��o iCarrinho
		}
		else { //se a quantidade a ser removida � igual menor que a quantidade no carrinho
			prodCarrinho.setQuantidade( prodCarrinho.getQuantidade() - qtdProduto ); //apenas subtrai a quantidade qtdProduto
		}
		
		int iEstoque = estoque.encontrarIndice(codProduto);
		if (iEstoque < 0) return false; //se n�o encontrou, retorna falso
		boolean adicionaAoEstoque = estoque.adicionarProdutosIndice(iEstoque, qtdProduto);
		if (adicionaAoEstoque == false) return false;
		
		return true;
	}
		
}
