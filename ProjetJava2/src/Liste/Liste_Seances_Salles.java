/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import Controleur.Seance_Salles;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Liste_Seances_Salles {
     ArrayList<Seance_Salles> LesSeances_Salles;
     public  Liste_Seances_Salles()
    {
         LesSeances_Salles = new ArrayList<Seance_Salles>();
    }
    public void ajout(Seance_Salles Seance_Salles)
    {
        LesSeances_Salles.add(Seance_Salles);
    }
}
