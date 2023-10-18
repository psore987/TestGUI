package explo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtils {
    private static final String DB_URL = "jdbc:mysql://192.168.1.100";
    private static final String DB_USER = "stagedating";
    private static final String DB_PASSWORD = "password";

    public static void ajouterRendezVous(String nomEtudiant, String heureRdv, String noStand) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO RendezVous (heureRdv, noStand, idProfessionnel, idEtu) VALUES (?, ?, ?, ?)";
            
            // Supposez que idProfessionnel et idEtu sont connus, remplacez-les par les valeurs appropriées
            int idProfessionnel = 1;  // Exemple
            int idEtu = 2;            // Exemple
            
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, heureRdv);
            statement.setString(2, noStand);
            statement.setInt(3, idProfessionnel);
            statement.setInt(4, idEtu);
            
            statement.executeUpdate();
            
            System.out.println("Rendez-vous ajouté à la base de données !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
