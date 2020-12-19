package fr.eniEnchere.view;

import fr.eniEnchere.bll.ArticlesVendusManager;
import fr.eniEnchere.bll.CategoriesManager;
import fr.eniEnchere.bo.ArticleVendus;
import fr.eniEnchere.bo.Categories;
import fr.eniEnchere.bo.Utilisateurs;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ServletListeEnchereConnecte
 */
@WebServlet("/user/accueil")

public class ServletListeEnchereConnecte extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Utilisateurs utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
        int id = utilisateur.getNoUtilisateur();

        //Peut être supprimé, me sert de test
        session.setAttribute("id", id);

        CategoriesManager categoriesManager = new CategoriesManager();
        List<Categories> listeCategories =  categoriesManager.selectionCategories();
        request.setAttribute("listeCategories", listeCategories);
        System.out.println("Dans la servlet liste catégorie :" + listeCategories);

        String filtering = request.getParameter("filtering");
        String motDansRecherche = request.getParameter("keyword");
        System.out.println("Dans le do get de Servlet connecte le motDansRecherche est : " + motDansRecherche);
        System.out.println("Dans le do get de Servlet connecte le filtering est : " + filtering);
        ArticlesVendusManager articlesVendusManager = new ArticlesVendusManager();

        if( motDansRecherche != null) {

            List<ArticleVendus> listeArticlesVendus = articlesVendusManager.selectionArticlesFiltreAchats(motDansRecherche);
            request.setAttribute("listeArticlesVendus", listeArticlesVendus);
            System.out.println("Dans la servlet listeEnchereConnecte les  articles vendus : " + listeArticlesVendus);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listeEncheresConnecte.jsp");
            rd.forward(request, response);


        }

        else {
            List<ArticleVendus> listeArticlesVendus = articlesVendusManager.selectionArticlesVendus();
            request.setAttribute("listeArticlesVendus", listeArticlesVendus);
            System.out.println("Dans la servlet liste articles vendus : " + listeArticlesVendus);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listeEncheresConnecte.jsp");
            rd.forward(request, response);
        }
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
