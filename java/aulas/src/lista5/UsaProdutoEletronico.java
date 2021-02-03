package lista5;

import java.util.Locale;
import java.util.Scanner;

public class UsaProdutoEletronico {

	public static void main(String[] args) {
		
		Locale.setDefault(new Locale ("en", "US")); //para o sinal de decimal ser um ponto
		
		Scanner ler = new Scanner(System.in);

		ProdutoEletronico produto = new ProdutoEletronico();

		char comando;
		System.out.println("OBS: É NECESSÁRIO ENERGIZAR O PRODUTO ANTES DE LIGÁ-LO");
		while (true) {
			System.out.println("______________________________________________________");
			System.out.println("\nESTADO DO PRODUTO ELETRÔNICO:\n");
			System.out.println("- - - "+(produto.getEnergizado()?"ENERGIZADO":"NÃO ENERGIZADO"));
			System.out.println("- - - "+(produto.getLigado()?"LIGADO":"DESLIGADO"));
			System.out.println("- - - "+(produto.getStandBy()?"EM STANDBY":"fora do standby"));
			//System.out.println("Dados na entrada: "+produto.getDadosEntrada);
			System.out.print("\nCOMANDOS:\n\n"
								+ "e - energizar\t\t\t\t(OBS: eeste comando coloca na tomada ou bateria)\n"
								+ "l - ligar\t\t\t\t(Obs: energizar antes de tentar ligar)\n"
								+ "d - entrar com dados para processar\t(Obs: ligar o produto antes de entrar com os dados)\n\n"
								+ "s - colocar em standby\n"
								+ "g - desenergizar\t\t\t(Obs: este comando tira da tomada ou bateria)\n\n"
								+ "r - desligar\n"
								+ "q - sair\n");
			comando = ler.next().toLowerCase().charAt(0);
			if (comando == 'e') {
				produto.energizar();
			} else if (comando == 'g') {
				produto.desenergizar();
			}else if (comando == 'l') {
				produto.ligar();
			}else if (comando == 'r') {
				produto.desligar();
			}else if (comando == 's') {
				produto.colocarEmStandBy();
			}else if (comando == 'd') {
				if (produto.getLigado()) { //apenas roda o código dentro do if se o produto estiver ligado
					ler.nextLine();
					System.out.println("Entre com os dados para inserir no produto (palavras):");
					String dadosEnvio = ler.nextLine();
					produto.inserirDados(dadosEnvio); //envia dados para o produto receber
					String dadosRecebidos = produto.emitirDados(); //recebe dados que foram emitidos pelo produto
					System.out.println("SAÍDA PROCESSADA PELO PRODUTO ELETRÔNICO:\n"+dadosRecebidos);
				}
			}else if (comando == 'q') {
				break;
			}
		}
		System.out.println("Fim do programa");
		ler.close();
		
	}

}
