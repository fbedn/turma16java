package listaPOO03;

public class Preguica extends Animal {

	public Preguica(String nome, int idade) {
		super(nome, idade);
	}
	
	@Override
	public void emitirSom () {
		System.out.println("� uma pregui�a, e est� emitindo seu som");
	}
	public void subirEmArvore () {
		System.out.println("O cavalo est� correndo");
	}

}
