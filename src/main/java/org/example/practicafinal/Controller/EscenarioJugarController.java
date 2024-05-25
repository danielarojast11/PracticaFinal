package org.example.practicafinal.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
import org.example.practicafinal.Clases.Bucles;
import org.example.practicafinal.Entity.*;
import org.example.practicafinal.Dialog.CasillaDialog;
import org.example.practicafinal.EstructurasDeDatos.EstructurasDeDatos;
import org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada.ElementoLE;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class EscenarioJugarController {
    private final boolean pruebas = true;

    //@FXML private Button btnAceptarTablero;
    @FXML private Label lblTurno;
    @FXML private Label lblNumeroIndividuos;
    @FXML private Slider sliderVelocidad;
    @FXML private Slider sliderVida;
    @FXML private Slider sliderClonacion;
    @FXML private Slider sliderReproduccion;
    @FXML private Slider sliderBasico;
    @FXML private Slider sliderNormal;
    @FXML private Slider sliderAvanzado;
    @FXML private Slider sliderAgua;
    @FXML private Slider sliderComida;
    @FXML private Slider sliderMontana;
    @FXML private Slider sliderCofre;
    @FXML private Slider sliderBiblioteca;
    @FXML private Slider sliderPozo;
    @FXML private Slider sliderTiempoActividad;
    @FXML private Slider sliderColumnas;
    @FXML private Slider sliderFilas;

    private Bucles bucles;
    private Partida partida;
    private GridPane tablero = new GridPane();
    private int velocidad = 50;
    private Boolean tableroCreado = false;
    private EstructurasDeDatos estructurasDeDatos;

    AnimationTimer animationTimer = new AnimationTimer() {
        int i = velocidad;
        @Override
        public void handle(long now) {
            if (i % velocidad == 0) {
                partida.aumentarTurno();
                lblTurno.setText("Turno: " + partida.getTurno());

                bucles.moverIndividuos();
                bucles.evaluarCasillas();

                lblNumeroIndividuos.setText("Nº Individuos: " + partida.getNumIndividuos());

                if (partida.getNumIndividuos() <= 0){
                    endGame();
                }


                limpiarCasillas();
                mostrarCasillas();
            }
            i++;
        }
    };

    @FXML
    public void aceptarTablero(){
        eliminarTablero();
        crearPartida();
        bucles = new Bucles(partida);
        crearTablero();
        cambiarVelocidad();
    }

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

    @FXML
    private void start() {
        if (tableroCreado){
            if (validarInicioPartida() || true) {
                btnStart.setDisable(true);
                btnPause.setDisable(false);
                btnEnd.setDisable(false);
                desabilitarSliders(true);
                // Empezar Juego
                animationTimer.start();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("No has colocado los individuos y los elementos en las casillas");
                alert.showAndWait();
            }
        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);     //Si el tablero no está creado, da un aviso
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No has creado el Tablero");
            alert.showAndWait();
        }
    }

    private void crearTablero (){
        double a = paneTablero.getWidth();
        double b = paneTablero.getHeight();
        for (int i = 0; i < partida.getColumnas(); i++){
            for (int j = 0; j < partida.getFilas(); j++){
                Casilla casilla = new Casilla(i, j);
                casilla.setMinSize(a / partida.getColumnas(), b / partida.getFilas());
                casilla.setStyle("-fx-background-color:#D4E5E3; -fx-border-color: #000000");

                if (pruebas) {
                    crearPruebas(casilla);
                    mostrarContenidoCasilla(casilla);
                }

                casilla.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                            Dialog<Casilla> casillaDialog = new CasillaDialog(casilla, partida);
                            Window window = casillaDialog.getDialogPane().getScene().getWindow();
                            window.setOnCloseRequest(event -> window.hide());
                            Optional<Casilla> result = casillaDialog.showAndWait();
                            if (result != null && result.get().isCompleta()) {
                                mostrarContenidoCasilla(casilla);
                            }
                        }
                    }
                });

                tablero.add(casilla,i,j);
                partida.getListaCasillas().add(casilla);
            }
        }
        this.tableroCreado = true;
    }

    public void mostrarCasillas(){
        ElementoLE elementoLE = partida.getListaCasillas().getPrimero();
        while (elementoLE != null) {
            Casilla casilla = (Casilla) elementoLE.getData();
            mostrarContenidoCasilla(casilla);
            elementoLE = elementoLE.getSiguiente();
        }
    }

    public void limpiarCasillas(){
        ElementoLE elementoLE = partida.getListaCasillas().getPrimero();
        while (elementoLE != null) {
            Casilla casilla = (Casilla) elementoLE.getData();
            casilla.getChildren().clear();
            elementoLE = elementoLE.getSiguiente();
        }
    }

    private void mostrarContenidoCasilla(Casilla casilla) {
        int i = 1;
        ElementoLE posicionLista;
        if (casilla.getIndividuos().getPrimero() != null) {
            posicionLista = casilla.getIndividuos().getPrimero();
            casilla.getChildren().addAll(
                crearVistaIndividuo((Individuo) posicionLista.getData(), i)
            );
            while (posicionLista.getSiguiente() != null) {
                i += 2;
                posicionLista = posicionLista.getSiguiente();
                casilla.getChildren().addAll(
                        crearVistaIndividuo((Individuo) posicionLista.getData(), i)
                );
            }
        }
        i = 0;
        if (casilla.getElementos().getPrimero() != null) {
            posicionLista = casilla.getElementos().getPrimero();
            casilla.getChildren().addAll(
                    crearVistaElemento((Elemento) posicionLista.getData(), i)
            );
            while (posicionLista.getSiguiente() != null) {
                i+=1;
                posicionLista = posicionLista.getSiguiente();
                casilla.getChildren().addAll(
                        crearVistaElemento((Elemento) posicionLista.getData(), i)
                );
            }
        }
    }

    private Rectangle crearVistaElemento(Elemento elemento, int i) {
        Rectangle rectangle = new Rectangle(getTamanoElementos(),getTamanoElementos());
        colorElemento(elemento, rectangle);
        rectangle.setX(getTamanoElementos() * i);
        rectangle.setY(getTamanoIndividuos() * 3);
        return rectangle;
    }

    private Circle crearVistaIndividuo(Individuo individuo, int i) {
        Circle circulo = new Circle();
        circulo.setRadius(getTamanoIndividuos());
        colorIndividuo(individuo, circulo);
        circulo.setCenterX(getTamanoIndividuos() * i);
        circulo.setCenterY(getTamanoIndividuos() * 2 - getTamanoIndividuos() / 3);
        return circulo;
    }

    private void eliminarTablero(){
        tablero.getChildren().clear();
    }

    private void crearPartida(){
        this.partida = new Partida(
                (int) sliderVida.getValue(),
                (int) sliderClonacion.getValue(),
                (int) sliderReproduccion.getValue(),
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
    }

    private boolean validarInicioPartida() {
        int pendiente = partida.getNumeroIndividuosBasicos() + partida.getNumeroIndividuosNormal() + partida.getNumeroIndividuosAvanzados() +
                partida.getAgua() + partida.getCofre() + partida.getBiblioteca() + partida.getComida() + partida.getMontana() + partida.getPozo();
        if (pruebas) {
            return true;
        }
        return pendiente <= 0;
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

    private void crearPruebas(Casilla casilla) {
        int individuos = 0;
        int disponibles = partida.getNumeroIndividuosBasicos() + partida.getNumeroIndividuosNormal() +
                partida.getNumeroIndividuosAvanzados();
        while (individuos < partida.getMaxIndividuos() && disponibles > 0 && partida.getNumeroIndividuosBasicos() > 0) {
            if (partida.getNumeroIndividuosBasicos() > 0) {
                colocarIndividuo(casilla, 1);
                individuos++;
                disponibles--;
                partida.setNumeroIndividuosBasicos(partida.getNumeroIndividuosBasicos() - 1);
            }
        }
        while (individuos < partida.getMaxIndividuos() && disponibles > 0 && partida.getNumeroIndividuosNormal() > 0) {
            if (partida.getNumeroIndividuosNormal() > 0) {
                colocarIndividuo(casilla, 2);
                individuos++;
                disponibles--;
                partida.setNumeroIndividuosNormal(partida.getNumeroIndividuosNormal() - 1);
            }
        }
        while (individuos < partida.getMaxIndividuos() && disponibles > 0 && partida.getNumeroIndividuosAvanzados() > 0) {
            if (partida.getNumeroIndividuosAvanzados() > 0) {
                colocarIndividuo(casilla, 3);
                individuos++;
                disponibles--;
                partida.setNumeroIndividuosAvanzados(partida.getNumeroIndividuosAvanzados() - 1);
            }
        }

        int elementos = 0;
        disponibles = partida.getAgua() + partida.getCofre() + partida.getBiblioteca() + partida.getComida() +
                partida.getMontana() + partida.getPozo();
        while (elementos < partida.getMaxElementos() && disponibles > 0 && partida.getAgua() > 0) {
            if (partida.getAgua() > 0) {
                casilla.addElemento(new Agua(partida.getTiempoActividad(), casilla));
                elementos++;
                disponibles--;
                partida.setAgua(partida.getAgua() - 1);
            }
        }
        while (elementos < partida.getMaxElementos() && disponibles > 0 && partida.getCofre() > 0) {
            if (partida.getCofre() > 0) {
                casilla.addElemento(new Tesoro(partida.getTiempoActividad(), casilla));
                elementos++;
                disponibles--;
                partida.setCofre(partida.getCofre() - 1);
            }
        }
        while (elementos < partida.getMaxElementos() && disponibles > 0 && partida.getBiblioteca() > 0) {
            if (partida.getBiblioteca() > 0) {
                casilla.addElemento(new Biblioteca(partida.getTiempoActividad(), casilla));
                elementos++;
                disponibles--;
                partida.setBiblioteca(partida.getBiblioteca() - 1);
            }
        }
        while (elementos < partida.getMaxElementos() && disponibles > 0 && partida.getComida() > 0) {
            if (partida.getComida() > 0) {
                casilla.addElemento(new Comida(partida.getTiempoActividad(), casilla));
                elementos++;
                disponibles--;
                partida.setComida(partida.getComida() - 1);
            }
        }
        while (elementos < partida.getMaxElementos()  && disponibles > 0 && partida.getMontana() > 0) {
            if (partida.getMontana() > 0) {
                casilla.addElemento(new Montaña(partida.getTiempoActividad(), casilla));
                elementos++;
                disponibles--;
                partida.setMontana(partida.getMontana() - 1);
            }
        }
        while (elementos < partida.getMaxElementos()  && disponibles > 0 && partida.getPozo() > 0) {
            if (partida.getPozo() > 0) {
                casilla.addElemento(new Pozo(partida.getTiempoActividad(), casilla));
                elementos++;
                disponibles--;
                partida.setCofre(partida.getPozo() - 1);
            }
        }
    }

    private void colocarIndividuo(Casilla casilla, int rango) {
        partida.aumentarid();
        Individuo in = new Individuo(
                partida.getId(),
                partida.getTurno(),
                partida.getTurnosVida(),
                partida.getProbReproduccion(),
                partida.getProbClonacion(),
                rango,
                casilla
        );
        casilla.addIndividuo(in);
        this.partida.addIndividuo(in);
    }


    //Parameters
    EscenariosController controladorEscenarios;

    private final Boolean individuosCreados = false;

    private Boolean partidaCreada = false;

    private List<Individuo> listaIndividuos = new ArrayList<>();

    private final List<Elemento> listaElementos = new ArrayList<>();


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
    private Button btnRestablecerTablero;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnCargarPartida;

    @FXML
    public void restablecerTablero(){
        sliderColumnas.setValue(5);     //Valores predeterminados
        sliderFilas.setValue(5);
        sliderVelocidad.setValue(1);
    }

    ////////////////////////////////////////////////////////////////////////////

        /* FUNCIONES MENÚ
            * Objetivo: dar al usuario las opciones de:
            *                   - Cargar Partida Existente
            *                   - Guardar Partida Actual
            *                   - Salir a la Pantalla de Inicio
         */


    @FXML
    public void salir() {
        controladorEscenarios.cargarEscenarioInicio();
    }

    ////////////////////////////////////////////////////////////////////////////

        /* BOTONES MANEJAR PARTIDA
            * Objetivo: comenzar, pausar o finalizar la partida
         */

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
        controladorEscenarios.cargarArbolFinal(partida);
    }

    @FXML
    private void guardar(){
        Gson gson = new Gson ();
        try (FileWriter writer = new FileWriter("partida.json")) {
            gson.toJson(partida.toJson(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        btnPause.setDisable(true);
        btnEnd.setDisable(false);
        btnStart.setDisable(false);
        desabilitarSliders(false);
        animationTimer.stop();
    }

    @FXML
    public void cargar(){
        Gson gson = new Gson ();
        try {
            if (this.partida == null) {
                crearPartida();
            }
            JsonElement jsonElement = JsonParser.parseReader(new FileReader("partida.json"));
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            partida.fromJson(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////

        //OTRAS FUNCIONES

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
                    lblVelocidad.textProperty().setValue("Velocidad: x"+ sliderVelocidad.getValue());
                }
            }
        });
    }

        //Mostrar Casillas
    public double getTamanoIndividuos(){
        double a = paneTablero.getHeight()/sliderColumnas.getValue();
        double b = paneTablero.getWidth()/sliderFilas.getValue();
        double diametro;
        if (a<b){
            diametro = a/partida.getMaxIndividuos();
        } else{
            diametro = b/partida.getMaxIndividuos();
        }
        return diametro/2;
    }

    public double getTamanoElementos(){
        double a = paneTablero.getHeight()/sliderColumnas.getValue();
        double b = paneTablero.getWidth()/sliderFilas.getValue();
        double lado;
        if (a<b){
            lado = a/partida.getMaxElementos();
        } else {
            lado = b/partida.getMaxElementos();
        }
        return lado;
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

    public void colorElemento(Elemento elemento, Rectangle rectangle){
        if (elemento instanceof Agua){
            rectangle.setStroke(Color.rgb(212,229,227));
            rectangle.setFill(Color.rgb(82,223,215));
        }else if (elemento instanceof Biblioteca){
            rectangle.setStroke(Color.rgb(212,229,227));
            rectangle.setFill(Color.rgb(193,188,80));
        }else if (elemento instanceof Comida) {
            rectangle.setStroke(Color.rgb(212,229,227));
            rectangle.setFill(Color.rgb(253,247,225));
        }else if (elemento instanceof Montaña) {
            rectangle.setStroke(Color.rgb(212,229,227));
            rectangle.setFill(Color.rgb(178,148,118));
        }else if (elemento instanceof Pozo){
            rectangle.setStroke(Color.rgb(212,229,227));
            rectangle.setFill(Color.rgb(226,194,110));
        }else if (elemento instanceof Tesoro){
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
