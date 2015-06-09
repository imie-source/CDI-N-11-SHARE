package fr.imie.DAO;

import java.util.List;

import fr.imie.DTO.UsagerDTO;

public interface IUsagerDAO {

	UsagerDTO ajouter(UsagerDTO usagerDTO);

	List<UsagerDTO> readAll();
	
	List<UsagerDTO> readByDTO(UsagerDTO usagerDTO);
	
	UsagerDTO update (UsagerDTO usagerDTO);
	
	Integer delete(UsagerDTO usagerDTO);

}