package coursSwing;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormSwing extends JFrame{

	private static final long serialVersionUID = 1L;

	public FormSwing() { 
		// paramètres généraux de présentation
		super("Mon formulaire"); //on peut appeler le constructeur avec un titre de fenêtre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fermer la fenêtre stoppe le programme
		this.setVisible(true); // car la fenêtre est invisible par défaut
		this.setSize(300, 200); // taille fixe
		this.setLocationRelativeTo(null); //fenêtre centrée par rapport au bureau Windows

		// Création du Jpanel : la fenêtre principale du formulaire
		JPanel panel= (JPanel) this.getContentPane();
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		JButton button = new JButton("Bouton");
		panel.add(button); //on ajoute un bouton
		
	}

	public static void main(String[] args) {
		FormSwing form = new FormSwing();

	}

}
