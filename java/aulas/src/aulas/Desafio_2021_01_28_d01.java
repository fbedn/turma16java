package aulas;

public class Desafio_2021_01_28_d01 {

	/*
	 * A prefeitura de uma cidade fez uma pesquisa entre 20 de seus habitantes,
	 * coletando dados sobre o salário e número de filhos. A prefeitura deseja
	 * saber: a) média do salário da população; b) média do número de filhos; c)
	 * maior salário; d) percentual de pessoas com salário até R$100,00.
	 */

	public static void main(String[] args) {

		double salHabitantes[] = new double[20]; // arranjo com salário de 20 habitantes
		int nFilhosHabitantes[] = new int[20]; // arranjo com número de filhos de 20 habitantes
		double somaSalarios = 0; // somatório dos salários
		double mediaSalarios; // média do salário dos habitantes
		int somaFilhos = 0; // somatório do número de filhos
		double mediaFilhos; // média de filhos dos habitantes
		double maiorSalario = 0; // maior salário entre os habitantes
		double nHabSalAte100 = 0; // número de habitantes com salário até R$ 100,00 reais
		double prcntHabSalAte100; // percentual de habitantes com salário até R$ 100,00 reais

		// inicialização do arranjo com salários dos habitantes
		salHabitantes[0] = 1200.00;
		salHabitantes[1] = 1500.00;
		salHabitantes[2] = 90.00;
		salHabitantes[3] = 1000.00;
		salHabitantes[4] = 2800.00;
		salHabitantes[5] = 1700.00;
		salHabitantes[6] = 600.00;
		salHabitantes[7] = 1250.00;
		salHabitantes[8] = 1000.00;
		salHabitantes[9] = 2900.00;
		salHabitantes[10] = 900.00;
		salHabitantes[11] = 1300.00;
		salHabitantes[12] = 5000.00;
		salHabitantes[13] = 850.00;
		salHabitantes[14] = 1200.00;
		salHabitantes[15] = 900.00;
		salHabitantes[16] = 4200.00;
		salHabitantes[17] = 100.00;
		salHabitantes[18] = 1250.00;
		salHabitantes[19] = 2000.00;

		// inicialização do arranjo com o número de filhos dos habitantes
		nFilhosHabitantes[0] = 1;
		nFilhosHabitantes[1] = 1;
		nFilhosHabitantes[2] = 0;
		nFilhosHabitantes[3] = 2;
		nFilhosHabitantes[4] = 3;
		nFilhosHabitantes[5] = 2;
		nFilhosHabitantes[6] = 0;
		nFilhosHabitantes[7] = 1;
		nFilhosHabitantes[8] = 0;
		nFilhosHabitantes[9] = 1;
		nFilhosHabitantes[10] = 1;
		nFilhosHabitantes[11] = 2;
		nFilhosHabitantes[12] = 4;
		nFilhosHabitantes[13] = 1;
		nFilhosHabitantes[14] = 0;
		nFilhosHabitantes[15] = 0;
		nFilhosHabitantes[16] = 2;
		nFilhosHabitantes[17] = 0;
		nFilhosHabitantes[18] = 1;
		nFilhosHabitantes[19] = 3;

		for (int i = 0; i < 20; i++) { // passa por cada habitante
			somaSalarios = somaSalarios + salHabitantes[i]; // somatório dos salários
			somaFilhos = somaFilhos + nFilhosHabitantes[i]; // somatório d número de filhos
			if (salHabitantes[i] > maiorSalario) { // verifica o maior salário
				maiorSalario = salHabitantes[i];
			}
			if (salHabitantes[i] <= 100) { // verifica se o salário do habitante é <= 100 reais
				nHabSalAte100 = nHabSalAte100 + 1;
			}
		}

		mediaSalarios = somaSalarios / 20;
		mediaFilhos = (double) somaFilhos / 20; // o (double) é necessário para considerar a parte decimal
		prcntHabSalAte100 = nHabSalAte100 / 0.2;

		// System.out.println("\nMédia do salário da população: R$
		// "+mediaSalarios+"\nMédia do número de filhos: "+mediaFilhos+"\nMaior salário
		// : R$ "+maiorSalario+"\nPercentual de pessoas com salário até R$ 100,00:
		// "+prcntHabSalAte100+"%");
		System.out.printf(
				"\nMédia do salário da população: R$ %.2f\nMédia do número de filhos: %.2f\nMaior salário : R$ %.2f\nPercentual de pessoas com salário até R$ 100,00: %.2f %%\n",
				mediaSalarios, mediaFilhos, maiorSalario, prcntHabSalAte100);

	}

}
