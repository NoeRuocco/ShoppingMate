package test.example.shoptest.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class MainController {

    @FXML
    Button AdminLogin;
    public void showAdminLogin(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) AdminLogin.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/test/example/shoptest/views/adminViews/adminLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    Button UserLogin;
    public void showUserLogin(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) UserLogin.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/test/example/shoptest/views/userViews/userLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }


}