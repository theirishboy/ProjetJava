/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import Controleur.Utilisateur;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Liste_Utilisateurs {
     public                                                                                                                                                                                         ArrayList<Utilisateur> LesUtilisateurs;
     public  Liste_Utilisateurs()
                                                                                    {
                                                                                         LesUtilisateurs = new ArrayList<Utilisateur>();
    }
    public void ajout(Utilisateur User)
    {
        
        LesUtilisateurs.add(User);
    }
    public int size()
    {
        return LesUtilisateurs.size();
    }
}
