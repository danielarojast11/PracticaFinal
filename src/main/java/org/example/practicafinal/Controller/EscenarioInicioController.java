package org.example.practicafinal.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.practicafinal.MainApplication;

public class EscenarioInicioController {
    private static final Logger log = LogManager.getLogger(EscenarioInicioController.class);
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
        log.info("EscenarioJugarCargar cargado");
    }

    @FXML
    void nuevaPartida() {
        controladorEscenarios.cargarEscenarioJugar();
        log.info("EscenarioJugar Cargado");
    }

    public void setControladorEscenarios(EscenariosController controlador){
        this.controladorEscenarios = controlador;
        log.info("Controlador de Escenarios establecido");
    }
}
