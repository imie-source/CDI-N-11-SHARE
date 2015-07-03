package fr.imie.presentation.sessionBean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class SecurityAskedRessourceSessionBean implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8374068656427416313L;
	private String askedRessource;
	
	public SecurityAskedRessourceSessionBean() {
		// TODO Auto-generated constructor stub
	}

	public String getAskedRessource() {
		return askedRessource;
	}

	public void setAskedRessource(String askedRessource) {
		this.askedRessource = askedRessource;
	}

	
	
}
