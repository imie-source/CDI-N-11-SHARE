package fr.imie.service;
//package fr.imie.usages;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.annotation.Resource;
//import javax.ejb.Stateless;
//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.sql.DataSource;
//
//import fr.imie.DAO.ISiteDAO;
//import fr.imie.DAO.IUsagerDAO;
//import fr.imie.DTO.SiteDTO;
//import fr.imie.DTO.UsagerDTO;
//import fr.imie.annotation.Mocked;
//import fr.imie.connection.ConnectionProvider;
//import fr.imie.factory.IFactory;
//
//@Stateless
//public class UsagesServiceEJB implements IUsagesService {
//
//	@Resource(lookup = "java:/jdbc/imieDB")
//	private DataSource datasource;
//
//	@Inject
//	@Mocked
//	private IUsagerDAO usagerDAO;
//	@Inject
//	private ISiteDAO siteDAO;
//
//	public UsagesServiceEJB(IFactory factory) {
//		usagerDAO = factory.createUsagerDAO();
//	}
//
//	public UsagesServiceEJB() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public UsagerDTO ajouter(UsagerDTO usagerDTO) {
//		return usagerDAO.ajouter(usagerDTO);
//	}
//
//	@Override
//	public List<UsagerDTO> readAll() {
//		return usagerDAO.readAll();
//	}
//
//	@Override
//	public List<UsagerDTO> readByDTO(UsagerDTO usagerDTO) {
//		return usagerDAO.readByDTO(usagerDTO);
//	}
//
//	@Override
//	public UsagerDTO update(UsagerDTO usagerDTO) {
//		return usagerDAO.update(usagerDTO);
//	}
//
//	@Override
//	public Integer delete(UsagerDTO usagerDTO) {
//		return usagerDAO.delete(usagerDTO);
//	}
//
//	@Override
//	public Integer delete(UsagerDTO usagerDTO, Connection connection) {
//		return usagerDAO.delete(usagerDTO, connection);
//	}
//
//	@Override
//	public UsagerDTO getAuthentifiedUsager(UsagerDTO usagerDTO) {
//		return usagerDAO.getAuthentifiedUsager(usagerDTO);
//	}
//
//	@Override
//	public Integer deleteSite(SiteDTO siteDTO) {
//		Integer retour = null;
//		try {
//			Connection connection = datasource.getConnection();
//			try {
//				connection.setAutoCommit(false);
//				UsagerDTO usagerDTO = new UsagerDTO();
//				usagerDTO.setSiteDTO(siteDTO);
//				List<UsagerDTO> usagerDTOs = usagerDAO.readByDTO(usagerDTO);
//				for (UsagerDTO usagerDTO2 : usagerDTOs) {
//					usagerDAO.delete(usagerDTO2, connection);
//				}
//
//				siteDAO.delete(siteDTO, connection);
//				connection.commit();
//			} catch (Exception e) {
//				connection.rollback();
//				throw new RuntimeException(e);
//			}
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return retour;
//	}
//
//}
