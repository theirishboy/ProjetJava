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
    
   public Cours(Graphics g, int x, int y, int h, int w, String cours,String type, Liste_Utilisateurs ens, Liste_Groupes groupes, Liste_Salles lesalles,String site, int nomPromotion,int Etat)
   {  

    //////////////////////////////////////////////////////Bloc cours//////////////////////////////////////////////////////
        blocx = x;
        blocy = y;
        bloch = h;
        blocw = w;
        
        String coulor = vraieMatiere(cours);
        couleurCours = choixCouleur(coulor);
       
        g.setColor(couleurCours);
        g.fillRect(blocx, blocy, blocw, bloch);
        g.setColor(Color.BLACK);
        if(Etat == 2)
        {
            Color couleur = new Color(255,255,255);
            g.setColor(couleur);
            g.fillRect(blocx,blocy,190,20);
            g.setColor(Color.RED);
            g.drawString("ANNULÉ", blocx + 70,blocy+15);
            g.setColor(Color.BLACK);
        }
        

        int emplacement = 35;
                g.drawString(type+" "+cours, blocx + 50, blocy+emplacement);

        for(int i = 0; i < ens.size();i++)
        {
            emplacement = emplacement+15;
              g.drawString(ens.LesUtilisateurs.get(i).getNom(), blocx + 50, blocy +emplacement);

        }
           for(int i = 0; i < groupes.size();i++)
        {
               emplacement = emplacement+15;

              g.drawString(groupes.LesGroupes.get(i).getNom()+" Promo : "+nomPromotion, blocx + 50, blocy + emplacement);

        }
            for(int i = 0; i < lesalles.size();i++)
        {
                        emplacement = emplacement+15;

              g.drawString(site+" " +lesalles.LesSalles.get(i).getNom(), blocx + 50, blocy + emplacement);

        }
             emplacement = emplacement+15;
        
   }
   
   public String vraieMatiere(String mat)
   {
       String nouv = "";
       System.out.println("matiere is " + mat);
       if("Math".equals(mat))
       {
           nouv = "MathÃ©matiques";
       }
       else if("Info".equals(mat))
       {
           nouv = "Informatique";
       }
       else if("elec".equals(mat))
       {
           nouv = "Electronique";
       }
       else if("Phy".equals(mat))
       {
           nouv = "Physique";
       }
       
       return nouv;
   }
   
   public Color choixCouleur(String mat)
   {
       Color couleur = new Color(255,0,0);
       if("MathÃ©matiques".equals(mat))
       {
           couleur = new Color(24, 142, 254);
       }
       else if("Informatique".equals(mat))
       {
           couleur = new Color(254,251,24);
       }
       else if("Electronique".equals(mat))
       {
           couleur = new Color(163,24,254);
       }
       else if("Physique".equals(mat))
       {
           couleur = new Color(24,254,191);
       }
       
       return couleur;
   }
    
}
