package aulas;

public class Desafio_2021_01_28_d01 {

	/*
	 * A prefeitura de uma cidade fez uma pesquisa entre 20 de seus habitantes,
	 * coletando dados sobre o sal�rio e n�mero de filhos. A prefeitura deseja
	 * saber: a) m�dia do sal�rio da popula��o; b) m�dia do n�mero de filhos; c)
	 * maior sal�rio; d) percentual de pessoas com sal�rio at� R$100,00.
	 */

	public static void main(String[] args) {

		double salHabitantes[] = new double[20]; // arranjo com sal�rio de 20 habitantes
		int nFilhosHabitantes[] = new int[20]; // arranjo com n�mero de filhos de 20 habitantes
		double somaSalarios = 0; // somat�rio dos sal�rios
		double mediaSalarios; // m�dia do sal�rio dos habitantes
		int somaFilhos = 0; // somat�rio do n�mero de filhos
		double mediaFilhos; // m�dia de filhos dos habitantes
		double maiorSalario = 0; // maior sal�rio entre os habitantes
		double nHabSalAte100 = 0; // n�mero de habitantes com sal�rio at� R$ 100,00 reais
		double prcntHabSalAte100; // percentual de habitantes com sal�rio at� R$ 100,00 reais

		// inicializa��o do arranjo com sal�rios dos habitantes
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

		// inicializa��o do arranjo com o n�mero de filhos dos habitantes
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
			somaSalarios = somaSalarios + salHabitantes[i]; // somat�rio dos sal�rios
			somaFilhos = somaFilhos + nFilhosHabitantes[i]; // somat�rio d n�mero de filhos
			if (salHabitantes[i] > maiorSalario) { // verifica o maior sal�rio
				maiorSalario = salHabitantes[i];
			}
			if (salHabitantes[i] <= 100) { // verifica se o sal�rio do habitante � <= 100 reais
				nHabSalAte100 = nHabSalAte100 + 1;
			}
		}

		mediaSalarios = somaSalarios / 20;
		mediaFilhos = (double) somaFilhos / 20; // o (double) � necess�rio para considerar a parte decimal
		prcntHabSalAte100 = nHabSalAte100 / 0.2;

		// System.out.println("\nM�dia do sal�rio da popula��o: R$
		// "+mediaSalarios+"\nM�dia do n�mero de filhos: "+mediaFilhos+"\nMaior sal�rio
		// : R$ "+maiorSalario+"\nPercentual de pessoas com sal�rio at� R$ 100,00:
		// "+prcntHabSalAte100+"%");
		System.out.printf(
				"\nM�dia do sal�rio da popula��o: R$ %.2f\nM�dia do n�mero de filhos: %.2f\nMaior sal�rio : R$ %.2f\nPercentual de pessoas com sal�rio at� R$ 100,00: %.2f %%\n",
				mediaSalarios, mediaFilhos, maiorSalario, prcntHabSalAte100);

	}

}
