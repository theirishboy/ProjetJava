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
  //Ces deux paramètres vont contenir le tableau de BoutonSemaine et le nombre de la semaine sur laquelle on appuie
  private BoutonSemaine[] semaine = new BoutonSemaine[53];
  private int nombre = 1;

  //Classe MyCationListener qui va décider de l'action lorsque l'on appuie sur le bouton
  //Cette classe reçoit en paramètre le numéro de semaine
  private final class MyActionListener implements ActionListener {
        private final int index;
        private MyActionListener(int nb) {
            index = nb;
        }
        //Lorsqu'on appuie sur un bouton, on donne à l'attribut nombre la valeur de la semaine
        public void actionPerformed(ActionEvent theActionEvent) {
            nombre = index;
            //Ici test qui prouve que nombre est bien égale à la valeur de la case appuyée
            System.out.println(index);
            System.out.println("Valeur Retournée: "+ nombre);
        }
    }
  
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
        
        JPanel ZoneBoutons = new JPanel();
        ZoneBoutons.setBackground(couleur);
        ZoneBoutons.setPreferredSize(new Dimension(1500, 35));
        //On remplit le tableau de BoutonSemaine
        for(Integer i = 1; i <= 52; ++i)
        {
            //On converti le i en String (d'où l'utilisation d'un Integer)
            String bouton = i.toString();
            semaine[i] = new BoutonSemaine(bouton);
            //Les boutons se décalent de 35 pixels vers la droite à chaque boucle
            semaine[i].setBounds(35*i, 35, 35, 35);
            //On ajoute dans le JPanel
            ZoneBoutons.add(semaine[i]);
        }

        //Pour tous les boutons, on leur donne comme action la MyActionListener qui sera donc activée lorsque l'on cliquera sur un bouton
        for (int i = 1; i <= 52; i++) 
        {
            semaine[i].addActionListener(new MyActionListener(i));
        }

        JPanel top = new JPanel();
        top.setBackground(couleur);
        top.setPreferredSize(new Dimension(this.getWidth(), 75));
        
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
        top.add(ZoneBoutons, BorderLayout.SOUTH);
        container.add(top, BorderLayout.NORTH);
        this.setContentPane(container);
        this.setVisible(true);
    
  }
}
