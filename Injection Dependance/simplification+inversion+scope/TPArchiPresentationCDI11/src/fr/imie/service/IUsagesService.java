package fr.imie.service;

import java.sql.Connection;
import java.util.List;

import fr.imie.DTO.SiteDTO;
import fr.imie.DTO.UsagerDTO;

public interface IUsagesService {

	UsagerDTO ajouter(UsagerDTO usagerDTO);

	List<UsagerDTO> readAll();

	List<UsagerDTO> readByDTO(UsagerDTO usagerDTO);

	UsagerDTO update(UsagerDTO usagerDTO);

	Integer delete(UsagerDTO usagerDTO);

	Integer delete(UsagerDTO usagerDTO, Connection connection);

	UsagerDTO getAuthentifiedUsager(UsagerDTO usagerDTO);

	Integer deleteSite(SiteDTO siteDTO);


}