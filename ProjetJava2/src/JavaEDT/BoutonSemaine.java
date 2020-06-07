/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaEDT;
//import com.sun.corba.se.impl.io.TypeMismatchException;
import BDD.ConnexionBDD;
import Controleur.Utilisateur;
import java.awt.*;
import java.awt.event.*;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class BoutonSemaine extends JButton
{
    //Boolean appui qui va permettre de savoir quel BoutonSemiane est appuyé actuellement
    private boolean appui;
    //Constructeur par défaut utile pour déclarer le tableau de 52 BoutonSemaine
    public BoutonSemaine()
    {
        appui = false;
    }
    
    //Constructeur surchargé qui prend en paramètre la valeur de la semaine correspondante en string
    public BoutonSemaine(String nb) 
    {
        //Donne la valeur de la semaine comme nom au bouton
        super(nb);
        //On enlève les marges sinon "..." est affiché dans le bouton à la place de la semaine
        this.setMargin(new Insets(0, 0, 0, 0));

    }
    
    //Retourne la valeur du boolean appui
    public boolean getAppui()
    {
        return appui;
    }
    
    //Méthode qui change la valeur du boolean appui
    public void setAppui(boolean change)
    {
        if(change == true)
        {
            appui = false;
        }
        else
        {
            appui = true;
        }
    }
    
    public void paintComponent(Graphics g)
    {
        //Peint le fond du bouton
        super.paintComponent(g);
        //Donne la couleur du bouton, ici la même que celle du background
	g.setColor(Color.WHITE);
        //Variable qui sera utilisée pour faire la forme du fond
	Rectangle forme= new Rectangle();
        //On crée un bouton abstrait qui va avir les mêmes caractéristiues que notre bouton
	AbstractButton bouton = (AbstractButton) this ;
        //On donne à la forme du bouton la même forme que le bouton de base
	Insets i =  getInsets();
	forme.x = i.left;
        forme.y = i.top;
        forme.width = bouton.getWidth() - (i.right + forme.x);
        forme.height = bouton.getHeight() - (i.bottom +forme.y);
        //On dessine le rectangle
	g.fillRect(forme.x, forme.y, forme.width, forme.height);
 
	//Variable qui contient le texte du bouton
	String t = getText();
        //Variable qui contient le Font du bouton
	Font f = g.getFont();
        //Variable qui contient la taille du texte du bouton
	FontMetrics metrics = g.getFontMetrics(f);
        //On crée un rectangle fictif qui va contenir le texte
	java.awt.geom.Rectangle2D s = metrics.getStringBounds(t,g);
        //On centre le texte
 	forme=g.getClipBounds();	
	int x=0, y = 0; 
	if (s.getWidth() < forme.width) x = forme.x + (forme.width - (int)s.getWidth() )/2;
	if (s.getHeight() < forme.height) y = forme.y + forme.height - (forme.height -(int)s.getHeight())/2 ;
        //On écrit le texte en noir
	g.setColor(getForeground());
 
        //On écrit le texte
	g.drawString(t, x, y-4);
    }

   
}

