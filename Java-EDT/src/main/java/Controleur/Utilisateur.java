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
public class Utilisateur {
     int ID; 
     String Email;
     String Password;
     String Nom;
     String Prenom;
     int Droit;
     
     public Utilisateur(int ID,String Email,String Password, String Nom, String Prenom,int Droit)
     {
         this.ID = ID;
         this.Email = Email;
         this.Password = Password;
         this.Nom = Nom;
         this.Prenom = Prenom;
         this.Droit = Droit;
     }

  
     public int getID()
    {
        return this.ID;
    }
      public int getDroit()
    {
        return this.Droit;
    }
       public String getEmail()
    {
        return this.Email;
    }
        public String getNom()
    {
        return this.Nom;
    }
    public String getPrenom()
    {
        return this.Prenom;
    }
    
}
