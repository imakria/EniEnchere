package fr.eniEnchere.bo;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    private int noCategorie;
    private String libelle;
    private List<Categories> categories = new ArrayList<Categories>();


    public Categories() {
        super();
    }


    public Categories(String libelle) {
        super();
        this.libelle = libelle;
    }


    public Categories(int no_categorie, String libelle) {
        super();
        this.noCategorie = no_categorie;
        this.libelle = libelle;
    }


    public String getLibelle() {
        return libelle;
    }


    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }




    public int getNoCategorie() {
        return noCategorie;
    }


    public void setNoCategorie(int noCategorie) {
        this.noCategorie = noCategorie;
    }


    public List<Categories> getCategories() {
        return categories;
    }


    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }


    @Override
    public String toString() {
        return "Categories [no_categorie=" + noCategorie + ", libelle=" + libelle + "]";
    }
}
