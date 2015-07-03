package fr.imie.presentation.requestBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
@Named("headerRequestBean")
public class HeaderRequestBean {
	
	@Inject
    private HttpServletRequest httpServletRequest;
	
	public HeaderRequestBean() {
		// TODO Auto-generated constructor stub
	}


	public String getAgent(){
		return httpServletRequest.getHeader("user-agent");
	}
	

}
