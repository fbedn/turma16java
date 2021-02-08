package miniECommerceOO03;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class Pedido {
	
	Date dataHoraAtual = new Date();
	String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
	String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
	
	private List <Produto> carrinho = new ArrayList<>();
	private double subTotal = 0;
	
	Pagamento pagamento;
	Cliente cliente;

	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
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
	/*
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
	}*/
	/*
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
	*/
	
	public void imprimirCarrinho() {
		System.out.print("\nCARINHO DE COMPRAS:\nCOD PRODUTO\t|\tPreço unitário\t|\tQuantidade\t|\tNome\n");
		for (Produto p : carrinho) {
			System.out.print(p.getCodigo() + "\t\t|\tR$ " + p.getPrecoUnitario() + "\t\t|\t" + p.getQuantidade() +"\t\t|\t"+p.getNome()+"\n");
		}
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
	
	public double subTotal() {
		
		for(Produto calculando : carrinho) {
			double mult = calculando.getQuantidade()*calculando.getPrecoUnitario();

			subTotal += mult;
		}
		return subTotal;
	}
	
	public void zerarCarrinho(Estoque estoque) {
		int n = carrinho.size();
		for(int i = 0; i < n; i++) {
			Produto p = carrinho.get(i);
			int qtd = p.getQuantidade();
			String codigo = p.getCodigo();
			removerProdutos(codigo, qtd, estoque);
		}
	}
	
	public void notaFiscal() {
		System.out.println("\t\tPAGUFE PetShop\n"
	            +"\t\t NOTA FISCAL\n"
	            +"\tEndereço, 0000 - Bairro\n"
	            +"\tSão Paulo - SP - CEP 00000-000\n"
	            +"CNPJ: XX.XXX.XXX/XXXX-XX\n"
	            +"----------------------------------------------------\n"
	            +data+"\t\t\t\t"+hora+"\n"
	            +"qntd\t preço\t produto \n");
				for (Produto p : carrinho) 
				{
					System.out.print(p.getQuantidade() +"\t"+ p.getPrecoUnitario()+"\t"+p.getNome()+"\n");
				}
	           System.out.println("----------------------------------------------------\n"
	   	            +"total: \t " );
	}
}
