package fr.eniEnchere.bll;

import fr.eniEnchere.bo.ArticleVendus;
import fr.eniEnchere.dal.ArticlesVendusDAO;
import fr.eniEnchere.dal.DAOFactory;


import java.sql.Date;
import java.util.List;

public class ArticlesVendusManager {

    private ArticlesVendusDAO daoArticleVendus;


    public ArticlesVendusManager() {
        daoArticleVendus = DAOFactory.getArticleVendusDAO();
    }

    public ArticleVendus ajouterArticle(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres, int prixInitial, int noUtilisateur, int noCategorie) {
        ArticleVendus newArticle = new ArticleVendus(nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, 0, noUtilisateur, noCategorie);
        ArticleVendus newArticleAjouterAvecID = daoArticleVendus.ajouterProduit(newArticle);

        return newArticleAjouterAvecID;
    }

    public List<ArticleVendus> selectionArticlesVendus() {
        return daoArticleVendus.selectAll();
    }

    public ArticleVendus selectionArticlesVendusById(int id) {
        return daoArticleVendus.selectById(id);
    }

    public ArticleVendus articleVendusWithAllInfo(int id) {
        return daoArticleVendus.selectByIdWithInfoFromOtherTable(id);
    }

    public List<ArticleVendus> selectionArticlesFiltreAchats(String motDansRecherche) {
        return daoArticleVendus.selectByFilter(motDansRecherche);
    }

    public boolean update(ArticleVendus articleVendu) {
        return daoArticleVendus.update(articleVendu);
    }

    public List<ArticleVendus> selectionFiltreLike() {
        return daoArticleVendus.selectByFilterLike();
    }


    // Code pour photo
    public void saveImage(ArticleVendus a, String fileName) throws Exception {

        System.out.println("L'article dans saveImage est : " + a);
        System.out.println("Le nom du fichier de la photo est : " + fileName);

        if (fileName != null && !fileName.isEmpty()) {
            a.setImage(fileName);
            daoArticleVendus.updateImage(a);
            System.out.println("L'article avec la photo : " + a);
        } else {
            throw new Exception("Error File");
        }
    }

    public ArticleVendus find(int id) throws Exception {
        if (id != 0) {
            ArticleVendus a = daoArticleVendus.read(id);
            return a;
        } else {
            throw new Exception("Error find by id = " + id);
        }
    }


}
