package fr.eniEnchere.dal;

import fr.eniEnchere.dal.jdbc.*;

public class DAOFactory {
    public static UtilisateursDAO getUtilisateursDAO() {
        return new UtilisateursDAOJdbcImpl();
    }

    public static CategoriesDAO getCategoriesDAO() {
        return new CategoriesDAOJdbcImpl();
    }

    public static ArticlesVendusDAO getArticleVendusDAO() {
        return new ArticlesVendusDAOJdbcImpl();
    }

    public static RetraitDAO getRetraitDAO() {
        return new RetraitDAOJdbcImpl();
    }

    public static EnchereDAO getEnchereDAO() {
        return new EnchereDAOJdbcImpl();
    }

    public static ArticlesVendusDAO getArticleDAO() {
        return new ArticlesVendusDAOJdbcImpl();
    }

}
