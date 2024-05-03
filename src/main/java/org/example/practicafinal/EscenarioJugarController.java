package org.example.practicafinal;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Tablero.Casilla;
import org.example.practicafinal.Clases.Partida.Partida;

import java.util.ArrayList;
import java.util.Objects;

public class EscenarioJugarController {
    EscenariosController controladorEscenarios;
    private Partida partida;

    private GridPane tablero = new GridPane();

    private Boolean tableroCreado = false;

    private Boolean partidaCreada = false;

    private ArrayList<Individuo> listaIndividuos;
    private ArrayList<Casilla> listaCasillas = new ArrayList<>();

    private int velocidad = 50;

    @FXML
    private Label lblTurno;

    @FXML
    private TabPane tabPane;

    @FXML
    private Pane paneTablero;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnPause;

    @FXML
    private Button btnEnd;

    @FXML
    private Button btnCaracteristicas;

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
    private Label lblVelocidad;

    @FXML
    private Label lblFilas;

    @FXML
    private Slider sliderColumnas;

    @FXML
    private Slider sliderFilas;

    @FXML
    private Slider sliderVelocidad;

    @FXML
    private Button btnAceptarTablero;

    @FXML
    private Button btnRestablecerTablero;

    ////////////////////////////////////////////////////////////////////////////

        /* ACEPTAR Y RESTABLECER CAMBIOS
            * Objetivo: guardar los valores establecidos por el individuo en los diferentes parámetros del juego */
    @FXML
    public void aceptarParIndividuo() {
        crearPartida();
    }

    @FXML
    public void aceptarParEntorno() {

    }

    @FXML
    public void aceptarTablero(){
        this.tableroCreado = true;
        eliminarTablero();      //Limpiar tablero anterior y volver a dibujarlo
        crearTablero((int) sliderColumnas.getValue(), (int) sliderFilas.getValue());
        cambiarVelocidad();
    }

    @FXML
    public void restablecerTablero(){
        sliderColumnas.setValue(5);     //Valores predeterminados
        sliderFilas.setValue(5);
        sliderVelocidad.setValue(1);
    }

    @FXML
    public void restablecerIndividuos() {
        sliderReproduccion.setValue(70);        //Valores predeterminados
        sliderClonacion.setValue(50);
        sliderVida.setValue(10);
        sliderNumeroIndividuos.setValue(20);
    }

    @FXML
    private void restablecerEntorno(){

    }

    ////////////////////////////////////////////////////////////////////////////

        /* FUNCIONES MENÚ
            * Objetivo: dar al usuario las opciones de:
            *                   - Cargar Partida Existente
            *                   - Guardar Partida Actual
            *                   - Salir a la Pantalla de Inicio
         */
    @FXML
    public void cargarPartida(){
        controladorEscenarios.cargarEscenarioCargar();
    }

    @FXML
    public void salir() {
        controladorEscenarios.cargarEscenarioInicio();
    }

    ////////////////////////////////////////////////////////////////////////////

        /* BOTONES MANEJAR PARTIDA
            * Objetivo: comenzar, pausar o finalizar la partida
         */
        AnimationTimer animationTimer = new AnimationTimer() {
            int i = velocidad;
            @Override
            public void handle(long now) {
                if (i%velocidad==0) {
                    listaIndividuos = partida.getListaIndividuos();
                    partida.modificarTurno();
                    lblTurno.setText("Turno: " + partida.getTurno());
                }
                i++;
            }
        };

