/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import Controleur.Groupe;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Liste_Groupes {
    
   public ArrayList<Groupe> LesGroupes;
     public Liste_Groupes()
    {
         LesGroupes = new ArrayList<Groupe>();
    }
    public void ajout(Groupe Groupe1)
    {
        LesGroupes.add(Groupe1);
    }
    public int size()
    {
        return LesGroupes.size();
    }
}
