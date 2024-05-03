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
import test.example.shoptest.model.productModels.Product;

import java.io.IOException;

public class PrManController {
    //funzione per tornare alla schermata di home da amministratore
    @FXML
    private Button BackToHomeButton;
    public void backToHomeFunction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BackToHomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/test/example/shoptest/views/adminViews/adminHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    //funzione per visualizzare le schermate di creazione, di modifica dello sconto e di visualizzazione dei prodotti
    @FXML
    private Button ShowCreatePrButton;
    public void showCreatePrFunction(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage) ShowCreatePrButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/test/example/shoptest/views/adminViews/prManViews/createPr.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Button ModifyPrButton;
    public void showModifyPrFunction (ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage) ShowCreatePrButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/test/example/shoptest/views/adminViews/prManViews/modifyPr.fxml"));
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
