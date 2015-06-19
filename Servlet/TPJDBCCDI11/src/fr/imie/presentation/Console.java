/**
 * 
 */
package fr.imie.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fr.imie.NullInputException;
import fr.imie.DAO.ISiteDAO;
import fr.imie.DAO.IUsagerDAO;
import fr.imie.DAO.SiteDAO;
import fr.imie.DTO.SiteDTO;
import fr.imie.DTO.UsagerDTO;

/**
 * @author imie
 *
 */
public class Console {

	private IUsagerDAO usagerDAO;
	private ISiteDAO siteDAO;

	public Console(IUsagerDAO usagerDAO,ISiteDAO siteDAO) {
		super();
		this.usagerDAO = usagerDAO;
		this.siteDAO = siteDAO;
	}

	public void start() {
		try (Scanner scanner = new Scanner(System.in)) {

			Boolean exitFlag = false;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"dd/MM/yyyy");

			while (!exitFlag) {

				System.out.println("-------------------------");
				System.out.println("0: exit");
				System.out.println("1: lires tous les usagers");
				System.out.println("2: inserer un usager");
				System.out.println("3: rechercher des usagers");
				System.out.println("4: supprimer un usager");
				System.out.println("5: modifier un usager");
				System.out.println("6: lire tous les sites");
				System.out.println("7: créer un site");
				System.out.println("8: supprimer un site");
				System.out.println("-------------------------");
				Integer menu;
				try {
					menu = inputInteger(scanner);
				} catch (NullInputException e) {
					menu = -1;
				}
				UsagerDTO usagerDTO = null;
				List<UsagerDTO> usagers;
				SiteDTO siteDTO = null;
				List<SiteDTO> sites;
				Integer numLigneCounter;
				Integer numLigneSelect = null;
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
				case 4:
					usagers = usagerDAO.readAll();
					numLigneCounter = 1;
					for (UsagerDTO usagerDTO2 : usagers) {
						System.out.format("%3d :", numLigneCounter);
						displayUsager(simpleDateFormat, usagerDTO2);
						numLigneCounter++;
					}
					System.out.println("saisie du num de ligne à supprimer:");
					try {
						numLigneSelect = inputInteger(scanner);
						usagerDTO = usagers.get(numLigneSelect - 1);
						usagerDAO.delete(usagerDTO);
					} catch (NullInputException e) {
						System.out.println("numéro de ligne invalide");
					}

					break;
				case 5:
					usagers = usagerDAO.readAll();
					numLigneCounter = 1;
					for (UsagerDTO usagerDTO2 : usagers) {
						System.out.format("%3d :", numLigneCounter);
						displayUsager(simpleDateFormat, usagerDTO2);
						numLigneCounter++;
					}
					System.out.println("saisie du num de ligne à modifier:");
					try {
						numLigneSelect = inputInteger(scanner);
						usagerDTO = usagers.get(numLigneSelect - 1);
					} catch (NullInputException e) {
						System.out.println("numéro de ligne invalide");
					}

					if (numLigneSelect != null) {

						System.out.format("nom : %s ->", usagerDTO.getNom());
						String nom;
						UsagerDTO usagerDTOToUpdate = new UsagerDTO();
						try {
							nom = inputString(scanner);
							if (nom == null) {
								usagerDTOToUpdate.setNom(usagerDTO.getNom());
							} else {
								usagerDTOToUpdate.setNom(nom);
							}
						} catch (NullInputException e) {
							usagerDTOToUpdate.setNom(null);
						}

						System.out.format("prenom : %s ->",
								usagerDTO.getPrenom());
						String prenom;
						try {
							prenom = inputString(scanner);
							if (prenom == null) {
								usagerDTOToUpdate.setPrenom(usagerDTO
										.getPrenom());
							} else {
								usagerDTOToUpdate.setPrenom(prenom);
							}
						} catch (NullInputException e) {
							usagerDTOToUpdate.setPrenom(null);
						}

						System.out.format("date de naisance : %s ->",
								usagerDTO.getDateNaiss());
						Date dateNaiss;
						try {
							dateNaiss = inputDate(scanner, simpleDateFormat);
							if (dateNaiss == null) {
								usagerDTOToUpdate.setDateNaiss(usagerDTO
										.getDateNaiss());
							} else {
								usagerDTOToUpdate.setDateNaiss(dateNaiss);
							}
						} catch (NullInputException e) {
							usagerDTOToUpdate.setDateNaiss(null);
						}

						System.out
								.format("email : %s ->", usagerDTO.getEmail());
						String email;
						try {
							email = inputString(scanner);
							if (email == null) {
								usagerDTOToUpdate
										.setEmail(usagerDTO.getEmail());
							} else {
								usagerDTOToUpdate.setEmail(email);
							}
						} catch (NullInputException e) {
							usagerDTOToUpdate.setEmail(null);
						}

						usagerDTOToUpdate.setId(usagerDTO.getId());
						usagerDAO.update(usagerDTOToUpdate);
					}

					break;
				case 6:
					sites = siteDAO.readAll();
					for (SiteDTO siteDTO2 : sites) {
						displaySite(simpleDateFormat, siteDTO2);
					}
					break;

				case 7:
					siteDTO = inputSite(scanner, simpleDateFormat);

					siteDTO = siteDAO.ajouter(siteDTO);
					System.out.format("site inséré avec l'id : %d\n",
							siteDTO.getId());
					displaySite(simpleDateFormat, siteDTO);
					break;
				case 8:
					sites = siteDAO.readAll();
					numLigneCounter = 1;
					for (SiteDTO siteDTO2 : sites) {
						System.out.format("%3d :", numLigneCounter);
						displaySite(simpleDateFormat, siteDTO2);
						numLigneCounter++;
					}
					System.out.println("saisie du num de ligne à supprimer:");
					try {
						numLigneSelect = inputInteger(scanner);
						siteDTO = sites.get(numLigneSelect - 1);
						siteDAO.delete(siteDTO);
					} catch (NullInputException e) {
						System.out.println("numéro de ligne invalide");
					}
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
		String nom;
		try {
			nom = inputString(scanner);
		} catch (NullInputException e) {
			nom = null;
		}
		System.out.print("prenom : ");
		String prenom;
		try {
			prenom = inputString(scanner);
		} catch (NullInputException e) {
			prenom = null;
		}
		System.out.print("date naissance : ");
		Date dateNaiss;
		try {
			dateNaiss = inputDate(scanner, simpleDateFormat);
		} catch (NullInputException e) {
			dateNaiss = null;
		}
		System.out.print("email : ");
		String email;
		try {
			email = inputString(scanner);
		} catch (NullInputException e) {
			email = null;
		}

		System.out.print("site : ");
		SiteDTO siteDTO=null;
		List<SiteDTO> sites = siteDAO.readAll();
		Integer numLigneCouter=1;
		for (SiteDTO siteDTO2 : sites) {
			System.out.format(" %3d :", numLigneCouter++);
			displaySite(simpleDateFormat, siteDTO2);
		}
		try {
			Integer numLigneSelected = inputInteger(scanner);
			siteDTO = sites.get(numLigneSelected-1);
		} catch (NullInputException e) {
			//aucun site selectionné
		}
		
		usagerDTO = new UsagerDTO();
		usagerDTO.setNom(nom);
		usagerDTO.setPrenom(prenom);
		usagerDTO.setDateNaiss(dateNaiss);
		usagerDTO.setEmail(email);
		usagerDTO.setSiteDTO(siteDTO);
		return usagerDTO;
	}

	private SiteDTO inputSite(Scanner scanner,
			SimpleDateFormat simpleDateFormat) {
		SiteDTO siteDTO;
		System.out.print("nom : ");
		String nom;
		try {
			nom = inputString(scanner);
		} catch (NullInputException e) {
			nom = null;
		}
		siteDTO = new SiteDTO();
		siteDTO.setNom(nom);
		return siteDTO;
	}
	
	private void displayUsager(SimpleDateFormat simpleDateFormat,
			UsagerDTO usagerDTO) {
		String dateDisplay;
		if (usagerDTO.getDateNaiss() == null) {
			dateDisplay = null;
		} else {
			dateDisplay = simpleDateFormat.format(usagerDTO.getDateNaiss());
		}
		System.out.format("%-20s | %-20s | %-10s | %3d | %-20s | %-20s\n",
				usagerDTO.getNom(), usagerDTO.getPrenom(), dateDisplay,
				usagerDTO.getNbConnexion(), usagerDTO.getEmail(),usagerDTO.getSiteDTO()==null?null:usagerDTO.getSiteDTO().getNom());
	}
	
	private void displaySite(SimpleDateFormat simpleDateFormat,
			SiteDTO siteDTO) {
		String dateDisplay;
		System.out.format("%-20s\n",
				siteDTO.getNom());
	}

	private String inputString(Scanner scanner) throws NullInputException {
		String retour = null;
		String saisie = "";

		saisie = scanner.nextLine();
		if (saisie.compareTo("**") != 0) {
			retour = saisie.isEmpty() ? null : saisie;
		} else {
			throw new NullInputException();
		}

		return retour;
	}

	private Date inputDate(Scanner scanner, SimpleDateFormat simpleDateFormat)
			throws NullInputException {
		Date retour = null;
		String saisie = "";
		Boolean badFormat=true;
		while (badFormat) {
			saisie = scanner.nextLine();
			if (saisie.compareTo("**") != 0) {
				try {
					retour = saisie.isEmpty() ? null : simpleDateFormat
							.parse(saisie);
					badFormat=false;
				} catch (ParseException e) {
					System.out.println("mauvais format");
				}
			} else {
				throw new NullInputException();
			}

		}
		return retour;
	}

	private Integer inputInteger(Scanner scanner) throws NullInputException {
		Integer retour = null;
		String saisie = "";
		Boolean badFormat=true;
		while (badFormat) {
			saisie = scanner.nextLine();
			if (saisie.compareTo("**") != 0) {
				try {
					retour = saisie.isEmpty() ? null : Integer.valueOf(saisie);
					badFormat=false;
				} catch (NumberFormatException e) {
					System.out.println("mauvais format");
				}
			} else {
				throw new NullInputException();
			}
		}
		return retour;
	}

}
