/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaEDT;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import BDD.ConnexionBDD;
import Controleur.Utilisateur;  
import Controleur.Enseignant;  
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.*;
import org.jfree.data.general.*;
import org.jfree.ui.*;

public class MesStatistiques extends ApplicationFrame {
    private ConnexionBDD maconnexion;
    
    //constructeur
    public MesStatistiques(String title, Utilisateur utilisateurco) throws ClassNotFoundException, SQLException {       
        super(title);        
        setContentPane(createDemoPanel()); 
        this.maconnexion = new ConnexionBDD("edt", "root", "");
    } 
    
    //creation du panneau d'affichage
    public static JPanel createDemoPanel() {       
        JFreeChart chart = createChart(createDataset( ) );         
        return new ChartPanel(chart);     
    }   
    
    //creation des datas
     private static PieDataset createDataset() {       
        DefaultPieDataset dataset = new DefaultPieDataset();       
        dataset.setValue("IPhone 5s", new Double(20));         
        dataset.setValue("SamSung Grand", new Double(20));          
        dataset.setValue("MotoG", new Double(40));           
        dataset.setValue("Nokia Lumia", new Double(10));         
        return dataset;             
     }  
     
     //creation du diagramme circulaire
      private static JFreeChart createChart(PieDataset dataset) {       
          JFreeChart chart = ChartFactory.createPieChart(                
                  "Ventes des smartphones",   //titre          
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
          Utilisateur cetuser = maconnexion.Connexionutilisateur("marine.michenaud@edu.ece.fr", "motdepasse");
          int id = cetuser.getID();
          int statut = cetuser.getDroit();
          
          System.out.println("Bonjour " + cetuser.getPrenom());
          System.out.println("Bonjour " + id);
          
          Enseignant myprof = new Enseignant(cetuser.getID(), cetuser.getEmail(), cetuser.getNom(), cetuser.getPrenom(), cetuser.getPassword(), cetuser.getDroit());
          /*int cours1 = myprof.getMatière();
          System.out.println("Essai matière " + cours1);*/
          
          MesStatistiques demo = new MesStatistiques("Ventes des smartphones", myprof);         
          demo.setSize(1000,800);       
          RefineryUtilities.centerFrameOnScreen(demo);           
          demo.setVisible(true);

          /*if(statut == 3){
              
          }*/
      } 
 
}
