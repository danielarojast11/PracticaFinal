package org.example.practicafinal;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.practicafinal.Clases.Partida.Partida;

public class EscenarioJugarController {
    EscenariosController controladorEscenarios;
    private Partida partida;

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
        crearPartida();
    }

    @FXML
    public void aceptarParEntorno() {

    }

    @FXML
    public void restablecerIndividuos() {
        sliderReproduccion.setValue(70);
        sliderClonacion.setValue(50);
        sliderVida.setValue(10);
        sliderNumeroIndividuos.setValue(20);
    }

    @FXML
    private void restablecerEntorno(){

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
        crearPartida();
    }
    public void crearPartida(){
        this.partida = new Partida((int)sliderReproduccion.getValue(), (int)sliderClonacion.getValue(), (int)sliderVida.getValue());
    }
    public void setControladorEscenarios(EscenariosController controlador){
        this.controladorEscenarios = controlador;
    }
}
