package org.example.practicafinal.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.practicafinal.Controller.EscenariosController;

public class EscenarioInicioController {
    EscenariosController controladorEscenarios;
    EscenarioJugarController escenarioJugar;

    @FXML
    private Button btnCargarPartida;

    @FXML
    private Button btnNuevaPartida;

    @FXML
    private Label lblStart;

    @FXML
    void cargarPartida() {
        controladorEscenarios.cargarEscenarioJugarCargar();
    }

    @FXML
    void nuevaPartida() {
        controladorEscenarios.cargarEscenarioJugar();
    }

    public void setControladorEscenarios(EscenariosController controlador){
        this.controladorEscenarios = controlador;
    }
}
