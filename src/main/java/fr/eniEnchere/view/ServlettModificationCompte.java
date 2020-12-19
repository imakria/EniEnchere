package fr.eniEnchere.view;

import fr.eniEnchere.bll.UtilisateursManager;
import fr.eniEnchere.bll.ValidationForm;
import fr.eniEnchere.bo.Utilisateurs;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet pour le formulaire d'inscription.
 */
@WebServlet("/user/modifie_profil")
public class ServlettModificationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * doGet récupére les info d'un User par son id et les envoie à la JSP pour les afficher.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtilisateursManager utilisateursManager = new UtilisateursManager();
		//on recupere l'id du User stocker dans la session
		HttpSession session = request.getSession();		
		Utilisateurs utilisateurConnecter = (Utilisateurs) session.getAttribute("utilisateur");
		int id = utilisateurConnecter.getNoUtilisateur(); 
		//=> je comente pour le moemnt pour tester avaec un id en dure plus bas
		session.setAttribute("id", id);
		
		//code en dure de l'ID pour la fase de test
		//int id = 19;
		//je vais rechercher l'utilisateur connecter en base de donné mais cela ne devrait pas etre necessaire car on a deja toute ses info dans la session
		//donc faire un essaie quand on aura finaliser la partie connexion
		Utilisateurs utilisateur = utilisateursManager.selectionnerUtilisateurParId(id);

		//on renvoie l'utilisateur connecter avec ces info dans le formulaire pour les afficher
		request.setAttribute("utilisateur", utilisateur);
		this.getServletContext().getRequestDispatcher("/WEB-INF/ModifierMonCompte.jsp").forward(request, response);
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
		String OldPasswordUser = request.getParameter("oldPassword");
		int credit = Integer.parseInt(request.getParameter("credit"));
	
		Boolean isFormValid = true;
		
		ValidationForm formValidation = new ValidationForm();
		
		//vérifier que le mot de passe Actuel soit celui de l'utilisateur avant d'incrire la modification
		//on dois recuperer le mot de passe de l'utilisateur connecté pour le vérifier avec le champ oldPassword du formulaire
		//si le mot de passe est identique alors on update la basse de donnée
		HttpSession session = request.getSession();		
		int id = (int) session.getAttribute("id");	
		//test pour voir quel id on recupere
		System.out.println("verifier qu'on a une id : " + id);	
		
		Utilisateurs utilisateurConnecter = (Utilisateurs) session.getAttribute("utilisateur");
		String motDePasseEnSession = utilisateurConnecter.getMotDePasse();
		
		
		// je le code en dure pour tester:
		//String motDePasseEnSession = "12345";
		
		//vérifier le mot de passe actuel
		if (!motDePasseEnSession.equals(OldPasswordUser)) {
			String messageErreur = "* Votre mot de passe actuel n'est pas correcte";
			request.setAttribute("messageErreurEmail", messageErreur);
			isFormValid= false;		
		}else {
			//verifier l'email
			if (!formValidation.verificationEmail(request)) {
				String messageErreur = "* Vous avez du faire une erreur dans votre email.";
				request.setAttribute("messageErreurEmail", messageErreur);
				isFormValid= false;
			}
			
			//verifier le telephone
			if (!formValidation.verificationPhone(request)) {
				String messageErreur = "* Vous avez du faire une erreur dans votre numéro de téléphone.";
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
				String messageErreur = "* Votre rue est incorrecte";
				request.setAttribute("messageErreurRue", messageErreur);
				isFormValid= false;	
			}
			if (cityUser.trim().length()<=1 | cityUser.startsWith(" ")) {
				String messageErreur = "* Votre ville est incorrecte";
				request.setAttribute("messageErreurVille", messageErreur);
				isFormValid= false;	
			}
			
			//Valider l'ensemble du form
			if (isFormValid) {
				UtilisateursManager newUser = new UtilisateursManager();
				//Utilisateurs utilisateur = 
				Utilisateurs utilisateur = newUser.updateUserProfil(id, pseudoUser, prenomUser, nomUser, emailUser, phoneUser, streetUser, zipCodeUser, cityUser, passwordUser, credit);					
				request.setAttribute("infoUpdate", true);			
				request.setAttribute("utilisateur", utilisateur);
				
			}
			//renvoyer la réponse sur la page de formulaire
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ModifierMonCompte.jsp");
			rd.forward(request, response);	
		}
	}
}
