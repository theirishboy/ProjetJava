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

public class StatistiquesEnseignant extends ApplicationFrame {
    private ConnexionBDD maconnexion;
    private static Connection conn;
    private static Statement stmt, stmt2, stmt3;
    private static ResultSet rset;
    private static int sommecours;
    private static int sommeSeance;
    private static int sommemat1, sommemat2, sommemat3;
    private static String matiere1, matiere2, matiere3;
    private static double total, tot;    
    
    //constructeur
    public StatistiquesEnseignant(String title) throws ClassNotFoundException, SQLException {       
        super(title);        
        setContentPane(createDemoPanel()); 
        this.maconnexion = new ConnexionBDD("edt", "root", "");
    } 
    
     public static void StatEnseignant(Utilisateur user)throws SQLException, ClassNotFoundException{
        int id = user.getID();
        ResultSet result2;
        ResultSet result3;
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/edt";
        conn = DriverManager.getConnection(url, "root", "");
        stmt = conn.createStatement();
        stmt2 = conn.createStatement();
        stmt3 = conn.createStatement();
        String sql1 = "SELECT ID_Cours FROM `enseignant` WHERE ID_Utilisateur = '"+id+"'";
        ResultSet result1 = stmt.executeQuery(sql1);
        int j=0;
        
        while(result1.next()){
            int Cours = result1.getInt(1); //tous les cours
            
            String sql2 = "SELECT ID_Cours FROM `seance` WHERE ID_Cours = '"+Cours+"'";
            result2 = stmt2.executeQuery(sql2);
            
            while(result2.next()){
                int ID_Seance = result2.getInt(1); //toutes les séances
                sommeSeance++;
                total++;//nbre total de seances    
            }
            
        String sql3 = "SELECT Nom FROM cours WHERE ID = '"+Cours+"'";
        result3 = stmt3.executeQuery(sql3);
        
        // sommecours++;  //nbre de matieres
        if(j==0)
        {
            sommemat1=sommeSeance;//sommemat1 a 4
            if(result3.next()){
                matiere1 = result3.getString("Nom");
                System.out.println(matiere1);
            }
        }
        if(j==1)
        {
            sommemat2=sommeSeance;//sommemat2 a 2
            if(result3.next()){
                matiere2 = result3.getString("Nom");
                System.out.println(matiere2);
            }
        }
        if(j==2)
        {
            sommemat3=sommeSeance;//sommemat3 a 0
            if(result3.next()){
                matiere3 = result3.getString("Nom");
                System.out.println(matiere3);
            }
        }
        sommeSeance=0;  
        j++;
     }
    }
     
    //creation du panneau d'affichage
    public static JPanel createDemoPanel() {       
        JFreeChart chart = createChart(createDataset( ) );         
        return new ChartPanel(chart);     
    }   
    
    //creation des datas
     private static PieDataset createDataset() {       
        DefaultPieDataset dataset = new DefaultPieDataset(); 
        if(sommemat1!=0){
            dataset.setValue(""+matiere1, new Double(sommemat1*100/total));
        }
        if(sommemat2!=0){
            dataset.setValue(""+matiere2, new Double(sommemat2*100/total));
        }
        if(sommemat3!=0){
            dataset.setValue(""+matiere3, new Double(sommemat3*100/total));
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
      public static void main(String[] args) throws ClassNotFoundException, SQLException {
          ConnexionBDD maconnexion;
          maconnexion = new ConnexionBDD("edt", "root", "");
          //Utilisateur cetuser = maconnexion.Connexionutilisateur("waleed.mouhali@edu.ece.fr", "motdepasse");
          Utilisateur cetuser = maconnexion.Connexionutilisateur("jena.dujardin@edu.ece.fr", "motdepasse");
          
          if(cetuser.getDroit() == 3){
            StatEnseignant(cetuser);
            StatistiquesEnseignant demo = new StatistiquesEnseignant("Mes statistiques de cours");         
            demo.setSize(1000,800);       
            RefineryUtilities.centerFrameOnScreen(demo);           
            demo.setVisible(true);  
          }

      } 
}