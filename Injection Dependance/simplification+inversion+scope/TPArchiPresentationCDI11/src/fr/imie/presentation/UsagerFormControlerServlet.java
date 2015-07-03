package fr.imie.presentation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.DTO.UsagerDTO;
import fr.imie.annotation.Proxy;
import fr.imie.presentation.sessionBean.UsagerIHMSessionBean;
import fr.imie.service.IUsagesService;

/**
 * Servlet implementation class UsagerServletFormControler
 */
@WebServlet("/usagerForm")
public class UsagerFormControlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	@Proxy
	private IUsagesService usagesService;

	@Inject
	private UsagerIHMSessionBean usagerIHMSessionBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsagerFormControlerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// List<UsagerDTO> dtos = (List<UsagerDTO>) request.getSession()
		// .getAttribute("usagers");
		List<UsagerDTO> dtos = usagerIHMSessionBean.getUsagers();
		String numLigneUrl = request.getParameter("numLigne");
		if (numLigneUrl != null) {
			Integer numLigne = Integer.valueOf(numLigneUrl);
			UsagerDTO dto = dtos.get(numLigne - 1);
			request.setAttribute("usager", dto);
		} else {
			request.setAttribute("usager", null);
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
		UsagerDTO usagerDTO = null;
		if (request.getParameter("create") != null) {
			usagerDTO = new UsagerDTO();
		} else if (request.getParameter("edit") != null) {
			String numLigne = request.getParameter("numLigne");
			Integer numLigneInteger = Integer.valueOf(numLigne);
			// List<UsagerDTO> usagers = (List<UsagerDTO>) request.getSession()
			// .getAttribute("usagers");
			List<UsagerDTO> usagers = usagerIHMSessionBean.getUsagers();
			usagerDTO = usagers.get(numLigneInteger - 1);
		}

		usagerDTO.setNom(request.getParameter("nom"));
		usagerDTO.setPrenom(request.getParameter("prenom"));
		usagerDTO.setEmail(request.getParameter("mail"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if (request.getParameter("dateNaiss") != null) {
				usagerDTO.setDateNaiss(simpleDateFormat.parse(request
						.getParameter("dateNaiss")));
			}

		} catch (ParseException e) {
			request.setAttribute("error", e.getMessage());
		}
		usagerDTO.setPassword(request.getParameter("password"));
		// récupération de la factoty créé par FactoryListener

		if (request.getParameter("create") != null) {
			usagesService.ajouter(usagerDTO);
		} else if (request.getParameter("edit") != null) {
			usagesService.update(usagerDTO);
		}
		response.sendRedirect("usagerList");

		// TODO Auto-generated method stub
	}

}
