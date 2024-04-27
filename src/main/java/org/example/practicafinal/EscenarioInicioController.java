package org.example.practicafinal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EscenarioInicioController {
    EscenariosController controladorEscenarios;
    @FXML
    private Button btnCargarPartida;

    @FXML
    private Button btnNuevaPartida;

    @FXML
    private Label lblStart;

    @FXML
    void cargarPartida() {
        controladorEscenarios.cargarEscenarioCargar();
    }

    @FXML
    void nuevaPartida() {
        controladorEscenarios.cargarEscenarioJugar();
    }

    public void setControladorEscenarios(EscenariosController controlador){
        this.controladorEscenarios = controlador;
    }
}
