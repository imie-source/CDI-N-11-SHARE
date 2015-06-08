/**
 * 
 */
package fr.imie.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fr.imie.DAO.IUsagerDAO;
import fr.imie.DTO.UsagerDTO;

/**
 * @author imie
 *
 */
public class UsagerConsole {

	private IUsagerDAO usagerDAO;

	public UsagerConsole(IUsagerDAO usagerDAO) {
		super();
		this.usagerDAO = usagerDAO;
	}

	public void start() {
		try (Scanner scanner = new Scanner(System.in)) {

			Boolean exitFlag = false;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"dd/MM/yyyy");

			while (!exitFlag) {

				System.out.println("0: exit");
				System.out.println("1: lires tous");
				System.out.println("2: inserer");
				System.out.println("3: rechercher");
				Integer menu = inputInteger(scanner);
				UsagerDTO usagerDTO;
				List<UsagerDTO> usagers;

				switch (menu) {
				case 0:
					exitFlag = !exitFlag;
					break;
				case 1:
					usagers = usagerDAO.readAll();
					for (UsagerDTO usagerDTO2 : usagers) {
						displayUsager(simpleDateFormat, usagerDTO2);
					}
					break;

				case 2:
					usagerDTO = inputUsager(scanner, simpleDateFormat);

					usagerDTO = usagerDAO.ajouter(usagerDTO);
					System.out.format("usager inséré avec l'id : %d\n",
							usagerDTO.getId());
					displayUsager(simpleDateFormat, usagerDTO);
					break;
				case 3:
					System.out.println("saisie de la recherche :");
					usagerDTO = inputUsager(scanner, simpleDateFormat);
					usagers = usagerDAO.readByDTO(usagerDTO);
					for (UsagerDTO usagerDTO2 : usagers) {
						displayUsager(simpleDateFormat, usagerDTO2);
					}
					break;

				default:
					break;
				}
			}
		}

	}

	private UsagerDTO inputUsager(Scanner scanner,
			SimpleDateFormat simpleDateFormat) {
		UsagerDTO usagerDTO;
		System.out.print("nom : ");
		String nom = inputString(scanner, simpleDateFormat);
		System.out.print("prenom : ");
		String prenom = inputString(scanner, simpleDateFormat);
		System.out.print("date naissance : ");
		Date dateNaiss = inputDate(scanner, simpleDateFormat);
		System.out.print("email : ");
		String email = inputString(scanner, simpleDateFormat);

		usagerDTO = new UsagerDTO();
		usagerDTO.setNom(nom);
		usagerDTO.setPrenom(prenom);
		usagerDTO.setDateNaiss(dateNaiss);
		usagerDTO.setEmail(email);
		return usagerDTO;
	}

	private void displayUsager(SimpleDateFormat simpleDateFormat,
			UsagerDTO usagerDTO) {
		String dateDisplay;
		if (usagerDTO.getDateNaiss() == null) {
			dateDisplay = null;
		} else {
			dateDisplay = simpleDateFormat.format(usagerDTO.getDateNaiss());
		}
		System.out.format("%-20s | %-20s | %-10s | %3d | %-20s\n",
				usagerDTO.getNom(), usagerDTO.getPrenom(), dateDisplay,
				usagerDTO.getNbConnexion(), usagerDTO.getEmail());
	}

	private String inputString(Scanner scanner, SimpleDateFormat simpleDateFormat) {
		String retour = null;
		String saisie = "";
		while (retour == null && saisie.compareTo("**") != 0) {
			saisie = scanner.nextLine();
			if (saisie.compareTo("**") != 0) {
				retour = saisie;
			}
		}
		return retour;
	}
	
	private Date inputDate(Scanner scanner, SimpleDateFormat simpleDateFormat) {
		Date retour = null;
		String saisie = "";
		while (retour == null && saisie.compareTo("**") != 0) {
			saisie = scanner.nextLine();
			if (saisie.compareTo("**") != 0) {
				try {
					retour = simpleDateFormat.parse(saisie);
				} catch (ParseException e) {
					System.out.println("mauvais format");
				}
			}
		}
		return retour;
	}

	private Integer inputInteger(Scanner scanner) {
		Integer retour = null;
		String saisie = "";
		while (retour == null && saisie.compareTo("**") != 0) {
			saisie = scanner.nextLine();
			if (saisie.compareTo("**") != 0) {
				try {
					retour = Integer.valueOf(saisie);
				} catch (NumberFormatException e) {
					System.out.println("mauvais format");
				}
			}
		}
		return retour;
	}

}
