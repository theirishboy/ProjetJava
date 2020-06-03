/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaEDT;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fenetre extends JFrame {
  
  Color couleur = new Color(96, 96, 96);
  private JPanel container = new JPanel();
  //private JPanel pan = new Panneau();
  //private JPanel pan = new Recapitulatif();
  private JPanel panel;
  private JComboBox combo1 = new JComboBox();
  private JComboBox combo2 = new JComboBox();
  private JButton bouton1 = new JButton();
  
  
  public Fenetre(JPanel pan, String name){
        int statut = 3;
        String nom = name;
        System.out.println(nom);
        
        this.panel = pan;
        this.setTitle("Mon emploi du temps");

        // Mettre en plein écran automatiquement
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

        container.setBackground(Color.ORANGE);
        container.setLayout(new BorderLayout());
        container.add(pan, BorderLayout.CENTER);
        JPanel top = new JPanel();
        top.setBackground(couleur);
        top.setPreferredSize(new Dimension(this.getWidth(), 35));
        
        ////Statut administrateur////
        if(statut == 1){
            JPanel zoneRecherche = new JPanel();
            zoneRecherche.setBackground(couleur);
            zoneRecherche.setPreferredSize(new Dimension(350, 30));
            JTextField recherche = new JTextField();
            JButton r = new JButton("Rechercher");
            r.setPreferredSize(new Dimension(120, 23));
            recherche.setPreferredSize(new Dimension(170, 23));
            zoneRecherche.add(recherche, BorderLayout.WEST);
            zoneRecherche.add(r, BorderLayout.EAST);
            top.add(zoneRecherche, BorderLayout.CENTER);
            
            //////Les fonctions listener
            r.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    
                }
            });
        }
        
        ////Statut référent////
        if(statut == 2){
            
        }
        
        ////Statut enseignant////
        if(statut == 3){
            top.add(combo1, BorderLayout.WEST);
            combo1.addItem("Mon emploi du temps grille");
            combo1.addItem("Mon emploi du temps ligne");
            
            top.add(combo2, BorderLayout.EAST);
            combo2.addItem("Mes statistiques");
            combo2.addItem("Mes récapitulatifs de cours");
        }
        
        ////Statut étudiant////
        if(statut == 4){
            top.add(combo1, BorderLayout.WEST);
            combo1.addItem("Mon emploi du temps grille");
            combo1.addItem("Mon emploi du temps ligne");

            top.add(combo2, BorderLayout.EAST);
            combo2.addItem("Mes statistiques");
            combo2.addItem("Mes récapitulatifs de cours");

            JButton bouton1 = new JButton("Salles libres");
            top.add(bouton1, BorderLayout.EAST);
            
        }
        
        container.add(top, BorderLayout.NORTH);
        this.setContentPane(container);
        this.setVisible(true);
    
  }
}
