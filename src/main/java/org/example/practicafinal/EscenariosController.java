package org.example.practicafinal;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EscenariosController {
    private Stage stagePrincipal;
    private BorderPane borderPane;

    public EscenariosController(Stage stage) {
        this.stagePrincipal = stage;
        cargarEscenario();
    }

    public void cargarEscenario(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("escenarioPrincipal-view.fxml"));
            borderPane = (BorderPane) loader.load();
            Scene scene = new Scene(borderPane);
            stagePrincipal.setScene(scene);
            stagePrincipal.show();
            cargarEscenarioInicio();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void cargarEscenarioInicio(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("escenarioInicio-view.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            borderPane.setCenter(pane);
            EscenarioInicioController c = loader.getController();
            c.setControladorEscenarios(this);
        } catch (Exception e){

        }
    }

    public void cargarEscenarioJugar(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("escenarioJugar-view.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            borderPane.setCenter(pane);
            EscenarioJugarController c = loader.getController();
            c.setControladorEscenarios(this);
        } catch (Exception e){

        }
    }

    public void cargarEscenarioCargar(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("escenarioCargar-view.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            borderPane.setCenter(pane);
            EscenarioCargarController c = loader.getController();
            c.setControladorEscenarios(this);
        } catch (Exception e){

        }
    }
}
