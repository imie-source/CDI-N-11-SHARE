package fr.imie;

import fr.imie.DAO.IUsagerDAO;
import fr.imie.DAO.UsagerDAO;
import fr.imie.presentation.UsagerConsole;

public class Launcher {

	public static void main(String[] args) {
		IUsagerDAO usagerDAO = new UsagerDAO();
		UsagerConsole usagerConsole = new UsagerConsole(usagerDAO);
		usagerConsole.start();
	}

}
