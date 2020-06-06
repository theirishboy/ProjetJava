/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import Controleur.Seance;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gabri
 */
public class Liste_Seances {
    public ArrayList<Seance> LesSeances;
     public  Liste_Seances()
    {
         LesSeances = new ArrayList<Seance>();
    }
    public void ajout(Seance Seance)
    {
        LesSeances.add(Seance);
    }

    public int size() {
           return LesSeances.size();
    }
   
    
}
