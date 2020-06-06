/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import BDD.ConnexionBDD;
import Liste.Liste_Cours;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author gabri
 */
public class Enseignant extends Utilisateur {
    
     private Liste_Cours mescours;
     private ConnexionBDD maconnexion;
     private final Connection conn;
     private final Statement stmt, stmt2, stmt3;
     private ResultSet rset;
     private int Cours;
     
        
    public Liste_Cours getCours(){
        return this.mescours;
    }
    
    public int getMatière(){
        return this.Cours;
    }
    
    public  Enseignant(int ID_Utilisateur, String Email, String Nom, String Prenom,String PASSWD,int Droit) throws SQLException, ClassNotFoundException
    {
        super(ID_Utilisateur,Email,PASSWD,Nom,Prenom,Droit);
        this.ID = ID_Utilisateur;
        this.Email = Email;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Droit = 3;
        
        ResultSet result2;
        
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/edt";
        conn = DriverManager.getConnection(url, "root", "");
        stmt = conn.createStatement();
        stmt2 = conn.createStatement();
        stmt3 = conn.createStatement();
        String sql1 = "SELECT ID_Cours FROM `enseignant` WHERE ID_Utilisateur = 18";
       

        ResultSet result1 = stmt.executeQuery(sql1);
      
        int sommecours=0;
        int sommeSeance=0;
        int sommemat2=0;
        int sommemat3=0;
        
        while(result1.next()){
            Cours = result1.getInt(1); //tous les cours
            
            String sql2 = "SELECT ID_Cours FROM `seance` WHERE ID_Cours = '"+Cours+"'";
            result2 = stmt2.executeQuery(sql2);
            
            while(result2.next()){
            int ID_Seance = result2.getInt(1); //toutes les séances
            sommeSeance++;
                    
        }
        /*String sql3 = "SELECT Nom FROM `cours` WHERE ID = '"+Cours+"'";
        ResultSet result3 = stmt3.executeQuery(sql2);
        String nomCours = result3.getString(Cours);
        
        System.out.println("Hey" + nomCours);*/
        sommecours++;          
        System.out.println("matiere total:"+sommecours);
        System.out.println("Cours --> "+Cours+" total de séances : "+sommeSeance);
        sommeSeance=0;
 
        }
                    
       // System.out.println("nombre de cours :"+sommecours);
        //System.out.println("Matiere 1:"+sommemat1);
        
       
        
        
        
    }

   
    
}
