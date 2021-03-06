package fr.imie.presentation;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.entity.UsagerEntity;
import fr.imie.service.UsagesService;

/**
 * Servlet implementation class UsagerList
 */
@WebServlet("/usagerList")
public class UsagerList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UsagesService usagesService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsagerList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<UsagerEntity> usagerEntities = usagesService.findAll();
		// List<UsagerEntity> usagerEntities =usagesService.findByNom("paul");
		request.setAttribute("usagers", usagerEntities);
		request.getRequestDispatcher("/WEB-INF/usagerList.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("actionRechercher") != null) {
			String nom = request.getParameter("inputNom");
			String prenom = request.getParameter("inputPrenom");
			List<UsagerEntity> usagerEntities = usagesService.findByNom(nom,
					prenom);
			request.setAttribute("usagers", usagerEntities);
			request.getRequestDispatcher("/WEB-INF/usagerList.jsp").forward(
					request, response);
		} else if (request.getParameter("actionCreer") != null) {
			response.sendRedirect("usagerForm");
		} else if (request.getParameter("actionSupprimer") != null) {
			String idParameter = request.getParameter("inputId");
			Integer id = Integer.valueOf(idParameter);
			UsagerEntity usagerEntity = new UsagerEntity();
			usagerEntity.setId(id);
			usagesService.delete(usagerEntity);
			request.setAttribute("usagers", usagesService.findAll());
			request.getRequestDispatcher("/WEB-INF/usagerList.jsp").forward(
					request, response);
		}

	}

}
