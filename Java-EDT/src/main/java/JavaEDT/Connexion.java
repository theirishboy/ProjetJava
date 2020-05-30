/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaEDT;
import java.awt.*;
import javax.swing.*;

public class Connexion extends JFrame{
    Color couleur = new Color(196, 196, 196);
    private JLabel logo, login,connect, Labelemail, Labelmdp = new JLabel();
    private JTextField email, mdp;
    private JPanel panellogin = new JPanel();
    
    public Connexion(){
        this.setTitle("Connexion");

        // Mettre en plein écran automatiquement
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        Font police1 = new Font("Arial", Font.BOLD, 25);
        Font police2 = new Font("Arial", Font.BOLD, 15);
        
        //Container principal
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        
        //Zone du logo
        JPanel paneltop = new JPanel();
        paneltop.setLayout(new BorderLayout());
        paneltop.setBackground(couleur);
        paneltop.setPreferredSize(new Dimension(800, 300)); 
        
        logo = new JLabel(new ImageIcon("logo_ece.png"));
        
        JPanel panIcon = new JPanel();
        panIcon.setBackground(couleur);
        panIcon.setLayout(new BorderLayout());
        panIcon.add(logo);
        
        paneltop.add(panIcon, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(350, 90));
        
        //Zone du Connectez-vous !
        JPanel panelhaut = new JPanel();
        panelhaut.setBackground(couleur);
        panelhaut.setPreferredSize(new Dimension(170, 100));
        connect = new JLabel("Bienvenue sur votre Hyperplanning. Connectez-vous !");
        connect.setFont(police1);
        panelhaut.add(connect);
           
        //Zone de l'email
        JPanel panelEmail = new JPanel();
        panelEmail.setBackground(couleur);
        panelEmail.setPreferredSize(new Dimension(220, 30));
        email = new JTextField();
        email.setPreferredSize(new Dimension(150, 25));
        Labelemail = new JLabel("Email : ");
        Labelemail.setFont(police2);
        panelEmail.add(Labelemail, BorderLayout.CENTER);
        panelEmail.add(email);
        
        //Zone du mot de passe
        JPanel panelMDP = new JPanel();
        panelMDP.setBackground(couleur);
        panelMDP.setPreferredSize(new Dimension(220, 30));
        mdp = new JTextField();
        mdp.setPreferredSize(new Dimension(90, 25));
        Labelmdp = new JLabel("Mot de passe : ");
        Labelmdp.setFont(police2);
        panelMDP.add(Labelmdp);
        panelMDP.add(mdp);

        JPanel panelinfo = new JPanel();
        panelinfo.setPreferredSize(new Dimension(220, 70));
        panelinfo.setBackground(couleur);
        panelinfo.add(panelEmail, BorderLayout.NORTH);
        panelinfo.add(panelMDP, BorderLayout.CENTER);
        
        panel.setBackground(couleur);
        panel.add(panelhaut, BorderLayout.NORTH);
        panel.add(panelinfo, BorderLayout.CENTER);


        //Zone du bouton connexion
        JPanel panelbas = new JPanel();
        panelbas.setBackground(couleur);
        panelbas.setPreferredSize(new Dimension(220, 100));
        JButton okBouton = new JButton("Connexion");
        panelbas.add(okBouton);
        
        container.setBackground(couleur);
        container.add(paneltop, BorderLayout.NORTH);
        container.add(panel, BorderLayout.CENTER);
        container.add(panelbas, BorderLayout.SOUTH);
        this.setContentPane(container);
        this.setVisible(true);
        
        
    }    
}