package fr.imie.transactional;

import java.sql.Connection;
import java.util.List;

import fr.imie.DAO.IUsagerDAO;
import fr.imie.DTO.SiteDTO;
import fr.imie.DTO.UsagerDTO;
import fr.imie.factory.IFactory;
import fr.imie.transactionalFramework.ATransactional;
import fr.imie.transactionalFramework.ITransactional;
import fr.imie.usages.IUsagesService;

public class UsagesServiceProxified extends ATransactional implements IUsagesService, ITransactional {

	private IFactory factory;

	IUsagerDAO usagerDAO;

	
	public UsagesServiceProxified(IFactory factory) {
		super();
		this.factory = factory;
		usagerDAO = factory.createUsagerDAO();
	}


	@Override
	public UsagerDTO ajouter(UsagerDTO usagerDTO) {
		((ITransactional)usagerDAO).beginTransaction(this);
		UsagerDTO dto = usagerDAO.ajouter(usagerDTO);
		((ITransactional)usagerDAO).endTransaction();
		return dto;
		
	}

	@Override
	public List<UsagerDTO> readAll() {
		((ITransactional)usagerDAO).beginTransaction(this);
		List<UsagerDTO> readAll = usagerDAO.readAll();
		((ITransactional)usagerDAO).endTransaction();
		return readAll;
	}

	@Override
	public List<UsagerDTO> readByDTO(UsagerDTO usagerDTO) {
		((ITransactional)usagerDAO).beginTransaction(this);
		List<UsagerDTO> readByDTO = usagerDAO.readByDTO(usagerDTO);
		((ITransactional)usagerDAO).endTransaction();
		return readByDTO;
	}

	@Override
	public UsagerDTO update(UsagerDTO usagerDTO) {
		((ITransactional)usagerDAO).beginTransaction(this);
		UsagerDTO update = usagerDAO.update(usagerDTO);
		((ITransactional)usagerDAO).endTransaction();
		return update;
	}

	@Override
	public Integer delete(UsagerDTO usagerDTO) {
		((ITransactional)usagerDAO).beginTransaction(this);
		Integer delete = usagerDAO.delete(usagerDTO);
		((ITransactional)usagerDAO).endTransaction();
		return delete;
	}

	@Override
	public Integer delete(UsagerDTO usagerDTO, Connection connection) {
		((ITransactional)usagerDAO).beginTransaction(this);
		Integer delete = usagerDAO.delete(usagerDTO, connection);
		((ITransactional)usagerDAO).endTransaction();
		return delete;
	}

	@Override
	public UsagerDTO getAuthentifiedUsager(UsagerDTO usagerDTO) {
		((ITransactional)usagerDAO).beginTransaction(this);
		UsagerDTO authentifiedUsager = usagerDAO.getAuthentifiedUsager(usagerDTO);
		((ITransactional)usagerDAO).endTransaction();
		return authentifiedUsager;
	}


	@Override
	public Integer deleteSite(SiteDTO siteDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
