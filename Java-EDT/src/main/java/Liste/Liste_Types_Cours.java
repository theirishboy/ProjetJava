/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import Controleur.Type_Cours;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Liste_Types_Cours {
     ArrayList<Type_Cours> LesTypes_Cours;
     public  Liste_Types_Cours()
    {
         LesTypes_Cours = new ArrayList<Type_Cours>();
    }
    public void ajout(Type_Cours Type_Cours)
    {
        LesTypes_Cours.add(Type_Cours);
    }
    
}
