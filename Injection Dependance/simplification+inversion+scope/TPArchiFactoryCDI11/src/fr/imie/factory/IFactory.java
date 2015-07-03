package fr.imie.factory;

import fr.imie.DAO.ISiteDAO;
import fr.imie.DAO.IUsagerDAO;
import fr.imie.service.IUsagesService;


public interface IFactory {
	
	IUsagerDAO createUsagerDAO();
	IUsagesService createUsagesService();
	ISiteDAO createSiteDAO();

}
