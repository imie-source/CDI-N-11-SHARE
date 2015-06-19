package fr.imie;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class LogCounterListener
 *
 */
@WebListener
public class LogCounterListener implements HttpSessionAttributeListener {

	/**
	 * Default constructor.
	 */
	public LogCounterListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		if (arg0.getName().compareTo("connectedUsager") == 0) {
			ServletContext servletContext = arg0.getSession()
					.getServletContext();
			Integer connectionCount = (Integer) servletContext
					.getAttribute("connectionCount");
			if (connectionCount == null) {
				connectionCount = 0;
			}
			servletContext.setAttribute("connectionCount", ++connectionCount);
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		if (arg0.getName().compareTo("connectedUsager") == 0) {
			ServletContext servletContext = arg0.getSession()
					.getServletContext();
			Integer connectionCount = (Integer) servletContext
					.getAttribute("connectionCount");
			servletContext.setAttribute("connectionCount", --connectionCount);
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
	}

}
