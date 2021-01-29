package aulas;

import java.util.Scanner;

public class Desafio_2021_01_29_d02 {

	/*
	 * TO DO LIST - AGENDA
	 * 
	 * 1 - CADASTRAR EVENTOS EM UM DIA QUALQUER DO M�S 2 - SEMPRE EM UMA HORA 3 -
	 * PODE MOSTRAR A LISTA AT� O MOMENTO
	 * 
	 * 
	 * RESOLU��O EM MATRIZ
	 * 
	 * 
	 * STOREBOARD DE TELAS:
	 * 
	 * BEM-VINDO, DIGITE O SEU NOME:_
	 * 
	 * ESCOLHA UM DIA PARA CADASTRO [1/31] : _ SELECIONE A HORA DO EVENTO[0/24]: _
	 * 
	 * CONTINUA SIM OU N�O [s/n]:
	 * 
	 * SE ESCOLHIDO N�O:
	 * 
	 * MOSTRA AGENDA ATUAL s/n: SE SIM MOSTRA TODOS OS DIAS E EVENTOS CADASTRADOS
	 * 
	 * AP�S PERGUNTA, RECOME�A SIM OU N�O. SE SIM COME�A TUDO DE NOVO EM BRANCO PARA
	 * UM NOVO USUARIO SEN�O, SAI DO PROGRAMA
	 */
	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		String nome;
		int dia, hora;
		char comando = 's';

		while (comando == 's') { // la�o principal
			String agenda[][] = new String[24][31];

			System.out.println("BEM-VINDO, DIGITE O SEU NOME:");
			nome = ler.nextLine().toUpperCase(); // l� o nome do usu�rio e passa para mai�sculo

			while (comando == 's') {

				System.out.println("ESCOLHA UM DIA PARA CADASTRO [1/31]:");
				dia = ler.nextInt();
				while (dia < 1 || dia > 31) {
					System.out.println("DIA INFORMADO INCORRETO, ESCOLHA UM ENTRE 1 E 31:");
					dia = ler.nextInt();
				}

				System.out.println("SELECIONE A HORA DO EVENTO[0-23]:");
				hora = ler.nextInt();
				ler.nextLine(); // termina de ler o resto da linha
				while (hora < 0 || hora > 23) {
					System.out.println("HORA INFORMADA INCORRETA, ESCOLHA UMA ENTRE 0H E 23H:");
					hora = ler.nextInt();
					ler.nextLine(); // termina de ler o resto da linha
				}
				System.out.println("INFORME A TAREFA NESTA DATA E HORA:");
				agenda[hora][dia - 1] = ler.nextLine();

				System.out.println("INSERIR MAIS ALGUMA TAREFA NA AGENDA? SIM OU N�O [s/n]:");
				comando = ler.nextLine().charAt(0); // l� a entrada do teclado e passa para min�sculo
			}

			System.out.println(nome + ",\nVOC� DESEJA VER A AGENDA? SIM OU N�O [s/n]:");
			comando = ler.nextLine().toLowerCase().charAt(0); // l� a entrada do teclado e passa para min�sculo
			if (comando == 's') {
				for (int i = 0; i < 31; i++) {
					for (int j = 0; j < 24; j++) {
						if (agenda[j][i] != null) {
							System.out.println("DIA: " + (i + 1) + "\tHORA: " + j + "  \tTAREFA: " + agenda[j][i]);
						}
					}
				}
				System.out.println();
			}
			System.out.println("REINICIAR O PROGRAMA? SIM OU N�O [s/n]: ");
			comando = ler.nextLine().toLowerCase().charAt(0); // l� a entrada do teclado e passa para min�sculo
		}
		ler.close();
	}
}
