/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public class Voiture implements IVoiture {

	private DVehicule dVehicule;
	private DVehiculeMotorise dVehiculeMotorise;
	private DVehiculeRoulant dVehiculeRoulant; 
	private String name;
	private String marque;
	
	public Voiture() {
		super();
		DVehiculeMotorise dVehiculeMotorise2 = new DVehiculeMotorise(this);
		this.dVehicule = dVehiculeMotorise2;
		this.dVehiculeMotorise = dVehiculeMotorise2;
		this.dVehiculeRoulant = new DVehiculeRoulant(this);
	}
	
	

	/* (non-Javadoc)
	 * @see fr.imie.IVehiculeRoulant#avancer()
	 */
	@Override
	public void avancer() {
		dVehiculeRoulant.avancer();

	}

	/* (non-Javadoc)
	 * @see fr.imie.IVehiculeMotorise#demarrer()
	 */
	@Override
	public void demarrer() {
		dVehiculeMotorise.demarrer();

	}

	/* (non-Javadoc)
	 * @see fr.imie.IVehicule#mettreCasse()
	 */
	@Override
	public void mettreCasse() {
		dVehicule.mettreCasse();
	}

	/* (non-Javadoc)
	 * @see fr.imie.IVehicule#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see fr.imie.IVehicule#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name=name;
	}

	/* (non-Javadoc)
	 * @see fr.imie.IVehicule#getMarque()
	 */
	@Override
	public String getMarque() {
		return this.marque;
	}

	/* (non-Javadoc)
	 * @see fr.imie.IVehicule#setMarque(java.lang.String)
	 */
	@Override
	public void setMarque(String marque) {
		this.marque=marque;
	}


}
