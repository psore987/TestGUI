package explo1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Fenêtre simple.
 * @author fr.wikibooks.org
 */
public class SecondeFenetreSimple extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SecondeFenetreSimple()
	{
		setTitle("Une deuxième fenêtre simple");
		setSize(new Dimension(600,400));
		setLocation(new Point(200, 100));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
			/* (non-Javadoc)
			 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosing(WindowEvent e)
			{
				dispose();
				System.exit(0);
			}
		});
	}

	public static void main(String[] args)
	{
		// Utiliser le thread dédié à l'interface graphique
		// pour les opérations graphiques :
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				SecondeFenetreSimple frame = new SecondeFenetreSimple(); // Créer
				frame.setVisible(true); // Afficher
			}
		});
	}
}