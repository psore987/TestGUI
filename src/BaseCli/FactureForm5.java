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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FactureForm5 extends JFrame {

	private static final long serialVersionUID = 1L;

	private List<Facture> factures = new ArrayList<>();
	private JComboBox<String> factureComboBox;
	private JButton afficherProduitsButton;
	private Connection connexion; // Champ pour stocker la connexion à la base de données
	private String factureChoisie;
	// JTable
	private JTable listeProduitsArea;
	private JScrollPane scrollPane;


	// constructeur
	public FactureForm5(Connection connection) {

		// présentation générale et comportement de la fenêtre
		super("Mon formulaire");
		this.connexion = connection; // Initialisez la connexion
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 300); // taille absolue de la fenêtre
		this.setLocationRelativeTo(null); // fenêtre centrée par rapport à l'écran

		JPanel panel = new JPanel();

		JLabel titre = new JLabel("Liste des produits par facture");
		titre.setBounds(23, 6, 196, 19);
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
		lab3.setBounds(33, 35, 162, 20);

		// ... puis la liste ....
		factureComboBox = new JComboBox<>();
		factureComboBox.setBounds(205, 35, 104, 21);

		// ... que l'on remplit avec la collection "factures"

		factureComboBox.removeAllItems(); // Pour effacer toutes les anciennes valeurs
		// on remplit la liste avec le numéro des factures et leur date entre parenthèses
		for (Facture facture : factures) {
			String ligne = facture.getIdFac() + " (" + facture.getDateFac() +")";
			factureComboBox.addItem(ligne);
			System.out.println(ligne);
		}


		// Initialisation des composants

		afficherProduitsButton = new JButton("Afficher Produits");
		afficherProduitsButton.setBounds(104, 58, 142, 21);

		// JTable
		listeProduitsArea = new JTable();
		scrollPane = new JScrollPane(listeProduitsArea); // Ajout de cette ligne
		scrollPane.setBounds(23, 91, 322, 129);
		// Utiliser une police à largeur fixe pour JTextArea
		Font fixedWidthFont = new Font("Courier New", Font.PLAIN, 12);
		listeProduitsArea.setFont(fixedWidthFont);

		// Définissez la largeur des colonnes
		//		listeProduitsArea.getColumnModel().getColumn(0).setPreferredWidth(5);  // Colonne 0
		//		listeProduitsArea.getColumnModel().getColumn(1).setPreferredWidth(30);  // Colonne 1
		//		listeProduitsArea.getColumnModel().getColumn(2).setPreferredWidth(5);  // Colonne 2
		//		listeProduitsArea.getColumnModel().getColumn(3).setPreferredWidth(6);  // Colonne 3


		panel.setLayout(null);

		// Ajout des composants à la fenêtre
		panel.add(titre);
		panel.add(lab3);
		panel.add(factureComboBox);
		panel.add(afficherProduitsButton);
		panel.add(scrollPane); 

		// Affichage de la fenêtre
		getContentPane().add(panel);
		setVisible(true);


		// ajout d'un listener pour la liste déroulante
		factureComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				factureChoisie = (String) factureComboBox.getSelectedItem();
				System.out.println("Facture choisie : " + factureChoisie);
			}
		});

		// Ajout d'un écouteur d'événements au bouton
		afficherProduitsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Vérifier si une facture a été sélectionnée
				System.out.println(factureChoisie);
				if (factureChoisie == null) {
					JOptionPane.showMessageDialog(FactureForm5.this, "Veuillez sélectionner une facture.");
					return;
				} else {
					// on crée la liste de produits et on remplit la collection "produits"
					List<Produit> produits = Produit.afficherProduits(connection, factureChoisie);
					// on utilise le modèle de table pour configurer la JTable
					// on met en forme les produits dans "tableprod"
					ProduitTableModel tableProd = new ProduitTableModel(produits);
					// et on affecte ce contenu formaté à la variable JTable
					listeProduitsArea.setModel(tableProd);
				}

			}
		});




	}


public static void main(String[] args) {
	Connection connectionBD = BaseCli.BddUtils.connecterBdd(); // Obtenez la connexion ici
	FactureForm5 form = new FactureForm5(connectionBD);

	BaseCli.BddUtils.fermerBdd(null);
}
}
