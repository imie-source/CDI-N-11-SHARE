/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public class DVehiculeMotorise extends DVehicule {

	private IVehiculeMotorise vehiculeMotorise;
	
	
	
	public DVehiculeMotorise(IVehiculeMotorise vehiculeMotorise) {
		super(vehiculeMotorise);
		this.vehiculeMotorise = vehiculeMotorise;
	}

	public void demarrer() {
		System.out.format("demarrage de %s\n", vehiculeMotorise.getName());
	}

	@Override
	public void mettreCasse() {
		
		super.mettreCasse();
		System.out.println("recyclage du moteur");
	}
	
	

}
