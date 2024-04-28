package org.example.practicafinal;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import org.example.practicafinal.Clases.Partida.Partida;

import static javafx.scene.paint.Color.*;

public class EscenarioJugarController {
    EscenariosController controladorEscenarios;
    private Partida partida;

    @FXML
    private TabPane tabPane;

    @FXML
    private Pane paneTablero;

    @FXML
    private Button btnStart;

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
    private Label lblColumnas;

    @FXML
    private Label lblFilas;

    @FXML
    private Slider sliderColumnas;

    @FXML
    private Slider sliderFilas;

    @FXML
    private Button btnAceptarTablero;

    @FXML
    private Button btnRestablecerTablero;


    private GridPane tablero = new GridPane();

    @FXML
    public void aceptarParIndividuo() {
        crearPartida();
    }

    @FXML
    public void aceptarParEntorno() {

    }

    @FXML
    public void aceptarTablero(){
        crearTablero((int) sliderColumnas.getValue(), (int) sliderFilas.getValue());
    }

    @FXML
    public void restablecerTablero(){
        sliderColumnas.setValue(5);
        sliderFilas.setValue(5);
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

    public void crearTablero (int columnas, int filas){
        double a = paneTablero.getWidth();
        double b = paneTablero.getHeight();
        for (int i = 0; i < columnas; i++){
            for (int j = 0; j < filas; j++){
                Pane casilla = new Pane();
                casilla.setMinSize((double) a/columnas,(double) b/filas);
                casilla.setStyle("-fx-background-color:#D4E5E3; -fx-border-color: #000000");
                tablero.add(casilla,i,j);
            }
        }
    }

    public void eliminarTablero(){

    }
    public void crearPartida(){
        this.partida = new Partida((int)sliderReproduccion.getValue(), (int)sliderClonacion.getValue(), (int)sliderVida.getValue());
    }
    public void setControladorEscenarios(EscenariosController controlador){
        this.controladorEscenarios = controlador;
    }

    public void initialize(){
        paneTablero.getChildren().addAll(tablero);
        tablero.setGridLinesVisible(true);
    }
}
