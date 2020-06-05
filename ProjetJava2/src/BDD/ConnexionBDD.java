/* 
 * To change this template, choose Tools | Templates 
 * and open the template in the editor. 
 */
package BDD;

import Controleur.Enseignant;
import Controleur.Etudiant;
import Controleur.Seance;
import Controleur.Utilisateur;
import Liste.Liste_Cours;
import Liste.Liste_Enseignants;
import Liste.Liste_Seances;
import Liste.Liste_Utilisateurs;

/* 
 *  
 * Librairies importées 
 */
import java.sql.*;
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

    public Liste_Seances Mescours(Utilisateur utilisateur, int Semaine) throws SQLException {
        Liste_Seances messeances = new Liste_Seances();

        if (utilisateur.getDroit() == 4) {
            rset = stmt.executeQuery("select * from Etudiant where ID_Utilisateur=" + utilisateur.getID());
            rset.next();

            rset3 = stmt.executeQuery("select * from seance_groupe where ID_Groupe=" + rset.getInt(3));
            rset3.next();
            //  System.out.println("Je suis etudiant"+ rset.getInt(1) + rset.getInt(3)+rset.getInt(2));

            rset2 = stmt.executeQuery("select * from seance where ID=" + rset3.getInt(1) + "AND SEMAINE =" + Semaine);
            rset2.next();
            Seance seance1 = new Seance(rset2.getInt(1), Semaine, rset2.getString(3), rset2.getString(4), rset2.getString(5), rset2.getString(6), rset2.getInt(7), rset2.getInt(8), rset2.getInt(9));
            messeances.ajout(seance1);

        }
        if (utilisateur.getDroit() == 3) {
            rset = stmt.executeQuery("select * from Enseignant where ID_Utilisateur=" + utilisateur.getID());
            rset.next();

            rset3 = stmt.executeQuery("select * from seance_groupe where ID_Groupe=" + rset.getInt(3));
            rset3.next();

            rset2 = stmt.executeQuery("select * from seance where ID=" + rset3.getInt(1) + "AND SEMAINE =" + Semaine);
            rset2.next();
            Seance seance1 = new Seance(rset2.getInt(1), Semaine, rset2.getString(3), rset2.getString(4), rset2.getString(5), rset2.getString(6), rset2.getInt(7), rset2.getInt(8), rset2.getInt(9));
            messeances.ajout(seance1);
        }

        return messeances;

    }
    
    
    public Liste_Utilisateurs getEnseignant(Seance seance) throws SQLException
    {
        Liste_Utilisateurs liste1 = null; 
        rset=stmt.executeQuery("select ID_Enseignant From seance_enseignants where ID_Seance =" + seance.getID());
        while(rset.next())
        {
                rset2=stmt.executeQuery("Select * from utilisateur where ID= " + rset.getInt("ID_Enseignant"));
                rset2.next();
                Utilisateur utilisateur = new Utilisateur(rset2.getInt("ID"),rset2.getString("Email"),rset2.getString("PASSWD"),rset2.getString("Nom"),rset2.getString("Prenom"),rset2.getInt("Droit"));
                liste1.ajout(utilisateur);
                

        }
        
        return liste1;
        
    }

    

    
   
}
