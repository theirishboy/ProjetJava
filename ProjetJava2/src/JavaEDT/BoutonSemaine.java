/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaEDT;
//import com.sun.corba.se.impl.io.TypeMismatchException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;

public class BoutonSemaine extends JButton
{
    //Constructeur par défaut utile pour déclarer le tableau de 52 BoutonSemaine
    public BoutonSemaine()
    {
        
    }
    
    //Constructeur surchargé qui prend en paramètre la valeur de la semaine correspondante en string
    public BoutonSemaine(String nb) 
    {
        //Donne la valeur de la semaine comme nom au bouton
        super(nb);
        //On enlève les marges sinon "..." est affiché dans le bouton à la place de la semaine
        this.setMargin(new Insets(0, 0, 0, 0));
    }
    
}

