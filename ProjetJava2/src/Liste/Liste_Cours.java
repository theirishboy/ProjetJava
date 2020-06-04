/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Liste;
import Controleur.Cours;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Liste_Cours {
    private ArrayList<Cours> LesCours ;
    
    public  Liste_Cours()
    {
        LesCours = new ArrayList<Cours>();
    }
    public void ajout(Cours moncours)
    {
        LesCours.add(moncours);
    }
}
