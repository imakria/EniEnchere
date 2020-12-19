package fr.eniEnchere.bll;

import fr.eniEnchere.bo.Categories;
import fr.eniEnchere.dal.CategoriesDAO;
import fr.eniEnchere.dal.DAOFactory;

import java.util.List;

public class CategoriesManager {

    private CategoriesDAO daoCategorie;
    /**
     *  Constructeur de UtilisateursManager qui retourne une instance de UtilisateursDAOJdbcImpl
     * afin de ne pas créer une instance à chaque appel de méthode mais uniquement au moment de l'intanciation
     * UtilisateursManager
     *
     */
    public CategoriesManager() {
        daoCategorie = DAOFactory.getCategoriesDAO();
    }
    public List<Categories> selectionCategories() {
        return daoCategorie.selectAll();
    }
}
