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

public class Connexion extends JFrame {
    
    private JTextField email, mdp;
    private JLabel login,connect, Labelemail, Labelmdp;
    
    public Connexion(){
    //Color cool = new Color(199, 254, 235);
    Color cool = new Color(195, 195, 195); 
        
    this.setTitle("Connexion");
    this.setSize(400, 300);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    Font police = new Font("Arial", Font.BOLD, 15);
    
    JPanel panellogin = new JPanel();
    panellogin.setBackground(cool);
    panellogin.setPreferredSize(new Dimension(170, 60)); 
    //Icône Login
    login = new JLabel(new ImageIcon("IconeLogin.png"));
    panellogin.add(login);
    
    JPanel panelhaut = new JPanel();
    panelhaut.setBackground(cool);
    panelhaut.setPreferredSize(new Dimension(170, 60));
    connect = new JLabel("Connectez-vous !");
    connect.setFont(police);
    panelhaut.add(connect);
    
    JPanel panel = new JPanel();
    
    JPanel panelEmail = new JPanel();
    panelEmail.setBackground(cool);
    panelEmail.setPreferredSize(new Dimension(220, 30));
    email = new JTextField();
    email.setPreferredSize(new Dimension(150, 25));
    Labelemail = new JLabel("Email : ");
    Labelemail.setFont(police);
    panelEmail.add(Labelemail, BorderLayout.CENTER);
    panelEmail.add(email);
    
    JPanel panelMDP = new JPanel();
    panelMDP.setBackground(cool);
    panelMDP.setPreferredSize(new Dimension(220, 30));
    mdp = new JTextField();
    mdp.setPreferredSize(new Dimension(90, 25));
    Labelmdp = new JLabel("Mot de passe : ");
    Labelmdp.setFont(police);
    panelMDP.add(Labelmdp);
    panelMDP.add(mdp);
    
    panel.setBackground(cool);
    panel.add(panelEmail);
    panel.add(panelMDP);
    
    JPanel panelbas = new JPanel();
    panelbas.setBackground(cool);
    panelbas.setPreferredSize(new Dimension(220, 60));
    JButton okBouton = new JButton("Connexion");
    panelbas.add(okBouton);
    
    this.getContentPane().add(panellogin);
    this.getContentPane().add(panelhaut, BorderLayout.NORTH);
    this.getContentPane().add(panel, BorderLayout.CENTER);
    this.getContentPane().add(panelbas, BorderLayout.SOUTH);
    this.setVisible(true);
    }
    
    private class ConnectButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent i) {
            
        }
    }
}
