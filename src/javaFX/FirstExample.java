package javaFX;
import java.util.*;

import javafx.application.Application;
import javafx.stage.Stage;

public class FirstExample extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		Group root = new Group();
		Scene scene = new Scene(root, 400, 200); // Fenêtre 400x200 pixels

		stage.setScene(scene);
		stage.setTitle("Exemple de scene vide"); // Titre de la fenêtre
		stage.show();

		// Afficher tous les arguments passés à l'application
		// Exemple: test --limit=20 example --out=file.dat
		//   Paramètre limit = 20
		//   Paramètre out = file.dat
		//   Autre paramètre: test
		//   Autre paramètre: example
		Parameters params = getParameters();
		for(Map.Entry<String, String> named_parameter : params.getNamed().entrySet())
			System.out.println("  Paramètre "+named_parameter.getKey()+" = "+named_parameter.getValue());
		for(String p : params.getUnnamed())
			System.out.println("  Autre paramètre: "+p);
	}
}
