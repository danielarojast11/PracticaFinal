package org.example.practicafinal;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EscenarioJugarController {
    EscenariosController controladorEscenarios;

    @FXML
    private TabPane tabPane;

        //Modificar Parametros Individuos

    @FXML
    private Tab tabIndividuos;

    @FXML
    private Label lblClonacion;

    @FXML
    private Label lblNumeroInidividuos;

    @FXML
    private Label lblReproduccion;

    @FXML
    private Label lblVida;

    @FXML
    private Slider sliderClonacion;

    @FXML
    private Slider sliderNumeroIndividuos;

    @FXML
    private Slider sliderReproduccion;

    @FXML
    private Slider sliderVida;

    @FXML
    private Button btnAceptarParIndividuo;

    @FXML
    private Button btnRestablecer;

        //Modificar Parametros Entorno

    @FXML
    private Tab tabEntorno;

    @FXML
    private Button btnAceptarParEntorno;

    @FXML
    private Button btnRestablecer1;

        //Modificar Parametros Tablero

    @FXML
    private Tab tabTablero;

    @FXML
    private Button btnSalir;

    @FXML
    public void aceptarParIndividuo() {

    }

    @FXML
    public void aceptarParEntorno() {

    }

    @FXML
    public void restablecer() {

    }

    @FXML
    public void cargarPartida(){
        controladorEscenarios.cargarEscenarioCargar();
    }

    @FXML
    public void salir() {
        controladorEscenarios.cargarEscenarioInicio();
    }

    @FXML
    private void start() {

    }
    public void setControladorEscenarios(EscenariosController controlador){
        this.controladorEscenarios = controlador;
    }
}
