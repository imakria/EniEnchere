package fr.eniEnchere.dal;

import fr.eniEnchere.bo.Utilisateurs;

public interface UtilisateursDAO {
    /**
     *
     * @author Ken
     *Interface pour lister les méthode dont on aura besoin et que l'on va implémenter dans le FormInscriptionDAOJdbcImpl
     */


        void ajouterUtilisateur(Utilisateurs utilisateur);

        public Utilisateurs verifierUtilisateur(String pseudo, String motDePasse);

        public Utilisateurs selectionnerUtilisateurParId(int id);

        void modifierUtilisateur(Utilisateurs nouvellesInfoUser);

        public Boolean delete(Utilisateurs utilisateur);

    }

