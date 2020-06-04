package JavaEDT;
import java.awt.*;
import javax.swing.*;

public class Cours extends JPanel {
    
    private Color couleurCours;
    private int blocx;
    private int blocy;
    private int bloch;
    private int blocw;
    private String matiere;
    private String enseignant;
    private String promo;
    private String groupe;
    
   public Cours(Graphics g, int x, int y, int h, int w, String mat, String ens, String prom, String group)
   {  

    //////////////////////////////////////////////////////Bloc cours//////////////////////////////////////////////////////
        blocx = x;
        blocy = y;
        bloch = h;
        blocw = w;
        enseignant = ens;
        promo = prom;
        groupe = group;
        
        matiere = vraieMatiere(mat);
        couleurCours = choixCouleur(matiere);
        
        g.setColor(couleurCours);
        g.fillRect(blocx, blocy, blocw, bloch);
        g.setColor(Color.BLACK);
        g.drawString(matiere, blocx + 50, blocy + 25);
        g.drawString(enseignant, blocx + 50, blocy + 55);
        g.drawString(promo +" "+ groupe, blocx + 50, blocy + 75);
   }
   
   public String vraieMatiere(String mat)
   {
       String nouv = "";
       if(mat == "Math")
       {
           nouv = "Mathématiques";
       }
       else if(mat == "Info")
       {
           nouv = "Informatique";
       }
       else if(mat == "elec")
       {
           nouv = "Electronique";
       }
       else if(mat == "Phy")
       {
           nouv = "Physique";
       }
       
       return nouv;
   }
   
   public Color choixCouleur(String mat)
   {
       Color couleur = new Color(0,0,0);
       if(mat == "Mathématiques")
       {
           couleur = new Color(24, 142, 254);
       }
       else if(mat == "Informatique")
       {
           couleur = new Color(254,251,24);
       }
       else if(mat == "Electronique")
       {
           couleur = new Color(163,24,254);
       }
       else if(mat == "Physique")
       {
           couleur = new Color(24,254,191);
       }
       
       return couleur;
   }
    
}
