package coursSwing;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormSwing2 extends JFrame{   //héritage de la librairie

	private static final long serialVersionUID = 1L;

	public FormSwing2() { 
		// paramètres généraux de présentation
		super("Mon formulaire"); //on peut appeler le constructeur avec un titre de fenêtre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fermer la fenêtre stoppe le programme
		
		this.setSize(500, 400); // taille fixe
		this.setLocationRelativeTo(null); //fenêtre centrée par rapport au bureau Windows

		// Création du Jpanel : la fenêtre principale du formulaire
		JPanel panel= (JPanel) this.getContentPane();
		getContentPane().setLayout(null); // on n'utilise pas de layout
		
		//Création du titre
		JLabel titre = new JLabel("Formulaire étudiant");
		titre.setBounds(145, 29, 132, 19);
		titre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titre.setBackground(Color.LIGHT_GRAY);
		panel.add(titre);
		
		//Création de l'étiquette nom
		JLabel nom = new JLabel("Nom : ");
		nom.setBounds(50, 60, 60, 45);
		nom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nom.setBackground(Color.LIGHT_GRAY);
		panel.add(nom);
		
		//Création de la zone de texte nom
		JTextField textN = new JTextField();
		textN.setBounds(130, 78, 170, 15);
		panel.add(textN);
		
		
		//Création de l'étiquette prénom
		JLabel pren = new JLabel("Prénom : ");
		pren.setBounds(43, 98, 100, 45);
		pren.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pren.setBackground(Color.LIGHT_GRAY);
		panel.add(pren);
		
		//Création de la zone de texte prénom
		JTextField textP = new JTextField();
		textP.setBounds(130, 115, 170, 15);
		panel.add(textP);

		
		//Création d'un bouton
		JButton button = new JButton("Ajouter");
		button.setBounds(165, 150, 85, 21); // position et taille du bouton
		panel.add(button); //on ajoute le bouton
		
		this.setVisible(true); // car la fenêtre est invisible par défaut
	}


	public static void main(String[] args) { // programme principal
		FormSwing2 form = new FormSwing2();

	}
}