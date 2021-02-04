package listaPOO02;

public class Vendedor extends Pessoa {

	/*
	 * EXERC�CIO 6 
	 * Implemente a classe Vendedor como subclasse da classe Pessoa. 
	 * Um determinado vendedor tem como atributos da classe Pessoa e tamb�m os atributos pr�prios:
	 * - valorVendas (correspondente ao valor monet�rio dos artigos vendidos)
	 * - comissao (porcentagem do valorVendas que ser� adicionado ao vencimento base do Vendedor). 
	 */
	
	private double valorVendas;
	private double comissao;
	
	
	/*Construtores*/
	
	public Vendedor() {
		super();
		comissao = 10;
	}
	public Vendedor(String nome, String endereco) {
		super(nome, endereco);
		comissao = 10;
	}
	public Vendedor(String nome, String endereco, String telefone) {
		super(nome, endereco, telefone);
		comissao = 10;
	}
	public Vendedor(String nome, String endereco, String telefone, double valorVendas, double comissao) {
		super(nome, endereco, telefone);
		this.valorVendas = valorVendas;
		this.comissao = comissao;
	}
	
	
	/*Getters e Setters*/
	
	public double getValorVendas() {
		return valorVendas;
	}
	public void setValorVendas(double valorVendas) {
		this.valorVendas = valorVendas;
	}
	public double getComissao() {
		return comissao;
	}
	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	
	/*Outros m�todos*/
	
	public void inserirVenda(double valor) {
		if (valor > 0 ) {
			valorVendas = valorVendas + valor;
		}
	}
	
	public double valorComissoes() {
		return valorVendas*comissao*0.01;
	}
	
}
