package fr.imie.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import fr.imie.DTO.SiteDTO;

public interface ISiteDAO {

	SiteDTO ajouter(SiteDTO siteDTO);

	List<SiteDTO> readAll();
	
	List<SiteDTO> readByDTO(SiteDTO siteDTO);
	
	SiteDTO update (SiteDTO siteDTO);
	
	Integer delete(SiteDTO siteDTO);

	Integer delete(SiteDTO siteDTO, Connection connection) throws SQLException;

}