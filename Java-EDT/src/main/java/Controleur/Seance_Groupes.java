/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Seance_Groupes {
    int ID_Seance;
   private ArrayList<Integer> ID_Groupes;
    
    public void Seance_Groupes(int ID_Seance, int ID_Groupe)
    {
        this.ID_Seance = ID_Seance;
    }
    public void ajoutgroupe(int ID_Groupe)
  {
      this.ID_Groupes.add(ID_Groupe);
  }
   public ArrayList getID_Groupes()
  {
      return this.ID_Groupes;
  }
  public int ID_Seance(){
      return this.ID_Seance;
  }
   
    
}
