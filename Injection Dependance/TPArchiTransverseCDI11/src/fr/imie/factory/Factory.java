/**
 * 
 */
package fr.imie.factory;

import fr.imie.DAO.ISiteDAO;
import fr.imie.DAO.IUsagerDAO;
import fr.imie.transactional.SiteDAOProxified;
import fr.imie.transactional.UsagerDAOProxified;
import fr.imie.transactional.UsagesServiceProxified;
import fr.imie.transactionalFramework.TransactionalFactory;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.IFactory#createUsagerDAO()
	 */
	@Override
	public IUsagerDAO createUsagerDAO() {
		TransactionalFactory<UsagerDAOProxified> TF = (TransactionalFactory<UsagerDAOProxified>) TransactionalFactory
				.getInstance();
		return TF.createTransactionalService(new UsagerDAOProxified(this));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.IFactory#createUsagesService()
	 */
	@Override
	public IUsagesService createUsagesService() {

		TransactionalFactory<UsagesServiceProxified> TF = (TransactionalFactory<UsagesServiceProxified>) TransactionalFactory
				.getInstance();
		return TF.createTransactionalService(new UsagesServiceProxified(this));
	}

	@Override
	public ISiteDAO createSiteDAO() {
		TransactionalFactory<SiteDAOProxified> TF = (TransactionalFactory<SiteDAOProxified>) TransactionalFactory
				.getInstance();
		return TF.createTransactionalService(new SiteDAOProxified(this));

	}

}
