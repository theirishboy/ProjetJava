/* 
 * To change this template, choose Tools | Templates 
 * and open the template in the editor. 
 */
package BDD;

import Controleur.Cours;
import Controleur.Enseignant;
import Controleur.Etudiant;
import Controleur.Groupe;
import Controleur.Salle;
import Controleur.Seance;
import Controleur.Site;
import Controleur.Type_Cours;
import Controleur.Utilisateur;
import Liste.Liste_Cours;
import Liste.Liste_Enseignants;
import Liste.Liste_Groupes;
import Liste.Liste_Salles;
import Liste.Liste_Seances;
import Liste.Liste_Utilisateurs;
import static java.lang.String.format;

/* 
 *  
 * Librairies importées 
 */
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Connexion a votre BDD locale ou à distance sur le serveur de l'ECE via le
 * tunnel SSH
 *
 * @author segado
 */
public class ConnexionBDD {

    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private final Connection conn;
    private final Statement stmt;
    private ResultSet rset;
    private ResultSet rset2;
    private ResultSet rset3;

    private ResultSetMetaData rsetMeta;

    /**
     *
     */
    public ConnexionBDD(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver" 

        Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE" 
        String urlDatabase = "jdbc:mysql://localhost:3306/" + nameDatabase;
        // String urlDatabase = "jdbc:mysql://localhost:3308/jps?characterEncoding=latin1"; 

        //création d'une connexion JDBC à la base  
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement) 
        stmt = conn.createStatement();
    }

    public Utilisateur Connexionutilisateur(String Email, String motdepasse) {

        try {
            // récupération de l'ordre de la requete

            rset = stmt.executeQuery("select * from utilisateur where email=\"" + Email + "\" AND PASSWD= \"" + motdepasse + "\" ");

            // récupération du résultat de l'ordre
            rsetMeta = rset.getMetaData();

            // calcul du nombre de colonnes du resultat
            int nbColonne = rsetMeta.getColumnCount();

            // creation d'une ArrayList de String
            ArrayList<String> liste;
            liste = new ArrayList<>();

            // creation d'une ArrayList de String
            String champs = null;

            // tant qu'il reste une ligne
            rset.next();
            // tant qu'il reste une ligne
            // String champs = null;
            System.out.println("ici");

            String IDs = rset.getString(1);
            int ID;
            ID = Integer.parseInt(IDs);

            String Nom = rset.getString(4);

            String Prenom = rset.getString(5);

            int Droit = rset.getInt(6);

            System.out.println("droit = " + Droit);

            Utilisateur nouveauUtilisateur = new Utilisateur(ID, Email, motdepasse, Nom, Prenom, Droit);
            return nouveauUtilisateur;

        } catch (SQLException ex) {
            System.out.println("mot de passe faux");
            return null;
        }

    }

    public Liste_Seances Mescours(Utilisateur utilisateur, int Semaine) throws SQLException, ParseException {
        Liste_Seances messeances = new Liste_Seances();

        if (utilisateur.getDroit() == 4) {
            rset = stmt.executeQuery("select * from Etudiant where ID_Utilisateur=" + utilisateur.getID());
            rset.next();
            int b = rset.getInt("ID_Groupe");
            rset.close();

            rset2 = stmt.executeQuery("select ID_Seance from seance_groupe where ID_Groupe=" + b);
            //rset2 = stmt.executeQuery("select * from seance where ID='1' AND SEMAINE='1';");
            ArrayList<Integer> bonjour = new ArrayList();
            while (rset2.next()) {

                bonjour.add(rset2.getInt(1));

            }

            for (Integer bonjour1 : bonjour) {
                rset3 = stmt.executeQuery("select * from seance where (ID='" + bonjour1 + "'AND SEMAINE='"+Semaine+"');");
                rset3.next();
                SimpleDateFormat h1 = new SimpleDateFormat("H:m");
                java.util.Date h11 = h1.parse(rset3.getString(4));
                java.util.Date h22 = h1.parse(rset3.getString(5));
                Seance seance1 = new Seance(rset3.getInt(1), Semaine, rset3.getDate(3), h11, h22, rset3.getString(6), rset3.getInt(7), rset3.getInt(8), rset3.getInt(9));
                messeances.ajout(seance1);
            }
            //  System.out.println("Je suis etudiant"+ rset.getInt(1) + rset.getInt(3)+rset.getInt(2));

        }
        if (utilisateur.getDroit() == 3) {
            rset = stmt.executeQuery("select * from Enseignant where ID_Utilisateur=" + utilisateur.getID());
            rset.next();

            rset3 = stmt.executeQuery("select * from seance_groupe where ID_Groupe=" + rset.getInt(3));
            rset3.next();

            rset2 = stmt.executeQuery("select * from seance where ID=" + rset3.getInt(1) + "AND SEMAINE =" + Semaine);
            rset2.next();
            SimpleDateFormat h1 = new SimpleDateFormat("H:m");
            Date h11 = (Date) h1.parse(rset2.getString(4));
            Date h22 = (Date) h1.parse(rset2.getString(5));

            Seance seance1 = new Seance(rset2.getInt(1), Semaine, rset2.getDate(3), h11, h22, rset2.getString(6), rset2.getInt(7), rset2.getInt(8), rset2.getInt(9));
            messeances.ajout(seance1);
        }

        return messeances;

    }

    public Liste_Groupes getGroupe(Seance seance) throws SQLException {
        Liste_Groupes groupe = new Liste_Groupes();
        rset = stmt.executeQuery("select ID_Groupe From seance_groupe where ID_Seance =" + seance.getID());
        ArrayList<Integer> bonjour = new ArrayList();
        while (rset.next()) {

            bonjour.add(rset.getInt(1));

        }

        for (Integer bonjour1 : bonjour) {
            rset2 = stmt.executeQuery("select * From groupe where ID=" + bonjour1);
            rset2.next();
            Groupe transition = new Groupe(rset2.getInt("ID"), rset2.getString("Nom"), rset2.getInt("IDPromotion"));
            groupe.ajout(transition);

        }

        return groupe;
    }

    public Liste_Utilisateurs getEnseignants(Seance seance) throws SQLException {
        Liste_Utilisateurs liste1 = new Liste_Utilisateurs();
        rset = stmt.executeQuery("select ID_Enseignant From seance_enseignants where ID_Seance =" + seance.getID());
        int i = 0;
        ArrayList<Integer> bonjour = new ArrayList();
        while (rset.next()) {
            i = i++;

            bonjour.add(rset.getInt(1));

        }
        for (Integer bonjour1 : bonjour) {

            rset2 = stmt.executeQuery("Select * from utilisateur where ID= " + bonjour1);
            rset2.next();
            Utilisateur utilisateur = new Utilisateur(rset2.getInt("ID"), rset2.getString("Email"), rset2.getString("PASSWD"), rset2.getString("Nom"), rset2.getString("Prenom"), rset2.getInt("Droit"));
            if (utilisateur != null) {

                liste1.ajout(utilisateur);
            } else {
                System.out.println("wtf");
            }
        }

        return liste1;

    }

    public String Typecours(Seance seance) throws SQLException {
        String nom;
        rset = stmt.executeQuery("select * From Type_Cours where ID=" + seance.getID_Type());
        rset.next();

        nom = rset.getString("Nom");

        return nom;
    }

    public Cours getCours(Seance seance) throws SQLException {
        Cours lenom = null;
        rset = stmt.executeQuery("select * From Cours where ID=" + seance.getID_Cours());
        rset.next();
        lenom = new Cours(rset.getInt("ID"), rset.getString("Nom"));

        return lenom;
    }

    public Liste_Salles salle(Seance seance) throws SQLException {
        Liste_Salles liste1 = new Liste_Salles();
        rset = stmt.executeQuery("select * From Salle where ID=" + seance.getID_Cours());
        ArrayList<Integer> bonjour = new ArrayList();
        while (rset.next()) {

            bonjour.add(rset.getInt(1));

        }
        for (Integer bonjour1 : bonjour) {
            rset2 = stmt.executeQuery("Select * from salle where ID= " + bonjour1);
            rset2.next();
            Salle salle = new Salle(rset2.getInt("ID"), rset2.getString("Nom"), rset2.getInt("Capacite"), rset2.getInt("ID_Site"));
            liste1.ajout(salle);

        }
        return liste1;

    }

    public Site site(Salle salle) throws SQLException {
        rset = stmt.executeQuery("select * From site where ID=" + salle.ID_Site());
        rset.next();
        Site site = new Site(rset.getInt("ID"),rset.getString("Nom"));

        return site;

    }

}
