/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IVehicule vehicule = new Vehicule();
		DVehicule dVehicule = new DVehicule();
		vehicule.setDVehicule(dVehicule);
		vehicule.setName("titi");
		vehicule.setMarque("trotinette");
		vehicule.mettreCasse();
		
		IVoiture voiture = new Voiture();
		DVehiculeMotorise dVehiculeMotorise = new DVehiculeMotorise();
		DVehiculeRoulant dVehiculeRoulant = new DVehiculeRoulant();
		voiture.setDVehiculeMotorise(dVehiculeMotorise);
		voiture.setDVehiculeRoulant(dVehiculeRoulant);
		voiture.setDVehicule(dVehiculeMotorise);
		
		voiture.setName("clio");
		voiture.setMarque("Renault");
		voiture.demarrer();
		voiture.avancer();
		voiture.mettreCasse();
		
		IVoiture voiture2 = new VoitureMotoriseeRoulante();
		
		voiture2.setName("208");
		voiture2.setMarque("Peugeot");
		voiture2.demarrer();
		voiture2.avancer();
		voiture2.mettreCasse();
		
		
		
		
		

	}

}
