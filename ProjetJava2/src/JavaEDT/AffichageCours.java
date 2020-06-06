/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaEDT;

import BDD.ConnexionBDD;
import Controleur.Site;
import Controleur.Type_Cours;
import Liste.Liste_Cours;
import Liste.Liste_Enseignants;
import Liste.Liste_Groupes;
import Liste.Liste_Salles;
import Liste.Liste_Seances;
import Liste.Liste_Utilisateurs;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;

/**
 *
 * @author gabri
 */
public class AffichageCours extends JPanel {
        Liste_Salles lessalles;
        Site lesite;
        Controleur.Cours cours2;
        String type;
        Liste_Utilisateurs lesenseignants;
        Liste_Groupes nomGroupe;
        public AffichageCours(Graphics g,Liste_Seances mesSeances,ConnexionBDD maconnexion  ) throws SQLException {
             int blocx;
        int blocy;
         //Cours cours = new Cours(g, 100, 100, 97, 190,"elec","Delisle","ing3","TD06");

        for (int i = 0; i < mesSeances.size(); i++) {
            
            type = maconnexion.Typecours(mesSeances.LesSeances.get(i));
            cours2 = maconnexion.getCours(mesSeances.LesSeances.get(i));
            lesenseignants = maconnexion.getEnseignants(mesSeances.LesSeances.get(i));
            nomGroupe = maconnexion.getGroupe(mesSeances.LesSeances.get(i));
            lessalles = maconnexion.salle(mesSeances.LesSeances.get(i));
            lesite=maconnexion.site(lessalles.LesSalles.get(1));
            blocx = placementJour(mesSeances.LesSeances.get(i).getDate());
            int height = calculheight(mesSeances.LesSeances.get(i).getHeureDebut(),mesSeances.LesSeances.get(i).getHeureFin());
            blocy = placementHeure(mesSeances.LesSeances.get(i).getHeureFin(),height);
            

            System.out.print("Les parametre sont : " +blocx + " " + blocy + " "+height);
            Cours cours1 = new Cours(g, blocx, blocy, height, 190,cours2.getNom(),type,lesenseignants,nomGroupe,lessalles,lesite.getNom());
        }
       
        }
        public int placementHeure(Date heure,int height) {
        System.out.println("Heure = " +  heure.getHours() + " min " + heure.getMinutes());
        int hours = heure.getHours()-8;
        int min = heure.getMinutes();
        int tot = hours*60+min-30;
        int pixel = (int) (0.75*tot);
        
        int blocy = pixel+75-height;

        return blocy;
    }

  

    public int calculheight(Date heureDebut, Date heureFin) {
      int time1 = heureFin.getHours()*60+ heureFin.getMinutes();
      int time2 = heureDebut.getHours()*60+heureDebut.getMinutes();;
     int tot = time1-time2;
     int pixel = (int) (0.75*tot);
        
       

     return pixel;
    }

      public int placementJour(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("EEEE");
        
        String jour = dateFormat.format(date);
        System.out.println(jour);
        int blocx = 0;
        if ("lundi".equals(jour)) {//mardi
            blocx = 100;
        }
        if ("mardi".equals(jour)) {//mardi
            blocx = 310;
        }
        if ("mercredi".equals(jour)) {//mercredi
            blocx = 520;
        }
        if ("jeudi".equals(jour)) {//jeudi
            blocx = 730;
        }
        if ("vendredi".equals(jour)) {//vendredi
            blocx = 940;
        }
        if ("samedi".equals(jour)) { //samedi
            blocx = 1150;
        }

        return blocx;

    }
      


}

