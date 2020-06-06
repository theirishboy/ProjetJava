package JavaEDT;
import Liste.Liste_Groupes;
import Liste.Liste_Salles;
import Liste.Liste_Utilisateurs;
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
    
   public Cours(Graphics g, int x, int y, int h, int w, String cours,String type, Liste_Utilisateurs ens, Liste_Groupes groupes, Liste_Salles lesalles,String site)
   {  

    //////////////////////////////////////////////////////Bloc cours//////////////////////////////////////////////////////
        blocx = x;
        blocy = y;
        bloch = h;
        blocw = w;
        
        
        couleurCours = choixCouleur(matiere);
        
        g.setColor(couleurCours);
        g.fillRect(blocx, blocy, blocw, bloch);
        g.setColor(Color.BLACK);
        g.drawString(type+" "+cours, blocx + 50, blocy + 25);
        for(int i = 0; i < ens.size();i++)
        {
              g.drawString(ens.LesUtilisateurs.get(i).getNom(), blocx + 50+i*10, blocy + 55);

        }
           for(int i = 0; i < groupes.size();i++)
        {
              g.drawString(groupes.LesGroupes.get(i).getNom(), blocx + 50+i*10, blocy + 65);

        }
            for(int i = 0; i < lesalles.size();i++)
        {
              g.drawString(lesalles.LesSalles.get(i).getNom(), blocx + 50+i*10, blocy + 75);

        }
           
        
        g.drawString(site +" "+ groupe, blocx + 50, blocy + 85);
   }
   
   public String vraieMatiere(String mat)
   {
       String nouv = "";
       if(mat == "Math")
       {
           nouv = "MathÃ©matiques";
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
       if(mat == "MathÃ©matiques")
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
