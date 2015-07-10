/**
 * 
 */
package fr.imie.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.imie.entity.UsagerEntity;

/**
 * @author imie
 *
 */
@Stateless
public class UsagesService {

	@PersistenceContext
	EntityManager entityManager;

	public UsagerEntity findById(Integer id) {
		UsagerEntity retour = entityManager.find(UsagerEntity.class, id);
		return retour;
	}

	public List<UsagerEntity> findAll() {
		@SuppressWarnings("unchecked")
		List<UsagerEntity> usagerEntities = entityManager.createNamedQuery(
				"UsagerEntity.findAll").getResultList();
		return usagerEntities;
	}
	
	public List<UsagerEntity> findByNom(String nom,String prenom) {
		Query query = entityManager.createNamedQuery(
				"UsagerEntity.findByNom");
		query.setParameter("nom", "%"+nom+"%");
		query.setParameter("prenom", "%"+prenom+"%");
		@SuppressWarnings("unchecked")
		List<UsagerEntity> usagerEntities = query.getResultList();
		return usagerEntities;
	}

	public UsagerEntity createUsager(UsagerEntity usagerEntity) {
		entityManager.persist(usagerEntity);
		return usagerEntity;
		
	}

}
