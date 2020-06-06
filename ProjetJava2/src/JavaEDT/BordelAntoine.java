/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaEDT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author gabri
 */
public class BordelAntoine {
    int fonction = 0;
    FonctionsAdmin changement;
    public BordelAntoine(JPanel top, Color couleur,int width)
    {
    JPanel zoneChoix = new JPanel();
            zoneChoix.setBackground(couleur);
            zoneChoix.setPreferredSize(new Dimension(width, 100));
            //Boutons qui désignent chacun une fonction
            JButton supprCours = new JButton("Supprimer un cours");
            supprCours.setBackground(Color.white);
            supprCours.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    fonction = 1;
                    try {
                        changement = new FonctionsAdmin(fonction);
                    } catch (ParseException ex) {
                        Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    try {
                        changement = new FonctionsAdmin(fonction);
                    } catch (ParseException ex) {
                        Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    try {
                        changement = new FonctionsAdmin(fonction);
                    } catch (ParseException ex) {
                        Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    try {
                        changement = new FonctionsAdmin(fonction);
                    } catch (ParseException ex) {
                        Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    try {
                        changement = new FonctionsAdmin(fonction);
                    } catch (ParseException ex) {
                        Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    try {
                        changement = new FonctionsAdmin(fonction);
                    } catch (ParseException ex) {
                        Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    try {
                        changement = new FonctionsAdmin(fonction);
                    } catch (ParseException ex) {
                        Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    try {
                        changement = new FonctionsAdmin(fonction);
                    } catch (ParseException ex) {
                        Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    try {
                        changement = new FonctionsAdmin(fonction);
                    } catch (ParseException ex) {
                        Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    try {
                        changement = new FonctionsAdmin(fonction);
                    } catch (ParseException ex) {
                        Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
}
    

