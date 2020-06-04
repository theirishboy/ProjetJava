/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import Controleur.Site;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Liste_Sites {
    ArrayList<Site> LesSites;
     public  Liste_Sites()
    {
         LesSites = new ArrayList<Site>();
    }
    public void ajout(Site Site)
    {
        LesSites.add(Site);
    }
    
}
