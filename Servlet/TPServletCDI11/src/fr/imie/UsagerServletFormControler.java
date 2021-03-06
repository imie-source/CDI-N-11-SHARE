package fr.imie;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.DAO.UsagerDAO;
import fr.imie.DTO.UsagerDTO;

/**
 * Servlet implementation class UsagerServletFormControler
 */
@WebServlet("/UsagerServletFormControler")
public class UsagerServletFormControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsagerServletFormControler() {
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
		String numLigneUrl = request.getParameter("numLigne");
		if (numLigneUrl != null) {
			Integer numLigne = Integer.valueOf(numLigneUrl);
			UsagerDTO dto = dtos.get(numLigne - 1);
			request.setAttribute("usager", dto);
		} else {
			request.setAttribute("usager", null);
		}
		request.getRequestDispatcher("/UsagerServletFormView").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UsagerDTO usagerDTO=null;
		if (request.getParameter("create") != null) {
			usagerDTO = new UsagerDTO();
		} else if (request.getParameter("edit")!=null) {
			String numLigne = request.getParameter("numLigne");
			Integer numLigneInteger = Integer.valueOf(numLigne);
			List<UsagerDTO> usagers = (List<UsagerDTO>) request.getSession()
					.getAttribute("usagers");
			usagerDTO = usagers.get(numLigneInteger - 1);
		}
		
		usagerDTO.setNom(request.getParameter("nom"));
		usagerDTO.setPrenom(request.getParameter("prenom"));
		usagerDTO.setEmail(request.getParameter("mail"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			usagerDTO.setDateNaiss(simpleDateFormat.parse(request
					.getParameter("dateNaiss")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usagerDTO.setPassword(request.getParameter("password"));

		UsagerDAO usagerDAO = new UsagerDAO();
		
		if (request.getParameter("create") != null) {
			usagerDAO.ajouter(usagerDTO);
		} else if (request.getParameter("edit")!=null) {
			usagerDAO.update(usagerDTO);
		}
		response.sendRedirect("UsagersServletControler");

		// TODO Auto-generated method stub
	}

}
