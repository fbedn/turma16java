package listaPOO03;

public class Cavalo extends Animal {

	public Cavalo(String nome, int idade) {
		super(nome, idade);
	}
	
	@Override
	public void emitirSom () {
		System.out.println("É um cavalo, e está emitindo seu som");
	}
	public void correr () {
		System.out.println("O cavalo está correndo");
	}
	
}
