package org.example.practicafinal.Dialogs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import org.example.practicafinal.Clases.Partida.Partida;
import org.example.practicafinal.Clases.Tablero.Casilla;

import java.io.IOException;

public class CasillaDialog extends Dialog<Casilla> {
    //Parametros Tipos de Individuos
    @FXML
    private Slider sliderBasico;
    @FXML
    private Slider sliderNormal;
    @FXML
    private Slider sliderAvanzado;

    //Parametros Entorno
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

    //Botones
    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnAceptar;

    private Casilla casilla;

    public CasillaDialog(Casilla casilla, Partida partida) {
        super();
        this.setTitle("Elementos en casilla " + casilla.getFila() + " - " + casilla.getColumna());
        this.casilla = casilla;

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/org/example/practicafinal/configuracionCasilla-view.fxml"));
            loader.setController(this);

            DialogPane dialogPane = loader.load();
            setDialogPane(dialogPane);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
