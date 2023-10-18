package coursSwing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class FormSwing2 extends JFrame{

	private static final long serialVersionUID = 1L;

		public FormSwing2() {
			super("Mon formulaire");
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(300, 200);
			this.setLocationRelativeTo(null);

			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5)); // Même que votre code
			
			JLabel titre = new JLabel("Formulaire Etudiant");
			titre.setBackground(Color.LIGHT_GRAY);
			JLabel lab1 = new JLabel("Nom :");
			JTextField nom = new JTextField(20); // Définissez une largeur pour le champ de texte
			JLabel lab2 = new JLabel("Prénom :");
			JTextField prenom = new JTextField(20); // Définissez une largeur pour le champ de texte
			JButton btn_Ajouter = new JButton("Ajouter");

			panel.add(titre);
			panel.add(lab1);
			panel.add(nom);
			panel.add(lab2);
			panel.add(prenom);
			panel.add(btn_Ajouter);

			// Ajoutez le panneau à la JFrame
			getContentPane().add(panel);

			// Assurez-vous que la fenêtre est visible
			this.setVisible(true);

			btn_Ajouter.addActionListener(e -> {
			    String enteredNom = nom.getText();
			    String enteredPrenom = prenom.getText();
			    String message = "Nom : " + enteredNom + "\nPrénom : " + enteredPrenom;
			    JOptionPane.showMessageDialog(this, message, "Informations", JOptionPane.INFORMATION_MESSAGE);
			});
		}

		public static void main(String[] args) {
			System.out.println("Programme en cours ...");
			FormSwing2 form = new FormSwing2();

		}

	}
