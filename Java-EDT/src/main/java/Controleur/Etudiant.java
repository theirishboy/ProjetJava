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

    public Etudiant(int ID_Utilisateur, int ID_Groupe,int Numéro, String Email,String PASSWD, String Nom, String Prenom, int Droit)
    {
       super(ID_Utilisateur,Email,PASSWD,Nom,Prenom,Droit);


        this.ID_Groupe = ID_Groupe;
        this.ID = ID_Utilisateur;
        this.Email = Email;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Droit = 4;
        this.numéro = Numéro;

    }
 
    
}
