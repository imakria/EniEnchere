package fr.eniEnchere.view;

import fr.eniEnchere.bll.UtilisateursManager;
import fr.eniEnchere.bo.Utilisateurs;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/connexion")
public class ServletLoginPage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/connexion.jsp");
            rd.forward(request, response);
        }

        //RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/connexion.jsp");
        //rd.forward(request, response);
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pseudo = request.getParameter("identifiant");
        String motDePasse = request.getParameter("motDePasse");
        String seSouvenirDeMoi = request.getParameter("seSouvenirDeMoi");

        String pageDestination;

        UtilisateursManager utilisateurManager = new UtilisateursManager();

        Utilisateurs utilisateur = utilisateurManager.verifierUtilisateur(pseudo, motDePasse);

        if (utilisateur != null) {

            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60*200000);
            session.setAttribute("utilisateur", utilisateur);
            //session.setAttribute("id", utilisateur.getNoUtilisateur());
            System.out.println("ID de la methode DOPost ServletLogin : " + utilisateur.getNoUtilisateur());
            pageDestination = "/user/accueil";


            if(seSouvenirDeMoi != null) {
                System.out.println("Etat de seSouvenirDeMoi " + seSouvenirDeMoi);
                Cookie cookieUtilisateurPseudo = new Cookie("pseudo", pseudo);
                Cookie cookieUtilisateurMotDePasse = new Cookie("motDePasse", motDePasse);
                cookieUtilisateurPseudo.setMaxAge(200000);
                cookieUtilisateurMotDePasse.setMaxAge(200000);
                response.addCookie(cookieUtilisateurPseudo);
                response.addCookie(cookieUtilisateurMotDePasse);

                System.out.println(cookieUtilisateurPseudo);
                System.out.println(cookieUtilisateurMotDePasse);
            }
            response.sendRedirect(request.getContextPath()+ pageDestination);
        }else {
            String messageErreur = "Oops!! Pseudo/Mot de passe invalide";
            request.setAttribute("messageErreur", messageErreur);
            pageDestination = "WEB-INF/connexion.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(pageDestination);
            rd.forward(request, response);
        }
    }

}

