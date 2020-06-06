/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import java.util.*;
import java.text.*;
import java.time.LocalTime;
/**
 *
 * @author gabri
 */
public class Seance {
    int ID;
    int Semaine;
    Date Date;
    
     Date HeureDebut; 
     Date HeureFin ;
    int Etat; // Si 0 en cours de validation, si 1 validée, si 2 refusée
    int ID_Cours;
    int ID_Type;
    String Nom;
    public  Seance(int ID, int Semaine, Date date, Date HeureDebut,Date HeureFin, String Nom,int Etat, int ID_Cours,int ID_Type)
    {
        this.ID = ID;
        this.Semaine = Semaine;
        this.HeureDebut = HeureDebut;
        this.HeureFin = HeureFin;
        this.Etat = Etat;
        this.ID_Cours = ID_Cours;
        this.ID_Type = ID_Type;
        this.Nom = Nom;
        this.Date = date;
    }
     public int getID()
    {
        return this.ID;
    }
     public int getSemaine()
     {
         return this.Semaine;
     }
     public Date getDate()
     {
         return this.Date;
     }  
      public Date getHeureDebut()
     {
         return this.HeureDebut;
     }    
       public Date getHeureFin()
     {
         return this.HeureFin;
     }   
     public int getEtat()
    {
        return this.Etat;
    }
      public int getID_Cours()
    {
        return this.ID_Cours;
    }
       public int getID_Type()
    {
        return this.ID_Type;
    }
      
    
    
}
