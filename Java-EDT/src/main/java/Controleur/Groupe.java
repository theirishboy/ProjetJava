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
public class Groupe {
    int ID;
    String nom;
    int ID_Promotion;
    
    public void Groupe(int ID, String nom, int ID_Promotion)
    {
        this.ID = ID;
        this.nom = nom;
        this.ID_Promotion = ID_Promotion;
    }
     public int getID()
    {
        return this.ID;
    }
     public String getNom()
    {
        return this.nom;
    }
     public int getID_Promotion()
     {
         return this.ID_Promotion;
     }
    
}
