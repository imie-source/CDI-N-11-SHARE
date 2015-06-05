package fr.imie;

public class Affichage {

	private Long initTime=System.currentTimeMillis();
	
	public void printMiddleValue(Calcul calcul) {
		System.out.format("valeur intermediaire du Thread %d : %d\n", Thread
				.currentThread().getId(), calcul.getVal());
	}

	public void printFinalValue(Calcul calcul) {
		System.out
				.format("valeur finale du Thread %d : %d calculé en %d millisecondes\n",
						Thread.currentThread().getId(), calcul.getVal(),
						calcul.getDuration());
		System.out.format("tmps ecoulé depuis la création de l'affichage : %d\n", System.currentTimeMillis()-initTime);

	}

}
