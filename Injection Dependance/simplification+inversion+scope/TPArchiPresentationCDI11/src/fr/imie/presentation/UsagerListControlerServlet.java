package fr.imie.presentation;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class UsagersServletControler
 */
@WebServlet("/usagerList")
public class UsagerListControlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject @Proxy
	private IUsagesService usagesService;
	
	@Inject
	private UsagerIHMSessionBean usagerIHMSessionBean;

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

		List<UsagerDTO> dtos = usagesService.readAll();

//		HttpSession session = request.getSession();
//		session.setAttribute("usagers", dtos);
		usagerIHMSessionBean.setUsagers(dtos);

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
//			List<UsagerDTO> usagers = (List<UsagerDTO>) request.getSession()
//					.getAttribute("usagers");
			List<UsagerDTO> usagers = usagerIHMSessionBean.getUsagers();
			UsagerDTO dto = usagers.get(numLigneInteger - 1);
			try {
				usagesService.delete(dto);
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
			}

			// 1ere solution : modifier la session et afficher la vue
//			request.getSession().setAttribute("usagers",
//					usagesService.readAll());
			usagerIHMSessionBean.setUsagers(usagesService.readAll());
			request.getRequestDispatcher("/WEB-INF/usagerList.jsp").forward(
					request, response);

			// 2eme solution : repasser par le get du controller : redirect
			// response.sendRedirect("usagerList");
		} else if (request.getParameter("edit") != null) {
			String numLigne = request.getParameter("numLigne");
			Integer numLigneInteger = Integer.valueOf(numLigne);
			response.sendRedirect(String.format("usagerForm?numLigne=%d",
					numLigneInteger));

		} else if (request.getParameter("create") != null) {
			response.sendRedirect("usagerForm");
		}
	}

}
