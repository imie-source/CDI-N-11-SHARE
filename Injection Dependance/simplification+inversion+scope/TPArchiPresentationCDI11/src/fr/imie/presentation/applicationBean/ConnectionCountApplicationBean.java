package fr.imie.presentation.applicationBean;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("connectionCountApplicationBean")
public class ConnectionCountApplicationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -808172020414092564L;
	private Integer connectionCount=0;
	
	public ConnectionCountApplicationBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void addConnection(){
		connectionCount++;
	}
	public void decConnection(){
		connectionCount--;
	}
	
	public Integer getConnectionCount(){
		return this.connectionCount;
	}

}
