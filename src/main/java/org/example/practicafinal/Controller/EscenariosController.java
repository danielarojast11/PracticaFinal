package org.example.practicafinal.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.practicafinal.Entity.Individuo;
import org.example.practicafinal.Entity.Partida;
import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EscenariosController {
    private static final Logger log = LogManager.getLogger(EscenariosController.class);
    private final Stage stagePrincipal;
    private BorderPane borderPane;

    public EscenariosController(Stage stage) {
        this.stagePrincipal = stage;
        cargarEscenario();
    }

    public void cargarEscenario(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/org/example/practicafinal/escenarioPrincipal-view.fxml"));
            borderPane = loader.load();
            Scene scene = new Scene(borderPane);
            stagePrincipal.setScene(scene);
            stagePrincipal.show();
            cargarEscenarioInicio();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        log.info("Escenario Cargado");
    }

    public void cargarEscenarioInicio(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/org/example/practicafinal/escenarioInicio-view.fxml"));
            AnchorPane pane = loader.load();
            borderPane.setCenter(pane);
            EscenarioInicioController c = loader.getController();
            c.setControladorEscenarios(this);
        } catch (Exception e){
            e.printStackTrace();
            log.trace("Exception");
        }
        log.info("Escenario Inicio Cargado");
    }

    public void cargarEscenarioJugar(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/org/example/practicafinal/escenarioJugar-view.fxml"));
            AnchorPane pane = loader.load();
            borderPane.setCenter(pane);
            EscenarioJugarController c = loader.getController();
            c.setControladorEscenarios(this);
        } catch (Exception e){
            e.printStackTrace();
            log.trace("Exception");
        }
        log.info("Escenario Jugar Cargado");
    }

    public void cargarEscenarioJugarCargar(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/org/example/practicafinal/escenarioJugar-view.fxml"));
            AnchorPane pane = loader.load();
            borderPane.setCenter(pane);
            EscenarioJugarController c = loader.getController();
            c.setCargar(true);
            c.setControladorEscenarios(this);
        } catch (Exception e){
            e.printStackTrace();
        }
        log.info("Escenario Jugar Cargar Cargado");
    }

    public void cargarArbolFinal(Partida partida){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/org/example/practicafinal/arbolGenealogico-view.fxml"));
            AnchorPane pane = loader.load();
            borderPane.setCenter(pane);
            ArbolGenealogicoController a = loader.getController();
            a.setControladorEscenarios(this);
            a.mostrarIndividuos(partida);
        } catch (Exception e){
            e.printStackTrace();
        }
        log.info("Arbol Final Cargado");
    }
}
