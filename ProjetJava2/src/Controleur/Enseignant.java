/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Liste.Liste_Cours;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Enseignant extends Utilisateur {
    
     private Liste_Cours mescours;
    public  Enseignant(int ID_Utilisateur, String Email, String Nom, String Prenom,String PASSWD,int Droit)
    {
        super(ID_Utilisateur,Email,PASSWD,Nom,Prenom,Droit);
        this.ID = ID_Utilisateur;
        this.Email = Email;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Droit = 3;
    }
   
    
}
