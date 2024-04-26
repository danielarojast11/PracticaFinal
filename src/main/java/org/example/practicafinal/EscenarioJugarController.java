package org.example.practicafinal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EscenarioJugarController {
    EscenariosController controladorEscenarios;
    @FXML
    private Button btnSalir;

    @FXML
    void salir() {
        controladorEscenarios.cargarEscenarioInicio();
    }
    public void setControladorEscenarios(EscenariosController controlador){
        this.controladorEscenarios = controlador;
    }
}
