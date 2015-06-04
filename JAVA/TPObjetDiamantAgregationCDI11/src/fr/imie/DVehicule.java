package fr.imie;

public class DVehicule {

	public void mettreCasse(IVehicule vehicule) {
		System.out.format(
				"la casse prends en charge le vehicule %s de marque %s\n",
				vehicule.getName(), vehicule.getMarque());
	}
}
