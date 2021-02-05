package listaPOO03;

public class TestaAnimais {

	public static void main(String[] args) {
		
		Cachorro cachorro = new Cachorro("Bidu",6);
		Cavalo cavalo = new Cavalo("Trovão",4);
		Preguica preguica = new Preguica("Jaime",5);
		
		Animal vetorAnimais[] = new Animal[3];
		vetorAnimais[0] = cachorro;
		vetorAnimais[1] = cavalo;
		vetorAnimais[2] = preguica;
		
		for (Animal a : vetorAnimais) {
			System.out.print(a.getNome()+" tem "+a.getIdade()+" anos. ");
			a.emitirSom();
		}
		
	}

}
