package testSwing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.Font;

public class Formulaire extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Formulaire() {
		super("Mon formulaire"); //on peut appeler le constructeur avec un titre de fenêtre
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().setBackground(new Color(0, 128, 128));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true); // car la fenêtre est invisible par défaut
		this.setSize(400, 600); // taille fixe
		this.setLocationRelativeTo(null); //fenêtre centrée par rapport au bureau Windows
		
		JPanel panel= (JPanel) this.getContentPane();
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel label = new JLabel("Ceci est le titre de mon formulaire");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		JButton button = new JButton("Push me !");
		panel.add(button); //on ajoute un bouton
		JTextArea textArea = new JTextArea("Push me 2Push me 2Push me 2Push me 2Push me 2Push me 2Push me 2");
		panel.add(textArea); //on ajoute un bouton
		JTextField textField = new JTextField("Push me 3");
		panel.add(textField); //on ajoute un bouton
		JButton button_1 = new JButton("Push me 5");
		panel.add(button_1); //on ajoute un bouton
		JButton button_2 = new JButton("Push me 6");
		panel.add(button_2); //on ajoute un bouton
		JCheckBox checkBox = new JCheckBox("Push me 4");
		panel.add(checkBox); //on ajoute un bouton
		
		
	}


}
