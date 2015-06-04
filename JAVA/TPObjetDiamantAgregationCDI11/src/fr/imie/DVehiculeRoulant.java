/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public class DVehiculeRoulant extends DVehicule {

	public void avancer(IVehiculeRoulant vehiculeRoulant){
		System.out.format("le vehicule %s roule\n",vehiculeRoulant.getName());
	}
}
