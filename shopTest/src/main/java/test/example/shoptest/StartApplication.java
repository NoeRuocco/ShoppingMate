package test.example.shoptest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    //prima schermata visibile al lancio dell'applicazione
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("views/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Shopping Mate");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //per lanciare l'applicazione
        launch();
    }
}