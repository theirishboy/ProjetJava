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
public class Etudiant extends Utilisateur {

    int numéro;
    int ID_Groupe;
    public void Etudiant(int ID_Utilisateur, int ID_Groupe, String Email, String nom, String Prenom)
    {
        this.ID = ID_Utilisateur;
        this.Email = Email;
        this.Nom = nom;
        this.Prenom = Prenom;
        this.Droit = 4;

    }
 
    
}
