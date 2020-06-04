package JavaEDT;
import java.awt.*;
import javax.swing.*;

public class Cours extends JPanel { 
   public Cours(Graphics g, int x, int y, int h, int w){  

    //////////////////////////////////////////////////////Bloc cours//////////////////////////////////////////////////////
        int heure = 0;
        int blocx = x;
        int blocy = y;
        int bloch = h;
        int blocw = w; 

        String cours = "Anglais";
        String enseignant = "M. MELLANG";
        String promo = "Ing3";
        String groupe = "Gr06";

        g.setColor(Color.RED);
        g.fillRect(blocx, blocy, blocw, bloch);
        g.setColor(Color.BLACK);
        g.drawString(cours, blocx + 75, blocy + 25);
        g.drawString(enseignant, blocx + 65, blocy + 45);
        g.drawString(promo + groupe, blocx + 75, blocy + 75);

        blocy = blocy + bloch + 15;
        g.setColor(Color.RED);
        g.drawRect(blocx, blocy, blocw, bloch);

        blocy = blocy + bloch + 15;
        g.setColor(Color.RED);
        g.drawRect(blocx, blocy, blocw, bloch);
   }   
}
