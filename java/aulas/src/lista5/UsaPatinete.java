package lista5;

import java.util.Scanner;

public class UsaPatinete {
	
	/*
	 * EXERC�CIO 5
	 * Crie uma classe patinete e apresente os atributos e m�todos referentes esta classe.
	 * Em seguida crie um objeto patinete, defina as inst�ncias deste objeto e apresente as 
	 * informa��es deste objeto no console.
	 */

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		Patinete patinete = new Patinete();

		char comando;
		while (true) {
			System.out.printf("PATINETE:\n"
								+ "VELOCIDADE:\t\t %d km/h\n"
								+ "ROTA��O DO GUID�O:\t %d�\n",
								patinete.getVelocidade(), patinete.getRotacaoGuidao());
			System.out.print("\nComandos:\n"
								+ "w - acelera (1 km/h)\n"
								+ "s - desacelera (1 km/h)\n"
								+ "d - vira guid�o para a direita (1�)\n"
								+ "a - vira guid�o para a esquerda (1�)\n"
								+ "q - sair\n");
			comando = ler.next().toLowerCase().charAt(0);
			if (comando == 'w') {
				patinete.acelerar();
			} else if (comando == 's') {
				patinete.desacelerar();
			} else if (comando == 'd') {
				patinete.rotacionarGuidaoDir();
			} else if (comando == 'a') {
				patinete.rotacionarGuidaoEsq();
			} else if (comando == 'q') {
				break;
			}
		}
		System.out.println("Fim do programa");
		ler.close();
	}
}
