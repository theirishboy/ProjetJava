/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import Controleur.Seance_Groupes;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Liste_Seances_Groupes {
    ArrayList<Seance_Groupes> LesSeance_Groupes;
     public void Liste_Seances_Groupes()
    {
         LesSeance_Groupes = new ArrayList<Seance_Groupes>();
    }
    public void ajout(Seance_Groupes Seance_Groupes)
    {
        LesSeance_Groupes.add(Seance_Groupes);
    }
}
