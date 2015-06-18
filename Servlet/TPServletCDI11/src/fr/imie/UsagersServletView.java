package fr.imie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.DTO.UsagerDTO;

/**
 * Servlet implementation class UsagersServletView
 */
@WebServlet("/UsagersServletView")
public class UsagersServletView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsagersServletView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<UsagerDTO> dtos = (List<UsagerDTO>) request.getSession()
				.getAttribute("usagers");
		String templateDebut = "<!doctype html>"
				+ "<html lang=\"fr\">"
				+ "<head>"
				+ "<meta charset=\"utf-8\">"
				+ "<title>Usagers</title>"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/base.css\"> "
				+ "</head>" + "<body>";
		String templateFin = "</body>" + "</html>";

		String table = "<div class=\"container\"><div class=\"content\"><table><tr><th>nom</th><th>prenom</th><th>actions</th></tr>%s</table></div></div>";

		String creation = "<div><form method=\"POST\"><input type=\"submit\" class=\"icon createIcon\" name=\"create\"/></form></div>";
		String row = "<form action=\"UsagersServletControler\" method=\"POST\"><tr><td>%s</td>"
				+ "<td>%s</td>"
				+ "<td><input type=\"hidden\" value=\"%d\" name=\"numLigne\"/>"
				+ "<input type=\"submit\" name=\"edit\" class=\"icon editIcon\"/>"
				+ "<input type=\"submit\" name=\"delete\" class=\"icon delIcon\"/>"
				+ "</td></tr>"
				+ "</form>";

		String rows = "";
		Integer cpt = 1;
		for (UsagerDTO usagerDTO : dtos) {
			rows = rows.concat(String.format(row, usagerDTO.getNom(),
					usagerDTO.getPrenom(), cpt, cpt++));
		}

		table = String.format(table, rows);

		PrintWriter writer = response.getWriter();
		writer.write(templateDebut);
		request.getRequestDispatcher("/MenuServlet").include(request, response);
		writer.write(table+creation);
		writer.write(templateFin);

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
