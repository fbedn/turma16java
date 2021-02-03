package entidades;

public class Pessoa {

	public String nome;
	public char genero;
	public int anoNascimento;
	public boolean estaViva;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}

	public Pessoa(String nome, boolean estaViva) {
		this.nome = nome;
		this.estaViva = estaViva;
	}

	public int idade() {
		return (2021 - anoNascimento);
	}

	public void mostraIdade() {
		System.out.println(2021 - anoNascimento);
	}

	public boolean maiorIdade() {
		int idade;
		boolean maior;
		idade = 2021 - anoNascimento;
		if (idade < 18) {
			maior = false;
		} else {
			maior = true;
		}

		return maior;
	}

	public String pronome() {
		String sr = "";
		if (genero == 'F') {
			sr = "Sra.";
		} else if (genero == 'M') {
			sr = "Sr.";
		} else {
			sr = "Srx.";
		}
		return sr;
	}
	
	/*
	public int idade() {
		return 2021 - anoNascimento;
	}
	
	public String pronomeTratamento() {
		if (genero == 'M') return "Sr.";
		if (genero == 'F') return "Sra.";
		return "Sre.";
	}
	*/
}
