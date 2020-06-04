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
public class Cours {
    int ID;
    String nom;
    
    public Cours(int ID, String nom)
    {
        this.ID = ID;
        this.nom = nom;
    }
    public int getID()
    {
        return this.ID;
    }
    public String getNom()
    {
        return this.nom;
    }
}