    @FXML
    private void start() {
        if (tableroCreado){
            if (!partidaCreada){
                crearPartida();
                partida.individuosInicio();
                listaIndividuos = partida.getListaIndividuos();
                mostrarEnCasilla();
                partidaCreada = true;
            }
            //Disable Bottoms
            btnStart.setDisable(true);
            btnPause.setDisable(false);
            btnEnd.setDisable(false);
            //Disable Sliders
            desabilitarSliders(true);

            //Empezar Juego
            animationTimer.start();
        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);     //Si el tablero no está creado, da un aviso
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No has creado el Tablero");
            alert.showAndWait();
        }
    }

    @FXML
    private void pause(){
        btnPause.setDisable(true);
        btnEnd.setDisable(false);
        btnStart.setDisable(false);
        desabilitarSliders(false);
        animationTimer.stop();
    }

    @FXML
    private void endGame(){
        controladorEscenarios.cargarArbolFinal(listaIndividuos);
        btnEnd.setDisable(true);
        btnPause.setDisable(true);
        btnStart.setDisable(true);
        desabilitarSliders(true);
        animationTimer.stop();
    }

    private void desabilitarSliders(Boolean a){
        sliderColumnas.setDisable(a);
        sliderFilas.setDisable(a);
        sliderVida.setDisable(a);
        sliderReproduccion.setDisable(a);
        sliderClonacion.setDisable(a);
        sliderNumeroIndividuos.setDisable(a);
    }

    ////////////////////////////////////////////////////////////////////////////

        /* CREAR TABLERO
            * Objetivo: crear y eliminar el tablero
         */
    public void crearTablero (int columnas, int filas){
        double a = paneTablero.getWidth();
        double b = paneTablero.getHeight();
        for (int i = 0; i < columnas; i++){
            for (int j = 0; j < filas; j++){
                Casilla casilla = new Casilla(i,j);
                casilla.setMinSize((double) a/columnas,(double) b/filas);
                casilla.setStyle("-fx-background-color:#D4E5E3; -fx-border-color: #000000");
                tablero.add(casilla,i,j);
                listaCasillas.add(casilla);
            }
        }

    }

    public void eliminarTablero(){
        tablero.getChildren().clear();
    }

    ////////////////////////////////////////////////////////////////////////////

        //OTRAS FUNCIONES

    @FXML
    void cambiarVelocidad() {
        if (sliderVelocidad.getValue()==0.25){
            this.velocidad = 125;
        } else if (sliderVelocidad.getValue()==0.5){
            this.velocidad = 100;
        } else if(sliderVelocidad.getValue()==0.75){
            this.velocidad = 75;
        } else if (sliderVelocidad.getValue()==1.25) {
            this.velocidad = 40;
        } else if (sliderVelocidad.getValue()==1.5) {
            this.velocidad = 30;
        } else if (sliderVelocidad.getValue()==1.75) {
            this.velocidad = 20;
        } else if (sliderVelocidad.getValue()==2) {
            this.velocidad = 10;
        } else{
            this.velocidad = 50;
        }
    }

    public void changeStateOfLabelColumnas() {
        sliderColumnas.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number>
                                        observable, Number oldValue, Number newValue) {
                lblColumnas.textProperty().setValue("Número de Columnas: "+(int) sliderColumnas.getValue());
            }
        });
    }

    public void changeStateOfLabelFilas() {
        sliderFilas.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number>
                                        observable, Number oldValue, Number newValue) {
                lblFilas.textProperty().setValue("Número de Filas: "+(int) sliderFilas.getValue());
            }
        });
    }

    public void changeStateOfLabelVelocidad() {
        sliderVelocidad.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number>
                                        observable, Number oldValue, Number newValue) {
                double x = sliderVelocidad.getValue();
                if ((x == 0.25)||(x == 0.5)||(x==0.75)||(x == 1)||(x == 1.25)||(x == 1.5) || (x == 1.75) || (x == 2)){
                    lblVelocidad.textProperty().setValue("Velocidad: x"+(double) sliderVelocidad.getValue());
                }
            }
        });
    }

    public int getNumeroIndividuos(){
        return (int) sliderNumeroIndividuos.getValue();
    }

    public int getNumeroColumnas(){
        return (int)sliderColumnas.getValue();
    }

    public int getNumeroFilas(){
        return (int)sliderFilas.getValue();
    }

    public void crearPartida(){
        this.partida = new Partida((int)sliderReproduccion.getValue(), (int)sliderClonacion.getValue(), (int)sliderVida.getValue(), (int)sliderNumeroIndividuos.getValue(), (int)sliderColumnas.getValue(),(int)sliderFilas.getValue());
    }

    public double getTamanoIndividuos(){
        double a = paneTablero.getHeight();
        double casillas = a / sliderColumnas.getValue();
        double diametro = casillas / 3;
        return diametro/2;
    }

    public void mostrarEnCasilla(){
        for (Individuo individuo:listaIndividuos){
            Circle circulo = new Circle(getTamanoIndividuos());
            int rango = individuo.getRango();
            if (rango==3){
                circulo.setStroke(Color.rgb(255, 74, 123));
                circulo.setFill(Color.rgb(255,74,123));
                Casilla casilla = individuo.getCasilla();
                for (Casilla lugar:listaCasillas){
                    if (Objects.equals(casilla.getId(), lugar.getId())){
                        lugar.setCenter(circulo);
                    }
                }
            } else if (rango == 2) {
                circulo.setStroke(Color.rgb(241, 241, 70));
                circulo.setFill(Color.rgb(241, 241, 70));
                Casilla casilla = individuo.getCasilla();
                for (Casilla lugar:listaCasillas){
                    if (Objects.equals(casilla.getId(), lugar.getId())){
                        lugar.setCenter(circulo);
                    }
                }
            } else{
                circulo.setStroke(Color.rgb(169, 250, 70));
                circulo.setFill(Color.rgb(169, 250, 70));
                Casilla casilla = individuo.getCasilla();
                for (Casilla lugar:listaCasillas){
                    if (Objects.equals(casilla.getId(), lugar.getId())){
                        lugar.setCenter(circulo);
                    }
                }
            }
        }
    }

    public void setControladorEscenarios(EscenariosController controlador){
        this.controladorEscenarios = controlador;
    }

    public void initialize(){
        paneTablero.getChildren().addAll(tablero);
        tablero.setGridLinesVisible(true);
        changeStateOfLabelColumnas();
        changeStateOfLabelFilas();
        changeStateOfLabelVelocidad();
        btnPause.setDisable(true);
        btnEnd.setDisable(true);
    }
}
