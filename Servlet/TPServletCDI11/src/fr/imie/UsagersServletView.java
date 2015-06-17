package fr.imie;

import java.io.IOException;
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
		List<UsagerDTO> dtos = (List<UsagerDTO>) request
				.getAttribute("usagers");
		String template = "<!doctype html>" + "<html lang=\"fr\">" + "<head>"
				+ "<meta charset=\"utf-8\">" + "<title>HELLO</title>"
				+ "</head>" + "<body>" + "%s" + "</body>" + "</html>";

		String table = "<table><tr><th>nom</th><th>prenom</th></tr>%s</table>";
		
		String row = "<tr><td>%s</td><td>%s</td></tr>";
		
		String rows="";
		for (UsagerDTO usagerDTO : dtos) {
			rows= rows.concat(String.format(row, usagerDTO.getNom(),usagerDTO.getPrenom()));
		}
		
		table = String.format(table, rows);
		
		template = String.format(template, table);
		
		response.getWriter().write(template);

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
