/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaEDT;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class EDT extends JFrame{
    private JTextField email, mdp;
    private JLabel login,connect, Labelemail, Labelmdp;
    
    public EDT(){
    this.setTitle("Mon emploi du temps");
    this.setSize(800, 300);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel1 = new JPanel();
    panel1.setBackground(Color.ORANGE);
    this.setContentPane(panel1);
    JPanel panel2 = new JPanel();
    panel2.setBackground(Color.RED);
    this.setContentPane(panel2);
    
    
    this.setVisible(true);
    }
}
