package test.example.shoptest.database;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    static ConnectionDB db = ConnectionDB.getInstance();
    static Connection connection = db.getConnection();

    private static void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    //funzione per l'autenticazione dei vari utenti del sistema
    public static boolean authenticateUser(String username, String password) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean authenticated = false;

        try {
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Se il risultato della query non è vuoto, l'utente è autenticato
                authenticated = true;
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        } finally {
            // Chiudi ResultSet, PreparedStatement e Connection
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }

        return authenticated;
    }

    //funzione per verificare se un username è già esistente


    //funzione per la creazione di un utente
    public static void createUser(String username, String email, String password){

    }


}
