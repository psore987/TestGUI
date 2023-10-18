package testSwing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class MyFrame2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txNom;
	private JTextField txtPrenom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame2 frame = new MyFrame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txNom = new JTextField();
		txNom.setBounds(100, 65, 174, 19);
		contentPane.add(txNom);
		txNom.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Etudiant");
		lblNewLabel.setBounds(144, 10, 103, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom : ");
		lblNewLabel_1.setBounds(27, 68, 80, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prénom :");
		lblNewLabel_2.setBounds(27, 101, 80, 13);
		contentPane.add(lblNewLabel_2);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(100, 98, 174, 19);
		contentPane.add(txtPrenom);
		
	
		DefaultListModel<String> listModel = new DefaultListModel<>();
		listModel.addElement("Valeur 1");
		listModel.addElement("Valeur 2");
		listModel.addElement("Valeur 3");
		listModel.addElement("Valeur 4");
		listModel.addElement("Valeur 5");
		listModel.addElement("Valeur 6");
		
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
		for (int i = 0; i < listModel.getSize(); i++) {
		    comboBoxModel.addElement(listModel.getElementAt(i));
		}

		JComboBox<String> comboBox = new JComboBox<>(comboBoxModel);

		comboBox.setBounds(257, 127, 118, 19);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Classe :");
		lblNewLabel_3.setBounds(27, 129, 45, 13);
		contentPane.add(lblNewLabel_3);
		// Ajoutez autant d'éléments que vous le souhaitez à votre modèle de liste.
		
		JList<String> jList = new JList<>(listModel);
		jList.setBounds(100, 127, 80, 60);
		contentPane.add(jList);
		
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(133, 209, 85, 21);
		contentPane.add(btnNewButton);
		

	}
}
