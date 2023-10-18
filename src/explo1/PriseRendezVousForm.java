package explo1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PriseRendezVousForm extends JFrame {
   	private static final long serialVersionUID = 1L;
	private JLabel lblNomEtudiant, lblHeureRdv, lblNoStand;
    private JTextField txtHeureRdv;
    private JComboBox<String> comboNomEtudiant, comboNoStand;
    private JButton btnPrendreRdv;

    public PriseRendezVousForm() {
        setTitle("Prise de Rendez-vous");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2, 10, 10));

        lblNomEtudiant = new JLabel("Nom de l'Étudiant:");
        comboNomEtudiant = new JComboBox<>(new String[]{"Étudiant 1", "Étudiant 2", "Étudiant 3"});
        
        lblHeureRdv = new JLabel("Heure du Rendez-vous:");
        txtHeureRdv = new JTextField();

        lblNoStand = new JLabel("Numéro du Stand:");
        comboNoStand = new JComboBox<>(new String[]{"Stand 1", "Stand 2", "Stand 3"});
        
        btnPrendreRdv = new JButton("Prendre Rendez-vous");
        btnPrendreRdv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomEtudiant = (String) comboNomEtudiant.getSelectedItem();
                String heureRdv = txtHeureRdv.getText();
                String noStand = (String) comboNoStand.getSelectedItem();
                
                // Ajoutez ici la logique pour enregistrer le rendez-vous dans la base de données
                
                JOptionPane.showMessageDialog(null, "Rendez-vous pris pour " + nomEtudiant +
                        " à l'heure " + heureRdv + " au stand " + noStand);
            }
        });

        mainPanel.add(lblNomEtudiant);
        mainPanel.add(comboNomEtudiant);
        mainPanel.add(lblHeureRdv);
        mainPanel.add(txtHeureRdv);
        mainPanel.add(lblNoStand);
        mainPanel.add(comboNoStand);
        mainPanel.add(new JLabel()); // Espace vide pour l'apparence
        mainPanel.add(btnPrendreRdv);

        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PriseRendezVousForm();
            }
        });
    }
}
