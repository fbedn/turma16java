package miniECommerceOO03;

public class Cliente {
	
	private String nome;
	private char sexo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public String tratamento() {
		if (sexo == 'F') { //define o tratamento que o usuário será tratado
			return "Sra.";
		} else if (sexo == 'M') {
			return "Sr.";
		}
		return "Srx.";
	}
	
}
