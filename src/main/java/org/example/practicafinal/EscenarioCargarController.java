package org.example.practicafinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EscenarioCargarController {
    EscenariosController controladorEscenarios;
    @FXML
    private Button btnJugar;

    @FXML
    private Button btnSalir;

    @FXML
    void jugar() {
        controladorEscenarios.cargarEscenarioJugar();
    }

    @FXML
    void salir() {
        controladorEscenarios.cargarEscenarioInicio();
    }
    public void setControladorEscenarios(EscenariosController controlador){
        this.controladorEscenarios = controlador;
    }
}
