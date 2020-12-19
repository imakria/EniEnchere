package fr.eniEnchere.bo;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ArticleVendus {

    private int noArticle;
    private String nomArticle;
    private String description;
    private Date dateDebutEncheres;
    private Date dateFinEncheres;
    private int prixInitial;
    private int prixVente;
    private int noUtilisateur;
    private int noCategorie;
    private List<ArticleVendus> articles = new ArrayList<>();

    //Attribut Image
    private int id;
    private String name;
    private String image;

    //ajout d'attribut pour créer un objet regroupant les table ARTICLES_VENDUS / CATEGORIES et RETRAITS => voire constructeur Constructeur table réunie
    private String libelleCategorie;
    private String rue;
    private String code_postal;
    private String ville;

    //CONSTRUCTORS -----------------------------------------
    public ArticleVendus() {
        super();
    }

    //constructeur pour ajouter un nouvelle article depuis la page AjoutArticle.jsp
    public ArticleVendus(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
                         int prixInitial, int noUtilisateur, int noCategorie) {
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.prixInitial = prixInitial;
        this.noUtilisateur = noUtilisateur;
        this.noCategorie = noCategorie;
    }


    public ArticleVendus(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
                         int prixInitial, int prixVente, int noUtilisateur, int noCategorie) {
        super();
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.prixInitial = prixInitial;
        this.prixVente = prixVente;
        this.noUtilisateur = noUtilisateur;
        this.noCategorie = noCategorie;
    }



    public ArticleVendus(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
                         Date dateFinEncheres, int prixInitial, int prixVente, int noUtilisateur, int noCategorie) {
        super();
        this.noArticle = noArticle;
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.prixInitial = prixInitial;
        this.prixVente = prixVente;
        this.noUtilisateur = noUtilisateur;
        this.noCategorie = noCategorie;
    }

    //Constructeur table réunie  pour créer un objet regroupant les table ARTICLES_VENDUS / CATEGORIES et RETRAITS
    public ArticleVendus(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
                         Date dateFinEncheres, int prixInitial, int noUtilisateur, String libelleCategorie, String rue, String code_postal, String ville) {
        this.noArticle = noArticle;
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.prixInitial = prixInitial;
        this.noUtilisateur = noUtilisateur;

        this.libelleCategorie = libelleCategorie;
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;

    }

    public ArticleVendus(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
                         Date dateFinEncheres, int prixInitial, int prixVente, int noUtilisateur, int noCategorie, String image) {
        super();
        this.noArticle = noArticle;
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.prixInitial = prixInitial;
        this.prixVente = prixVente;
        this.noUtilisateur = noUtilisateur;
        this.noCategorie = noCategorie;
        this.image = image;
    }

    //GETTERS ET SETTERS -----------------------------------------

    public int getNoArticle() {
        return noArticle;
    }


    public void setNoArticle(int noArticle) {
        this.noArticle = noArticle;
    }


    public String getNomArticle() {
        return nomArticle;
    }


    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public Date getDateDebutEncheres() {
        return dateDebutEncheres;
    }


    public void setDateDebutEncheres(Date dateDebutEncheres) {
        this.dateDebutEncheres = dateDebutEncheres;
    }


    public Date getDateFinEncheres() {
        return dateFinEncheres;
    }


    public void setDateFinEncheres(Date dateFinEncheres) {
        this.dateFinEncheres = dateFinEncheres;
    }


    public int getPrixInitial() {
        return prixInitial;
    }


    public void setPrixInitial(int prixInitial) {
        this.prixInitial = prixInitial;
    }


    public int getPrixVente() {
        return prixVente;
    }


    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }


    public int getNoUtilisateur() {
        return noUtilisateur;
    }


    public void setNoUtilisateur(int noUtilisateur) {
        this.noUtilisateur = noUtilisateur;
    }


    public int getNoCategorie() {
        return noCategorie;
    }


    public void setNoCategorie(int noCategorie) {
        this.noCategorie = noCategorie;
    }



    public List<ArticleVendus> getArticles() {
        return articles;
    }


    public void setArticles(List<ArticleVendus> articles) {
        this.articles = articles;
    }


    public String getLibelleCategorie() {
        return libelleCategorie;
    }

    public void setLibelleCategorie(String libelleCategorie) {
        this.libelleCategorie = libelleCategorie;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }


    //Constructor pour image

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArticleVendus other = (ArticleVendus) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        final int maxLen = 10;
        return "ArticleVendus [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
                + ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", prixInitial="
                + prixInitial + ", prixVente=" + prixVente + ", noUtilisateur=" + noUtilisateur + ", noCategorie="
                + noCategorie + ", articles="
                + (articles != null ? articles.subList(0, Math.min(articles.size(), maxLen)) : null) + ", id=" + id
                + ", name=" + name + ", image=" + image + ", libelleCategorie=" + libelleCategorie + ", rue=" + rue
                + ", code_postal=" + code_postal + ", ville=" + ville + "]";
    }



    //Méthode to String -----------------------------------------



}
