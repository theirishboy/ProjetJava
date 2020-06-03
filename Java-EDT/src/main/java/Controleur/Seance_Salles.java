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
public class Seance_Salles {

    private ArrayList<Integer> ID_Seances;
    int ID_Salle;

    public Seance_Salles(int ID_Salle) {
        this.ID_Salle = ID_Salle;
    }

    public void ajoutgroupe(int ID_Seance) {
        this.ID_Seances.add(ID_Seance);
    }
      public ArrayList getID_Seances()
  {
      return this.ID_Seances;
  }
  public int ID_Salle(){
      return this.ID_Salle;
  }

}
