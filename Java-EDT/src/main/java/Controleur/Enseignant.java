/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

/**
 *
 * @author gabri
 */
public class Enseignant extends Utilisateur {
    
    int ID_Cours;
    public void Enseignant(int ID_Utilisateur, int ID_Groupe, String Email, String nom, String Prenom)
    {
        this.ID = ID_Utilisateur;
        this.Email = Email;
        this.Nom = nom;
        this.Prenom = Prenom;
        this.Droit = 3;
    }
   
    
}
