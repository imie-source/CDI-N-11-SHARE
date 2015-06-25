/**
 * 
 */
package fr.imie.factory;

import fr.imie.DAO.IUsagerDAO;
import fr.imie.DAO.UsagerDAO;
import fr.imie.usages.IUsagesService;
import fr.imie.usages.UsagesService;

/**
 * @author imie
 *
 */
public class Factory implements IFactory {

	/**
	 * 
	 */
	public Factory() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see fr.imie.IFactory#createUsagerDAO()
	 */
	@Override
	public IUsagerDAO createUsagerDAO() {
		return new UsagerDAO();
	}

	/* (non-Javadoc)
	 * @see fr.imie.IFactory#createUsagesService()
	 */
	@Override
	public IUsagesService createUsagesService() {
		// TODO Auto-generated method stub
		return new UsagesService(this);
	}

}
