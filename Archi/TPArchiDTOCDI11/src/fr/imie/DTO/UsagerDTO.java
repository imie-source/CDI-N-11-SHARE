/**
 * 
 */
package fr.imie.DTO;

import java.util.Date;

/**
 * @author imie
 *
 */
public class UsagerDTO{

	private Integer id;
	private String nom;
	private String prenom;
	private Date dateNaiss;
	private Integer nbConnexion;
	private String email;
	private SiteDTO siteDTO;
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public Integer getNbConnexion() {
		return nbConnexion;
	}

	public void setNbConnexion(Integer nbConnexion) {
		this.nbConnexion = nbConnexion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SiteDTO getSiteDTO() {
		return siteDTO;
	}

	public void setSiteDTO(SiteDTO siteDTO) {
		this.siteDTO = siteDTO;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
