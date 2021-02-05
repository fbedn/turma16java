package listaPOO03;

public class Cachorro extends Animal {

	public Cachorro(String nome, int idade) {
		super(nome, idade);
	}
	
	@Override
	public void emitirSom () {
		System.out.println("É um cachorro, e está emitindo seu som");
	}
	public void correr () {
		System.out.println("O cachorro está correndo");
	}
	
}
