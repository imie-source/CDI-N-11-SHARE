package fr.imie.presentation;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloworldServlet
 */
@WebServlet(urlPatterns = "/HelloworldServlet", initParams = @WebInitParam(name = "color", value = "red"))
public class HelloworldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloworldServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Writer writer = response.getWriter();
		String color = request.getParameter("color");
		if (color == null) {
			color = getInitParameter("color");
		}

		String template = "<!doctype html>" + "<html lang=\"fr\">" + "<head>"
				+ "<meta charset=\"utf-8\">"
				+ "<title>HELLO</title>" + "</head>" + "<body>"
				+ "%s" + "</body>" + "</html>";
		String content = "<div style=\"color:%s;font-size:40px;\">" + "HELLO WORLD" + "</div>";

		String links = "<div>" + "<a href=\"./HelloworldServlet?color=grey\">"
				+ "gris" + "</a>" + "</div>" + "<div>"
				+ "<a href=\"./HelloworldServlet?color=magenta\">" + "magenta"
				+ "</a>" + "</div>";

		content = String.format(content, color);

		String page = String.format(template, content + links);

		writer.write(page);
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
