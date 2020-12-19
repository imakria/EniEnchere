package fr.eniEnchere.view;

import fr.eniEnchere.bll.UtilisateursManager;
import fr.eniEnchere.bo.Utilisateurs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletSuppressionCompte
 */
@WebServlet("/user/suppressionCompte")
public class ServletSuppressionCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();		
		
		
		Utilisateurs utilisateur;
		utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
		System.out.println("Y'a t-il un utilisateur : " + utilisateur);
		
		UtilisateursManager utilisateursManager = new UtilisateursManager();
		utilisateursManager.deleteUtilisateur(utilisateur);
		
		if (session != null) {
			session.removeAttribute("utilisateur");	
			
			Cookie cookie = null;
			Cookie[] cookies = null;
			
			cookies = request.getCookies();
			if( cookies != null ) {
		         for (int i = 0; i < cookies.length; i++) {
		            cookie = cookies[i];

		            if((cookie.getName( )).compareTo("pseudo") == 0 ) {
		               cookie.setMaxAge(0);
		               response.addCookie(cookie);
		            }
		               if((cookie.getName( )).compareTo("motDePasse") == 0 ) {
			               cookie.setMaxAge(0);
			               response.addCookie(cookie);
		               }	              
		            }	           
		         }
			}
		
		response.sendRedirect(request.getContextPath()+"/accueil");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
