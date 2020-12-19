package fr.eniEnchere.view;

import fr.eniEnchere.bll.ArticlesVendusManager;
import fr.eniEnchere.bll.EnchereManager;
import fr.eniEnchere.bo.ArticleVendus;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletLoginPage
 */
@WebServlet("/encherir")
public class ServletEncherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//recup info produit par id avec toutes les infos des autres table du sql
		//pour tester id en dure
		//int idArticle = 1; 
		int idArticle = Integer.parseInt(request.getParameter("idArticle")) ;
		System.out.println(idArticle);
		ArticlesVendusManager articleManager = new ArticlesVendusManager();
		ArticleVendus infoArticleAEncherir = articleManager.articleVendusWithAllInfo(idArticle);
		System.out.println(infoArticleAEncherir);

		request.setAttribute("ArticleAEncherir", infoArticleAEncherir);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageEncherir.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//recup des info pour ajouter a la table encheres	
		//recup id utilisateur connecter
		HttpSession session = request.getSession();		
		int noUtilisateur = (int) session.getAttribute("id");
		//test pour voir quel id on recupere
		System.out.println("verifier qu'on a une id : " + noUtilisateur);
		
	
	    	//recu no_produit
	    //int idProduit = 5;
	    int idArticle = Integer.parseInt(request.getParameter("idArticle")) ;
	    System.out.println("je test l'id" + idArticle);
	    	//recu date enchere => date du jour
	    Date dateEnchere = new Date();
	    java.sql.Date sqlDateDebut = new java.sql.Date(dateEnchere.getTime()); 
	    System.out.println(dateEnchere);
	    System.out.println(sqlDateDebut);
	    
	      //recup montant
	    int montant_enchere = Integer.parseInt(request.getParameter("price"));
	    int montant_vente = Integer.parseInt(request.getParameter("prixVente"));
	    System.out.println("Le prix de vente est de : " + montant_vente);
	   
	    //ajout dans la BDD
	    
	    EnchereManager enchereManager = new EnchereManager();
	    enchereManager.ajouterUneEnchere(sqlDateDebut, montant_enchere, idArticle, noUtilisateur);

	    
	    //Update de l'article
	    ArticlesVendusManager articlesVendusManager = new ArticlesVendusManager();
	    ArticleVendus article = null;
	    article = articlesVendusManager.selectionArticlesVendusById(idArticle);
	    System.out.println("L'article selectionne avec l'id est : " + article);
	    article.setPrixVente(montant_enchere);
	    System.out.println("L'article avec le prix de vente à jour : " + article);
	    articlesVendusManager.update(article);
	   
	    response.sendRedirect(request.getContextPath()+ "/user/accueil");
	    
	    
	}

}
