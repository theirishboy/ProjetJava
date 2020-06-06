/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaEDT;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Essai1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        String nom = "Marine";
    Panneau fenetreEDT = new Panneau();
    Fenetre fenetre = new Fenetre(fenetreEDT,nom);
    //Recapitulatif fenetreRecap = new Recapitulatif();    
   // Fenetre fenetre = new Fenetre(fenetreRecap);
        /*try 
        {
            FonctionsAdmin admin = new FonctionsAdmin(1);
        }
        catch (ParseException ex) 
        {
            Logger.getLogger(Essai1.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    
  }       
}
