package fr.imie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.DTO.UsagerDTO;
import fr.imie.factory.IFactory;
import fr.imie.usages.IUsagesService;

/**
 * Servlet implementation class Home
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		//récupération de la factoty créé par FactoryListener
		IFactory factory = (IFactory) request.getServletContext().getAttribute(
				"factory");
		//Utilisation de la Factory pour récupérer le composant necessaire
		IUsagesService usagesService = factory.createUsagesService();
		UsagerDTO searchedUsager = new UsagerDTO();
		searchedUsager.setNom(login);
		searchedUsager.setPassword(passw);
		UsagerDTO dto = null;
		try {
			dto = usagesService.getAuthentifiedUsager(searchedUsager);
		} catch (IllegalArgumentException e) {
			request.getSession().setAttribute("error", e.getMessage());
		}
		if (dto != null) {
			request.getSession().setAttribute("connectedUsager", dto);
		} else {
			response.sendRedirect("LoginServlet");
		}

	}

}
