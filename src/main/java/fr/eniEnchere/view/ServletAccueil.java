package fr.eniEnchere.view;

import fr.eniEnchere.bll.ArticlesVendusManager;
import fr.eniEnchere.bll.CategoriesManager;
import fr.eniEnchere.bll.UtilisateursManager;
import fr.eniEnchere.bo.ArticleVendus;
import fr.eniEnchere.bo.Categories;
import fr.eniEnchere.bo.Utilisateurs;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/accueil")
public class ServletAccueil extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pageAccueil.jsp");
        //System.out.println("hola");
        //rd.forward(request, response);

        Cookie[] cookies = request.getCookies();
        Cookie cookieUtilisateurPseudo = null;
        Cookie cookieUtilisateurMotDePasse = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("pseudo")) {
                    cookieUtilisateurPseudo = cookie;
                };
                if(cookie.getName().equals("motDePasse")) {
                    cookieUtilisateurMotDePasse = cookie;
                };
            }
        }

        if(cookieUtilisateurPseudo != null) {
            String pageDestination;
            UtilisateursManager utilisateurManager = new UtilisateursManager();
            Utilisateurs utilisateur = utilisateurManager.verifierUtilisateur(cookieUtilisateurPseudo.getValue(), cookieUtilisateurMotDePasse.getValue());

            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60*5);
            session.setAttribute("utilisateur", utilisateur);

            System.out.println(cookieUtilisateurPseudo.getName());
            System.out.println(cookieUtilisateurPseudo.getValue());
            System.out.println(cookieUtilisateurMotDePasse.getName());
            System.out.println(cookieUtilisateurMotDePasse.getValue());

            pageDestination = "/user/accueil";
            response.sendRedirect(request.getContextPath()+ pageDestination);

            //RequestDispatcher rd = request.getRequestDispatcher("user/accueil");
            //rd.forward(request, response);

        } else {

            //Mon hypothèse (Naca)
            CategoriesManager categoriesManager = new CategoriesManager();
            List<Categories> listeCategories =  categoriesManager.selectionCategories();
            request.setAttribute("listeCategories", listeCategories);
            System.out.println("Dans la servlet liste catégorie :" + listeCategories);

            ArticlesVendusManager articlesVendusManager = new ArticlesVendusManager();
            List<ArticleVendus> listeArticlesVendus = articlesVendusManager.selectionArticlesVendus();
            request.setAttribute("listeArticlesVendus", listeArticlesVendus);
            System.out.println("Dans la servlet liste articles vendus : " + listeArticlesVendus);
            //Mon hypothèse (Naca)

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pageAccueil.jsp");
            rd.forward(request, response);
        }
        //RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/connexion.jsp");
        //rd.forward(request, response);
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
