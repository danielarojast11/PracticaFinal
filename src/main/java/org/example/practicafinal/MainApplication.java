package org.example.practicafinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class MainApplication extends Application {



    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("escenarioPrincipal-view.fxml"));
        Scene uScene = new Scene(fxmlLoader.load(), 900, 700);
        primaryStage.setScene(uScene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
