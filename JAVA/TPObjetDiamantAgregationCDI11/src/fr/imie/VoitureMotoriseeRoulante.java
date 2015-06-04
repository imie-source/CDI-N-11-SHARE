package fr.imie;

public class VoitureMotoriseeRoulante implements IVoiture {
	private DVehicule dVehicule;
	private DVehiculeMotorise dVehiculeMotorise;
	private DVehiculeRoulant dVehiculeRoulant; 
	private String name;
	private String marque;
	
	//la voie vers la composition
	public VoitureMotoriseeRoulante() {
		DVehiculeMotorise dVehiculeMotorise = new DVehiculeMotorise();
		this.dVehiculeMotorise = dVehiculeMotorise;
		this.dVehiculeRoulant = new DVehiculeRoulant();
		this.dVehicule=dVehiculeMotorise;
	}

	/* (non-Javadoc)
	 * @see fr.imie.IVehiculeRoulant#avancer()
	 */
	@Override
	public void avancer() {
		dVehiculeRoulant.avancer(this);

	}

	/* (non-Javadoc)
	 * @see fr.imie.IVehiculeMotorise#demarrer()
	 */
	@Override
	public void demarrer() {
		dVehiculeMotorise.demarrer(this);

	}

	/* (non-Javadoc)
	 * @see fr.imie.IVehicule#mettreCasse()
	 */
	@Override
	public void mettreCasse() {
		dVehicule.mettreCasse(this);
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

	/* (non-Javadoc)
	 * @see fr.imie.IVehicule#setDVehicule(fr.imie.DVehicule)
	 */
	@Override
	public void setDVehicule(DVehicule dVehicule) {
		this.dVehicule=dVehicule;

	}

	@Override
	public void setDVehiculeRoulant(DVehiculeRoulant dVehiculeRoulant) {
		this.dVehiculeRoulant=dVehiculeRoulant;
		
	}

	@Override
	public void setDVehiculeMotorise(DVehiculeMotorise dVehiculeMotorise) {
		this.dVehiculeMotorise=dVehiculeMotorise;
	}

}
