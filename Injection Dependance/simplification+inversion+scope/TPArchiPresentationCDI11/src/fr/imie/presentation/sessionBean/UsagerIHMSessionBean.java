package fr.imie.presentation.sessionBean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import fr.imie.DTO.UsagerDTO;

@SessionScoped
@Named("usagerIHMSessionBean")
public class UsagerIHMSessionBean implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -842693575155087170L;
	private List<UsagerDTO> usagers;
	private Integer numLigne;
	
	public UsagerIHMSessionBean() {
		// TODO Auto-generated constructor stub
	}

	public List<UsagerDTO> getUsagers() {
		return usagers;
	}

	public void setUsagers(List<UsagerDTO> usagers) {
		this.usagers = usagers;
	}

	public Integer getNumLigne() {
		return numLigne;
	}

	public void setNumLigne(Integer numLigne) {
		this.numLigne = numLigne;
	}
	
	

}
