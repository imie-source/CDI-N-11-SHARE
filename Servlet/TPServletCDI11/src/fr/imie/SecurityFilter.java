package fr.imie;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.DTO.UsagerDTO;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter("/*")
public class SecurityFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SecurityFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		UsagerDTO connectedUsager = (UsagerDTO) httpRequest.getSession()
				.getAttribute("connectedUsager");
		Boolean securedResource = true;
		if (httpRequest.getRequestURI().contains("Login")) {
			securedResource = false;
		}
		if (httpRequest.getRequestURI().contains("css")) {
			securedResource = false;
		}
		if (httpRequest.getRequestURI().contains("png")) {
			securedResource = false;
		}

		if (securedResource == false || connectedUsager != null) {
			chain.doFilter(request, response);
		} else {
			httpResponse.sendRedirect("LoginServlet");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
