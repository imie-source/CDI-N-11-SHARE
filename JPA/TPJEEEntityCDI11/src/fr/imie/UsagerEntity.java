package fr.imie;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UsagerEntity
 *
 */
@Entity
@Table(name="usager")
public class UsagerEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	   
	@Id
	private Integer id;
	private String nom;
	private String prenom;
	

	public UsagerEntity() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
   
}
