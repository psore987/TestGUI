package BaseCli;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FactureForm1 extends JFrame {

	private static final long serialVersionUID = 1L;

	private List<Facture> factures = new ArrayList<>();
	private JComboBox<String> factureComboBox;
	private JButton afficherProduitsButton;
	private JTextArea listeProduitsArea;
	private Connection connexion; // Champ pour stocker la connexion à la base de données
	private String factureChoisie;

	// constructeur
	public FactureForm1(Connection connection) {

		// présentation générale et comportement de la fenêtre
		super("Mon formulaire");
		this.connexion = connection; // Initialisez la connexion
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 300); // taille absolue de la fenêtre
		this.setLocationRelativeTo(null); // fenêtre centrée par rapport à l'écran

		JPanel panel = new JPanel();

		JLabel titre = new JLabel("Liste des produits par facture");
		titre.setBounds(120, 10, 250, 20);
		titre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titre.setBackground(Color.GRAY);

		// remplir la comboBox avec la liste des factures ...

		Statement statement = null;
		String sql = "SELECT * FROM factures";
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			// les données sont récupérées dans le "resultset", il faut compléter la
			// collection "Factures"
			while (resultSet.next()) {
				String numFac = resultSet.getString("Num_Fac");
				Date dateFac = resultSet.getDate("Date_Fac");
				Facture facture = new Facture(numFac, dateFac.toString());
				factures.add(facture);
			}
			// la collection "factures" est complète !
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// on affiche le label ...
		JLabel lab3 = new JLabel("Choisissez la facture : ");
		lab3.setBounds(20, 90, 150, 15);

		// ... puis la liste ....
		factureComboBox = new JComboBox<>();
		factureComboBox.setBounds(180, 90, 180, 20);

		// ... que l'on remplit avec la collection "factures"


		// Initialisation des composants

		afficherProduitsButton = new JButton("Afficher Produits");
		listeProduitsArea = new JTextArea(10, 30);

		// Configuration du gestionnaire de mise en page
		// ...

		// ajout d'un listener pour la liste déroulante
			
		// Ajout d'un écouteur d'événements au bouton
		afficherProduitsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//				afficherProduits();
			}
		});

		// Ajout des composants à la fenêtre
		panel.add(titre);
		panel.add(lab3);
		panel.add(factureComboBox);
		panel.add(afficherProduitsButton);
		panel.add(listeProduitsArea);

		// Affichage de la fenêtre
		add(panel);
		setVisible(true);


		// Vérifier si une facture a été sélectionnée
		if (factureChoisie == null) {
			JOptionPane.showMessageDialog(this, "Veuillez sélectionner une facture.");
			return;
		}

	
	}

	public static void main(String[] args) {
		Connection connectionBD = BaseCli.BddUtils.connecterBdd(); // Obtenez la connexion ici
		FactureForm1 form = new FactureForm1(connectionBD);

		BaseCli.BddUtils.fermerBdd(null);
	}
}
