package coursSwing;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormSwing4 extends JFrame{

	private static final long serialVersionUID = 1L;
	private Connection connexion; // Champ pour stocker la connexion à la base de données

	public FormSwing4(Connection connection) { //constructeur 
		super("Mon formulaire");
		this.connexion = connection; // Initialisez la connexion
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300, 200); // taille absolue de la fenêtre
		this.setLocationRelativeTo(null); //fenêtre centrée par rapport à l'écran

		JPanel panel = new JPanel();

		JLabel titre = new JLabel("Formulaire Etudiant");
		titre.setBounds(80, 10, 180, 20);
		titre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titre.setBackground(Color.GRAY);
		
		JLabel lab1 = new JLabel("Nom :");
		lab1.setBounds(20, 40, 50, 15);
		
		JTextField nom = new JTextField(20);
		nom.setBounds(90, 40, 180, 20);
		
		JLabel lab2 = new JLabel("Prénom :");
		lab2.setBounds(20, 65, 50, 15);
		
		JTextField prenom = new JTextField(20);
		prenom.setBounds(90, 65, 180, 20);
		
		JButton btn_Ajouter = new JButton("Ajouter");
		btn_Ajouter.setBounds(10, 120, 80, 20);
		
		JButton btn_Reset = new JButton("Reset");
		btn_Reset.setBounds(100, 120, 80, 20);
		
		JButton btn_Quitter = new JButton("Quitter");
		btn_Quitter.setBounds(190, 120, 80, 20);
		panel.setLayout(null);
		
		
		panel.add(titre);
		panel.add(lab1);
		panel.add(nom);
		panel.add(lab2);
		panel.add(prenom);
		panel.add(btn_Ajouter);
		panel.add(btn_Reset);
		panel.add(btn_Quitter);
		

		// Ajoutez le panneau à la JFrame
		getContentPane().add(panel);

		// Assurez-vous que la fenêtre est visible
		this.setVisible(true);

		//Listeners
		
		// Appui sur le bouton Ajouter
		btn_Ajouter.addActionListener(e -> {
			String enteredNom = nom.getText();
			String enteredPrenom = prenom.getText();
			String message = "Nom : " + enteredNom + "\nPrénom : " + enteredPrenom;
			//			    JOptionPane.showMessageDialog(this, message, "Informations", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(message);
			Etudiant.ajouterEtudiant(connexion, enteredNom, enteredPrenom);
		});  
		
		// Appui sur le bouton Reset
		btn_Reset.addActionListener(e -> {
			nom.setText(null);
			prenom.setText(null);
		});  
		
		// Appui sur le bouton Quitter
		btn_Quitter.addActionListener(e -> {
			BddUtils.fermerBdd(connexion); // Fermez la connexion à la base de données
	        System.exit(0); // Quittez l'application
		});  

	}

	public static void main(String[] args) {
		Connection connectionBD = BddUtils.connecterBdd(); // Obtenez la connexion ici
		FormSwing4 form = new FormSwing4(connectionBD);

	}

}
