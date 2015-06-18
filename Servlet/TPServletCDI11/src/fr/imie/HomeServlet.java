package fr.imie;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String templateDebut = "<!doctype html>"
				+ "<html lang=\"fr\">"
				+ "<head>"
				+ "<meta charset=\"utf-8\">"
				+ "<title>HELLO</title>"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/base.css\"> "
				+ "</head>" + "<body>";

		String welcome="BIENVENUE";
		String templateFin = "</body>" + "</html>";
		Writer writer = response.getWriter();
		writer.write(templateDebut);
		request.getRequestDispatcher("/MenuServlet").include(request, response);
		writer.write(welcome);
		writer.write(templateFin);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
