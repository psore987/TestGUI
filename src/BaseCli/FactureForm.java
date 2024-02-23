package BaseCli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class FactureForm extends JFrame {
	private List<Facture> factures = new ArrayList<>();
	private JComboBox<String> factureComboBox;
	private JButton afficherProduitsButton;
	private JTextArea listeProduitsArea;
	private String factureChoisie;

	public FactureForm() {
		// remplir la comboBox avec la liste des factures ...

		// Initialisation des composants
		factureComboBox = new JComboBox<>();
		afficherProduitsButton = new JButton("Afficher Produits");
		listeProduitsArea = new JTextArea(10, 30);

		// Configuration du gestionnaire de mise en page
		// ...

		// Ajout d'un écouteur d'événements au bouton
		afficherProduitsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// afficherProduits();
			}
		});

		// Ajout des composants à la fenêtre
		// ...

		// Affichage de la fenêtre
		setVisible(true);


	// Vérifier si une facture a été sélectionnée
	if (factureChoisie == null) {
		JOptionPane.showMessageDialog(this, "Veuillez sélectionner une facture.");
		return;
	}

	// Récupérer la liste des produits pour la facture sélectionnée

	// Afficher les produits dans la zone de texte

	//        listeProduitsArea.setText("");
	//        for (String produit : produits) {
	//            listeProduitsArea.append(produit + "\n");
	//        }
	//    }
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new FactureForm());
	}
}
