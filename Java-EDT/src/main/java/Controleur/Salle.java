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
public class Salle {
    int ID;
    String nom;
    int Capacite;
    int ID_Site;
    
    public void Salle(int ID, String nom, int Capacite, int ID_Site)
    {
        this.ID = ID;
        this.nom = nom;
        this.Capacite = Capacite;
        this.ID_Site = ID_Site;
    }
     public int getID()
    {
        return this.ID;
    }
     public String getNom()
    {
        return this.nom;
    }
     public int getCapacite()
     {
         return this.Capacite;
     }
     public int ID_Site()
     {
         return this.ID_Site;
     }
    
}
