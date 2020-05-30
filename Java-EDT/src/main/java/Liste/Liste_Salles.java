/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import Controleur.Salle;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Liste_Salles {
    ArrayList<Salle> LesSalles;
     public void Liste_Salles()
    {
         LesSalles = new ArrayList<Salle>();
    }
    public void ajout(Salle Salle)
    {
        LesSalles.add(Salle);
    }
    
}
