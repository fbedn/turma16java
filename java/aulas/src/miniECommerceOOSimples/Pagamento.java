package miniECommerceOOSimples;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Pagamento {
	
	Date dataHoraAtual = new Date();
	String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
	String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
	
	private double totalGeral;
	private double totalComImposto;
	private int opcaoPagamento;
	
	public double getTotalGeral() {
		return totalGeral;
	}
	public void setTotalGeral(double subTotal) {
		this.totalGeral = subTotal;
	}
	public double valorImposto() {
		return totalGeral*0.09;
	}
	
	public int getOpcaoPagamento() {
		return opcaoPagamento;
	}
	public void setOpcaoPagamento(int opcaoPagamento) {
		this.opcaoPagamento = opcaoPagamento;
	}
	public double totalComImposto() {
		return totalComImposto = totalGeral+(totalGeral*0.09);
	}
	
	public double precoAVista() {
		return totalComImposto*0.9;
	}
	
	public double precoCartao1Vez() {
		return totalComImposto;
	}
	
	public double precoCartao2Vezes() {
		return totalComImposto*1.10;
	}
	
	public double precoCartao3Vezes() {
		return totalComImposto*1.15;
	}
	
	public double calcularTotalGeral(List<Produto> carrinho) {
		for(Produto calculando : carrinho) {
			double mult = calculando.getQuantidade()*calculando.getPrecoUnitario();
			totalGeral += mult;
		}
		return totalGeral;
	}
	
	// public void geraNotaFiscal() {}
	
	public void notaFiscal(List<Produto> carrinho) {
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