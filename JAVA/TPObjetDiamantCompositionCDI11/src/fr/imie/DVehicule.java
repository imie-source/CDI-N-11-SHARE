package fr.imie;

public class DVehicule{

	private final IVehicule vehicule;
	
	
	public DVehicule(IVehicule vehicule) {
		super();
		this.vehicule = vehicule;
	}

	public void mettreCasse() {
		System.out.format(
				"la casse prends en charge le vehicule %s de marque %s\n",
				vehicule.getName(), vehicule.getMarque());
	}

}
