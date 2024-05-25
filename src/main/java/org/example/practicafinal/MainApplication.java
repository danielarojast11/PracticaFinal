package org.example.practicafinal;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.practicafinal.Controller.EscenariosController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private static final Logger log = LogManager.getLogger(MainApplication.class);
    @Override
    public void start(Stage primaryStage) {
        log.info("Inicio del método de arranque");
        new EscenariosController(primaryStage);
        primaryStage.setResizable(false);

        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");

    }
}
