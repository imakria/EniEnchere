package fr.eniEnchere.view;

import fr.eniEnchere.bll.UtilisateursManager;
import fr.eniEnchere.bo.Utilisateurs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ServletProfilNonConnecte
 */
@WebServlet("/user/monprofil1")
public class ServletProfilNonConnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateursManager utilisateursManager = new UtilisateursManager();

		int id = Integer.parseInt(request.getParameter("id"));
		
		Utilisateurs utilisateur = utilisateursManager.selectionnerUtilisateurParId(id);


		request.setAttribute("utilisateur", utilisateur);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/monProfilNonConnecte.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
