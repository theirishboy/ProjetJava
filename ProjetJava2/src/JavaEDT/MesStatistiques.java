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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.*;
import org.jfree.data.general.*;
import org.jfree.ui.*;

public class MesStatistiques extends ApplicationFrame {
    
    public MesStatistiques(String title) {       
        super(title);        
        setContentPane(createDemoPanel());    
    }
    
    public static JPanel createDemoPanel() {       
        JFreeChart chart = createChart(createDataset( ) );         
        return new ChartPanel(chart);     
    }   
    
     private static PieDataset createDataset() {       
        DefaultPieDataset dataset = new DefaultPieDataset();       
        dataset.setValue("IPhone 5s", new Double(20));         
        dataset.setValue("SamSung Grand", new Double(20));          
        dataset.setValue("MotoG", new Double(40));           
        dataset.setValue("Nokia Lumia", new Double(10));         
        return dataset;             
     }  
     
      private static JFreeChart createChart(PieDataset dataset) {       
          JFreeChart chart = ChartFactory.createPieChart(                
                  "Ventes des smartphones",   //title           
                  dataset,                   // données             
                  true,                      // inclure une legende           
                  true,           
                  false);       
          return chart;    
      }
       
      public static void main(String[] args) {       
          MesStatistiques demo = new MesStatistiques("Ventes des smartphones");         
          demo.setSize(1000,800);       
          RefineryUtilities.centerFrameOnScreen(demo);           
          demo.setVisible(true);     
      } 
 
}
