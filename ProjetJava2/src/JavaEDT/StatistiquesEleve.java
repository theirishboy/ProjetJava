package JavaEDT;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import BDD.ConnexionBDD;
import Controleur.Utilisateur;  
import Controleur.Enseignant;  
import Controleur.Etudiant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.*;
import org.jfree.data.general.*;
import org.jfree.ui.*;

public class StatistiquesEleve extends ApplicationFrame{
    private ConnexionBDD maconnexion;
    private static Connection conn;
    private static Statement stmt, stmt2, stmt3, stmt4, stmt5, stmt6, stmt7;
    private static ResultSet rset;
    private static double  tot;    
    private static int groupe;  
    private static int seance; 
    private static int coursSeance; 
    private static int sommeCours1, sommeCours2, sommeCours3, sommeCours4;
    private static String nomCours1, nomCours2, nomCours3, nomCours4;
    
    //constructeur
    public StatistiquesEleve(String title) throws ClassNotFoundException, SQLException {       
        super(title);        
        setContentPane(createDemoPanel()); 
        this.maconnexion = new ConnexionBDD("edt", "root", "");
    } 
    public static void StatEleve(Utilisateur user)throws SQLException, ClassNotFoundException{
        String nomuser = user.getPrenom();
        System.out.println("Bonjour "+nomuser);
        int id = user.getID();
        ResultSet result1;
        ResultSet result2;
        ResultSet result3;
        ResultSet result4;
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/edt";
        conn = DriverManager.getConnection(url, "root", "");
        stmt4 = conn.createStatement();
        stmt5 = conn.createStatement();
        stmt6 = conn.createStatement();
        stmt7 = conn.createStatement();
        
        String sql1 = "SELECT ID_Groupe FROM `etudiant` WHERE ID_Utilisateur = '"+id+"'"; //Recherche du groupe : groupe 1
        result1 = stmt4.executeQuery(sql1);
        if(result1.next()){
            groupe = result1.getInt(1);
        }
        
        System.out.println("Le groupe : " +groupe);
        int j=0;
        
        String sql2 = "SELECT ID_Seance FROM `seance_groupe` WHERE ID_Groupe = '"+groupe+"'"; //1ere boucle seance 1 et 2eme boucle seance 4
        result2 = stmt5.executeQuery(sql2);
        
        while(result2.next()){
            seance = result2.getInt(1);
            System.out.println("La séance : "+ seance); //les séances qu'un groupe a //seance 1
            
            String sql3 = "SELECT ID_Cours FROM `seance` WHERE ID = '"+seance+"'";
            result3 = stmt6.executeQuery(sql3);
            while(result3.next()){
                coursSeance = result3.getInt(1);
                System.out.println("Le cours : "+coursSeance); //le cours de la séance particulière //cours 4
                
            }
            
            String sql4 = "SELECT Nom FROM `cours` WHERE ID = '"+coursSeance+"'";
            result4 = stmt7.executeQuery(sql4);
            
            
            if(coursSeance == 1)
            {
                if(result4.next()){
                    sommeCours1++;
                    nomCours1 = result4.getString("Nom");
                    System.out.println("Le nom du cours : " +nomCours1);
                }
            }
            if(coursSeance == 2)
            {
                if(result4.next()){
                    sommeCours2++;
                    nomCours2 = result4.getString("Nom");
                    System.out.println("Le nom du cours : " +nomCours2);
                }
            }
            if(coursSeance == 3)
            {
                if(result4.next()){
                    sommeCours3++;
                    nomCours3 = result4.getString("Nom");
                    System.out.println("Le nom du cours : " +nomCours3);
                }
            }
            if(coursSeance == 4)
            {
                if(result4.next()){
                    sommeCours4++;
                    nomCours4 = result4.getString("Nom");
                    System.out.println("Le nom du cours : " +nomCours4);
                }
            }
            tot++;
            
        }
            System.out.println("Cours 1 --> "+sommeCours1);
            System.out.println("Cours 2 --> "+sommeCours2);
            System.out.println("Cours 3 --> "+sommeCours3);
            System.out.println("Cours 4 --> "+sommeCours4);
            System.out.println("Total : "+tot);

    }
     
    //creation du panneau d'affichage
    public static JPanel createDemoPanel() {       
        JFreeChart chart = createChart(createDataset( ) );         
        return new ChartPanel(chart);     
    }   
    
    //creation des datas
     private static PieDataset createDataset() {       
        DefaultPieDataset dataset = new DefaultPieDataset(); 
        if(sommeCours1!=0){
            dataset.setValue(""+nomCours1, new Double(sommeCours1*100/tot));
        }
        if(sommeCours2!=0){
            dataset.setValue(""+nomCours2, new Double(sommeCours2*100/tot));
        }
        if(sommeCours3!=0){
            dataset.setValue(""+nomCours3, new Double(sommeCours3*100/tot));
        }
        if(sommeCours4!=0){
            dataset.setValue(""+nomCours4, new Double(sommeCours4*100/tot));
        }
        return dataset;             
     }  
     
     //creation du diagramme circulaire
      private static JFreeChart createChart(PieDataset dataset) {       
          JFreeChart chart = ChartFactory.createPieChart(                
                  "Mes statistiques de cours",   //titre          
                  dataset,                   // données             
                  true,                      // inclure une legende           
                  true,           
                  false);       
          return chart;    
      }

      //tester le diagramme
      /*public static void main(String[] args) throws ClassNotFoundException, SQLException {
          ConnexionBDD maconnexion;
          maconnexion = new ConnexionBDD("edt", "root", "");
          Utilisateur cetuser = maconnexion.Connexionutilisateur("antoine.benard@edu.ece.fr", "motdepasse");
          
          if(cetuser.getDroit() == 4){
            StatEleve(cetuser);
            StatistiquesEleve demo = new StatistiquesEleve("Mes statistiques de cours");         
            demo.setSize(1000,800);       
            RefineryUtilities.centerFrameOnScreen(demo);           
            demo.setVisible(true);  
          }
      }*/ 
    
}
