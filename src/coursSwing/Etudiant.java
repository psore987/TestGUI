package coursSwing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Etudiant {

	public static void ajouterEtudiant(Connection connection, String nomE, String prenomE, String idClasseE) {
		PreparedStatement preparedStatement = null;

		try {
			// Requête SQL avec un PreparedStatement
			String sql = "INSERT INTO Etudiant (nomEtu, prenomEtu,idClasseEtu) VALUES (?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);

			// Remplacer les paramètres par les valeurs actuelles
			preparedStatement.setString(1, nomE);
			preparedStatement.setString(2, prenomE);
			preparedStatement.setString(3, idClasseE);
			

			// Exécutez la requête d'insertion
			preparedStatement.executeUpdate();

			System.out.println("Etudiant ajouté avec succès à la base de données.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fermez les ressources
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//    public static void supprimerPersonne(Connection connection, int idPersonne) {
	//        PreparedStatement preparedStatement = null;
	//
	//        try {
	//            // Requête SQL avec un PreparedStatement pour supprimer une personne par son ID
	//            String sql = "DELETE FROM Personne WHERE idPersonne = ?";
	//            preparedStatement = connection.prepareStatement(sql);
	//
	//            // Remplacez le paramètre par la valeur actuelle de l'ID à supprimer
	//            preparedStatement.setInt(1, idPersonne);
	//
	//            // Exécutez la requête de suppression
	//            int rowsAffected = preparedStatement.executeUpdate();
	//
	//            if (rowsAffected > 0) {
	//                System.out.println("Personne supprimée avec succès de la base de données.");
	//            } else {
	//                System.out.println("Aucune personne trouvée avec cet ID.");
	//            }
	//        } catch (SQLException e) {
	//            e.printStackTrace();
	//        } finally {
	//            // Fermez les ressources
	//            try {
	//                if (preparedStatement != null) {
	//                    preparedStatement.close();
	//                }
	//            } catch (SQLException e) {
	//                e.printStackTrace();
	//            }
	//        }
	//    }
}
