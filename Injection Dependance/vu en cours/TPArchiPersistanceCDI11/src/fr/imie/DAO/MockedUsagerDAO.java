/**
 * 
 */
package fr.imie.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import fr.imie.DTO.SiteDTO;
import fr.imie.DTO.UsagerDTO;
import fr.imie.connection.ConnectionProvider;
import fr.imie.factory.IFactory;

/**
 * @author imie
 *
 */
@Named("mockedUsagerDAO")
public class MockedUsagerDAO implements IUsagerDAO {

	private IFactory factory;

	@Inject
	private ISiteDAO siteDAO;

	public MockedUsagerDAO(IFactory factory) {
		super();
		this.factory = factory;
		siteDAO = factory.createSiteDAO();
	}

	public MockedUsagerDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.DAO.IUsagerDAO#ajouter(fr.imie.DTO.UsagerDTO)
	 */
	@Override
	public UsagerDTO ajouter(UsagerDTO usagerDTO) {
		return usagerDTO;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.DAO.IUsagerDAO#readAll()
	 */
	@Override
	public List<UsagerDTO> readAll() {
		List<UsagerDTO> usagerDTOs = new ArrayList<UsagerDTO>();

		UsagerDTO usagerDTO1 = new UsagerDTO();
		usagerDTO1.setNom("nom1");
		usagerDTO1.setPrenom("nom1");

		UsagerDTO usagerDTO2 = new UsagerDTO();
		usagerDTO2.setNom("verse");
		usagerDTO2.setPrenom("alain");

		UsagerDTO usagerDTO3 = new UsagerDTO();
		usagerDTO3.setNom("conda");
		usagerDTO3.setPrenom("anna");

		UsagerDTO usagerDTO4 = new UsagerDTO();
		usagerDTO4.setNom("emploi");
		usagerDTO4.setPrenom("paul");

		usagerDTOs.add(usagerDTO1);
		usagerDTOs.add(usagerDTO2);
		usagerDTOs.add(usagerDTO3);
		usagerDTOs.add(usagerDTO4);

		return usagerDTOs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imie.DAO.IUsagerDAO#readByDTO(fr.imie.DTO.UsagerDTO)
	 */
	@Override
	public List<UsagerDTO> readByDTO(UsagerDTO usagerDTO) {
		List<UsagerDTO> retour = new ArrayList<UsagerDTO>();
		retour.add(usagerDTO);
		return retour;

	}

	@Override
	public UsagerDTO getAuthentifiedUsager(UsagerDTO usagerDTO) {
		return usagerDTO;

	}

	@Override
	public UsagerDTO update(UsagerDTO usagerDTO) {

		return usagerDTO;

	}

	@Override
	public Integer delete(UsagerDTO usagerDTO) {
		Integer retour;
		retour = delete(usagerDTO, null);
		return retour;
	}

	@Override
	public Integer delete(UsagerDTO usagerDTO, Connection connection) {

		return 1;
	}
}
