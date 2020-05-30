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
     ArrayList<Utilisateur> LesUtilisateurs;
     public void Liste_Utilisateur()
    {
         LesUtilisateurs = new ArrayList<Utilisateur>();
    }
    public void ajout(Utilisateur Utilisateur)
    {
        LesUtilisateurs.add(Utilisateur);
    }
}
