package test.example.shoptest.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import test.example.shoptest.model.userModels.User;

import java.io.IOException;

public class UserController {
    //funzione per tornare alla schermata in cui scegliere la modalità di utilizzo
    @FXML
    private Button BackToStartButton;
    public void backToStartFunction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BackToStartButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/test/example/shoptest/views/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    //funzione per tornare alla schermata di login
    @FXML
    private Button BackToLoginButton;
    public void backToLoginFunction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BackToLoginButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/test/example/shoptest/views/userViews/userLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    //funzione per effettuare il login
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button LoginButton;
    public void loginFunction(ActionEvent actionEvent) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (User.authenticate(username, password)) {
            if(username.equals("admin")){
                // nel caso in cui si cerca di entrare con credenziali da admin in user mode
                showAlert(Alert.AlertType.ERROR, "Errore di login", "Le credenziali inserite non sono quelle di un utente.");
            } else {
                // visualizza prima una finestra di benvenuto e poi cambia scena
                showAlert(Alert.AlertType.INFORMATION, "Login riuscito", "Benvenuto, " + username + "!");
                Stage stage = (Stage) LoginButton.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/test/example/shoptest/views/userViews/userHome.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.show();
            }
        } else {
            // login fallito, visualizza una finestra di dialogo di errore
            showAlert(Alert.AlertType.ERROR, "Errore di login", "Credenziali non valide.");
        }
    }


    //funzioni per effettuare la registrazione al sito, e quindi la creazione di un nuovo account
    @FXML
    private Button SignInButton;
    public void signInFunction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) SignInButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/test/example/shoptest/views/userViews/userSignIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField emailField;
    @FXML
    private Button CreateUserButton;
    public void createUserFunction(ActionEvent actionEvent) throws IOException{
        //richiama la funzione di User per la creazione del nuovo account e poi mostra la schermata di login
        //per verificare che la registrazione ha avuto buon fine
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        User.createUser(username, email, password);
    }


    //funzione per effettuare il logout
    @FXML
    private Button UserLogoutButton;
    public void userLogout(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage) UserLogoutButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/test/example/shoptest/views/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    //funzione per mostrare le finestre di dialogo
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
