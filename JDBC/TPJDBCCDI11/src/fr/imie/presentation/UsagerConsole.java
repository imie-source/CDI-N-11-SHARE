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
				Integer menu = inputInteger(scanner);

				switch (menu) {
				case 0:
					exitFlag = !exitFlag;
					break;
				case 1:
					List<UsagerDTO> usagers = usagerDAO.readAll();

					for (UsagerDTO usagerDTO : usagers) {
						displayUsager(simpleDateFormat, usagerDTO);
					}

					break;

				case 2:
					System.out.print("nom : ");
					String nom = scanner.nextLine();
					System.out.print("prenom : ");
					String prenom = scanner.nextLine();
					System.out.print("date naissance : ");
					Date dateNaiss = inputDate(scanner,simpleDateFormat);
					System.out.print("email : ");
					String email = scanner.nextLine();
					
					UsagerDTO usagerDTO = new UsagerDTO();
					usagerDTO.setNom(nom);
					usagerDTO.setPrenom(prenom);
					usagerDTO.setDateNaiss(dateNaiss);
					usagerDTO.setEmail(email);
					
					usagerDTO = usagerDAO.ajouter(usagerDTO);
					System.out.format("usager inséré avec l'id : %d\n",
							usagerDTO.getId());
					displayUsager(simpleDateFormat, usagerDTO);
					break;

				default:
					break;
				}
			}
		}

	}

	private void displayUsager(SimpleDateFormat simpleDateFormat,
			UsagerDTO usagerDTO) {
		String dateDisplay;
		if (usagerDTO.getDateNaiss() == null) {
			dateDisplay = null;
		} else {
			dateDisplay = simpleDateFormat.format(usagerDTO
					.getDateNaiss());
		}
		System.out.format(
				"%-20s | %-20s | %-10s | %3d | %-20s\n",
				usagerDTO.getNom(), usagerDTO.getPrenom(),
				dateDisplay, usagerDTO.getNbConnexion(),
				usagerDTO.getEmail());
	}

	private Date inputDate(Scanner scanner, SimpleDateFormat simpleDateFormat) {
		Date retour = null;
		while (retour == null) {
			String saisie = scanner.nextLine();
			try {
				retour = simpleDateFormat.parse(saisie);
			} catch (ParseException e) {
				System.out.println("mauvais format");
			}
		}
		return retour;
	}

	private Integer inputInteger(Scanner scanner) {
		String saisie = scanner.nextLine();
		return Integer.valueOf(saisie);
	}

}
