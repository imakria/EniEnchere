package fr.eniEnchere.dal;

import fr.eniEnchere.bo.Categories;

import java.util.List;

public interface CategoriesDAO {
    public List<Categories> selectAll();
}
