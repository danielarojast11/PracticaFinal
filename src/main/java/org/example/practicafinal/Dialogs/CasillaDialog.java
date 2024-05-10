package org.example.practicafinal.Dialogs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import org.example.practicafinal.Clases.Partida.Partida;
import org.example.practicafinal.Clases.Tablero.Casilla;
import java.io.IOException;


public class CasillaDialog extends Dialog<Casilla> {
    @FXML
    private Slider sliderNormal;

    private Casilla casilla;
    private int maxIndividuos = 3;

    public CasillaDialog(Casilla casilla, Partida partida) {
        super();
        this.setTitle("Elementos en casilla " + casilla.getFila() + " - " + casilla.getColumna());
        this.casilla = casilla;

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/org/example/practicafinal/configuracionCasilla-view.fxml"));
            DialogPane dialogPane = loader.load();
            setDialogPane(dialogPane);
            loader.setController(this);


            int maxBasico = Math.min(maxIndividuos, partida.getNumeroIndividuosBasicos());
            sliderNormal.setMax(maxBasico);
            /*int maxNormal = Math.min(maxIndividuos, partida.getNumeroIndividuosNormal());
            sliderNormal.setMax(maxNormal);
            int maxAvanzado = Math.min(maxIndividuos, partida.getNumeroIndividuosAvanzados());
            sliderAvanzado.setMax(maxAvanzado);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
