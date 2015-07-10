package fr.imie.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the "usager" database table.
 * 
 */
@Entity
@Table(name = "usager")
@NamedQueries({
		@NamedQuery(name = "UsagerEntity.findAll", query = "SELECT u FROM UsagerEntity u"),
		@NamedQuery(name = "UsagerEntity.findByNom", query = "SELECT u FROM UsagerEntity u WHERE u.nom like :nom and u.prenom like :prenom") })
public class UsagerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance")
	private Date dateNaissance;

	@Column(name = "email")
	private String email;

	@Column(name = "nb_connexion")
	private int nbConnexion;

	@Column(name = "nom")
	private String nom;

	@Column(name = "password")
	private String password;

	@Column(name = "prenom")
	private String prenom;

	public UsagerEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNbConnexion() {
		return this.nbConnexion;
	}

	public void setNbConnexion(int nbConnexion) {
		this.nbConnexion = nbConnexion;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}