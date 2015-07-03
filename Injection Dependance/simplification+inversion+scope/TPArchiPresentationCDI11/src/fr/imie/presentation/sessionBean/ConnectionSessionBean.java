package fr.imie.presentation.sessionBean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.imie.DTO.UsagerDTO;
import fr.imie.presentation.applicationBean.ConnectionCountApplicationBean;

@SessionScoped
@Named("connectionSessionBean")
public class ConnectionSessionBean implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8010030227348644546L;

	private UsagerDTO connectedUsager;
	
	@Inject
	private ConnectionCountApplicationBean connectionCountApplicationBean;

	public ConnectionSessionBean() {
		// TODO Auto-generated constructor stub
	}

	public UsagerDTO getConnectedUsager() {
		return connectedUsager;
	}

	public void setConnectedUsager(UsagerDTO connectedUsager) {
		if(this.connectedUsager==null&&connectedUsager!=null){
			connectionCountApplicationBean.addConnection();
		}else if(this.connectedUsager!=null&&connectedUsager==null){
			connectionCountApplicationBean.decConnection();
		}
		this.connectedUsager = connectedUsager;
	}

}
