package miniECommerceOO03;

public class Pagamento {
	
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
	
}