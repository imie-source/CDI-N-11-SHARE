package fr.imie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
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

					try (Connection connection = DriverManager.getConnection(
							"jdbc:postgresql://localhost:5432/CDI11",
							"postgres", "postgres")) {
						try (Statement statement = connection.createStatement()) {
							String query = "select * from usager";
							try (ResultSet resultSet = statement
									.executeQuery(query)) {
								while (resultSet.next()) {
									String dateDisplay;
									Date date_naissance = resultSet
											.getDate("date_naissance");
									if (resultSet.wasNull()) {
										dateDisplay = null;
									} else {
										dateDisplay = simpleDateFormat
												.format(date_naissance);
									}
									System.out
											.format("%-20s | %-20s | %-10s | %3d | %-20s\n",
													resultSet.getString("nom"),
													resultSet
															.getString("prenom"),
													dateDisplay,
													resultSet
															.getInt("nb_connexion"),
													resultSet
															.getString("email"));
								}
							}
						}
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}

					break;

				case 2:
					System.out.print("nom : ");
					String nom = scanner.nextLine();
					System.out.print("prenom : ");
					String prenom = scanner.nextLine();

					try (Connection connection = DriverManager.getConnection(
							"jdbc:postgresql://localhost:5432/CDI11",
							"postgres", "postgres")) {
						String query = "INSERT INTO usager(nom, prenom, date_naissance, email, nb_connexion) VALUES (?, ?, ?, ?, ?)";
						try (PreparedStatement statement = connection
								.prepareStatement(query)) {
							statement.setString(1, nom);
							statement.setString(2, prenom);
							statement.setDate(3, null);
							statement.setString(4, null);
							statement.setNull(5, Types.INTEGER);
							Integer recordCount = statement.executeUpdate();
							System.out.format("nb de record inséré : %d\n",
									recordCount);
							//
							// try (ResultSet resultSet = statement
							// .executeQuery(query)) {
							// while (resultSet.next()) {
							// System.out.println(resultSet
							// .getString("nom"));
							//
							// }
							// }
						}
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}

					break;

				default:
					break;
				}
			}
		}

	}

	private static Integer inputInteger(Scanner scanner) {
		String menu = scanner.nextLine();
		return Integer.valueOf(menu);
	}
}
