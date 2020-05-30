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
public class Promotion {
    int ID;
    int Nom;
    
    public void Promotion(int ID,int nom)
    {
        this.ID = ID;
        this.Nom = nom;
    }
    
     public int getID()
    {
        return this.ID;
    }
     public int getNom()
    {
        return this.Nom;
    }
}
