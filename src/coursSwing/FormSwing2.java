package coursSwing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormSwing2 extends JFrame{

	private static final long serialVersionUID = 1L;

		public FormSwing2() {
			super("Mon formulaire");
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(300, 200);
			this.setLocationRelativeTo(null);

			JPanel panel = new JPanel();
			
			JLabel titre = new JLabel("Formulaire Etudiant");
			titre.setBounds(90, 29, 132, 19);
			titre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			titre.setBackground(Color.LIGHT_GRAY);
			JLabel lab1 = new JLabel("Nom :");
			lab1.setBounds(32, 66, 48, 13);
			JTextField nom = new JTextField(20); // Définissez une largeur pour le champ de texte
			nom.setBounds(90, 63, 166, 19);
			JLabel lab2 = new JLabel("Prénom :");
			lab2.setBounds(20, 95, 72, 13);
			JTextField prenom = new JTextField(20); // Définissez une largeur pour le champ de texte
			prenom.setBounds(90, 92, 166, 19);
			JButton btn_Ajouter = new JButton("Ajouter");
			btn_Ajouter.setBounds(126, 121, 88, 21);
			panel.setLayout(null);

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
