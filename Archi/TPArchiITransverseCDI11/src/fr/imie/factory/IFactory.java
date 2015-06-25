package fr.imie.factory;

import fr.imie.DAO.IUsagerDAO;
import fr.imie.usages.IUsagesService;


public interface IFactory {
	
	IUsagerDAO createUsagerDAO();
	IUsagesService createUsagesService();

}
