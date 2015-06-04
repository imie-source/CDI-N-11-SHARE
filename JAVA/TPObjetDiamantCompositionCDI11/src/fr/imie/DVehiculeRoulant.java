/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public class DVehiculeRoulant extends DVehicule {

	IVehiculeRoulant vehiculeRoulant;
		
	public DVehiculeRoulant(IVehiculeRoulant vehiculeRoulant) {
		super(vehiculeRoulant);
		this.vehiculeRoulant = vehiculeRoulant;
	}

	public void avancer(){
		System.out.format("le vehicule %s roule\n",vehiculeRoulant.getName());
	}
}
