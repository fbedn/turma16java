package listaPOO02;

/*
 * EXERCÍCIO 1
 * Cria uma Classe Pessoa, contendo os atributos encapsulados, com seus respectivos 
 * seletores (getters) e modificadores (setters), e ainda o construtor padrão e pelo menos mais duas
 * opções de construtores conforme sua percepção.
 * Atributos: String nome; String endereco; String telefone;
 */

public class Pessoa {
	
	private String nome;
	private String endereco;
	private String telefone;
	
	
	/*Construtores*/
	
	public Pessoa() { //construtor padrão
	}
	
	public Pessoa(String nome, String endereco) { //construtor nome e endereço
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public Pessoa(String nome, String endereco, String telefone) { //construtor nome, endereço e telefone
		this.nome = nome;
		this.telefone = telefone;
	}
	

	/*Getters e Setters*/
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
