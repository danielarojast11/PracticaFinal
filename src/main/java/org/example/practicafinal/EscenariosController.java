package org.example.practicafinal;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.EstructurasDeDatos.Lista.DoblementeEnlazada.ListaDoblementeEnlazada;

import java.io.IOException;

public class EscenariosController {

        //PARAMETERS
    private final Stage stagePrincipal;
    private BorderPane borderPane;


        //CONSTRUCTOR
    public EscenariosController(Stage stage) {
        this.stagePrincipal = stage;
        cargarEscenario();
    }

        //UPLOAD DIFFERENT SCENES/STAGES
    public void cargarEscenario(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("escenarioPrincipal-view.fxml"));
            borderPane = loader.load();
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
            AnchorPane pane = loader.load();
            borderPane.setCenter(pane);
            EscenarioInicioController c = loader.getController();
            c.setControladorEscenarios(this);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void cargarEscenarioJugar(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("escenarioJugar-view.fxml"));
            AnchorPane pane = loader.load();
            borderPane.setCenter(pane);
            EscenarioJugarController c = loader.getController();
            c.setControladorEscenarios(this);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void cargarEscenarioCargar(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("escenarioCargar-view.fxml"));
            AnchorPane pane = loader.load();
            borderPane.setCenter(pane);
            EscenarioCargarController c = loader.getController();
            c.setControladorEscenarios(this);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void cargarArbolFinal(ListaDoblementeEnlazada<Individuo> listaIndividuos){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("arbolGenealogico-view.fxml"));
            AnchorPane pane = loader.load();
            borderPane.setCenter(pane);
            ArbolGenealogicoController a = loader.getController();
            a.setControladorEscenarios(this);
            a.mostrarIndividuos(listaIndividuos);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
