package fr.eniEnchere.dal.jdbc;

import fr.eniEnchere.bo.Categories;
import fr.eniEnchere.dal.CategoriesDAO;
import fr.eniEnchere.dal.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAOJdbcImpl implements CategoriesDAO {

    private Connection connection;
    private static final String SELECT_ALL = "SELECT * FROM categories";

    private void loadDatabase() {
        try {
            //on établie la connexion, on crée la requete.
            connection = ConnectionProvider.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Categories> selectAll() {

        loadDatabase();
        List<Categories> listeCategorie = new ArrayList<Categories>();

        try {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                listeCategorie.add(new Categories(rs.getInt(1), rs.getString(2)));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(listeCategorie);
        return listeCategorie;
    }
}
