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
public class Seance_Enseignants {
   int ID_Seance;
   private ArrayList<Integer> ID_Enseignants;
    
  public Seance_Enseignants(int ID_Seance)
  {
      this.ID_Seance = ID_Seance;
  }
  
  public void ajoutEnseignants(int ID_Enseignant)
  {
      this.ID_Enseignants.add(ID_Enseignant);
  }
  public ArrayList getID_Enseignants()
  {
      return this.ID_Enseignants;
  }
  public int ID_Seance(){
      return this.ID_Seance;
  }
}
