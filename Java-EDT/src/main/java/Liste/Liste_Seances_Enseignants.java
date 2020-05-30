/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import Controleur.Seance_Enseignants;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Liste_Seances_Enseignants{
       ArrayList<Seance_Enseignants> LesSeances_Enseignants;
     public void Liste_Enseignants()
    {
         LesSeances_Enseignants = new ArrayList<Seance_Enseignants>();
    }
    public void ajout(Seance_Enseignants Seance_Enseignants)
    {
        LesSeances_Enseignants.add(Seance_Enseignants);
    }
    
}
