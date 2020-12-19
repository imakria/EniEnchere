package fr.eniEnchere.dal;

import fr.eniEnchere.bo.ArticleVendus;

import java.util.List;

public interface ArticlesVendusDAO {

    public List<ArticleVendus> selectAll();

    public ArticleVendus ajouterProduit(ArticleVendus newArticle);

    public ArticleVendus selectById(int id);

    public ArticleVendus selectByIdWithInfoFromOtherTable(int id);

    public List<ArticleVendus> selectByFilter(String motDansRecherche);

    public boolean update(ArticleVendus article);

    public List<ArticleVendus> selectByFilterLike();


    // CRUD POUR PHOTO

    // Design Pattern CRUD (Create Read Update Delete)
    void create(ArticleVendus a) throws Exception;

    ArticleVendus read(int id) throws Exception;

    void updateImage(ArticleVendus a) throws Exception;

    void delete(int id) throws Exception;

}
