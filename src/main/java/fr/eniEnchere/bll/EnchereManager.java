package fr.eniEnchere.bll;

import fr.eniEnchere.bo.Encheres;
import fr.eniEnchere.dal.DAOFactory;
import fr.eniEnchere.dal.EnchereDAO;

import java.sql.Date;


public class EnchereManager {
	
	private EnchereDAO daoEncheres;
	
	public EnchereManager() {
		daoEncheres = DAOFactory.getEnchereDAO();
	}
	
	public void ajouterUneEnchere(Date dateEnchere, int montantEnchere, int noArticle, int noUtilisateur) {
		//créer la condition d'ajout uniquement si l'enchère est plus haute que la précédente.
		
		Encheres newEnchere = new Encheres(dateEnchere, montantEnchere, noArticle, noUtilisateur);
		daoEncheres.ajouterEnchere(newEnchere);

	}
}
