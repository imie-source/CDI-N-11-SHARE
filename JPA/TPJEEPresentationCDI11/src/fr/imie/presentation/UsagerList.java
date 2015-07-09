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
		List<UsagerEntity> usagerEntities =usagesService.findAll();
		request.setAttribute("usagers", usagerEntities);
		request.getRequestDispatcher("/WEB-INF/usagerList.jsp").forward(request, response);
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
