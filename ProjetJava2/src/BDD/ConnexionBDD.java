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
import Liste.Liste_Seances;
 
/* 
 *  
 * Librairies importées 
 */ 
import java.sql.*; 
import java.util.ArrayList; 
 
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

    private ResultSetMetaData rsetMeta; 
    /** 
     * ArrayList public pour les tables 
     */ 
    public ArrayList<String> tables = new ArrayList<>(); 
    /** 
     * ArrayList public pour les requêtes de sélection 
     */ 
    public ArrayList<String> requetes = new ArrayList<>(); 
    /** 
     * ArrayList public pour les requêtes de MAJ 
     */ 
    public ArrayList<String> requetesMaj = new ArrayList<>(); 
 
    /** 
     * Constructeur avec 3 paramètres : nom, login et password de la BDD locale 
     * 
     * @param nameDatabase 
     * @param loginDatabase 
     * @param passwordDatabase 
     * @throws java.sql.SQLException 
     * @throws java.lang.ClassNotFoundException 
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
 
    /** 
     * Méthode qui ajoute la table en parametre dans son ArrayList 
     * 
     * @param table 
     */ 
    public void ajouterTable(String table) { 
        tables.add(table); 
    } 
 
    /** 
     * Méthode qui ajoute la requete de selection en parametre dans son 
     * ArrayList 
     * 
     * @param requete 
     */ 
    public void ajouterRequete(String requete) { 
        requetes.add(requete); 
    } 
 
    /** 
     * Méthode qui ajoute la requete de MAJ en parametre dans son ArrayList 
     * 
     * @param requete 
     */ 
    public void ajouterRequeteMaj(String requete) { 
        requetesMaj.add(requete); 
    } 
 
    /** 
     * Méthode qui retourne l'ArrayList des champs de la table en parametre 
     * 
     * @param table 
     * @return 
     * @throws java.sql.SQLException 
     */ 
    public Utilisateur Connexionutilisateur(String Email, String motdepasse) throws SQLException { 
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
        if (Droit == 1 || Droit == 2) { 
            Utilisateur nouveauUtilisateur = new Utilisateur(ID, Email, motdepasse, Nom, Prenom, Droit); 
            return nouveauUtilisateur; 
 
        } else if (Droit == 4) { 
            rset = stmt.executeQuery("select * from Etudiant where ID_Utilisateur=" + ID); 
            rsetMeta = rset.getMetaData(); 
            rset.next(); 
 
            //  System.out.println("Je suis etudiant"+ rset.getInt(1) + rset.getInt(3)+rset.getInt(2)); 
            int ID_Groupe = rset.getInt(3); 
            int Numero = rset.getInt(2); 
 
            Etudiant nouveauEtudiant = new Etudiant(ID, ID_Groupe, Numero, Email, motdepasse, Nom, Prenom, Droit); 
            return nouveauEtudiant; 
 
        } else if (Droit == 3) { 
            rset = stmt.executeQuery("select * from Enseignant where ID_Utilisateur=" + ID); 
            rsetMeta = rset.getMetaData(); 
            rset.next(); 
 
            Enseignant nouveauEnseignant = new Enseignant(ID, Email, Nom, Prenom, motdepasse, Droit); 
            System.out.println("Je suis enseigannt"); 
            return nouveauEnseignant; 
 
        } else { 
            return null; 
 
        } 
    }
    
    public Liste_Seances MescoursEtudiant(Etudiant etudiant, int Semaine) throws SQLException 
    { 
        Liste_Seances messeances = new Liste_Seances();
       
             rset = stmt.executeQuery("select * from seance_groupe where ID_Groupe=" + etudiant.getGroupe()); 
            
            rsetMeta = rset.getMetaData(); 
           while(rset.next())
           {
               
               rset2 = stmt.executeQuery("select * from seance where ID=" +rset.getInt(1) + "AND SEMAINE =" + Semaine);
               rset2.next();
               Seance seance1 = new Seance(rset.getInt(1),Semaine,rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getInt(7),rset.getInt(8),rset.getInt(9));
               messeances.ajout(seance1);
           }    
               
               
 
            
            System.out.println("Je suis enseigannt"); 
         
          
         
        return messeances; 
         
    } 
     
    /** 
     * Methode qui retourne l'ArrayList des champs de la requete en parametre 
     * 
     * @param requete 
     * @return 
     * @throws java.sql.SQLException 
     */ 
    public ArrayList remplirChampsRequete(String requete) throws SQLException { 
        // récupération de l'ordre de la requete 
        rset = stmt.executeQuery(requete); 
 
        // récupération du résultat de l'ordre 
        rsetMeta = rset.getMetaData(); 
 
        // calcul du nombre de colonnes du resultat 
        int nbColonne = rsetMeta.getColumnCount(); 
 
        // creation d'une ArrayList de String 
        ArrayList<String> liste; 
        liste = new ArrayList<>(); 
 
        // tant qu'il reste une ligne  
        while (rset.next()) { 
            String champs; 
            champs = rset.getString(1); // ajouter premier champ 
 
            // Concatener les champs de la ligne separes par , 
            for (int i = 1; i < nbColonne; i++) { 
                champs = champs + "," + rset.getString(i + 1); 
            } 
 
            // ajouter un "\n" à la ligne des champs 
            champs = champs + "\n"; 
 
            // ajouter les champs de la ligne dans l'ArrayList 
            liste.add(champs); 
        } 
 
        // Retourner l'ArrayList 
        return liste; 
    } 
 
    /** 
     * Méthode qui execute une requete de MAJ en parametre 
     * 
     * @param requeteMaj 
     * @throws java.sql.SQLException 
     */ 
    public void executeUpdate(String requeteMaj) throws SQLException { 
        stmt.executeUpdate(requeteMaj); 
    } 
} 
