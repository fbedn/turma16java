package lista5;

public class ProdutoEletronico {
	
	private boolean energizado;
	private boolean ligado;
	private boolean standBy;
	String dadosEntrada;
	String dadosSaida;
	
	public ProdutoEletronico() { 
		energizado = false;
		ligado = false;
		standBy = false;
		String dadosSaida = "";
		String dadosEntrada = "";
	}
	public boolean getEnergizado() {
		return energizado;
	}
	public boolean getLigado() {
		return ligado;
	}
	public boolean getStandBy() {
		return standBy;
	}
	
	public void energizar() { //energiza (tomada ou bateria) o produto eletr�nico
		energizado = true;
		if ( !(ligado) ) { //se o produto n�o estiver ligado
			standBy = true; //coloca em standby
		}
	}
	
	public void desenergizar() { //tira a energia (tomada ou bateria) o produto eletr�nico
		energizado = false;
		ligado = false;
		standBy = false;
		String dadosSaida = "";
		String dadosEntrada = "";
	}
	
	public void ligar() { //liga o produto eletr�nico
		if (energizado) { //verifica antes se est� energizado
			ligado = true;
			standBy = false;
		}
	}
	
	public void desligar() { //desliga o produto eletr�nico
		if (energizado) { //verifica antes se est� energizado
			ligado = false;
			standBy = true;
			String dadosSaida = "";
			String dadosEntrada = "";
		}
	}
	
	public void colocarEmStandBy() { //coloca em StandBy
		if (energizado) { //verifica antes se est� energizado
			standBy = true;
			ligado = false;
			String dadosSaida = "";
			String dadosEntrada = "";
		}
	}

	public void inserirDados(String dadosEntrada) { //insere dados pela entrada do produto eletr�nico
		if (ligado) { 
			this.dadosEntrada = dadosEntrada;
			processarDados();
		}
	}

	public String emitirDados() { //emite dados pela sa�da do produto eletr�nico
		return dadosSaida;
	}
	
	private void processarDados() { //faz algum processamento qualquer na entrada, e coloca na sa�da
		dadosSaida = String.valueOf(dadosEntrada.hashCode()); //encontra o HashCode de dadosEntrada. Depois transforma em String, e passa para o atributo dadosSaida
	}
}
