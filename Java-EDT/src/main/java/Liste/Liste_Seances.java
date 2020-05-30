/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import Controleur.Seance;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Liste_Seances {
    ArrayList<Seance> LesSeances;
     public void Liste_Seances()
    {
         LesSeances = new ArrayList<Seance>();
    }
    public void ajout(Seance Seance)
    {
        LesSeances.add(Seance);
    }
    
}
