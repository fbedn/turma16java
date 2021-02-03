package lista5;

public class ContaBancaria {
	
	private int numeroConta;
	private String titular;
	private double saldo;
	
	public ContaBancaria(int numeroConta, String titular, double saldo) {
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	protected int getNumeroConta() {
		return numeroConta;
	}
	
	protected String getTitular() {
		return titular;
	}
	
	protected double getSaldo() {
		return saldo;
	}
	
	protected void depositar(double valor) {
		saldo = saldo+valor;
	}
	
	protected void debitar(double valor) {
		double result = saldo-valor;
		if (result >= 0) { //verifica se a conta não fica negativa
			saldo = result;
		}
	}
	
}
