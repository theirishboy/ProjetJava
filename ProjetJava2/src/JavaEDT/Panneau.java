package JavaEDT;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Panneau extends JPanel { 
    
   public void paintComponent(Graphics g){
    //Colonne pour l'emploi du temps
    Color couleur1 = new Color(251, 251, 214);
    Color couleur2 = new Color(195, 195, 195); 
    
    g.setColor(couleur2);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    
    int x=100;
    int y=80;   
    for (int i=0; i<6; i++)
    {
        int largeur = 190;
        int ecart=20;

        g.setColor(couleur1);
        g.fillRect(x, y, largeur, 535);
        x=x+largeur;
        
        g.setColor(couleur2);
        g.drawRect(x, y, ecart, 535);
        x=x+20;    
    }
    
    x=100;
    y=75;
    
    //Les jours de la semaine
    Font font = new Font("Courier", Font.BOLD, 25);
    Color couleur3 = new Color(40, 40, 40);
    g.setFont(font);
    g.setColor(couleur3);
    //Lundi          
    g.drawString("Lundi", x+62, y-10);
    //Mardi         
    g.drawString("Mardi", x+270, y-10);
    //Mercredi        
    g.drawString("Mercredi", x+463, y-10);
    //Jeudi         
    g.drawString("Jeudi", x+691, y-10);
    //Vendredi         
    g.drawString("Vendredi", x+884, y-10);
    //Samedi          
    g.drawString("Samedi", x+1101, y-10);
    
    //Les horaires
    Font hor1 = new Font("Courier", Font.BOLD, 15);
    Color couleur4 = new Color(71, 71, 71);
    g.setFont(hor1);
    g.setColor(couleur4); 
    int j = (620-45)/13;
    System.out.println(this.getHeight());
    System.out.println(j);
    g.drawString("09:00", x/3, j*2+20);
    g.drawString("10:00", x/3, j*3+20);
    g.drawString("11:00", x/3, j*4+20);
    g.drawString("12:00", x/3, j*5+20);
    g.drawString("13:00", x/3, j*6+20);
    g.drawString("14:00", x/3, j*7+20);
    g.drawString("15:00", x/3, j*8+20);
    g.drawString("16:00", x/3, j*9+20);
    g.drawString("17:00", x/3, j*10+20);
    g.drawString("18:00", x/3, j*11+20);
    g.drawString("19:00", x/3, j*12+20);
    g.drawString("20:00", x/3, j*13+20);
    
    //Les sous-heures
    Font hor2 = new Font("Courier", Font.BOLD, 10);
    g.setFont(hor2);
    g.drawString("08:30", x/3+10, j+40);
    g.drawString("09:30", x/3+10, j*2+40);
    g.drawString("10:30", x/3+10, j*3+40);
    g.drawString("11:30", x/3+10, j*4+40);
    g.drawString("12:30", x/3+10, j*5+40);
    g.drawString("13:30", x/3+10, j*6+40);
    g.drawString("14:30", x/3+10, j*7+40);
    g.drawString("15:30", x/3+10, j*8+40);
    g.drawString("16:30", x/3+10, j*9+40);
    g.drawString("17:30", x/3+10, j*10+40);
    g.drawString("18:30", x/3+10, j*11+40);
    g.drawString("19:30", x/3+10, j*12+40);
    g.drawString("20:30", x/3+10, j*13+40);
    
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
    int blocx;
    int blocy;
    
    int jour = 4;
    String heure = "8h30";
    
    blocx = placementJour(jour);
    blocy = placementHeure(heure);
    
    Cours cours = new Cours(g, blocx, blocy, 97, 190,"elec","Delisle","ing3","TD06");
    
  } 
   
   public int placementJour(int jour)
   {
       int blocx = 0;
       if(jour == 1)
       {//lundi
        blocx = 100; 
    }
    if(jour == 2){//mardi
        blocx = 310;
    }
    if(jour == 3){//mercredi
        blocx = 520;
    }
    if(jour == 4){//jeudi
        blocx = 730;
    }
    if(jour == 5){//vendredi
        blocx = 940;
    }
    if(jour == 6){ //samedi
        blocx = placementJour(jour);
    }
    
    return blocx;
       
   }
   
   public int placementHeure(String heure)
   {   
       int blocy = 0;
       if(heure == "8h30")
       {
           blocy = ((620-45)/13)+36;
       }
       else if(heure == "9h")
       {
           blocy = ((620-45)/13)*2+20;
       }
       else if(heure == "9h30")
       {
           blocy = ((620-45)/13)*2+36;
       }
       else if(heure == "10h")
       {
           blocy = ((620-45)/13)*3+20;
       }
       else if(heure == "10h30")
       {
           blocy = ((620-45)/13)*3+36;
       }
       else if(heure == "11h")
       {
           blocy = ((620-45)/13)*4+20;
       }
       else if(heure == "11h30")
       {
           blocy = ((620-45)/13)*4+36;
       }
       else if(heure == "12h")
       {
           blocy = ((620-45)/13)*5+20;
       }
       else if(heure == "12h30")
       {
           blocy = ((620-45)/13)*5+36;
       }
       else if(heure == "13h")
       {
           blocy = ((620-45)/13)*6+20;
       }
       else if(heure == "13h30")
       {
           blocy = ((620-45)/13)*6+36;
       }
       else if(heure == "14h")
       {
           blocy = ((620-45)/13)*7+20;
       }
       else if(heure == "14h30")
       {
           blocy = ((620-45)/13)*7+36;
       }
       else if(heure == "15h")
       {
           blocy = ((620-45)/13)*8+20;
       }
       else if(heure == "15h30")
       {
           blocy = ((620-45)/13)*8+36;
       }
       else if(heure == "16h")
       {
           blocy = ((620-45)/13)*9+20;
       }
       else if(heure == "16h30")
       {
           blocy = ((620-45)/13)*9+36;
       }
       else if(heure == "17h")
       {
           blocy = ((620-45)/13)*10+20;
       }
       else if(heure == "17h30")
       {
           blocy = ((620-45)/13)*10+36;
       }
       else if(heure == "18h")
       {
           blocy = ((620-45)/13)*11+20;
       }
       else if(heure == "18h30")
       {
           blocy = ((620-45)/13)*11+36;
       }
       else if(heure == "19h")
       {
           blocy = ((620-45)/13)*12+20;
       }
       
       return blocy;
   }
}
