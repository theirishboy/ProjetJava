/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import Controleur.Promotion;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Liste_Promotions {
    ArrayList<Promotion> LesPromotions;
     public  Liste_Promotions()
    {
         LesPromotions = new ArrayList<Promotion>();
    }
    public void ajout(Promotion Promotion)
    {
        LesPromotions.add(Promotion);
    }
}
