package fr.eniEnchere.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletDeconnexion
 */
@WebServlet("/deconnexion")
public class ServletDeconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
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
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pageAccueil.jsp");
			rd.forward(request, response);
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
