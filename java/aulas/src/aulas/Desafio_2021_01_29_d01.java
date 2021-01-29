package aulas;

import java.util.Scanner;

public class Desafio_2021_01_29_d01 {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		
		String times[] = {"CORITHIANS","PALMEIRAS","SANTOS","SPFC"};
		int pontos[] = new int[4];
		char resposta;
		//int matriz[][] = new int[2][2];
		for (int x = 0; x<4; x++)
		{
			System.out.println("Rodada "+(x+1)+"\n");
			for (int y = 0; y<4; y++)
			{
				System.out.println(times[y]+" G-ganhou P-perdeu ou E-empatou [G/P/E]: ");
				
				resposta = ler.next().toUpperCase().charAt(0);
				
				if (resposta == 'G')
				{
					pontos[y] = pontos[y]+3;
				}
				else if (resposta == 'E')
				{
					pontos[y] = pontos[y]+1;
				}
				else if (resposta == 'P')
					pontos[y]= pontos[y]+0;
			}
		}
	
		System.out.println();
		for (int z = 0; z< 4; z++)
		{
			System.out.println(times[z]+" finalizou com "+pontos[z]+" pontos.");
		}
		
		ler.close();
		
	}
}
