package fr.imie;

public class monRunnableCalcul implements Runnable {
	Calcul calcul;
	Integer initValue;
			
	public monRunnableCalcul(Calcul calcul,Integer value) {
		super();
		this.calcul = calcul;
		this.initValue=value;
	}

	@Override
	public void run() {
		calcul.factVal(initValue);
	}
}
