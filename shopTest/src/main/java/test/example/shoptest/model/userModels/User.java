package test.example.shoptest.model.userModels;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.Scene;
 import javafx.scene.control.Alert;
 import javafx.stage.Stage;
 import test.example.shoptest.database.UserDAO;

public class User {

    public static boolean authenticate(String username, String password) {
        return UserDAO.authenticateUser(username, password);
    }

    //passare la procedura di login dal controller a questa classe in modo da essere solo richiamata
    public void login(String username, String password){

    }

    //funzione per la creazione di un nuovo utente
    public static void createUser(String username, String email, String password){
        UserDAO.createUser(username, email, password);
    }


}
