/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import Controleur.Etudiant;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Liste_Etudiants {
    ArrayList<Etudiant> LesEtudiants;
     public Liste_Etudiants()
    {
         LesEtudiants = new ArrayList<Etudiant>();
    }
    public void ajout(Etudiant Etudiant1)
    {
        LesEtudiants.add(Etudiant1);
    }
    
}
