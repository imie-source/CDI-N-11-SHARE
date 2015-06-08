/**
 * 
 */
package fr.imie.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.imie.DTO.UsagerDTO;

/**
 * @author imie
 *
 */
public class UsagerDAO implements IUsagerDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.DAO.IUsagerDAO#ajouter(fr.imie.DTO.UsagerDTO)
	 */
	@Override
	public UsagerDTO ajouter(UsagerDTO usagerDTO) {
		UsagerDTO usagerDTOInserted = null;
		try (Connection connection = ConnectionProvider.getInstance().provideConnection()) {
			String query = "INSERT INTO usager(nom, prenom, date_naissance, email)"
					+ " VALUES (?, ?, ?, ?) returning id, nom, prenom, date_naissance, email, nb_connexion";
			try (PreparedStatement statement = connection
					.prepareStatement(query)) {
				statement.setString(1, usagerDTO.getNom());
				statement.setString(2, usagerDTO.getPrenom());
				statement.setDate(3, new Date(usagerDTO.getDateNaiss()
						.getTime()));
				statement.setString(4, usagerDTO.getEmail());

				// System.out.format("nb de record inséré : %d\n", recordCount);

				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						usagerDTOInserted = buildDTO(resultSet);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return usagerDTOInserted;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.DAO.IUsagerDAO#readAll()
	 */
	@Override
	public List<UsagerDTO> readAll() {
		List<UsagerDTO> usagerDTOs = new ArrayList<UsagerDTO>();
		try (Connection connection = ConnectionProvider.getInstance().provideConnection()) {
			try (Statement statement = connection.createStatement()) {
				String query = "select * from usager";
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while (resultSet.next()) {
						buildDTO(resultSet);
						usagerDTOs.add(buildDTO(resultSet));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usagerDTOs;
	}

	private UsagerDTO buildDTO(ResultSet resultSet) throws SQLException {
		UsagerDTO usagerDTO = new UsagerDTO();
		usagerDTO.setId(resultSet.getInt("id"));
		usagerDTO.setNom(resultSet.getString("nom"));
		usagerDTO.setPrenom(resultSet.getString("prenom"));
		usagerDTO.setDateNaiss(resultSet.getDate("date_naissance"));
		usagerDTO.setEmail(resultSet.getString("email"));
		usagerDTO.setNbConnexion(resultSet.getInt("nb_connexion"));
		return usagerDTO;

	}
}
