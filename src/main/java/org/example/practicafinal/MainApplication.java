package org.example.practicafinal;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.practicafinal.Controller.EscenariosController;

public class MainApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        new EscenariosController(primaryStage);
        primaryStage.setResizable(false);
    }
}
