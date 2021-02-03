package lista5;

public class Patinete {
	
	private int velocidade; //os métodos limitarão a velocidade entre 0 a 60 (km/h)
	private int rotacaoGuidao; //os métodos limitarão a rotação entre -90 (totalmente à esquerda) e 90 (totalmente à direita)
	
	public Patinete () { //construtor
		velocidade = 0;
		rotacaoGuidao = 0;
	}
	
	public int getVelocidade() { //devolve a velocidade
		return velocidade;
	}
	
	public int getRotacaoGuidao() { //devolve a rotação do guidão
		return rotacaoGuidao;
	}
	
	public void acelerar() { //incrementa 1 na velocidade
		if (velocidade < 60) {
			++velocidade;
		}
	}

	public void desacelerar() {  //decrementa 1 na velocidade
		if (velocidade > 0) {
			--velocidade;
		}
	}

	public void rotacionarGuidaoEsq() { //rotaciona guidão 1 para a esquerda (decrementa 1 em rotacaoGuidao)
		if (rotacaoGuidao > -90) {
			--rotacaoGuidao;
		}
	}
	
	public void rotacionarGuidaoDir() { //rotaciona guidão 1 para a direita (incrementa 1 em rotacaoGuidao)
		if (rotacaoGuidao < 90) {
			++rotacaoGuidao;
		}
	}

}
