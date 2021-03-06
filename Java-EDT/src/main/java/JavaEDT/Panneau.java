package JavaEDT;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Panneau extends JPanel { 
   public void paintComponent(Graphics g){
    //Colonne pour l'emploi du temps
    Color couleur1 = new Color(61, 175, 175);
    Color couleur2 = new Color(195, 195, 195); 
    
    g.setColor(couleur2);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    
    int x=100;
    int y=80;   
    for (int i=0; i<6; i++)
    {
        int largeur = 210;
        int ecart=20;

        g.setColor(couleur1);
        g.fillRect(x, y, largeur, this.getHeight());
        x=x+largeur;
        
        g.setColor(couleur2);
        g.drawRect(x, y, ecart, this.getHeight());
        x=x+20;    
    }
    
    x=100;
    y=75;
    
    //Les jours de la semaine
    Font font = new Font("Courier", Font.BOLD, 25);
    Color couleur3 = new Color(41, 116, 114);
    g.setFont(font);
    g.setColor(couleur3);
    //Lundi          
    g.drawString("Lundi", x+75, y-10);
    //Mardi         
    g.drawString("Mardi", x+305, y-10);
    //Mercredi        
    g.drawString("Mercredi", x+515, y-10);
    //Jeudi         
    g.drawString("Jeudi", x+760, y-10);
    //Vendredi         
    g.drawString("Vendredi", x+970, y-10);
    //Samedi          
    g.drawString("Samedi", x+1210, y-10);
    
    //Les horaires
    Font hor1 = new Font("Courier", Font.BOLD, 15);
    Color couleur4 = new Color(71, 71, 71);
    g.setFont(hor1);
    g.setColor(couleur4); 
    int j = (this.getHeight()-45)/13;
    System.out.println(this.getHeight());
    System.out.println(j);
    g.drawString("09:00", x/3, j*2);
    g.drawString("10:00", x/3, j*3);
    g.drawString("11:00", x/3, j*4);
    g.drawString("12:00", x/3, j*5);
    g.drawString("13:00", x/3, j*6);
    g.drawString("14:00", x/3, j*7);
    g.drawString("15:00", x/3, j*8);
    g.drawString("16:00", x/3, j*9);
    g.drawString("17:00", x/3, j*10);
    g.drawString("18:00", x/3, j*11);
    g.drawString("19:00", x/3, j*12);
    g.drawString("20:00", x/3, j*13);
    
    //Les sous-heures
    Font hor2 = new Font("Courier", Font.BOLD, 10);
    g.setFont(hor2);
    g.drawString("08:30", x/3+10, j+32);
    g.drawString("09:30", x/3+10, j*2+32);
    g.drawString("10:30", x/3+10, j*3+32);
    g.drawString("11:30", x/3+10, j*4+32);
    g.drawString("12:30", x/3+10, j*5+32);
    g.drawString("13:30", x/3+10, j*6+32);
    g.drawString("14:30", x/3+10, j*7+32);
    g.drawString("15:30", x/3+10, j*8+32);
    g.drawString("16:30", x/3+10, j*9+32);
    g.drawString("17:30", x/3+10, j*10+32);
    g.drawString("18:30", x/3+10, j*11+32);
    g.drawString("19:30", x/3+10, j*12+32);
    g.drawString("20:30", x/3+10, j*13+32);
    
    /*g.drawString("Septembre", 60, 50);
    g.drawString("Octobre", 210, 50);
    g.drawString("Novembre", 355, 50);
    g.drawString("Décembre", 515, 50);
    g.drawString("Janvier", 650, 50);
    g.drawString("Février", 820, 50);
    g.drawString("Mars", 955, 50);
    g.drawString("Avril", 1125, 50);
    g.drawString("Mai", 1285, 50);
    g.drawString("Juin", 1420, 50);*/
    
    //////////////////////////////////////////////////////Bloc cours//////////////////////////////////////////////////////
    g.setFont(hor1);
    g.setColor(couleur4);
    
    int jour = 1;
    if(jour == 1){//lundi
        int blocx = 100;
        int blocy = 90;
        int bloch = 97;
        int blocw = 210; 
        Cours cours = new Cours(g, blocx, blocy, bloch, blocw);
    }
    if(jour == 2){//mardi
        int blocx = 330;
        int blocy = 90;
        int bloch = 97;
        int blocw = 210; 
        Cours cours = new Cours(g, blocx, blocy, bloch, blocw);
    }
    if(jour == 3){//mercredi
        int blocx = 560;
        int blocy = 90;
        int bloch = 97;
        int blocw = 210; 
        Cours cours = new Cours(g, blocx, blocy, bloch, blocw);
    }
    if(jour == 4){//jeudi
        int blocx = 790;
        int blocy = 90;
        int bloch = 97;
        int blocw = 210; 
        Cours cours = new Cours(g, blocx, blocy, bloch, blocw);
    }
    if(jour == 5){//vendredi
        int blocx = 1020;
        int blocy = 90;
        int bloch = 97;
        int blocw = 210; 
        Cours cours = new Cours(g, blocx, blocy, bloch, blocw);
    }
    if(jour == 6){ //samedi
        int blocx = 1250;
        int blocy = 90;
        int bloch = 97;
        int blocw = 210; 
        Cours cours = new Cours(g, blocx, blocy, bloch, blocw);
    }

    //Cours cours = new Cours(g);
    
  }   
}
