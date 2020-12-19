package fr.eniEnchere.filtre;

import fr.eniEnchere.bll.ArticlesVendusManager;
import fr.eniEnchere.bll.CategoriesManager;
import fr.eniEnchere.bo.ArticleVendus;
import fr.eniEnchere.bo.Categories;
import fr.eniEnchere.bo.Utilisateurs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ServletFiltre
 */
@WebServlet("/user/ServletFiltre")
public class ServletFiltre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFiltre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String btnRadioChoisi = request.getParameter("filtering");
		String checkEncheresOuvertes = null;
		String checkMesEncheres = null;
		String checkMesEncheresRemportees = null;
		String checkMesVentesEnCours = null;
		String checkVentesNonDebutees = null;
		String checkVentesTerminees = null;
		String motDansRecherche = null;
		
		
		motDansRecherche = request.getParameter("keyword");
		request.setAttribute("motDansRecherche", motDansRecherche);
		
		System.out.println("le mot dans la barre de recherche est : " + motDansRecherche);
		
		if(btnRadioChoisi.equalsIgnoreCase("0")) {
			checkEncheresOuvertes = request.getParameter("encheresOuvertes");
			checkMesEncheres = request.getParameter("mesEncheres");
			checkMesEncheresRemportees = request.getParameter("mesEncheresRemportees");
		}
		
		if(btnRadioChoisi.equalsIgnoreCase("1")) {
			checkMesVentesEnCours = request.getParameter("mesVentesEnCours");
			checkVentesNonDebutees = request.getParameter("ventesNonDebutees");
			checkVentesTerminees = request.getParameter("ventesTerminees");
		}
		
		
		
		HttpSession session = request.getSession();	
		Utilisateurs utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
		
		
		//int id = (int) session.getAttribute("id");	
		
		int id = utilisateur.getNoUtilisateur();
		System.out.println("noUtilisateur :" + id);
		
		request.setAttribute("utilisateur", utilisateur);
		//Peut être supprimé, me sert de test
		session.setAttribute("id", id);

		System.out.println(id);
		
		

		CategoriesManager categoriesManager = new CategoriesManager();
		List<Categories> listeCategories =  categoriesManager.selectionCategories();
		request.setAttribute("listeCategories", listeCategories);
		System.out.println("Dans la servlet liste catégorie :" + listeCategories);
		
		ArticlesVendusManager articlesVendusManager = new ArticlesVendusManager();
		List<ArticleVendus> listeArticlesVendus = articlesVendusManager.selectionArticlesFiltreAchats(motDansRecherche);
		request.setAttribute("listeArticlesVendus", listeArticlesVendus);
		System.out.println("Dans la servlet liste articles vendus : " + listeArticlesVendus);
		
		String filtering = request.getParameter("filtering");
		request.setAttribute("filtering", "filtering");
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/accueil");
		rd.forward(request, response);
		
		//response.sendRedirect(request.getContextPath()+"/user/accueil");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("je rentre aussi dans la servlet du doPost de ServletFiltre");
	}

}
