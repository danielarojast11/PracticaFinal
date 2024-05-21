package org.example.practicafinal.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EscenarioCargarController {
    EscenariosController controladorEscenarios;
    EscenarioJugarController controladorEscenarioJugar;

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
    void cargar(){
        controladorEscenarioJugar.cargar();
    }

    public void setControladorEscenarios(EscenariosController controlador){
        this.controladorEscenarios = controlador;
    }
}
