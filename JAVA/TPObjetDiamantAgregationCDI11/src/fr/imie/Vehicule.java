/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public class Vehicule implements IVehicule {
	
	private String name;
	private String marque;
	private DVehicule dVehicule; 
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getMarque() {
		return marque;
	}
	@Override
	public void setMarque(String marque) {
		this.marque = marque;
	}
	@Override
	public void mettreCasse() {
		dVehicule.mettreCasse(this);	
	}
	
	@Override
	public void setDVehicule(DVehicule dVehicule) {
		this.dVehicule = dVehicule;
	}
	
	

}
