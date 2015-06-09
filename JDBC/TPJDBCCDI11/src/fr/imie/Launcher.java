package fr.imie;

import fr.imie.DAO.ISiteDAO;
import fr.imie.DAO.IUsagerDAO;
import fr.imie.DAO.SiteDAO;
import fr.imie.DAO.UsagerDAO;
import fr.imie.presentation.Console;

public class Launcher {

	public static void main(String[] args) {
		ISiteDAO siteDAO = new SiteDAO();
		IUsagerDAO usagerDAO = new UsagerDAO(siteDAO);
		Console usagerConsole = new Console(usagerDAO,siteDAO);
		usagerConsole.start();
	}

}
