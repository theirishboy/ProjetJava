package JavaEDT;

import BDD.ConnexionBDD;
import Liste.Liste_Cours;
import Liste.Liste_Seances;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Panneau extends JPanel {
        Liste_Seances Seances;
        ConnexionBDD connexion;
    public void paintComponent(Graphics g ) {
        //Colonne pour l'emploi du temps
        Color couleur1 = new Color(61, 175, 175);
        Color couleur2 = new Color(195, 195, 195);

        g.setColor(couleur2);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        int x = 100;
        int y = 80;
        for (int i = 0; i < 6; i++) {
            int largeur = 190;
            int ecart = 20;

            g.setColor(couleur1);
            g.fillRect(x, y, largeur, 535);
            x = x + largeur;

            g.setColor(couleur2);
            g.drawRect(x, y, ecart, 535);
            x = x + 20;
        }

        x = 100;
        y = 75;

        //Les jours de la semaine
        Font font = new Font("Courier", Font.BOLD, 25);
        Color couleur3 = new Color(41, 116, 114);
        g.setFont(font);
        g.setColor(couleur3);
        //Lundi          
        g.drawString("Lundi", x + 65, y - 10);
        //Mardi         
        g.drawString("Mardi", x + 270, y - 10);
        //Mercredi        
        g.drawString("Mercredi", x + 465, y - 10);
        //Jeudi         
        g.drawString("Jeudi", x + 695, y - 10);
        //Vendredi         
        g.drawString("Vendredi", x + 890, y - 10);
        //Samedi          
        g.drawString("Samedi", x + 1100, y - 10);

        //Les horaires
        Font hor1 = new Font("Courier", Font.BOLD, 15);
        Color couleur4 = new Color(71, 71, 71);
        g.setFont(hor1);
        g.setColor(couleur4);
        int j = (620 - 45) / 13;
        System.out.println(this.getHeight());
        System.out.println(j);
        g.drawString("09:00", x / 3, j * 2 + 20);
        g.drawString("10:00", x / 3, j * 3 + 20);
        g.drawString("11:00", x / 3, j * 4 + 20);
        g.drawString("12:00", x / 3, j * 5 + 20);
        g.drawString("13:00", x / 3, j * 6 + 20);
        g.drawString("14:00", x / 3, j * 7 + 20);
        g.drawString("15:00", x / 3, j * 8 + 20);
        g.drawString("16:00", x / 3, j * 9 + 20);
        g.drawString("17:00", x / 3, j * 10 + 20);
        g.drawString("18:00", x / 3, j * 11 + 20);
        g.drawString("19:00", x / 3, j * 12 + 20);
        g.drawString("20:00", x / 3, j * 13 + 20);

        //Les sous-heures
        Font hor2 = new Font("Courier", Font.BOLD, 10);
        g.setFont(hor2);
        g.drawString("08:30", x / 3 + 10, j + 40);
        g.drawString("09:30", x / 3 + 10, j * 2 + 40);
        g.drawString("10:30", x / 3 + 10, j * 3 + 40);
        g.drawString("11:30", x / 3 + 10, j * 4 + 40);
        g.drawString("12:30", x / 3 + 10, j * 5 + 40);
        g.drawString("13:30", x / 3 + 10, j * 6 + 40);
        g.drawString("14:30", x / 3 + 10, j * 7 + 40);
        g.drawString("15:30", x / 3 + 10, j * 8 + 40);
        g.drawString("16:30", x / 3 + 10, j * 9 + 40);
        g.drawString("17:30", x / 3 + 10, j * 10 + 40);
        g.drawString("18:30", x / 3 + 10, j * 11 + 40);
        g.drawString("19:30", x / 3 + 10, j * 12 + 40);
        g.drawString("20:30", x / 3 + 10, j * 13 + 40);
         
            try {
                AffichageCours affichertout = new AffichageCours(g,Seances,this.connexion);
            } catch (SQLException ex) {
                Logger.getLogger(Panneau.class.getName()).log(Level.SEVERE, null, ex);
            }
     
       


    }
    public void setVar(Liste_Seances Seance,ConnexionBDD maconnexion)
    {
        this.Seances = Seance;
        this.connexion = maconnexion;
    }
}

  

