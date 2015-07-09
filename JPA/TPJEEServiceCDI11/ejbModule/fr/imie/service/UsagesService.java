/**
 * 
 */
package fr.imie.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
