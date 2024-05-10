package org.example.practicafinal.Dialogs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import org.example.practicafinal.Clases.Individuo.Individuo;
import org.example.practicafinal.Clases.Partida.Partida;
import org.example.practicafinal.Clases.Tablero.Casilla;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        int maxBasico = Math.max(3, partida.getNumeroIndividuosBasicos());
        sliderBasico.setMax(maxBasico);
        int maxNormal = Math.max(3, partida.getNumeroIndividuosNormal());
        sliderNormal.setMax(maxNormal);
        int maxAvanzado = Math.max(3, partida.getNumeroIndividuosAvanzados());
        sliderAvanzado.setMax(maxAvanzado);
        int maxAgua = Math.max(3, partida.getAgua());
        sliderAgua.setMax(maxAgua);
        int maxComida = Math.max(3, partida.getComida());
        sliderComida.setMax(maxComida);
        int maxMontana = Math.max(3, partida.getMontana());
        sliderMontana.setMax(maxMontana);
        int maxCofre = Math.max(3, partida.getCofre());
        sliderCofre.setMax(maxCofre);
        int maxBiblioteca = Math.max(3, partida.getBiblioteca());
        sliderBiblioteca.setMax(maxBiblioteca);
        int maxPozo = Math.max(3, partida.getPozo());
        sliderPozo.setMax(maxPozo);

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
