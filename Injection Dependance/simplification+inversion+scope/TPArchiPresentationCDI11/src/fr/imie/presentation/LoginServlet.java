package fr.imie.presentation;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.DTO.UsagerDTO;
import fr.imie.annotation.Proxy;
import fr.imie.presentation.sessionBean.ConnectionSessionBean;
import fr.imie.service.IUsagesService;

/**
 * Servlet implementation class Home
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject @Proxy private IUsagesService usagesService;
	@Inject private ConnectionSessionBean connectionSessionBean;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String passw = request.getParameter("passw");
		UsagerDTO searchedUsager = new UsagerDTO();
		searchedUsager.setNom(login);
		searchedUsager.setPassword(passw);
		UsagerDTO dto = null;
		try {
			dto = usagesService.getAuthentifiedUsager(searchedUsager);
		} catch (IllegalArgumentException e) {
			request.setAttribute("error", e.getMessage());
		}
		if (dto != null) {
			//request.setAttribute("connectedUsager", dto);
			connectionSessionBean.setConnectedUsager(dto);
		} else {
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			//response.sendRedirect("login");
		}
	}
}
