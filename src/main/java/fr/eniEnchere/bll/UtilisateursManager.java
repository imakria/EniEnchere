package fr.eniEnchere.bll;

import fr.eniEnchere.bo.Utilisateurs;
import fr.eniEnchere.dal.DAOFactory;
import fr.eniEnchere.dal.UtilisateursDAO;

public class UtilisateursManager {


    private UtilisateursDAO daoUtilisateur;
    /**
     *  Constructeur de UtilisateursManager qui retourne une instance de UtilisateursDAOJdbcImpl
     * afin de ne pas créer une instance à chaque appel de méthode mais uniquement au moment de l'intanciation
     * UtilisateursManager
     *
     */
    public UtilisateursManager() {
        daoUtilisateur = DAOFactory.getUtilisateursDAO();
    }

    public Utilisateurs addNewUser(String pseudoUser, String prenomUser, String nomUser, String emailUser, String phoneUser, String streetUser, String zipCodeUser, String cityUser, String passwordUser) {
        Utilisateurs utilisateur = new Utilisateurs(pseudoUser, nomUser, prenomUser, emailUser, phoneUser, streetUser, zipCodeUser, cityUser, passwordUser, 10, 0);
        daoUtilisateur.ajouterUtilisateur(utilisateur);
        return utilisateur;
    }

    public Utilisateurs verifierUtilisateur(String pseudo, String motDePasse) {

        return daoUtilisateur.verifierUtilisateur(pseudo, motDePasse);

    }

    public  Utilisateurs selectionnerUtilisateurParId(int id) {
        System.out.println(id);
        return daoUtilisateur.selectionnerUtilisateurParId(id);
    }

    public Utilisateurs updateUserProfil(int id, String pseudoUser, String prenomUser, String nomUser, String emailUser, String phoneUser, String streetUser, String zipCodeUser, String cityUser, String passwordUser, int credit) {
        Utilisateurs utilisateur = new Utilisateurs(id, pseudoUser, nomUser, prenomUser, emailUser, phoneUser, streetUser, zipCodeUser, cityUser, passwordUser, credit);
        daoUtilisateur.modifierUtilisateur(utilisateur);
        return utilisateur;

    }

    public boolean deleteUtilisateur(Utilisateurs utilisateur) {
        return daoUtilisateur.delete(utilisateur);
    }

}
