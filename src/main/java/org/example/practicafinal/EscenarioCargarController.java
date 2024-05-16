package org.example.practicafinal;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.practicafinal.Clases.Partida.Partida;

import java.io.FileReader;
import java.io.IOException;

public class EscenarioCargarController {
    EscenariosController controladorEscenarios;
    @FXML
    private Button btnJugar;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnPartida;

    @FXML
    void jugar() {
        controladorEscenarios.cargarEscenarioJugar();
    }

    @FXML
    void salir() {
        controladorEscenarios.cargarEscenarioInicio();
    }

    @FXML
    private void cargar(){
        Gson gson = new Gson ();
        try (FileReader reader = new FileReader("partida.json")) {
            gson.fromJson(reader, Partida.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setControladorEscenarios(EscenariosController controlador){
        this.controladorEscenarios = controlador;
    }
}
