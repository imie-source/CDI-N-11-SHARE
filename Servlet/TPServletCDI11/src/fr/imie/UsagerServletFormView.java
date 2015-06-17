package fr.imie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.DTO.UsagerDTO;

/**
 * Servlet implementation class UsagerServletFormView
 */
@WebServlet("/UsagerServletFormView")
public class UsagerServletFormView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsagerServletFormView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UsagerDTO usagerDTO = (UsagerDTO) request.getAttribute("usager");

		String templateDebut = "<!doctype html>"
				+ "<html lang=\"fr\">"
				+ "<head>"
				+ "<meta charset=\"utf-8\">"
				+ "<title>HELLO</title>"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/base.css\"> "
				+ "</head>" + "<body>";

		String templateFin = "</body>" + "</html>";

		String form = "<div class=\"container\"><div class=\"content\"><form>%s</form></div></div>";

		String nom = "<div><label for=\"nomInput\">nom : </label><input id=\"nomInput\" type=\"text\" value=\"%s\"/></div>";
		String prenom = "<div><label for=\"prenomInput\">prenom : </label><input id=\"prenomInput\" type=\"text\" value=\"%s\"/></div>";
		String mail = "<div><label for=\"mailInput\">mail : </label><input id=\"mailInput\" type=\"text\" value=\"%s\"/></div>";
		String dateNais = "<div><label for=\"dateNaissInput\">date de naissance : </label><input id=\"dateNaissInput\" type=\"date\" value=\"%s\"/></div>";
		String passw = "<div><label for=\"passwInput\">mot de passe : </label><input id=\"passwInput\" type=\"password\" value=\"%s\"/></div>";

		nom = String.format(nom, usagerDTO.getNom());
		prenom = String.format(prenom, usagerDTO.getPrenom());
		mail = String.format(mail, usagerDTO.getEmail());
		dateNais = String.format(dateNais, usagerDTO.getDateNaiss());
		passw = String.format(passw, "");

		form = String.format(form, nom + prenom + mail + dateNais + passw);
		
		PrintWriter writer = response.getWriter();
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
		// TODO Auto-generated method stub
	}

}
