package org.example.practicafinal;

import com.google.gson.Gson;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Window;
import org.example.practicafinal.Clases.BuclesDeControl.Bucles;
import org.example.practicafinal.Clases.Entorno.Elementos;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Partida.Partida;
import org.example.practicafinal.Clases.Tablero.Casilla;
import org.example.practicafinal.Clases.Tablero.PartidaCasilla;
import org.example.practicafinal.Dialogs.CasillaDialog;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class EscenarioJugarController {

    //Parameters
    EscenariosController controladorEscenarios;

    private Partida partida;

    private Bucles bucle = new Bucles();

    private GridPane tablero = new GridPane();

    private Boolean tableroCreado = false;

    private Boolean individuosCreados = false;

    private Boolean partidaCreada = false;

    private List<Individuo> listaIndividuos = new ArrayList<>();

    private List<Casilla> listaCasillas = new ArrayList<>();

    private List<Elementos> listaElementos = new ArrayList<>();

    private int velocidad = 50;

    @FXML
    private Label lblTurno;

    @FXML
    private Label lblNumeroIndividuos;

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

        //Modify Individuals Parameters

    @FXML
    private Tab tabIndividuos;

    @FXML
    private Label lblClonacion;

    @FXML
    private Label lblReproduccion;

    @FXML
    private Label lblVida;

    @FXML
    private Slider sliderClonacion;

    @FXML
    private Slider sliderReproduccion;

    @FXML
    private Slider sliderVida;

    @FXML
    private Button btnAceptarParIndividuo;

    @FXML
    private Button btnRestablecer;

        //Modify Individuals Types

    @FXML
    private Tab tabTipoIndividuos;

    @FXML
    private Label lblBasico;

    @FXML
    private Label lblNormal;

    @FXML
    private Label lblAvanzado;

    @FXML
    private Slider sliderBasico;

    @FXML
    private Slider sliderNormal;

    @FXML
    private Slider sliderAvanzado;

    @FXML
    private Button btnRestablecerTipoIndividuo;

    @FXML
    private Button btnAceptarTipoIndividuo;

        //Modify Elements Parameters

    @FXML
    private Tab tabEntorno;

    @FXML
    private Slider sliderAgua;

    @FXML
    private Slider sliderComida;

    @FXML
    private Slider sliderMontana;

    @FXML
    private Slider sliderCofre;

    @FXML
    private Slider sliderBiblioteca;

    @FXML
    private Slider sliderPozo;

    @FXML
    private Slider sliderTiempoActividad;

    @FXML
    private Button btnAceptarParEntorno;

    @FXML
    private Button btnRestablecer1;

        //Modify Board Parameters

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

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnCargarPartida;

    ////////////////////////////////////////////////////////////////////////////

        /* ACEPTAR Y RESTABLECER CAMBIOS
            * Objetivo: guardar los valores establecidos por el individuo en los diferentes parámetros del juego */

    @FXML
    public void aceptarParIndividuo() {
        crearPartida();
    }


    @FXML
    public void aceptarParEntorno() {
        crearPartida();
    }

    @FXML
    public void aceptarTablero(){
        this.tableroCreado = true;
        eliminarTablero();      //Limpiar tablero anterior y volver a dibujarlo
        crearTablero((int) sliderColumnas.getValue(), (int) sliderFilas.getValue());
        if (!partidaCreada){
            crearPartida();
            partida.individuosInicio();
            listaIndividuos = partida.getListaIndividuos();
            listaCasillas = partida.getListaCasillas();
            partidaCreada = true;
        }
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
        sliderBasico.setValue(30);
        sliderNormal.setValue(20);
        sliderAvanzado.setValue(10);
    }

    @FXML
    private void restablecerEntorno(){
        sliderAgua.setValue(5);
        sliderComida.setValue(5);
        sliderMontana.setValue(5);
        sliderCofre.setValue(5);
        sliderBiblioteca.setValue(5);
        sliderPozo.setValue(5);
        sliderTiempoActividad.setValue(5);
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
                    lblNumeroIndividuos.setText("Nº Individuos: "+partida.getIndividuosTotales());
                    listaIndividuos = partida.getListaIndividuos();
                    listaElementos = partida.getListaElementos();
                    listaCasillas = partida.getListaCasillas();
                    partida.modificarTurno();
                    lblTurno.setText("Turno: " + partida.getTurno());

                    //mover individuos
                    for (Individuo individuo:listaIndividuos){
                        partida.moverIndividuo(individuo);
                    }
                    for (Casilla casilla:listaCasillas){
                        bucle.evaluacionFinal(casilla);
                    }
                    bucle.actualizarIndividuos(listaIndividuos);
                    limpiarCasillas();
                    mostrarCasillas();
                }
                i++;
            }
        };

    @FXML
    private void start() {
        if (tableroCreado){
            //Disable Bottoms
            btnStart.setDisable(true);
            btnPause.setDisable(false);
            btnEnd.setDisable(false);
            partida.elementosPrincipio();
            partida.individuosInicio();
            mostrarCasillas();
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
        if (individuosCreados) {
            if (!partidaCreada){
                //crearPartida();
                //partida.individuosInicio();
                //listaIndividuos = partida.getListaIndividuos();
                //mostrarEnCasilla();
                //partidaCreada = true;
            }
        } else {
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No has colocado los individuos en las casillas");
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
        btnEnd.setDisable(true);
        btnPause.setDisable(true);
        btnStart.setDisable(true);
        desabilitarSliders(true);
        animationTimer.stop();
        controladorEscenarios.cargarArbolFinal(listaIndividuos);
    }

    public static <T> void guardarObjeto(String rutaArchivo, T objeto){
        Gson gson = new Gson ();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(objeto, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T cargarObjeto(String rutaArchivo, Class<T> clase){
        Gson gson = new Gson ();
        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, clase);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @FXML
    private void guardar(){
        btnGuardar.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseButton.PRIMARY){
                    guardarObjeto("partida.json", partida);
                }
            }
        });
        btnPause.setDisable(true);
        btnEnd.setDisable(false);
        btnStart.setDisable(false);
        desabilitarSliders(false);
        animationTimer.stop();
    }

    @FXML
    private void cargar(){
        btnCargarPartida.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseButton.PRIMARY){
                    cargarObjeto("partida.json", Partida.class);
                }
            }
        });
    }

    private void desabilitarSliders(Boolean a){
        sliderColumnas.setDisable(a);
        sliderFilas.setDisable(a);
        sliderVida.setDisable(a);
        sliderReproduccion.setDisable(a);
        sliderClonacion.setDisable(a);
        sliderBasico.setDisable(a);
        sliderNormal.setDisable(a);
        sliderAvanzado.setDisable(a);
        sliderAgua.setDisable(a);
        sliderComida.setDisable(a);
        sliderMontana.setDisable(a);
        sliderCofre.setDisable(a);
        sliderBiblioteca.setDisable(a);
        sliderPozo.setDisable(a);
        sliderTiempoActividad.setDisable(a);
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
                Casilla casilla = new Casilla(i, j);
                casilla.setMinSize((double) a/columnas,(double) b/filas);
                casilla.setStyle("-fx-background-color:#D4E5E3; -fx-border-color: #000000");
                casilla.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                            Dialog<PartidaCasilla> casillaDialog = new CasillaDialog(casilla, partida);
                            Window window = casillaDialog.getDialogPane().getScene().getWindow();
                            window.setOnCloseRequest(event -> window.hide());
                            Optional<PartidaCasilla> result = casillaDialog.showAndWait();
                            if (result != null && result.get().getCasilla() != null) {
                                casilla.setIndividuosCasilla(result.get().getCasilla().getIndividuosCasilla());
                                casilla.setElementosCasilla(result.get().getCasilla().getElementosCasilla());

                                partida.setAgua(result.get().getPartida().getAgua());
                                partida.setComida(result.get().getPartida().getComida());
                                partida.setMontana(result.get().getPartida().getMontana());
                                partida.setCofre(result.get().getPartida().getCofre());
                                partida.setBiblioteca(result.get().getPartida().getBiblioteca());
                                partida.setPozo(result.get().getPartida().getPozo());
                            }
                        }
                    }
                });
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
    public void cambiarVelocidad() {
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

        //Crear Partida
    public void crearPartida(){
        this.partida = new Partida(
            (int) sliderReproduccion.getValue(),
            (int) sliderClonacion.getValue(),
            (int) sliderVida.getValue(),
            (int) sliderBasico.getValue(),
            (int) sliderNormal.getValue(),
            (int) sliderAvanzado.getValue(),
            (int) sliderAgua.getValue(),
            (int) sliderComida.getValue(),
            (int) sliderMontana.getValue(),
            (int) sliderCofre.getValue(),
            (int) sliderBiblioteca.getValue(),
            (int) sliderPozo.getValue(),
            (int) sliderTiempoActividad.getValue(),
            (int) sliderColumnas.getValue(),
            (int) sliderFilas.getValue()
        );
        partida.setListaCasillas(listaCasillas);
    }

        //Mostrar Casillas
    public double getTamanoIndividuos(){
        double a = paneTablero.getHeight()/sliderColumnas.getValue();
        double b = paneTablero.getWidth()/sliderFilas.getValue();
        double diametro;
        if (a<b){
            diametro = a/partida.getMaximosIndividuos();
        } else{
            diametro = b/partida.getMaximosIndividuos();
        }
        return diametro/2;
    }

    public double getTamanoElementos(){
        double a = paneTablero.getHeight()/sliderColumnas.getValue();
        double b = paneTablero.getWidth()/sliderFilas.getValue();
        double lado;
        if (a<b){
            lado = a/partida.getMaximosIndividuos();
        } else {
            lado = b/partida.getMaximosIndividuos();
        }
        return lado;
    }

    public void mostrarIndividuoCasilla(Casilla casilla){
        bucle.evaluacionFinal(casilla);
        int i = 1;
        for (Individuo individuo : casilla.getIndividuosCasilla()){
            Circle circulo = new Circle();
            circulo.setRadius(getTamanoIndividuos());
            colorIndividuo(individuo,circulo);
            circulo.setCenterX(getTamanoIndividuos()*i);
            circulo.setCenterY(getTamanoIndividuos()*2-getTamanoIndividuos()/3);
            casilla.getChildren().addAll(circulo);
            i += 2;
        }
    }

    public void mostrarElementoCasilla(Casilla casilla){
        int i = 0;
        for (Elementos elemento:casilla.getElementosCasilla()){
            Rectangle rectangle = new Rectangle(getTamanoElementos(),getTamanoElementos());
            colorEelemento(elemento,rectangle);
            rectangle.setX(getTamanoElementos()*i);
            rectangle.setY(getTamanoIndividuos()*3);
            casilla.getChildren().addAll(rectangle);
            i+=1;
        }
    }
    public void mostrarCasillas(){
        for (Casilla casilla : listaCasillas){
            mostrarIndividuoCasilla(casilla);
            mostrarElementoCasilla(casilla);
        }
    }

    public void limpiarCasillas(){
        for (Casilla casilla:listaCasillas){
            casilla.getChildren().clear();
        }
    }

    public void colorIndividuo(Individuo individuo, Circle circulo){
        if (individuo.getRango() == 3) {
            circulo.setStroke(Color.rgb(83,98,98));
            circulo.setFill(Color.rgb(83,98,98));
        } else if (individuo.getRango() == 2) {
            circulo.setStroke(Color.rgb(138,145,148));
            circulo.setFill(Color.rgb(138,145,148));
        } else {
            circulo.setStroke(Color.rgb(203,205,205));
            circulo.setFill(Color.rgb(203,205,205));
        }
    }

    public void colorEelemento(Elementos elemento, Rectangle rectangle){
        if (elemento.getType()==0){
            rectangle.setStroke(Color.rgb(212,229,227));
            rectangle.setFill(Color.rgb(82,223,215));
        }else if (elemento.getType()==1){
            rectangle.setStroke(Color.rgb(212,229,227));
            rectangle.setFill(Color.rgb(193,188,80));
        }else if (elemento.getType()==2) {
            rectangle.setStroke(Color.rgb(212,229,227));
            rectangle.setFill(Color.rgb(253,247,225));
        }else if (elemento.getType()==3) {
            rectangle.setStroke(Color.rgb(212,229,227));
            rectangle.setFill(Color.rgb(178,148,118));
        }else if (elemento.getType()==4){
            rectangle.setStroke(Color.rgb(212,229,227));
            rectangle.setFill(Color.rgb(226,194,110));
        }else{
            rectangle.setStroke(Color.rgb(212,229,227));
            rectangle.setFill(Color.rgb(59,133,140));
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
