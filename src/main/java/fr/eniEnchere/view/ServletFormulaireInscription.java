package fr.eniEnchere.view;

import fr.eniEnchere.bll.UtilisateursManager;
import fr.eniEnchere.bll.ValidationForm;
import fr.eniEnchere.bo.Utilisateurs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
/**
 * Servlet pour le formulaire d'inscription.

 */
@WebServlet("/inscription")
public class ServletFormulaireInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/formulaireInscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudoUser = request.getParameter("pseudo");
		String prenomUser = request.getParameter("firstname");
		String nomUser = request.getParameter("name");
		String emailUser = request.getParameter("email");
		String phoneUser = request.getParameter("phone");
		String streetUser = request.getParameter("street");
		String zipCodeUser = request.getParameter("zipCode");
		String cityUser = request.getParameter("city");
		String passwordUser = request.getParameter("password");
		
		Boolean isFormValid = true;
		
		ValidationForm formValidation = new ValidationForm();
		
		//verifier l'email
		if (!formValidation.verificationEmail(request)) {
			String messageErreur = "* Vous avez du faire une erreur dans votre email.";
			request.setAttribute("messageErreurEmail", messageErreur);
			isFormValid= false;
		}
		
		//verifier le telephone
		if (!formValidation.verificationPhone(request)) {
			String messageErreur = "* Vous avez du faire une erreur.";
			request.setAttribute("messageErreurPhone", messageErreur);
			isFormValid= false;
		}
		
		//verifier le code postal
		if (!formValidation.verificationZipCode(request)) {
			String messageErreur = "* Vous avez du faire une erreur dans votre code postal.";
			request.setAttribute("messageErreurZipcode", messageErreur);
			isFormValid= false;
		}
		
		//verifier le mot de passe
		if (!formValidation.verificationPassword(request)) {
			String messageErreur = "* Votre mot de passe dois contenir 5 chiffres uniquement";
			request.setAttribute("messageErreurPassword", messageErreur);
			isFormValid= false;
			
		}
		
		//verifier que la confirmation et le mot de pase soit identique
		if (!formValidation.verificationConfirmation(request)) {
			String messageErreur = "* Votre mot de passe et votre confirmation sont différentes";
			request.setAttribute("messageErreurConfirmation", messageErreur);
			isFormValid= false;			
		}

		//condition pour vérifier les autres champs vide
		if (pseudoUser.trim().length()<=1 | pseudoUser.startsWith(" ")) {
			String messageErreur = "* Votre pseudo est incorrecte";
			request.setAttribute("messageErreurPseudo", messageErreur);
			isFormValid= false;		
		}
		if (prenomUser.trim().length()<=1 | prenomUser.startsWith(" ")) {
			String messageErreur = "* Votre prénom est incorrecte";
			request.setAttribute("messageErreurPrenom", messageErreur);
			isFormValid= false;	
		}
		if (nomUser.trim().length()<=1 | nomUser.startsWith(" ")) {
			String messageErreur = "* Votre nom est incorrecte";
			request.setAttribute("messageErreurNom", messageErreur);
			isFormValid= false;	
		}
		if (streetUser.trim().length()<=1 | streetUser.startsWith(" ")) {
			String messageErreur = "* Votre rue est incorrecte ou contient un espace vide au début";
			request.setAttribute("messageErreurRue", messageErreur);
			isFormValid= false;	
		}
		if (cityUser.trim().length()<=1 | cityUser.startsWith(" ")) {
			String messageErreur = "* Votre ville est incorrecte ou contient un espace vide au début";
			request.setAttribute("messageErreurVille", messageErreur);
			isFormValid= false;	
		}
			
		//Valider l'ensemble du form
		if (isFormValid) {
			HttpSession session = request.getSession();	
			UtilisateursManager newUser = new UtilisateursManager();
			Utilisateurs utilisateur = newUser.addNewUser(pseudoUser, prenomUser, nomUser, emailUser, phoneUser, streetUser, zipCodeUser, cityUser, passwordUser);
			session.setAttribute("utilisateur", utilisateur);

			response.sendRedirect(request.getContextPath()+ "/user/accueil");			
		}else {
			//renvoyer la réponse sur la page de formulaire
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/formulaireInscription.jsp");
			rd.forward(request, response);					
		}

	}
}
