/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaEDT;

import BDD.ConnexionBDD;
import Controleur.Utilisateur;
import Liste.Liste_Cours;
import Liste.Liste_Seances;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Fenetre extends JFrame {
   int SemaineChoisi = 0;
  ConnexionBDD maconnexion1;
  Color couleur = new Color(96, 96, 96);
  
  private JPanel container = new JPanel();
  //private JPanel pan = new Recapitulatif();
  private Panneau panel;

  private JComboBox combo1 = new JComboBox();
  private JComboBox combo2 = new JComboBox();
  private JButton bouton1 = new JButton();
  //Ces deux paramètres vont contenir le tableau de BoutonSemaine et le nombre de la semaine sur laquelle on appuie
  private BoutonSemaine[] semaine = new BoutonSemaine[53];
  private int nombre = 1;

   

=======
>>>>>>> master
  //Classe MyCationListener qui va décider de l'action lorsque l'on appuie sur le bouton
  //Cette classe reçoit en paramètre le numéro de semaine
  private final class MyActionListener implements ActionListener {
        private final int index;
        private MyActionListener(int nb) 
        {
            index = nb + 1;
        }
        //Lorsqu'on appuie sur un bouton, on donne à l'attribut nombre la valeur de la semaine
        public void actionPerformed(ActionEvent theActionEvent) 
        {
            //On parcourt tous les BoutonSemaine pour trouver celui qui était appuyé avant
            for(int i = 0; i < 53; ++i)
            {
                //Condition qui est activée que si le bouton était appuyé
                if(semaine[i].getAppui() == true)
                {
                    //On passe le bouton en non-appuyé et on lui redonne une couleur normale
                    semaine[i].setAppui(true);
                    semaine[i].setBackground(new Color(185,231,227));
                }
                //On passe la nouveau bouton appuyé en appuyé
                semaine[index-1].setAppui(false);
                //On met sa bordure en noir
                semaine[index-1].setBackground(Color.black);
            }
            
            nombre = index;
            //Ici test qui prouve que nombre est bien égale à la valeur de la case appuyée
            System.out.println(index);
            System.out.println("Valeur Retournée: "+ nombre);
        }
    }
  
  public Fenetre(Utilisateur utilisateurco, ConnexionBDD maconnexion) throws SQLException, ParseException, ClassNotFoundException{
        Color couleur = new Color(96, 96, 96);

        int statut = utilisateurco.getDroit();
        this.maconnexion1 = maconnexion;
        //String nom = name;
        int SemaineChoisi = 1;
=======
  public Fenetre(JPanel pan, String name){
        int statut = 3;
>>>>>>> master
        this.panel = pan;
        
        this.setTitle("Mon emploi du temps");
        Liste_Seances LesSeances = null;
        // Mettre en plein écran automatiquement
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setSize(1368,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        
        
        //On remplit le tableau de BoutonSemaine
        for(Integer i = 0; i < 52; ++i)
        {
            Integer j = i+1;
            //On converti le i en String (d'où l'utilisation d'un Integer)
            String bouton = j.toString();
            semaine[i] = new BoutonSemaine(bouton);
            //Les boutons se décalent de 35 pixels vers la droite à chaque boucle
            semaine[i].setBounds(26*i, 70, 26, 26);
            //On ajoute dans le JPanel
            container.add(semaine[i]);
        }

        //Pour tous les boutons, on leur donne comme action la MyActionListener qui sera donc activée lorsque l'on cliquera sur un bouton
        for (int i = 0; i < 52; i++) 
        {
            semaine[i].addActionListener(new MyActionListener(i));
        }
        //On ajoute ensuite le panneau avec l'emploi du temps au JPanel de la fenêtre
        container.setBackground(Color.ORANGE);
        container.setLayout(new BorderLayout());
        
        
        
        //On crée un JPanel qui va afficher ce qui à en haut de la page
        //Cela va dépendre de quel statut est l'utilisateur
        JPanel top = new JPanel();
        top.setBackground(couleur);
        top.setPreferredSize(new Dimension(1, 75));
        
        ////Statut administrateur////
        if(statut == 1){
            //Création d'un JPanel contenant les boutons qui vont désigner les actions
            JPanel zoneChoix = new JPanel();
            zoneChoix.setBackground(couleur);
            zoneChoix.setPreferredSize(new Dimension(this.getWidth(), 100));
            //Boutons qui désignent chacun une fonction
            JButton supprCours = new JButton("Supprimer un cours");
            supprCours.setBackground(Color.white);
            supprCours.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    fonction = 1;
                    changement = new FonctionsAdmin(fonction);
                    changement.setVisible(true);
                }
            });
            
            JButton affecEns = new JButton("Affecter un cours à un enseignant");
            affecEns.setBackground(Color.white);
            affecEns.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    fonction = 2;
                    changement = new FonctionsAdmin(fonction);
                    changement.setVisible(true);
                }
            });
            
            JButton affecGroup = new JButton("Affecter un cours à un groupe");
            affecGroup.setBackground(Color.white);
            affecGroup.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    fonction = 3;
                    changement = new FonctionsAdmin(fonction);
                    changement.setVisible(true);
                }
            });
            
            JButton modifCours = new JButton("Modifier un cours");
            modifCours.setBackground(Color.white);
            modifCours.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    fonction = 4;
                    changement = new FonctionsAdmin(fonction);
                    changement.setVisible(true);
                }
            });
            
            JButton affecSalle = new JButton("Affecter une salle à un cours");
            affecSalle.setBackground(Color.white);
            affecSalle.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    fonction = 5;
                    changement = new FonctionsAdmin(fonction);
                    changement.setVisible(true);
                }
            });
            
            JButton ajoutCours = new JButton("Ajouter un cours");
            ajoutCours.setBackground(Color.white);
            ajoutCours.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    fonction = 6;
                    changement = new FonctionsAdmin(fonction);
                    changement.setVisible(true);
                }
            });
            
            JButton ajoutEns = new JButton("Ajouter un enseignant à un cours");
            ajoutEns.setBackground(Color.white);
            ajoutEns.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    fonction = 7;
                    changement = new FonctionsAdmin(fonction);
                    changement.setVisible(true);
                }
            });
            
            JButton ajoutGroup = new JButton("Ajouter un groupe à un cours");
            ajoutGroup.setBackground(Color.white);
            ajoutGroup.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    fonction = 8;
                    changement = new FonctionsAdmin(fonction);
                    changement.setVisible(true);
                }
            });
            
            JButton enlevEns = new JButton("Enlever un enseignant d'un cours");
            enlevEns.setBackground(Color.white);
            enlevEns.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    fonction = 9;
                    changement = new FonctionsAdmin(fonction);
                    changement.setVisible(true);
                }
            });
            
            JButton enlevGroup = new JButton("Enlever un groupe d'un cours");
            enlevGroup.setBackground(Color.white);
            enlevGroup.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    fonction = 10;
                    changement = new FonctionsAdmin(fonction);
                    changement.setVisible(true);
                }
            });
            
            supprCours.setPreferredSize(new Dimension(240, 23));
            affecEns.setPreferredSize(new Dimension(240, 23));
            affecGroup.setPreferredSize(new Dimension(240, 23));
            modifCours.setPreferredSize(new Dimension(240, 23));
            affecSalle.setPreferredSize(new Dimension(240, 23));
            ajoutCours.setPreferredSize(new Dimension(240, 23));
            ajoutEns.setPreferredSize(new Dimension(240, 23));
            ajoutGroup.setPreferredSize(new Dimension(240, 23));
            enlevEns.setPreferredSize(new Dimension(240, 23));
            enlevGroup.setPreferredSize(new Dimension(240, 23));
            //On ajoute le bouton et la barre dans le JPanel zoneChoix
            zoneChoix.add(supprCours, BorderLayout.EAST);
            zoneChoix.add(affecEns, BorderLayout.EAST);
            zoneChoix.add(affecGroup, BorderLayout.EAST);
            zoneChoix.add(modifCours, BorderLayout.EAST);
            zoneChoix.add(affecSalle, BorderLayout.EAST);
            zoneChoix.add(ajoutCours, BorderLayout.EAST);
            zoneChoix.add(ajoutEns, BorderLayout.EAST);
            zoneChoix.add(ajoutGroup, BorderLayout.EAST);
            zoneChoix.add(enlevEns, BorderLayout.EAST);
            zoneChoix.add(enlevGroup, BorderLayout.EAST);
            //On ajoute ensuite zoneRecherche dans le JPanel top
            top.add(zoneChoix, BorderLayout.CENTER);
        }
        
        ////Statut référent////
        if(statut == 2){
            
        }
        
        ////Statut enseignant////

        if(statut == 3){
            
           LesSeances = maconnexion.Mescours(utilisateurco,SemaineChoisi);
           actualisercours(LesSeances);
            top.add(combo1, BorderLayout.WEST);
            combo1.addItem("Mon emploi du temps grille");
            combo1.addItem("Mon emploi du temps ligne");
            
            top.add(combo2, BorderLayout.EAST);
            combo2.addItem("Mes statistiques");
            combo2.addItem("Mes récapitulatifs de cours");
        }
        
        ////Statut étudiant////
        if(statut == 4){

           LesSeances = maconnexion.Mescours(utilisateurco,SemaineChoisi);
                    System.out.println("OUIIIII");
            if(LesSeances != null) System.out.println("ca va =0 " + LesSeances.size());
            actualisercours(LesSeances);

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
        container.add(panel);


        this.setContentPane(container);
        
        this.setVisible(true);
    
  }
  public void actualisercours(Liste_Seances mesSeances)
  {
       this.setVisible(true);

        this.panel.removeAll();
//        if(mesSeances != null) System.out.println(mesSeances.LesSeances.get(1).getID());
        this.panel.setVar(mesSeances,this.maconnexion1);
        this.panel.removeAll();
        this.panel.repaint();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
}
