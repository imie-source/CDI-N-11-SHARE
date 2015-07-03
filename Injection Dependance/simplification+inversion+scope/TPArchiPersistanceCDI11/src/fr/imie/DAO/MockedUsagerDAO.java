/**
 * 
 */
package fr.imie.DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;

import fr.imie.DTO.UsagerDTO;

/**
 * @author imie
 *
 */
@Alternative
public class MockedUsagerDAO implements IUsagerDAO {

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
