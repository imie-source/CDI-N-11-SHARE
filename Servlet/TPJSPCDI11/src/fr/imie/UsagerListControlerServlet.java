package fr.imie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.DAO.UsagerDAO;
import fr.imie.DTO.UsagerDTO;

/**
 * Servlet implementation class UsagersServletControler
 */
@WebServlet("/usagerList")
public class UsagerListControlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsagerListControlerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// UsagerDTO usagerDTO1 = new UsagerDTO();
		// usagerDTO1.setNom("Bon");
		// usagerDTO1.setPrenom("Jean");
		// UsagerDTO usagerDTO2 = new UsagerDTO();
		// usagerDTO2.setNom("Sonsec");
		// usagerDTO2.setPrenom("Sofie");
		// UsagerDTO usagerDTO3 = new UsagerDTO();
		// usagerDTO3.setNom("Emploi");
		// usagerDTO3.setPrenom("Paul");
		// UsagerDTO usagerDTO4 = new UsagerDTO();
		// usagerDTO4.setNom("Ochon");
		// usagerDTO4.setPrenom("Paul");
		//
		// List<UsagerDTO> dtos = new ArrayList<UsagerDTO>();
		// dtos.add(usagerDTO1);
		// dtos.add(usagerDTO2);
		// dtos.add(usagerDTO3);
		// dtos.add(usagerDTO4);
		//

		List<UsagerDTO> dtos = new UsagerDAO().readAll();

		HttpSession session = request.getSession();
		session.setAttribute("usagers", dtos);

		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/WEB-INF/usagerList.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("delete") != null) {
			String numLigne = request.getParameter("numLigne");
			Integer numLigneInteger = Integer.valueOf(numLigne);
			List<UsagerDTO> usagers = (List<UsagerDTO>) request.getSession()
					.getAttribute("usagers");
			UsagerDTO dto = usagers.get(numLigneInteger - 1);
			UsagerDAO usagerDAO = new UsagerDAO();
			try {
				usagerDAO.delete(dto);	
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
			}
			
			// 1ere solution : modifier la session et afficher la vue
			// request.getRequestDispatcher("/UsagersServletView").forward(request,
			// response);

			// 2eme solution : repasser par le get du controller : redirect
			response.sendRedirect("usagerList");
		} else if (request.getParameter("edit") != null) {
			String numLigne = request.getParameter("numLigne");
			Integer numLigneInteger = Integer.valueOf(numLigne);
			List<UsagerDTO> usagers = (List<UsagerDTO>) request.getSession()
					.getAttribute("usagers");
			UsagerDTO dto = usagers.get(numLigneInteger - 1);
			//UsagerDAO usagerDAO = new UsagerDAO();
			response.sendRedirect(String.format("usagerForm?numLigne=%d",numLigneInteger));

		} else if (request.getParameter("create") != null) {
			response.sendRedirect("usagerForm");
		}
	}

}
