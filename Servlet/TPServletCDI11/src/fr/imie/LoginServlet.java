package fr.imie;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.DAO.UsagerDAO;
import fr.imie.DTO.UsagerDTO;

/**
 * Servlet implementation class Home
 */
@WebServlet("/LoginServlet")
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
		String templateDebut = "<!doctype html>"
				+ "<html lang=\"fr\">"
				+ "<head>"
				+ "<meta charset=\"utf-8\">"
				+ "<title>HELLO</title>"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/base.css\"> "
				+ "</head>" + "<body>";
		String form = "<div class=\"container\"><div class=\"content\"><form method=\"POST\">%s"
				+ "<div></div>" + "%s" + "</form>" + "</div></div>";
		String loginButton = "<input type=\"submit\" name=\"login\"/>";

		String templateFin = "</body>" + "</html>";

		String login = "<div><label for=\"loginInput\">login : </label><input id=\"loginInput\" type=\"text\" value=\"\"/ name=\"login\"></div>";
		String passw = "<div><label for=\"passwInput\">mot de passe : </label><input id=\"passwInput\" type=\"text\" value=\"\" name=\"passw\"/></div>";

		form = String.format(form, login + passw, loginButton);

		Writer writer = response.getWriter();
		writer.write(templateDebut);
		request.getRequestDispatcher("/MenuServlet").include(request, response);
		writer.write(form);
		writer.write(templateFin);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String passw = request.getParameter("passw");
		UsagerDAO usagerDAO = new UsagerDAO();
		UsagerDTO searchedUsager = new UsagerDTO();
		searchedUsager.setNom(login);
		List<UsagerDTO> dtos = usagerDAO.readByDTO(searchedUsager);
		if (dtos.size()>0){
			request.getSession().setAttribute("connectedUsager", dtos.get(0));
			response.sendRedirect("HomeServlet");
		}else{
			response.sendRedirect("LoginServlet");
		}

	}

}
