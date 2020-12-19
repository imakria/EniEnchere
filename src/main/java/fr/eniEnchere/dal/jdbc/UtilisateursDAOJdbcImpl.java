package fr.eniEnchere.dal.jdbc;

import fr.eniEnchere.bo.Utilisateurs;
import fr.eniEnchere.dal.ConnectionProvider;
import fr.eniEnchere.dal.UtilisateursDAO;

import java.sql.*;

public class UtilisateursDAOJdbcImpl implements UtilisateursDAO {
    private Connection connection;

    private static final String INSERT_USER = "INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String CHECK_LOGIN = "SELECT * FROM UTILISATEURS WHERE (pseudo = ? AND  mot_de_passe = ?) ";
    private static final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
    private static final String UPDATE_USER = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?   WHERE  no_utilisateur = ?";

    private static final String DELETE_USER = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";

    private void loadDatabase() {
        try {
            //on établie la connexion, on crée la requete.
            connection = ConnectionProvider.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ajouterUtilisateur(Utilisateurs utilisateur) {
        loadDatabase();

        try {
            PreparedStatement preparedStmtInsert = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStmtInsert.setString(1, utilisateur.getPseudo());
            preparedStmtInsert.setString(2, utilisateur.getNom());
            preparedStmtInsert.setString(3, utilisateur.getPrenom());
            preparedStmtInsert.setString(4, utilisateur.getEmail());
            preparedStmtInsert.setString(5, utilisateur.getTelephone());
            preparedStmtInsert.setString(6, utilisateur.getRue());
            preparedStmtInsert.setString(7, utilisateur.getCode_postal());
            preparedStmtInsert.setString(8, utilisateur.getVille());
            preparedStmtInsert.setString(9, utilisateur.getMotDePasse());
            preparedStmtInsert.setInt(10, utilisateur.getCredit());
            preparedStmtInsert.setInt(11, utilisateur.getAdministrateur());

            preparedStmtInsert.executeUpdate();

            ResultSet rs = preparedStmtInsert.getGeneratedKeys();
            if(rs.next()) {
                utilisateur.setNoUtilisateur(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Utilisateurs verifierUtilisateur(String pseudo, String motDePasse) {
        loadDatabase();
        Utilisateurs utilisateur = null;

        try {
            PreparedStatement pstmt = connection.prepareStatement(CHECK_LOGIN);
            pstmt.setString(1, pseudo);
            pstmt.setString(2, motDePasse);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                utilisateur = new Utilisateurs();
                utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
                utilisateur.setPseudo(pseudo);
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setTelephone(rs.getString("telephone"));
                utilisateur.setRue(rs.getString("rue"));
                utilisateur.setCode_postal(rs.getString("code_postal"));
                utilisateur.setVille(rs.getString("ville"));
                utilisateur.setMotDePasse(motDePasse);
                utilisateur.setCredit(rs.getInt("credit"));
                utilisateur.setAdministrateur(rs.getInt("administrateur"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 	utilisateur;
    }

    @Override
    public Utilisateurs selectionnerUtilisateurParId(int id) {

        loadDatabase();
        Utilisateurs utilisateur = null;

        try {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_ID);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                utilisateur = new Utilisateurs();
                utilisateur.setNoUtilisateur(id);
                utilisateur.setPseudo(rs.getString("pseudo"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setTelephone(rs.getString("telephone"));
                utilisateur.setRue(rs.getString("rue"));
                utilisateur.setCode_postal(rs.getString("code_postal"));
                utilisateur.setVille(rs.getString("ville"));
                utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
                utilisateur.setCredit(rs.getInt("credit"));
                utilisateur.setAdministrateur(rs.getInt("administrateur"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;

    }

    @Override
    public void modifierUtilisateur(Utilisateurs nouvellesInfoUser) {
        loadDatabase();

        PreparedStatement pstmtModifProfil;
        try {
            pstmtModifProfil = connection.prepareStatement(UPDATE_USER);
            pstmtModifProfil.setString(1, nouvellesInfoUser.getPseudo());
            pstmtModifProfil.setString(2, nouvellesInfoUser.getNom());
            pstmtModifProfil.setString(3, nouvellesInfoUser.getPrenom());
            pstmtModifProfil.setString(4, nouvellesInfoUser.getEmail());
            pstmtModifProfil.setString(5, nouvellesInfoUser.getTelephone());
            pstmtModifProfil.setString(6, nouvellesInfoUser.getRue());
            pstmtModifProfil.setString(7, nouvellesInfoUser.getCode_postal());
            pstmtModifProfil.setString(8, nouvellesInfoUser.getVille());
            pstmtModifProfil.setString(9, nouvellesInfoUser.getMotDePasse());
            pstmtModifProfil.setInt(10, nouvellesInfoUser.getCredit());

            pstmtModifProfil.setInt(11, nouvellesInfoUser.getNoUtilisateur());

            pstmtModifProfil.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




    }

    @Override
    public Boolean delete(Utilisateurs utilisateur) {
        loadDatabase();
        try {
            PreparedStatement pstmt = connection.prepareStatement(DELETE_USER);
            pstmt.setInt(1,	utilisateur.getNoUtilisateur());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }



}
