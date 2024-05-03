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

public class AdminController {
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

    //funzione per effettuare il login come amministratore
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
                // visualizza prima una finestra di benvenuto e poi cambia scena
                showAlert(Alert.AlertType.INFORMATION, "Login successful", "Welcome, " + username + "!");
                Stage stage = (Stage) LoginButton.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/test/example/shoptest/views/adminViews/adminHome.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.show();
            } else {
                // se si cerca di entrare con credenziali da user in admin mode
                showAlert(Alert.AlertType.ERROR, "Login failed", "The credentials used are not administrator credentials.");
            }
        } else {
            // login fallito, visualizza una finestra di dialogo di errore
            showAlert(Alert.AlertType.ERROR, "Login failed", "Invalid credentials.");
        }
    }

    //funzione per effettuare il logout come amministratore
    @FXML
    private Button AdminLogoutButton;
    public void adminLogout(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage) AdminLogoutButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/test/example/shoptest/views/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    //funzioni per mostrare la pagina di gestione dei prodotti e per mostrare la pagina di gestione delle vendite
    @FXML
    private Button PrManButton;
    @FXML
    private Button SaManButton;
    public void showPrManViewFunction(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage) PrManButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/test/example/shoptest/views/adminViews/prManViews/adminPrMan.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
    public void showSaManViewFunction(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage) SaManButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/test/example/shoptest/views/adminViews/adminSaMan.fxml"));
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
