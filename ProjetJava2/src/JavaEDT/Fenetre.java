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

    private int SemaineChoisi = 0;
    ConnexionBDD maconnexion1;
    Color couleur = new Color(96, 96, 96);
    private int fonction = 0;
    FonctionsAdmin changement = new FonctionsAdmin();
    private JPanel container = new JPanel();
    //private JPanel pan = new Recapitulatif();
    private Panneau panel;
    private String nom;
    private JComboBox combo1 = new JComboBox();
    private JComboBox combo2 = new JComboBox();
    private JComboBox combo3 = new JComboBox();

    private JButton bouton1 = new JButton();
    //Ces deux paramètres vont contenir le tableau de BoutonSemaine et le nombre de la semaine sur laquelle on appuie
    private BoutonSemaine[] semaine = new BoutonSemaine[53];
    private int nombre = 1;
    private Utilisateur utilisateurco;
    private int localisation;

    //Classe MyCationListener qui va décider de l'action lorsque l'on appuie sur le bouton
    //Cette classe reçoit en paramètre le numéro de semaine
    private final class MyActionListener implements ActionListener {

        private final int index;

        private MyActionListener(int nb) {
            index = nb + 1;

        }
        //Lorsqu'on appuie sur un bouton, on donne à l'attribut nombre la valeur de la semaine

        public void actionPerformed(ActionEvent theActionEvent) {
            Liste_Seances LesSeances = null;
            ConnexionBDD maconnexion = getConnexion();

            //On parcourt tous les BoutonSemaine pour trouver celui qui était appuyé avant
            /* for(int i = 0; i < 53; ++i)
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
                
            }*/

            nombre = index;
            //Ici test qui prouve que nombre est bien égale à la valeur de la case appuyée
            System.out.println(index);
            System.out.println("Valeur Retournée: " + nombre);
            if(localisation() == 1)
            {
                
            
            try {
                 Utilisateur utilisateurco = getUtilisateur();
                LesSeances = maconnexion.Mescours(utilisateurco, nombre);
            } catch (SQLException ex) {
                Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            if(localisation() == 2)
             {
                 String nom = nom();
                try {
                    LesSeances = maconnexion.courssalle(nom, nombre);
                } catch (SQLException ex) {
                    Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if(localisation() == 3)
            {
                String nom = nom();

                try{
                            
                            LesSeances = maconnexion.coursGroupe(nom,nombre);
                            
                        }catch (SQLException ex) {
                            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
            }
            
            
            actualisercours(LesSeances);
        }

    }

    public Fenetre(Utilisateur utilisateurco, ConnexionBDD maconnexion) throws SQLException, ParseException, ClassNotFoundException {
        Color couleur = new Color(96, 96, 96);
        this.utilisateurco = utilisateurco;
        int statut = utilisateurco.getDroit();
        this.maconnexion1 = maconnexion;
        //String nom = name;
        this.SemaineChoisi = 1;
        this.localisation = 1;
        this.panel = new Panneau();
        this.nom = "";
        this.setTitle("Mon emploi du temps");
        Liste_Seances LesSeances = null;
        // Mettre en plein écran automatiquement
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setSize(1368, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //On remplit le tableau de BoutonSemaine
        //On crée un JPanel qui va afficher ce qui à en haut de la page
        //Cela va dépendre de quel statut est l'utilisateur
        JPanel top = new JPanel();
        top.setBackground(couleur);
        top.setPreferredSize(new Dimension(1, 75));

        lesboutons(top);

        ////Statut administrateur////
        if (statut == 1) {
            BordelAntoine cebordel = new BordelAntoine(top, couleur, this.getWidth());
            //Création d'un JPanel contenant les boutons qui vont désigner les actions
        }

        ////Statut référent////
        if (statut == 2) {

        }

        ////Statut enseignant////
        if (statut == 3) {

            LesSeances = maconnexion.Mescours(utilisateurco, SemaineChoisi);
            actualisercours(LesSeances);
            top.add(combo1, BorderLayout.WEST);
            combo1.addItem("Mon emploi du temps grille");
            combo1.addItem("Mon emploi du temps ligne");

            top.add(combo2, BorderLayout.EAST);
            combo2.addItem("Mes statistiques");
            combo2.addItem("Mes récapitulatifs de cours");
        }

        ////Statut étudiant////
        if (statut == 4) {

            LesSeances = maconnexion.Mescours(utilisateurco, SemaineChoisi);
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
        if (statut == 3 || statut == 4) {
            top.add(combo3, BorderLayout.CENTER);
            combo3.addItem("Rechercher un utilisateur");
            combo3.addItem("Rechercher une Salle");
            combo3.addItem("Rechercher un Groupe");

            JFormattedTextField element = new JFormattedTextField("exemple : enseignant/etudiant");
            JButton bouton2 = new JButton("Rechercher");
            top.add(element, BorderLayout.EAST);

            top.add(bouton2, BorderLayout.EAST);

            container.add(top, BorderLayout.NORTH);
            container.add(panel);

            bouton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    Liste_Seances LesSeances = null;
                    String nom = element.getText();
                    String combo = combo3.getSelectedItem().toString();
                    if (combo == "Rechercher un utilisateur") {
                        Utilisateur utilisateurnew = maconnexion.rechercherutilisateur(nom);
                        try {
                            updateutilisateur(utilisateurnew);
                            udpdatelocalisation(1);
                            LesSeances = maconnexion.Mescours(utilisateurnew, semaine());

                        } catch (SQLException ex) {
                            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (combo == "Rechercher une Salle") {
                        try {
                            udpdatelocalisation(2);
                            updatenom(nom);
                            LesSeances = maconnexion.courssalle(nom, semaine());
                        } catch (SQLException ex) {
                            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if(combo == "Rechercher un Groupe")
                    {
                        try{
                             udpdatelocalisation(3);
                            updatenom(nom);
                            LesSeances = maconnexion.coursGroupe(nom,semaine());
                            
                        }catch (SQLException ex) {
                            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    actualisercours(LesSeances);

                }

            });
        }

        this.setContentPane(container);

        this.setVisible(true);

    }

    public void actualisercours(Liste_Seances mesSeances) {
        this.setVisible(true);

        this.panel.removeAll();
//        if(mesSeances != null) System.out.println(mesSeances.LesSeances.get(1).getID());
        this.panel.setVar(mesSeances, this.maconnexion1);
        this.panel.removeAll();

        this.panel.repaint();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateutilisateur(Utilisateur utilisateurnew)
    {
        this.utilisateurco = utilisateurnew;
    }
    public Utilisateur getUtilisateur() {
        return this.utilisateurco;
    }

    public ConnexionBDD getConnexion() {
        return this.maconnexion1;
    }

    public int semaine() {
        return this.SemaineChoisi;
    }

    public void lesboutons(JPanel top) {
        for (Integer i = 0; i < 52; ++i) {
            Integer j = i + 1;
            //On converti le i en String (d'où l'utilisation d'un Integer)
            String bouton = j.toString();
            semaine[i] = new BoutonSemaine(bouton);
            //Les boutons se décalent de 35 pixels vers la droite à chaque boucle
            semaine[i].setBounds(26 * i, 70, 26, 26);
            //On ajoute dans le JPanel
            top.add(semaine[i]);
        }

        //Pour tous les boutons, on leur donne comme action la MyActionListener qui sera donc activée lorsque l'on cliquera sur un bouton
        for (int i = 0; i < 52; i++) {
            semaine[i].addActionListener(new MyActionListener(i));
        }
        //On ajoute ensuite le panneau avec l'emploi du temps au JPanel de la fenêtre
        container.setBackground(Color.ORANGE);
        container.setLayout(new BorderLayout());
    }

    public void udpdatelocalisation(int localisation) {
        this.localisation = localisation;
    }

    public int localisation() {
        return this.localisation;
    }
    public String nom()
    {
        return this.nom;
    }
    public void updatenom(String nom)
    {
        this.nom = nom;
    }
    
}
