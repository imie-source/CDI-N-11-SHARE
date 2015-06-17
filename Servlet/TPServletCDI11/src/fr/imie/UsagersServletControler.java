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
@WebServlet("/UsagersServletControler")
public class UsagersServletControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsagersServletControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		UsagerDTO usagerDTO1 = new UsagerDTO();
//		usagerDTO1.setNom("Bon");
//		usagerDTO1.setPrenom("Jean");
//		UsagerDTO usagerDTO2 = new UsagerDTO();
//		usagerDTO2.setNom("Sonsec");
//		usagerDTO2.setPrenom("Sofie");
//		UsagerDTO usagerDTO3 = new UsagerDTO();
//		usagerDTO3.setNom("Emploi");
//		usagerDTO3.setPrenom("Paul");
//		UsagerDTO usagerDTO4 = new UsagerDTO();
//		usagerDTO4.setNom("Ochon");
//		usagerDTO4.setPrenom("Paul");
//		
//		List<UsagerDTO> dtos = new ArrayList<UsagerDTO>();
//		dtos.add(usagerDTO1);
//		dtos.add(usagerDTO2);
//		dtos.add(usagerDTO3);
//		dtos.add(usagerDTO4);
//		
		
		List<UsagerDTO> dtos = new UsagerDAO().readAll();
		
		HttpSession session = request.getSession();
		session.setAttribute("usagers",dtos);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/UsagersServletView");
		requestDispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
