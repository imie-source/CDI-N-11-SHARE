/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public class DVehiculeMotorise extends DVehicule {

	public void demarrer(IVehiculeMotorise vehiculeMotorise) {
		System.out.format("demarrage de %s\n", vehiculeMotorise.getName());
	}

	@Override
	public void mettreCasse(IVehicule vehicule) {
		
		super.mettreCasse(vehicule);
		System.out.println("recyclage du moteur");
	}
	
	

}
