/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaEDT;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*; 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Tonio
 */
public class FonctionsAdmin extends JFrame
{
    private JPanel pan2 = new JPanel();
    //Eléments BDD
    Connection connexionBDD;
    Statement statement;
    
    
    
    public FonctionsAdmin()
    {
        
    }
    
    public FonctionsAdmin(int fonction) throws ParseException
    {
        this.setTitle("Fonction admin");
        // Mettre en écran de dimension 1368*1000 automatiquement
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setSize(1368,1000);
        this.setLocationRelativeTo(null);
        this.setContentPane(pan2);
        this.setVisible(true);
        
        
         //Fonction Supprimant un cours
        if(fonction == 1)
        {
            //JPanel qui va contenir le formulaire
            JPanel form1 = new JPanel();
            form1.setPreferredSize(new Dimension(250,250));
            
            //Création des composants du formulaire
            JLabel cours = new JLabel("Cours : ");
            JFormattedTextField choixCours = new JFormattedTextField("exemple : Mathématiques");
            JLabel dateSeance = new JLabel("Date de la séance : ");
            JFormattedTextField choixDate = new JFormattedTextField("2020-06-03");
            JLabel heure = new JLabel("Heure de début : ");
            JFormattedTextField choixHeure = new JFormattedTextField("20:00:00");
            JLabel enseignant = new JLabel ("Enseignant : ");
            JFormattedTextField choixEnseignant = new JFormattedTextField("exemple : Chamberlain");
            
            //On ajoute les composant au JPanel form1
            form1.add(cours);
            form1.add(choixCours);
            form1.add(dateSeance);
            form1.add(choixDate);
            form1.add(heure);
            form1.add(choixHeure);
            form1.add(enseignant);
            form1.add(choixEnseignant);
            
            //On crée un bouton qui va servir a envoyer le formulaire
            //Le ActionListene de ce bouton contiendra la fonction en rapport avec la BDD
            JButton valider = new JButton("Valider");
            
            String choix1 = choixCours.getText();
            java.util.Date choix2 = new SimpleDateFormat("yyyy-MM-dd").parse(choixDate.getText());
            java.util.Date choix3 = new SimpleDateFormat("HH:mm:ss").parse(choixHeure.getText());
            String choix4 = choixEnseignant.getText();
            
            java.sql.Date sdate = new java.sql.Date(choix2.getTime());
            java.sql.Date sheure = new java.sql.Date(choix3.getTime());
            
            valider.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    //Ici on appellera la fonction
                    supprimer(choix1,sdate,sheure,choix4);
                }
            });
            
            //On ajoute le JPanel du formulaire dans celui de la fenêtre
            pan2.add(form1,BorderLayout.SOUTH);
            pan2.add(valider);
            super.setContentPane(pan2);
        }
        //Fonction affectant un nouveau cours à un enseignant
        else if(fonction == 2)
        {
            JPanel form1 = new JPanel();
            form1.setPreferredSize(new Dimension(250,250));
            
            JLabel dateSeance = new JLabel("Date de la séance : ");
            JFormattedTextField choixDate = new JFormattedTextField("2020-06-03");
            JLabel heure = new JLabel("Heure de début : ");
            JFormattedTextField choixHeure = new JFormattedTextField("19:00:00");
            JLabel enseignant = new JLabel ("Enseignant : ");
            JFormattedTextField choixEnseignant = new JFormattedTextField("exemple : Chamberlain");
            
            form1.add(dateSeance);
            form1.add(choixDate);
            form1.add(heure);
            form1.add(choixHeure);
            form1.add(enseignant);
            form1.add(choixEnseignant);
            
            JButton valider = new JButton("Valider");
            
            valider.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    //Ici on appellera la fonction
                }
            });

            pan2.add(form1,BorderLayout.SOUTH);
            pan2.add(valider);
            super.setContentPane(pan2);
        }
        //Fonction affectant un cours à un groupe
        else if(fonction == 3)
        {
            JPanel form1 = new JPanel();
            form1.setPreferredSize(new Dimension(250,250));
            
            JLabel dateSeance = new JLabel("Date de la séance : ");
            JFormattedTextField choixDate = new JFormattedTextField("2020-06-03");
            JLabel heure = new JLabel("Heure de début : ");
            JFormattedTextField choixHeure = new JFormattedTextField("19:00:00");
            JLabel groupe = new JLabel ("Groupe de TD : ");
            JFormattedTextField choixGroupe = new JFormattedTextField("exemple : TD06");
            
            form1.add(dateSeance);
            form1.add(choixDate);
            form1.add(heure);
            form1.add(choixHeure);
            form1.add(groupe);
            form1.add(choixGroupe);
            
            JButton valider = new JButton("Valider");
            
            valider.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    //Ici on appellera la fonction
                }
            });

            pan2.add(form1,BorderLayout.SOUTH);
            pan2.add(valider);
            super.setContentPane(pan2);
        }
        //Fonction modifiant un cours
        else if(fonction == 4)
        {
            JPanel form1 = new JPanel();
            form1.setPreferredSize(new Dimension(250,280));
            
            JLabel dateSeance = new JLabel("Date de la séance : ");
            JFormattedTextField choixDate = new JFormattedTextField("2020-06-03");
            JLabel heure = new JLabel("Heure de début : ");
            JFormattedTextField choixHeure = new JFormattedTextField("19:00:00");
            JLabel groupe = new JLabel ("Groupe de TD : ");
            JFormattedTextField choixGroupe = new JFormattedTextField("exemple : TD06");
            JLabel cours = new JLabel("Nouveau cours : ");
            JFormattedTextField choixCours = new JFormattedTextField("exemple: Mathématiques");
            JLabel enseignant = new JLabel("Enseignant :");
            JFormattedTextField choixEnseignant = new JFormattedTextField("exemple: Chamberlain");
            
            form1.add(dateSeance);
            form1.add(choixDate);
            form1.add(heure);
            form1.add(choixHeure);
            form1.add(groupe);
            form1.add(choixGroupe);
            form1.add(cours);
            form1.add(choixCours);
            form1.add(enseignant);
            form1.add(choixEnseignant);
            
            JButton valider = new JButton("Valider");
            
            valider.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    //Ici on appellera la fonction
                }
            });

            pan2.add(form1,BorderLayout.SOUTH);
            pan2.add(valider);
            super.setContentPane(pan2);
        }
        //Fonction affectant une salle à un cours
        else if(fonction == 5)
        {
            JPanel form1 = new JPanel();
            form1.setPreferredSize(new Dimension(250,250));
            
            JLabel dateSeance = new JLabel("Date de la séance : ");
            JFormattedTextField choixDate = new JFormattedTextField("2020-06-03");
            JLabel heure = new JLabel("Heure de début : ");
            JFormattedTextField choixHeure = new JFormattedTextField("19:00:00");
            JLabel groupe = new JLabel ("Groupe de TD : ");
            JFormattedTextField choixGroupe = new JFormattedTextField("exemple : TD06");
            
            form1.add(dateSeance);
            form1.add(choixDate);
            form1.add(heure);
            form1.add(choixHeure);
            form1.add(groupe);
            form1.add(choixGroupe);
            
            JButton valider = new JButton("Valider");
            
            valider.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    //Ici on appellera la fonction
                }
            });

            pan2.add(form1,BorderLayout.SOUTH);
            pan2.add(valider);
            super.setContentPane(pan2);
        }
        //Fonction ajoutant un cours
        else if(fonction == 6)
        {
            JPanel form1 = new JPanel();
            form1.setPreferredSize(new Dimension(250,250));
            
            JLabel dateSeance = new JLabel("Date de la séance : ");
            JFormattedTextField choixDate = new JFormattedTextField("2020-06-03");
            JLabel heure = new JLabel("Heure de début : ");
            JFormattedTextField choixHeure = new JFormattedTextField("19:00:00");
            JLabel groupe = new JLabel ("Groupe de TD : ");
            JFormattedTextField choixGroupe = new JFormattedTextField("exemple : TD06");
            JLabel enseignant = new JLabel("Enseignant :");
            JFormattedTextField choixEnseignant = new JFormattedTextField("exemple: Chamberlain");
            
            form1.add(dateSeance);
            form1.add(choixDate);
            form1.add(heure);
            form1.add(choixHeure);
            form1.add(groupe);
            form1.add(choixGroupe);
            form1.add(enseignant);
            form1.add(choixEnseignant);
            
            JButton valider = new JButton("Valider");
            
            valider.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    //Ici on appellera la fonction
                }
            });

            pan2.add(form1,BorderLayout.SOUTH);
            pan2.add(valider);
            super.setContentPane(pan2);
        }
        //Fonction ajoutant un enseignant à une séance de cours
        else if(fonction == 7)
        {
            JPanel form1 = new JPanel();
            form1.setPreferredSize(new Dimension(250,250));
            
            JLabel dateSeance = new JLabel("Date de la séance : ");
            JFormattedTextField choixDate = new JFormattedTextField("2020-06-03");
            JLabel heure = new JLabel("Heure de début : ");
            JFormattedTextField choixHeure = new JFormattedTextField("19:00:00");
            JLabel groupe = new JLabel ("Groupe de TD : ");
            JFormattedTextField choixGroupe = new JFormattedTextField("exemple : TD06");
            JLabel enseignant = new JLabel("Enseignant ajouté :");
            JFormattedTextField choixEnseignant = new JFormattedTextField("exemple: Chamberlain");
            
            form1.add(dateSeance);
            form1.add(choixDate);
            form1.add(heure);
            form1.add(choixHeure);
            form1.add(groupe);
            form1.add(choixGroupe);
            form1.add(enseignant);
            form1.add(choixEnseignant);
            
            JButton valider = new JButton("Valider");
            
            valider.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    //Ici on appellera la fonction
                }
            });

            pan2.add(form1,BorderLayout.SOUTH);
            pan2.add(valider);
            super.setContentPane(pan2);
        }
        //Fonction ajoutant un groupe à une séance de cours
        else if(fonction == 8)
        {
            JPanel form1 = new JPanel();
            form1.setPreferredSize(new Dimension(250,250));
            
            JLabel dateSeance = new JLabel("Date de la séance : ");
            JFormattedTextField choixDate = new JFormattedTextField("2020-06-03");
            JLabel heure = new JLabel("Heure de début : ");
            JFormattedTextField choixHeure = new JFormattedTextField("19:00:00");
            JLabel enseignant = new JLabel("Enseignant :");
            JFormattedTextField choixEnseignant = new JFormattedTextField("exemple: Chamberlain");
            JLabel groupe = new JLabel ("Groupe ajouté : ");
            JFormattedTextField choixGroupe = new JFormattedTextField("exemple : TD06");
            
            
            form1.add(dateSeance);
            form1.add(choixDate);
            form1.add(heure);
            form1.add(choixHeure);
            form1.add(enseignant);
            form1.add(choixEnseignant);
            form1.add(groupe);
            form1.add(choixGroupe);
            
            JButton valider = new JButton("Valider");
            
            valider.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    //Ici on appellera la fonction
                }
            });

            pan2.add(form1,BorderLayout.SOUTH);
            pan2.add(valider);
            super.setContentPane(pan2);
        }
        //Fonction enlevant un enseignant d'une séance de cours
        else if(fonction == 9)
        {
            JPanel form1 = new JPanel();
            form1.setPreferredSize(new Dimension(250,250));
            
            JLabel dateSeance = new JLabel("Date de la séance : ");
            JFormattedTextField choixDate = new JFormattedTextField("2020-06-03");
            JLabel heure = new JLabel("Heure de début : ");
            JFormattedTextField choixHeure = new JFormattedTextField("19:00:00");
            JLabel groupe = new JLabel ("Groupe de TD : ");
            JFormattedTextField choixGroupe = new JFormattedTextField("exemple : TD06");
            JLabel enseignant = new JLabel("Enseignant enlevé :");
            JFormattedTextField choixEnseignant = new JFormattedTextField("exemple: Chamberlain");
            
            form1.add(dateSeance);
            form1.add(choixDate);
            form1.add(heure);
            form1.add(choixHeure);
            form1.add(groupe);
            form1.add(choixGroupe);
            form1.add(enseignant);
            form1.add(choixEnseignant);
            
            JButton valider = new JButton("Valider");
            
            valider.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    //Ici on appellera la fonction
                }
            });

            pan2.add(form1,BorderLayout.SOUTH);
            pan2.add(valider);
            super.setContentPane(pan2);
        }
        //Fonction enlevant un groupe d'une séance de cours
        else if(fonction == 10)
        {
            JPanel form1 = new JPanel();
            form1.setPreferredSize(new Dimension(250,250));
            
            JLabel dateSeance = new JLabel("Date de la séance : ");
            JFormattedTextField choixDate = new JFormattedTextField("2020-06-03");
            JLabel heure = new JLabel("Heure de début : ");
            JFormattedTextField choixHeure = new JFormattedTextField("19:00:00");
            JLabel enseignant = new JLabel("Enseignant :");
            JFormattedTextField choixEnseignant = new JFormattedTextField("exemple: Chamberlain");
            JLabel groupe = new JLabel ("Groupe ajouté : ");
            JFormattedTextField choixGroupe = new JFormattedTextField("exemple : TD06");
            
            
            form1.add(dateSeance);
            form1.add(choixDate);
            form1.add(heure);
            form1.add(choixHeure);
            form1.add(enseignant);
            form1.add(choixEnseignant);
            form1.add(groupe);
            form1.add(choixGroupe);
            
            JButton valider = new JButton("Valider");
            
            valider.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    //Ici on appellera la fonction
                }
            });

            pan2.add(form1,BorderLayout.SOUTH);
            pan2.add(valider);
            super.setContentPane(pan2);
        }
        
    }
    
    public void conversionHeure()
    {
        
    }
    
    public void supprimer(String cours, java.sql.Date date, java.sql.Date heure, String enseignant)
    {
        try
        {
            String test;
            
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/edt";
            
            connexionBDD = DriverManager.getConnection(url, "root", "");
            
            statement = connexionBDD.createStatement();

            
            ResultSet result = statement.executeQuery("SELECT Nom FROM Seance WHERE Heure_Debut = " + "'"+heure.getTime()+"'");
            System.out.println("Jusque là ça va");
            System.out.println(heure.getTime());
            if(result.next())
            {
                System.out.println("Jusque là ça va");
                test = result.getString("Nom");
                System.out.println(heure);
            }
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
