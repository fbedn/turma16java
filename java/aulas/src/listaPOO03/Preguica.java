package listaPOO03;

public class Preguica extends Animal {

	public Preguica(String nome, int idade) {
		super(nome, idade);
	}
	
	@Override
	public void emitirSom () {
		System.out.println("É uma preguiça, e está emitindo seu som");
	}
	public void subirEmArvore () {
		System.out.println("O cavalo está correndo");
	}

}
