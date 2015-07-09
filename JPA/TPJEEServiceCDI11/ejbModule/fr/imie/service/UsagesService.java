/**
 * 
 */
package fr.imie.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.imie.UsagerEntity;

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
	
	
	
	
	
	
	
	
	

}
