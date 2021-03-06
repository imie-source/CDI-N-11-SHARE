package fr.imie.presentation;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.entity.UsagerEntity;
import fr.imie.service.UsagesService;

/**
 * Servlet implementation class UsagerForm
 */
@WebServlet("/usagerForm")
public class UsagerForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UsagesService usagesService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsagerForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idParameter = request.getParameter("id");
		if (idParameter != null) {
			Integer id = Integer.valueOf(idParameter);
			request.setAttribute("usager", usagesService.findById(id));
		}
		request.getRequestDispatcher("/WEB-INF/usagerForm.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("actionCreer") != null) {
			UsagerEntity usagerEntity = new UsagerEntity();
			usagerEntity.setNom(request.getParameter("inputNom"));
			usagerEntity.setPrenom(request.getParameter("inputPrenom"));
			usagesService.createUsager(usagerEntity);
			response.sendRedirect("usagerList");
		} else if (request.getParameter("actionModifier") != null) {
			UsagerEntity usagerEntity = new UsagerEntity();
			usagerEntity.setNom(request.getParameter("inputNom"));
			usagerEntity.setPrenom(request.getParameter("inputPrenom"));
			usagerEntity
					.setId(Integer.valueOf(request.getParameter("inputId")));
			usagesService.updateUsager(usagerEntity);
			response.sendRedirect("usagerList");
		}
	}

}
