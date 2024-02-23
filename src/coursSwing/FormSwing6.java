package coursSwing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FormSwing6 extends JFrame{

	private static final long serialVersionUID = 1L;
	private Connection connexion; // Champ pour stocker la connexion à la base de données
	private String choix_Combo;
	PreparedStatement preparedStatement = null;
	
	public FormSwing6(Connection connection) { //constructeur 
		super("Mon formulaire");
		this.connexion = connection; // Initialisez la connexion
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300, 200); // taille absolue de la fenêtre
		this.setLocationRelativeTo(null); //fenêtre centrée par rapport à l'écran

		JPanel panel = new JPanel();

		JLabel titre = new JLabel("Formulaire Etudiant");
		titre.setBounds(120, 10, 180, 20);
		titre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titre.setBackground(Color.GRAY);
		
		//Sexe
		JRadioButton masculinRadioButton = new JRadioButton("M");
		JRadioButton femininRadioButton = new JRadioButton("F");

		ButtonGroup sexeButtonGroup = new ButtonGroup();
		sexeButtonGroup.add(masculinRadioButton);
		sexeButtonGroup.add(femininRadioButton);

		
		// Nom
		JLabel lab1 = new JLabel("Nom :");
		lab1.setBounds(20, 40, 60, 15);
		
		JTextField nom = new JTextField(20);
		nom.setBounds(90, 40, 180, 20);
		
		// Prénom
		JLabel lab2 = new JLabel("Prénom :");
		lab2.setBounds(20, 65, 60, 15);
		
		JTextField prenom = new JTextField(20);
		prenom.setBounds(90, 65, 180, 20);
		
		// Liste déroulante classes 
		
		// Récupérer les données de la table Classe depuis la base de données dans une collection "classes"
		List<Classe> classes = new ArrayList<>();
		 // Requête SQL avec un PreparedStatement
		Statement statement = null;
		String sql = "SELECT * FROM Classe";
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			// les données sont récupérées dans le "resultset", il faut compléter la collection "classes"
			while (resultSet.next()) {
		        String idClasse = resultSet.getString("idClasse");
		        String libClasse = resultSet.getString("Libclasse");
		        Classe classe = new Classe(idClasse, libClasse);
		        classes.add(classe); }
			// la collection "classes" est complète ! 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// on affiche le label ...		
		JLabel lab3 = new JLabel("Classe : ");
		lab3.setBounds(20, 90, 60, 15);
		
		// ... puis la liste ....
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(90,90,180,20);
		
		// ... que l'on remplit avec la collection "classes"

		comboBox.removeAllItems(); // Pour effacer toutes les anciennes valeurs
		// on remplit la liste avec le libellé des classes
		for (Classe classe : classes) {
			comboBox.addItem(classe.getLibClasse());
		}

		// boutons
		JButton btn_Ajouter = new JButton("Ajouter");
		btn_Ajouter.setBounds(10, 120, 80, 20);
		
		JButton btn_Reset = new JButton("Reset");
		btn_Reset.setBounds(100, 120, 80, 20);
		
		JButton btn_Quitter = new JButton("Quitter");
		btn_Quitter.setBounds(190, 120, 80, 20);
		panel.setLayout(null);
		
		// Ajouter les composants au panel
		panel.add(titre);
		panel.add(lab1);
		panel.add(nom);
		panel.add(lab2);
		panel.add(prenom);
		panel.add(lab3);
		panel.add(comboBox);
		panel.add(btn_Ajouter);
		panel.add(btn_Reset);
		panel.add(btn_Quitter);
		

		// Ajoutez le panneau à la JFrame
		getContentPane().add(panel);
		
		// Assurez-vous que la fenêtre est visible
		this.setVisible(true);

		//Listeners
		
		// Liste déroulante Classe
		comboBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // on récupère l'index de la ligne choisie
		        int selectedIndex = comboBox.getSelectedIndex();
		        
		        // Si aucune classe n'est sélectionnée, l'index sera à -1
		        if (selectedIndex != -1) {
		            // On récupère l'élément Classe correspondant à l'index sélectionné
		            Classe selectedClasse = classes.get(selectedIndex);
		            
		            // Maintenant,  on peut accéder à l'idClasse
		            choix_Combo = selectedClasse.getIdClasse();
		            
		            System.out.println("ID de la classe : " + choix_Combo);
		        }
		    }
		});

		// Appui sur le bouton Ajouter
		btn_Ajouter.addActionListener(e -> {
			String enteredNom = nom.getText();
			String enteredPrenom = prenom.getText();
			String message = "Nom : " + enteredNom + "\nPrénom : " + enteredPrenom;
			System.out.println(message);
			Etudiant.ajouterEtudiant(connexion, enteredNom, enteredPrenom,choix_Combo);
		});  
		
		// Appui sur le bouton Reset
		btn_Reset.addActionListener(e -> {
			nom.setText(null);
			prenom.setText(null);
			choix_Combo = "";
		});  
		
		// Appui sur le bouton Quitter
		btn_Quitter.addActionListener(e -> {
			BddUtils.fermerBdd(connexion); // Fermez la connexion à la base de données
	        System.exit(0); // Quittez l'application
		});  

	}

	public static void main(String[] args) {
		Connection connectionBD = BddUtils.connecterBdd(); // Obtenez la connexion ici
		FormSwing6 form = new FormSwing6(connectionBD);

	}
	}
