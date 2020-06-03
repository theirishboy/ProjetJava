/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import Controleur.Enseignant;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Liste_Enseignants {
     private ArrayList<Enseignant> LesEnseignants ;
    
    public Liste_Enseignants()
    {
        LesEnseignants = new ArrayList<Enseignant>();
    }
    public void ajout(Enseignant Enseignant1)
    {
        LesEnseignants.add(Enseignant1);
    }
}
