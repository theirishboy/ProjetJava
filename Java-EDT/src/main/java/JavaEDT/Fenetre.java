/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaEDT;
import java.awt.*;
import javax.swing.*;

public class Fenetre extends JFrame {
  
  Color couleur = new Color(96, 96, 96);
  private JPanel container = new JPanel();
  private JPanel pan = new Panneau();
  private JComboBox combo1 = new JComboBox();
  private JComboBox combo2 = new JComboBox();
  private JButton bouton1 = new JButton();
  
  public Fenetre(){
    this.setTitle("Mon emploi du temps");
    
    // Mettre en plein écran automatiquement
    this.pack();
    this.setDefaultLookAndFeelDecorated(true);
    this.setExtendedState(this.MAXIMIZED_BOTH);
    
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

    container.setBackground(Color.ORANGE);
    container.setLayout(new BorderLayout());
    container.add(pan, BorderLayout.CENTER);
    
    JPanel top = new JPanel();
    top.setBackground(couleur);
    top.add(combo1, BorderLayout.WEST);
    combo1.addItem("Mon emploi du temps 1");
    combo1.addItem("Mon emploi du temps 2");
    combo1.addItem("Mon emploi du temps 3");
    
    top.add(combo2, BorderLayout.EAST);
    combo2.addItem("Mes statistiques");
    combo2.addItem("Mes récapitulatifs de cours");
    
    JButton bouton1 = new JButton("Salles libres");
    top.add(bouton1, BorderLayout.EAST);
    
    container.add(top, BorderLayout.NORTH);
    this.setContentPane(container);
    this.setVisible(true);
    
  }
}
