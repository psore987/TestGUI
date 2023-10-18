package coursSwing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormSwing1 extends JFrame{

	private static final long serialVersionUID = 1L;

	public FormSwing1() { 
		// paramètres généraux de présentation
		super("Mon formulaire"); //on peut appeler le constructeur avec un titre de fenêtre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fermer la fenêtre stoppe le programme
		this.setVisible(true); // car la fenêtre est invisible par défaut
		this.setSize(300, 200); // taille fixe
		this.setLocationRelativeTo(null); //fenêtre centrée par rapport au bureau Windows

		// Création du Jpanel : la fenêtre principale du formulaire
		JPanel panel= (JPanel) this.getContentPane();
		getContentPane().setLayout(null); // on n'utilise pas de layout
	
		JButton button = new JButton("Bouton");
		button.setBounds(118, 66, 85, 21); // position et taille du bouton
		panel.add(button); //on ajoute le bouton
		
	}

	public static void main(String[] args) {
		FormSwing1 form = new FormSwing1();

	}

}
