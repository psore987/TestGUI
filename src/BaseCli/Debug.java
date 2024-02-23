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

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Debug extends JFrame {

	private static final long serialVersionUID = 1L;

	private Connection connexion; // Champ pour stocker la connexion à la base de données
	private String factureChoisie;
	// JTable
	private static JTable listeProduitsArea;
	private JScrollPane scrollPane;


	// constructeur
	public Debug(Connection connection) {

		// présentation générale et comportement de la fenêtre
		super("Mon formulaire");
		setTitle("Facture");
		this.connexion = connection; // Initialisez la connexion
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(547, 381); // taille absolue de la fenêtre
		this.setLocationRelativeTo(null); // fenêtre centrée par rapport à l'écran

		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));

		JLabel titre = new JLabel("Liste des produits par facture");
		titre.setBounds(87, 21, 254, 19);
		titre.setFont(new Font("Times New Roman", Font.BOLD, 17));
		titre.setBackground(new Color(0, 255, 255));

		// Initialisation des composants

		// JTable

		listeProduitsArea = new JTable();
		scrollPane = new JScrollPane(listeProduitsArea); // Ajout de cette ligne
		scrollPane.setBounds(23, 153, 481, 151);
		// Utiliser une police à largeur fixe pour JTextArea
		Font fixedWidthFont = new Font("Courier New", Font.PLAIN, 12);
		listeProduitsArea.setFont(fixedWidthFont);

		panel.setLayout(null);

		panel.add(scrollPane); 

		setVisible(true);

		// Affichage de la fenêtre
		getContentPane().add(panel);

		remplirTable(connection,"2");
	}

		public static void remplirTable(Connection connect, String numfac) {

			// on crée la liste de produits et on remplit la collection "produits"
			List<Produit> produits = Produit.afficherProduits(connect, numfac);
			// on utilise le modèle de table pour configurer la JTable
			// on met en forme les produits dans "tableprod"
			ProduitTableModel tableProd = new ProduitTableModel(produits);
			// et on affecte ce contenu formaté à la variable JTable
			listeProduitsArea.setModel(tableProd);

			// Définissez la largeur des colonnes
			listeProduitsArea.getColumnModel().getColumn(0).setPreferredWidth(40); // Colonne 0
			listeProduitsArea.getColumnModel().getColumn(1).setPreferredWidth(250); // Colonne 1
			listeProduitsArea.getColumnModel().getColumn(2).setPreferredWidth(50); // Colonne 2
			listeProduitsArea.getColumnModel().getColumn(3).setPreferredWidth(90); // Colonne 3

			// Utiliser une police à largeur fixe pour JTextArea
			Font fixedWidthFont = new Font("Courier New", Font.PLAIN, 12);
			listeProduitsArea.setFont(fixedWidthFont);



			// Ajouter la colonne de boutons de suppression
			new ButtonColumn(listeProduitsArea, 4, new AbstractAction() {
				private static final long serialVersionUID = 1L;
				// et ce qui se passe lorsqu'on appuie sur le bouton 
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Bouton supprimé appuyé");
					int modelRow = Integer.valueOf(e.getActionCommand());
					((ProduitTableModel) listeProduitsArea.getModel()).removeProduit(modelRow);
				}
			});

			// Assurez-vous que la JTable est bien rafraîchie après l'ajout de la colonne de boutons
			System.out.println("je rafraîchis la Jtable");
			listeProduitsArea.repaint();

		}

	public static void main(String[] args) {
		Connection connectionBD = BaseCli.BddUtils.connecterBdd(); // Obtenez la connexion ici
		Debug form = new Debug(connectionBD);

		BaseCli.BddUtils.fermerBdd(null);
	}
}
