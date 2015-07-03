/**
 * 
 */
package fr.imie.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.DTO.SiteDTO;
import fr.imie.connection.ConnectionProvider;

/**
 * @author imie
 *
 */
public class SiteDAO implements ISiteDAO {


	public SiteDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.DAO.ISiteDAO#ajouter(fr.imie.DTO.SiteDTO)
	 */
	@Override
	public SiteDTO ajouter(SiteDTO siteDTO) {
		SiteDTO siteDTOInserted = null;
		try (Connection connection = ConnectionProvider.getInstance()
				.provideConnection()) {
			String query = "INSERT INTO site(nom)"
					+ " VALUES (?) returning id, nom";
			try (PreparedStatement statement = connection
					.prepareStatement(query)) {
				statement.setString(1, siteDTO.getNom());
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						siteDTOInserted = buildDTO(resultSet);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return siteDTOInserted;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.DAO.ISiteDAO#readAll()
	 */
	@Override
	public List<SiteDTO> readAll() {
		List<SiteDTO> siteDTOs = new ArrayList<SiteDTO>();
		try (Connection connection = ConnectionProvider.getInstance()
				.provideConnection()) {
			try (Statement statement = connection.createStatement()) {
				String query = "select * from site";
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while (resultSet.next()) {
						buildDTO(resultSet);
						siteDTOs.add(buildDTO(resultSet));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return siteDTOs;
	}

	private SiteDTO buildDTO(ResultSet resultSet) throws SQLException {
		SiteDTO siteDTO = new SiteDTO();
		siteDTO.setId(resultSet.getInt("id"));
		siteDTO.setNom(resultSet.getString("nom"));
		return siteDTO;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.DAO.ISiteDAO#readByDTO(fr.imie.DTO.SiteDTO)
	 */
	@Override
	public List<SiteDTO> readByDTO(SiteDTO siteDTO) {
		List<SiteDTO> retour = new ArrayList<SiteDTO>();
		try (Connection connection = ConnectionProvider.getInstance()
				.provideConnection()) {
			String query = "select id, nom from site ";
			Boolean firstConstraint = true;
			if (siteDTO.getNom() != null) {
				query = query.concat(firstConstraint ? "where" : "and").concat(
						" nom like ?");
				firstConstraint = false;
			}
			if (siteDTO.getId() != null) {
				query = query.concat(firstConstraint ? "where" : "and").concat(
						" id=?");
				firstConstraint = false;
			}

			try (PreparedStatement preparedStatement = connection
					.prepareStatement(query)) {

				Integer numParam = 1;
				if (siteDTO.getNom() != null) {
					preparedStatement.setString(numParam++,
							"%" + siteDTO.getNom() + "%");
				}
				if (siteDTO.getId() != null) {
					preparedStatement.setInt(numParam++, siteDTO.getId());
				}

				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						retour.add(buildDTO(resultSet));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return retour;

	}

	@Override
	public SiteDTO update(SiteDTO siteDTO) {
		if (siteDTO.getId() == null) {
			throw new IllegalArgumentException("id obligatoire pour update");
		}
		SiteDTO siteDTOUpdated = null;
		try (Connection connection = ConnectionProvider.getInstance()
				.provideConnection()) {
			String query = "UPDATE site " + "SET nom=? "
					+ "WHERE id=? returning id, nom";
			try (PreparedStatement statement = connection
					.prepareStatement(query)) {
				statement.setString(1, siteDTO.getNom());
				statement.setInt(2, siteDTO.getId());
				System.out.println(statement.toString());
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						siteDTOUpdated = buildDTO(resultSet);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return siteDTOUpdated;

	}

	@Override
	public Integer delete(SiteDTO siteDTO) {
		Integer retour = null;
		try (Connection connection = ConnectionProvider.getInstance()
				.provideConnection()) {

			retour = delete(siteDTO, connection);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return retour;
	}

	@Override
	public Integer delete(SiteDTO siteDTO, Connection connection)
			throws SQLException {
		Integer retour;
		try {

			String query = "DELETE FROM site WHERE id=?";
			try (PreparedStatement statement = connection
					.prepareStatement(query)) {
				statement.setInt(1, siteDTO.getId());

				retour = statement.executeUpdate();
			}
		} catch (Exception e) {
			connection.rollback();
			throw new RuntimeException(e);
		}
		return retour;
	}
}
