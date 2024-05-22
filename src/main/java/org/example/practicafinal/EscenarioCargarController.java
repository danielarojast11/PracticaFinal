package org.example.practicafinal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.practicafinal.Controller.EscenarioJugarController;
import org.example.practicafinal.Controller.EscenariosController;

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
