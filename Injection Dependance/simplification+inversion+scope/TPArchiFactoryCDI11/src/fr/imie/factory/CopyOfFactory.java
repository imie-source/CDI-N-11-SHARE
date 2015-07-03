/**
 * 
 */
package fr.imie.factory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import fr.imie.DAO.ISiteDAO;
import fr.imie.DAO.IUsagerDAO;
import fr.imie.DAO.proxified.SiteDAOProxified;
import fr.imie.DAO.proxified.UsagerDAOProxified;
import fr.imie.annotation.Proxy;
import fr.imie.service.IUsagesService;
import fr.imie.service.proxified.UsagesServiceProxified;
import fr.imie.transactionalFramework.TransactionalFactory;

/**
 * @author imie
 *
 */
public class CopyOfFactory{

	@Inject private UsagesServiceProxified usagesServiceProxified;
//	@Inject private UsagerDAOProxified usagerDAOProxified;
//	@Inject private SiteDAOProxified siteDAOProxified;
	
	/**
	 * 
	 */
	public CopyOfFactory() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.IFactory#createUsagerDAO()
	 */
//	@Override
//	@Produces
//	@Proxy
//	public IUsagerDAO createUsagerDAO() {
//		System.out.println("XXXXXXXX UDAO");
//		@SuppressWarnings("unchecked")
//		TransactionalFactory<UsagerDAOProxified> TF = (TransactionalFactory<UsagerDAOProxified>) TransactionalFactory
//				.getInstance();
//		return TF.createTransactionalService(usagerDAOProxified);
//	}
//
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.IFactory#createUsagesService()
	 */
	//@Override
	@Produces
	@Proxy
	public IUsagesService createUsagesService() {
		System.out.println("XXXXXXXX Service");
		@SuppressWarnings("unchecked")
		TransactionalFactory<UsagesServiceProxified> TF = (TransactionalFactory<UsagesServiceProxified>) TransactionalFactory
				.getInstance();
		return TF.createTransactionalService(usagesServiceProxified);
	}

//	@Override
//	@Produces
//	@Proxy
//	public ISiteDAO createSiteDAO() {
//		@SuppressWarnings("unchecked")
//		TransactionalFactory<SiteDAOProxified> TF = (TransactionalFactory<SiteDAOProxified>) TransactionalFactory
//				.getInstance();
//		return TF.createTransactionalService(siteDAOProxified);
//
//	}

}
