package explo1;
import java.awt.*;

import javax.swing.*;

/**
 * Fenêtre simple.
 * @author fr.wikibooks.org
 */
public class FenetreSimple extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		// Utiliser le thread dédié à l'interface graphique
		// pour les opérations graphiques :
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				FenetreSimple frame = new FenetreSimple(); // Créer
				frame.setVisible(true); // Afficher
			}
		});
	}
}