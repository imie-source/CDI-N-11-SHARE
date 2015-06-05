package fr.imie;

public class Calcul {

	private Integer val = 0;
	private Affichage affichage;
	private Long tmpsInit;
	private Long duration;

	public Calcul() {
		super();
		this.affichage = new Affichage();
	}

	public void factVal() {
		synchronized (val) {

			tmpsInit = System.currentTimeMillis();
			for (Integer i = val - 1; i > 1; i--) {
				val = val * i;
				for (int j = 0; j < 1000000000; j++) {
					Integer tmp = val + 1;
				}
				// affichage.printMiddleValue(this);
				// try {
				// Thread.sleep(100);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
			}
			duration = System.currentTimeMillis() - tmpsInit;
			affichage.printFinalValue(this);

		}
	}

	public void factVal(Integer initValue) {
		synchronized (val) {
			val = initValue;
			factVal();
		}

	}

	public Object getVal() {
		return val;
	}

	public void setVal(Integer val) {
		synchronized (val) {
			this.val = val;
		}
	}

	public Long getDuration() {
		return duration;
	}

}
