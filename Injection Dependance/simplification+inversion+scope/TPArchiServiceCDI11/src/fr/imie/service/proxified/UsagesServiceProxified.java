package fr.imie.service.proxified;

import java.sql.Connection;
import java.util.List;

import javax.inject.Inject;

import fr.imie.DAO.ISiteDAO;
import fr.imie.DAO.IUsagerDAO;
import fr.imie.DTO.SiteDTO;
import fr.imie.DTO.UsagerDTO;
import fr.imie.annotation.Proxy;
import fr.imie.connection.ConnectionProvider;
import fr.imie.service.IUsagesService;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.ITransactional;

public class UsagesServiceProxified extends ATransactional implements
		IUsagesService, ITransactional {

	@Inject
	@Proxy
	IUsagerDAO usagerDAO;

	@Inject
	@Proxy
	ISiteDAO siteDAO;

	@Override
	public UsagerDTO ajouter(UsagerDTO usagerDTO) {
		((ITransactional) usagerDAO).beginTransaction(this);
		UsagerDTO dto = usagerDAO.ajouter(usagerDTO);
		((ITransactional) usagerDAO).endTransaction();
		return dto;

	}

	@Override
	public List<UsagerDTO> readAll() {
		((ITransactional) usagerDAO).beginTransaction(this);
		List<UsagerDTO> readAll = usagerDAO.readAll();
		((ITransactional) usagerDAO).endTransaction();
		return readAll;
	}

	@Override
	public List<UsagerDTO> readByDTO(UsagerDTO usagerDTO) {
		((ITransactional) usagerDAO).beginTransaction(this);
		List<UsagerDTO> readByDTO = usagerDAO.readByDTO(usagerDTO);
		((ITransactional) usagerDAO).endTransaction();
		return readByDTO;
	}

	@Override
	public UsagerDTO update(UsagerDTO usagerDTO) {
		((ITransactional) usagerDAO).beginTransaction(this);
		UsagerDTO update = usagerDAO.update(usagerDTO);
		((ITransactional) usagerDAO).endTransaction();
		return update;
	}

	@Override
	public Integer delete(UsagerDTO usagerDTO) {
		((ITransactional) usagerDAO).beginTransaction(this);
		Integer delete = usagerDAO.delete(usagerDTO);
		((ITransactional) usagerDAO).endTransaction();
		return delete;
	}

	@Override
	public Integer delete(UsagerDTO usagerDTO, Connection connection) {
		((ITransactional) usagerDAO).beginTransaction(this);
		Integer delete = usagerDAO.delete(usagerDTO, connection);
		((ITransactional) usagerDAO).endTransaction();
		return delete;
	}

	@Override
	public UsagerDTO getAuthentifiedUsager(UsagerDTO usagerDTO) {
		System.out.println(usagerDAO);
		((ITransactional) usagerDAO).beginTransaction(this);
		UsagerDTO authentifiedUsager = usagerDAO
				.getAuthentifiedUsager(usagerDTO);
		((ITransactional) usagerDAO).endTransaction();
		return authentifiedUsager;
	}

	@Override
	public Integer deleteSite(SiteDTO siteDTO) {
		Integer retour = null;
		try {
			UsagerDTO usagerDTO = new UsagerDTO();
			usagerDTO.setSiteDTO(siteDTO);
			
			((ITransactional) usagerDAO).beginTransaction(this);
			((ITransactional) siteDAO).beginTransaction(this);
			
			List<UsagerDTO> usagerDTOs = usagerDAO.readByDTO(usagerDTO);
			for (UsagerDTO usagerDTO2 : usagerDTOs) {
				usagerDAO.delete(usagerDTO2);
			}
			siteDAO.delete(siteDTO);
			
			((ITransactional) siteDAO).endTransaction();
			((ITransactional) usagerDAO).endTransaction();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return retour;
	}

}
