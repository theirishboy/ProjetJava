/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaEDT;
import java.awt.*;
import javax.swing.*;

public class Recapitulatif extends JPanel{
    public void paintComponent(Graphics g){
        
        Font font = new Font("Courier", Font.BOLD, 20);
        g.setFont(font);
        Color couleur1 = new Color(112, 146, 190);
        Color couleur2 = new Color(195, 195, 195); 

        g.setColor(couleur2);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        g.setColor(Color.BLACK);        
        g.drawString("Récapitulatif des cours", this.getWidth()/2 - 70, 30);
        
        int x=50;
        int y=100; 
        
        g.setColor(Color.WHITE); g.fillRect(x, 60, 370, 30); g.setColor(couleur1); g.drawRect(x, 60, 370, 30);
        g.drawString("Matière", 200, 80);
        
        g.setColor(Color.WHITE); g.fillRect(440, 60, 370, 30); g.setColor(couleur1); g.drawRect(440, 60, 370, 30);
        g.drawString("Première séance", 550, 80);
        
        g.setColor(Color.WHITE); g.fillRect(830, 60, 370, 30); g.setColor(couleur1); g.drawRect(830, 60, 370, 30);
        g.drawString("Dernière séance", 930, 80);
        
        g.setColor(Color.WHITE); g.fillRect(1220, 60, 120, 30); g.setColor(couleur1); g.drawRect(1220, 60, 120, 30);
        g.drawString("Durée", 1250, 80);
        
        g.setColor(Color.WHITE); g.fillRect(1360, 60, 120, 30); g.setColor(couleur1); g.drawRect(1360, 60, 120, 30);
        g.drawString("Nb", 1410, 80);
        
        for (int i=0; i<3; i++)
        {   int largeur = 370;
            int ecart=20;

            g.setColor(couleur1);
            g.fillRect(x, y, largeur, this.getHeight());
            x=x+largeur;

            g.setColor(couleur2);
            g.drawRect(x, y, ecart, this.getHeight());
            x=x+20;    
        }
        
        for (int i=0; i<2; i++)
        {   int largeur = 120;
            int ecart=20;

            g.setColor(couleur1);
            g.fillRect(x, y, largeur, this.getHeight());
            x=x+largeur;

            g.setColor(couleur2);
            g.drawRect(x, y, ecart, this.getHeight());
            x=x+20;    
        }
        
    }
}
