package fr.imie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MEnuSer
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String menu = "<div id=\"menuContainer\">"
				+ "<a href=\"HomeServlet\"><div id=\"menu0\" class=\"menu\">Home</div></a>"
				+ "<a href=\"UsagersServletControler\"><div id=\"menu1\" class=\"menu\">Usagers</div></a>"
				+ "<a href=\"DeconnexionServlet\"><div id=\"menu9\" class=\"menu\">Deconnexion</div></a>"
				+ "</div>";
		String erreur = (String) request.getSession().getAttribute("error");
		if (erreur != null) {
			menu = menu + String.format("<div><span>%s</span></div>", erreur);
		}
		request.getSession().removeAttribute("error");
		response.getWriter().write(menu);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
