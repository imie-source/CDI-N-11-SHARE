package fr.imie.usages;

import java.sql.Connection;
import java.util.List;

import fr.imie.DAO.IUsagerDAO;
import fr.imie.DAO.UsagerDAO;
import fr.imie.DTO.UsagerDTO;

public class UsagerService implements IUsagerService {

	IUsagerDAO usagerDAO;
	
	public UsagerService() {
		usagerDAO = new UsagerDAO();
	}

	@Override
	public UsagerDTO ajouter(UsagerDTO usagerDTO) {
		return usagerDAO.ajouter(usagerDTO);
	}

	@Override
	public List<UsagerDTO> readAll() {
		return usagerDAO.readAll();
	}

	@Override
	public List<UsagerDTO> readByDTO(UsagerDTO usagerDTO) {
		return usagerDAO.readByDTO(usagerDTO);
	}

	@Override
	public UsagerDTO update(UsagerDTO usagerDTO) {
		return usagerDAO.update(usagerDTO);
	}

	@Override
	public Integer delete(UsagerDTO usagerDTO) {
		return usagerDAO.delete(usagerDTO);
	}

	@Override
	public Integer delete(UsagerDTO usagerDTO, Connection connection) {
		return usagerDAO.delete(usagerDTO, connection);
	}

	@Override
	public UsagerDTO getAuthentifiedUsager(UsagerDTO usagerDTO) {
		return usagerDAO.getAuthentifiedUsager(usagerDTO);
	}

}
